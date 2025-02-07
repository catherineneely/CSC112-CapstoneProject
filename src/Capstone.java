// Catherine Neely

import java.io.*;
import java.util.*;

public class Capstone {
    public static void main(String[] args) {
        String[] userArtists = userMusic();
        userData.UData(userArtists);
        System.out.println(userArtists[0]);
        System.out.println(userArtists[1]);
        System.out.println(userArtists[2]);
    }
    public static String[] userMusic() {
        Scanner input = new Scanner(System.in);
        System.out.print("Who are your top three favorite music artists? ");
        String artists = input.nextLine();
        input.close();
        String[] data = null;
        for (int i = 0; i < 3; i++) {
            data = artists.split(", ");
        }
        return data;
    }

}
