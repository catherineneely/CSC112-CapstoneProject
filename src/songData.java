// Catherine Neely

import java.io.*;
import java.util.*;

public class songData {

    private String songGenre;
    private String songArtist;
    private int songPopularity;
    private String songAlbum;
    private String songName;
    private String songAlbumYear;
    private String songSubgenre;

    // constructors
    public songData() {
        this.songGenre = "";
        this.songArtist = "";
        this.songPopularity = 0;
        this.songAlbum = "";
        this.songName = "";
        this.songAlbumYear = "";
        this.songSubgenre = "";
    }
    public songData(String SG, String SArt, int SP, String SAlb, String SN, String SAY, String SSG) {
        this.songGenre = SG;
        this.songArtist = SArt;
        this.songPopularity = SP;
        this.songAlbum = SAlb;
        this.songName = SN;
        this.songAlbumYear = SAY;
        this.songSubgenre = SSG;
    }

    // toString method
    @Override
    public String toString() {
        return songGenre + "," + songArtist + "," + songPopularity + "," + songAlbum + ","
                + songName + "," + songAlbumYear + "," + songSubgenre;
    }

    // getter and setter methods
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
    public int getSongPopularity() {
        return songPopularity;
    }
    public void setSongPopularity(int songPopularity) {
        this.songPopularity = songPopularity;
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
    public String getSongAlbumYear() {
        return songAlbumYear;
    }
    public void setSongAlbumYear(String songAlbumYear) {
        this.songAlbumYear = songAlbumYear;
    }
    public String getSongSubgenre() {
        return songSubgenre;
    }
    public void setSongSubgenre(String songSubgenre) {
        this.songSubgenre = songSubgenre;
    }

    public ArrayList<songData> songFileRead() {
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
            String[] songInfo = line.split(",");
            SD.setSongGenre(songInfo[0]);
            SD.setSongArtist(songInfo[1]);
            try {
                SD.setSongPopularity(Integer.parseInt(songInfo[2]));
            } catch (NumberFormatException e) {
                System.out.println();
                continue;
            }
            SD.setSongAlbum(songInfo[3]);
            SD.setSongName(songInfo[4]);
            SD.setSongAlbumYear(songInfo[5]);
            SD.setSongSubgenre(songInfo[6]);
            objects.add(SD);
        }
        fileScan.close();
        songSort(objects, objects.size() - 1);
        return objects;
    }
    public void songSort(ArrayList<songData> objects, int n) {
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
    public void songSwap(ArrayList<songData> objects, int i, int i1) {
        songData temp = objects.get(i);
        objects.set(i, objects.get(i1));
        objects.set(i1, temp);
    }
}
