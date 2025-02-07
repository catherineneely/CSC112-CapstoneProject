// Catherine Neely

import java.io.*;
import java.util.*;

public class Capstone {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to use genre(g), artists(a), or mood(m) " +
                "for music discovery?");
        String MD = scan.nextLine();
        if (MD.equals("g")) {
            String[] UG = userGenres();
            userData.UGenre(UG);
        } else if (MD.equals("a")) {
            String[] UA = userArtists();
            userData.UArtist(UA);
        } else if (MD.equals("m")) {
            String[] UM = userMoods();
            userData.UMood(UM);
        } else {
            System.out.println("Unknown command.");
        }

    }
    public static String[] userArtists() {
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
    public static String[] userGenres() {
        Scanner input = new Scanner(System.in);
        System.out.print("How many genres would you like to use for the recommendation? ");
        int NOG = input.nextInt();
        String space = input.nextLine();
        System.out.print("List the genres: ");
        String genres = input.nextLine();
        input.close();
        String[] UG = null;
        for (int i = 0; i < NOG; i++) {
            UG = genres.split(", ");
        }
        return UG;
    }
    public static String[] userMoods() {
        Scanner input = new Scanner(System.in);
        System.out.print("How many moods would you like to use for the recommendation? ");
        int NOM = input.nextInt();
        String space = input.nextLine();
        System.out.print("List the moods: ");
        String moods = input.nextLine();
        input.close();
        String[] UG = null;
        for (int i = 0; i < NOM; i++) {
            UG = moods.split(", ");
        }
        return UG;
    }
}
