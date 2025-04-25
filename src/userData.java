// Catherine Neely

import java.io.*;

// Class for saving arrays of user data (artists, genres, moods) to text files
public class userData {
    // Saves an array of user input artists to "userArtistData.txt"
    public static void UArtist (String[] userArtists) {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream("userArtistData.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        PrintWriter pw = new PrintWriter(fileOut);
        writeToFileRecursive(userArtists, 0, pw);
        pw.flush();
        pw.close();
    }
     // Saves an array of user input genres to "userGenreData.txt"
    public static void UGenre (String[] userGenres) {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream("userGenreData.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        PrintWriter pw = new PrintWriter(fileOut);
        writeToFileRecursive(userGenres, 0, pw);
        pw.flush();
        pw.close();
    }
    // Saves an array of user input moods to "userMoodData.txt"
    public static void UMood (String[] userMoods) {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream("userMoodData.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        PrintWriter pw = new PrintWriter(fileOut);
        writeToFileRecursive(userMoods, 0, pw);
        pw.flush();
        pw.close();
    }
    // Recursive method that writes a file with information depending on user input in the main
    public static void writeToFileRecursive(String[] data, int index, PrintWriter pw) {
        if (index == data.length) {
            return;
        }
        pw.println(data[index]);
        writeToFileRecursive(data, index + 1, pw);
    }
}
