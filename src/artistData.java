// Catherine Neely

import java.io.*;
import java.util.*;

public class artistData {
    private String artistSong;
    private String artistAlbum;

    public artistData() {
        artistSong = "";
        artistAlbum = "";
    }
    public artistData(String artistSong, String artistAlbum) {
        this.artistSong = artistSong;
        this.artistAlbum = artistAlbum;
    }

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

    public String getArtists() {
        ArrayList<String> userArtists = new ArrayList<>();

        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream("userArtistData.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        songData songData = new songData();
        ArrayList<songData> objects = songData.songFileRead();
        Stack stack = new Stack();
        Scanner fileScanner = new Scanner(fileIn);
        int i = 0;

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
            i++;
        }

        Random rand = new Random();
        int ss = stack.stackSize();
        int popCount;
        if (ss > 0) {
            popCount = rand.nextInt(ss) + 1;
            for (int j = 0; j < popCount; j++) {
                Node poppedNode = stack.pop();
                String poppedGenre = poppedNode.data;

                LinkedList genreArtists = new LinkedList();
                for (int k = 0; k < objects.size(); k++) {
                    songData data = objects.get(k);
                    if (data.getSongGenre().equalsIgnoreCase(poppedGenre)) {
                        genreArtists.add(data.getSongArtist());
                    }
                }
                if (genreArtists.size() > 0) {
                    int artistsCount = rand.nextInt(genreArtists.size());
                    Node curr = genreArtists.head;
                    for (int w = 0; w < artistsCount; w++) {
                        curr = curr.next;
                    }
                    String pg = curr.data;
                    if (pg.contains(", ")) {
                        String[] singleArtist = pg.split(", ");
                        pg = singleArtist[0].trim();
                    }
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
