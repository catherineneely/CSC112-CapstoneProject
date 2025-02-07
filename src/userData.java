// Catherine Neely

import java.io.*;

public class userData {
    public static void UData (String[] userArtists) {
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
