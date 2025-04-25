// Catherine Neely

import java.io.*;
import java.util.*;

// Class for storing information about a song and reading, sorting, and writing song data
public class songData {

    private String songGenre;
    private String songArtist;
    private String songAlbum;
    private String songName;
    private int songAlbumYear;
    private String songSubgenre;

    // Default constructor
    public songData() {
        this.songGenre = "";
        this.songArtist = "";
        this.songAlbum = "";
        this.songName = "";
        this.songAlbumYear = 0;
        this.songSubgenre = "";
    }
    // Parameterized constructor
    public songData(String SG, String SArt, String SAlb, String SN, int SAY, String SSG) {
        this.songGenre = SG;
        this.songArtist = SArt;
        this.songAlbum = SAlb;
        this.songName = SN;
        this.songAlbumYear = SAY;
        this.songSubgenre = SSG;
    }

    // toString method
    @Override
    public String toString() {
        return songGenre + "/-/" + songArtist + "/-/" + songAlbum + "/-/"
                + songName + "/-/" + songAlbumYear + "/-/" + songSubgenre;
    }

    // Getter and setter methods
    public String getSongGenre() {
        return songGenre;
    }
    public void setSongGenre(String songGenre) {
        this.songGenre = songGenre;
    }
    public String getSongArtist() {
        return songArtist;
    }
    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }
    public String getSongAlbum() {
        return songAlbum;
    }
    public void setSongAlbum(String songAlbum) {
        this.songAlbum = songAlbum;
    }
    public String getSongName() {
        return songName;
    }
    public void setSongName(String songName) {
        this.songName = songName;
    }
    public int getSongAlbumYear() {
        return songAlbumYear;
    }
    public void setSongAlbumYear(int songAlbumYear) {
        this.songAlbumYear = songAlbumYear;
    }
    public String getSongSubgenre() {
        return songSubgenre;
    }
    public void setSongSubgenre(String songSubgenre) {
        this.songSubgenre = songSubgenre;
    }

    // Reads song data from the "spotify-data.csv" file, creates songData objects,
    // stores them in a list, sorts them, and returns the list
    public static ArrayList<songData> songFileRead() {
        FileInputStream userFile = null;
        ArrayList<songData> objects = new ArrayList<>();
        try {
            userFile = new FileInputStream("src/spotify-data.csv");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        Scanner fileScan = new Scanner(userFile);
        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            songData SD = new songData();
            String[] songInfo = line.split("/-/");
            // Adds to the songData object with parsed values
            SD.setSongGenre(songInfo[0]);
            SD.setSongArtist(songInfo[1]);
            SD.setSongAlbum(songInfo[2]);
            SD.setSongName(songInfo[3]);
            try {
                SD.setSongAlbumYear(Integer.parseInt(songInfo[4]));
            } catch (NumberFormatException e) {
                continue;
            }
            SD.setSongSubgenre(songInfo[5]);
            objects.add(SD);    // Adds the song to the ArrayList
        }
        fileScan.close();
        // Sorts the songs alphabetically by song title
        songSort(objects, objects.size() - 1);
        return objects;
    }
    // Sorts the list of songs using bubble sort and the songTitlesComparator
    public static void songSort(ArrayList<songData> objects, int n) {
        songTitlesComparator comparator = new songTitlesComparator();
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < n; i++) {
                if (comparator.compare(objects.get(i), objects.get(i + 1)) > 0) {
                    songSwap(objects, i, i + 1);
                    sorted = false;
                }
            }
            n--;
        }
    }
    public static void songSwap(ArrayList<songData> objects, int i, int i1) {
        songData temp = objects.get(i);
        objects.set(i, objects.get(i1));
        objects.set(i1, temp);
    }
    // Adds a new song to both the spotify-data.csv file and the in-memory ArrayList
    public void addNewSong(songData SD, ArrayList<songData> objects){
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream("src/spotify-data.csv", true);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        PrintWriter pw = new PrintWriter(fileOut);
        pw.println(SD.toString());
        pw.flush();
        pw.close();
        objects.add(SD);
        System.out.println("Song added!");
    }

}
