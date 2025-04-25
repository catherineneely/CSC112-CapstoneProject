// Catherine Neely

import java.io.*;
import java.util.*;

// Class for handling artist-related data and generating artist recommendations
public class artistData {
    private String artistSong;
    private String artistAlbum;

    // Default constructor
    public artistData() {
        artistSong = "";
        artistAlbum = "";
    }
    // Parameterized constructor
    public artistData(String artistSong, String artistAlbum) {
        this.artistSong = artistSong;
        this.artistAlbum = artistAlbum;
    }

    // Setter and getter methods
    public void setArtistSong(String artistSong) {
        this.artistSong = artistSong;
    }
    public void setArtistAlbum(String artistAlbum) {
        this.artistAlbum = artistAlbum;
    }
    public String getArtistSong() {
        return artistSong;
    }
    public String getArtistAlbum() {
        return artistAlbum;
    }

    // Method that recommends a new artist based on the user's previously liked artists
    public String getArtists() {
        ArrayList<String> userArtists = new ArrayList<>();  // To track known user artists

        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream("userArtistData.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        // Loads the full song database
        songData songData = new songData();
        ArrayList<songData> objects = songData.songFileRead();
        // Stack stores the genres of preferred artists
        Stack stack = new Stack();
        Scanner fileScanner = new Scanner(fileIn);

        // Reads each artist line from the user input file
        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            for (int p = 0; p < objects.size(); p++) {
                if (line.contains(objects.get(p).getSongArtist())) {
                    String genre = objects.get(p).getSongGenre();
                    Node songGenre = new Node(genre);
                    stack.push(songGenre);
                    userArtists.add(objects.get(p).getSongArtist());
                }
            }
        }

        Random rand = new Random();
        int ss = stack.stackSize();
        int popCount;
        // Only proceeds if there is at least one genre found
        if (ss > 0) {
            popCount = rand.nextInt(ss) + 1;
            for (int j = 0; j < popCount; j++) {
                Node poppedNode = stack.pop();
                String poppedGenre = poppedNode.data;

                LinkedList genreArtists = new LinkedList();

                // Look for all artists in the same genre
                for (int k = 0; k < objects.size(); k++) {
                    songData data = objects.get(k);
                    if (data.getSongGenre().equalsIgnoreCase(poppedGenre)) {
                        genreArtists.add(data.getSongArtist());
                    }
                }
                // If artists were found in this genre
                if (genreArtists.size() > 0) {
                    int artistsCount = rand.nextInt(genreArtists.size());
                    Node curr = genreArtists.head;
                    // Traverses to the randomly selected artist
                    for (int w = 0; w < artistsCount; w++) {
                        curr = curr.next;
                    }
                    String pg = curr.data;
                    // If multiple artists are listed, it chooses the first
                    if (pg.contains(", ")) {
                        String[] singleArtist = pg.split(", ");
                        pg = singleArtist[0].trim();
                    }
                    // If the selected artist isn't already known to the user, it recommends it
                    if (!userArtists.contains(pg)) {
                        return pg;
                    } else {
                        continue;
                    }
                }
            }
        } else {}
        return "No artist recommendation available";
    }
}
