// Catherine Neely

import java.io.*;
import java.util.*;

public class Capstone {
    public static void main(String[] args) {
        String[] userArtists = userMusic();
        userData.UData(userArtists);

    }
    public static String[] userMusic() {
        Scanner input = new Scanner(System.in);
        System.out.print("How many artists would you like to use for the recommendation? ");
        int NOA = input.nextInt();
        String space = input.nextLine();
        System.out.print("List the artists: ");
        String artists = input.nextLine();
        input.close();
        String[] userArtists = null;
        for (int i = 0; i < NOA; i++) {
            userArtists = artists.split(", ");
        }
        return userArtists;
    }
}
