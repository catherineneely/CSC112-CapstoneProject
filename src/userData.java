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
        for (int i = 0; i < userArtists.length; i++) {
            String line = userArtists[i];
            pw.println(line);
        }
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
        for (int i = 0; i < userGenres.length; i++) {
            String line = userGenres[i];
            pw.println(line);
        }
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
        for (int i = 0; i < userMoods.length; i++) {
            String line = userMoods[i];
            pw.println(line);
        }
        pw.flush();
        pw.close();
    }
}
