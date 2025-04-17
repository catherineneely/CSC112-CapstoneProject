// Catherine Neely

import java.util.*;

public class Capstone {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scan.nextLine();

        user user = new user(username);

        boolean returnUser = user.loadUserPreferences();
        if (returnUser) {
            System.out.println("You are logged in, " + username + "!");
            System.out.println("Your current preferences are...");
            System.out.println("Artist: " + user.getArtist());
            System.out.println("Genre: " + user.getGenre());
            System.out.println("Mood: " + user.getMood());

            System.out.print("Would you like to update these preferences (yes or no): ");
            String option = scan.nextLine();
            if (option.equalsIgnoreCase("yes")) {
                user.updateUserPreferences();
            }
        } else {
            System.out.println("Welcome new user, " + username + "!");
            user.updateUserPreferences();
        }
        System.out.print("Would you like to add a new song to the database (yes or no): ");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            System.out.print("List the details of the song: ");
            //FINISH HERE -- SEE NOTES
        } else {
            return;
        }

        System.out.print("Would you like to use artists(a), genre(g), or mood(m) " +
                "for music discovery? ");
        String MD = scan.nextLine();
        if (MD.equalsIgnoreCase("a")) {
            String[] UA = userArtists();
            userData.UArtist(UA);
            artistData AD = new artistData();
            String recommArtist = AD.getArtists();
            System.out.println("Your recommended artist is " + recommArtist + ".");
        } else if (MD.equalsIgnoreCase("g")) {
            String[] UG = userGenres();
            userData.UGenre(UG);
        } else if (MD.equalsIgnoreCase("m")) {
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
        String[] UA = null;
        for (int i = 0; i < NOA; i++) {
            UA = artists.split(", ");
        }
        return UA;
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
        String[] UM = null;
        for (int i = 0; i < NOM; i++) {
            UM = moods.split(", ");
        }
        return UM;
    }
}