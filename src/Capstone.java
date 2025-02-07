// Catherine Neely

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Capstone {
    public static void main(String[] args) {
        String[] userArtists = userMusic();

    }
    public static String[] userMusic() {
        Scanner input = new Scanner(System.in);
        System.out.println("Who are your favorite music artists? ");
        String artists = input.nextLine();
        String[] data = null;
        while (input.hasNextLine()) {
            data = artists.split(",");
        }
        return data;
    }
    public static void userData (String[] userArtists) {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream("userData.txt");
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
}
