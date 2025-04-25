// Catherine Neely

import java.io.*;
import java.util.*;

// Class for generating a playlist based on user input genres
public class playlistGen {
    // Generates a playlist of 10 unique songs based on the user's selected genres
    public static ArrayList<songData> generate(String userGenres, int genreNum) {
        String[] genres = new String[0];
        for (int i = 0; i < genreNum; i++) {
            genres = userGenres.split(", ");
        }

        ArrayList<songData> allSongs = songData.songFileRead();
        ArrayList<songData> possiblePlaylistSongs = new ArrayList<>();

        // Filters the allSongs ArrayList to find only those that match the selected genres
        for (int j = 0; j < allSongs.size(); j++) {
            for (int k = 0; k < genres.length; k++) {
                if (allSongs.get(j).getSongGenre().equals(genres[k])) {
                    possiblePlaylistSongs.add(allSongs.get(j));
                }
            }
        }

        // Randomly picks 10 unique songs for the playlist
        Random rand = new Random();
        ArrayList<songData> playlistSongs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int randomIndex = rand.nextInt(possiblePlaylistSongs.size());
            // Ensures no duplicate songs are added to the final playlist
            if (!playlistSongs.contains(possiblePlaylistSongs.get(randomIndex))) {
                playlistSongs.add(possiblePlaylistSongs.get(randomIndex));
            } else {
                continue;
            }
        }
        return playlistSongs;
    }
    // Writes the generated playlist to a .txt file with the user's username in the filename
    public static void printPlaylist(user user, ArrayList<songData> playlistSongs) {
        FileOutputStream songFile = null;
        try {
            songFile = new FileOutputStream(user.getUsername() + "Playlist.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        // Uses PrintWriter to write the song data to the user's playlist file
        PrintWriter pw = new PrintWriter(songFile);
        for (int i = 0; i < playlistSongs.size(); i++) {
            pw.print(playlistSongs.get(i).getSongName());
            pw.print(" by ");
            pw.print(playlistSongs.get(i).getSongArtist());
            pw.println();
        }
        pw.flush();
        pw.close();
        System.out.println("Playlist created!");
    }
}
