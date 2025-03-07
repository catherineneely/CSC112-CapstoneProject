// Catherine Neely

import java.io.*;

public class userData {
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

    // recursive method that writes a file with information depending on user input in the main
    public static void writeToFileRecursive(String[] data, int index, PrintWriter pw) {
        if (index == data.length) {
            return;
        }
        pw.println(data[index]);
        writeToFileRecursive(data, index + 1, pw);
    }
}
