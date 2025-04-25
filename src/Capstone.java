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
        } else {
            System.out.println("Welcome new user, " + username + "!");
            user.updateUserPreferences();
        }

        String option = "";
        while (!option.equals("f")) {
            System.out.print("""
                    
                    What would you like to do""" + " " + username + "?" + """
                    
                    (a) Update User Preferences
                    (b) Receive Recommendations Based on User Preferences
                    (c) Music Discovery
                    (d) Playlist Generator
                    (e) Add a New Song to the Database
                    (f) Exit
                    
                    ---→""" + " ");
            option = scan.nextLine().toLowerCase();

            if (option.equals("a")) {
                user.updateUserPreferences();
            } else if (option.equals("b")) {
                // FILL IN CODE HERE !!!
            } else if (option.equals("c")) {
                System.out.print("Would you like to use artists(a), genre(g), or mood(m) " +
                        "for music discovery? ");
                String MD = scan.nextLine();
                if (MD.equalsIgnoreCase("a")) {
                    String[] UA = userArtists(scan);
                    userData.UArtist(UA);
                    artistData AD = new artistData();
                    String recommArtist = AD.getArtists();
                    if (recommArtist.equals("No artist recommendation available")) {
                        System.out.println(recommArtist + ".");
                    } else {
                        System.out.println("Your recommended artist is " + recommArtist + ".");
                    }
                } else if (MD.equalsIgnoreCase("g")) {
                    String[] UG = userGenres(scan);
                    userData.UGenre(UG);
                    genreData GD = new genreData();
                    String recommGenre = GD.getGenres();
                    if (recommGenre.equals("No genre recommendation available")) {
                        System.out.println(recommGenre + ".");
                    } else {
                        System.out.println("Your recommended genre is " + recommGenre + ".");
                    }
                } else if (MD.equalsIgnoreCase("m")) {
                    String[] UM = userMoods(scan);
                    userData.UMood(UM);
                    moodData MoD = new moodData();
                    String recommSongForMood = MoD.getMoodRec();
                    if (recommSongForMood.equals("No mood recommendation available")) {
                        System.out.println(recommSongForMood + ".");
                    } else {
                        System.out.println("Your recommended song for a " + UM[0] + " mood is " + recommSongForMood + ".");
                    }
                } else {
                    System.out.println("Unknown command.");
                }
            } else if (option.equals("d")) {
                // FILL IN CODE HERE !!!
            } else if (option.equals("e")) {
                ArrayList<songData> objects = songData.songFileRead();
                System.out.print("What is the name of the song you would like to add to the database? ");
                String name = scan.nextLine();
                objects.sort(new songTitlesComparator());
                int nameSearch = linearSearch(objects, 0, objects.size()-1, name);
                if (nameSearch == -1) {
                    String genre = "";
                    System.out.print("What is the genre of the song (to see the genre list, enter 'list')? ");
                    genre = scan.nextLine();
                    while (genre.equalsIgnoreCase("list")) {
                        genreData GD = new genreData();
                        GD.printGenres();

                        System.out.print("What is the genre of the song (to see the genre list, enter 'list')? ");
                        genre = scan.nextLine();
                    }
                    System.out.print("What is the artist of the song? ");
                    String artist = scan.nextLine();
                    System.out.print("What is the album of the song? ");
                    String album = scan.nextLine();
                    System.out.print("What year was the album released? ");
                    int albumReleaseYear = Integer.parseInt(scan.nextLine());
                    String subgenre = "";
                    System.out.print("What is the subgenre of the song (to see the subgenre list, enter 'list')? ");
                    subgenre = scan.nextLine();
                    while (subgenre.equalsIgnoreCase("list")) {
                        genreData GD = new genreData();
                        GD.printSubgenres();

                        System.out.print("What is the subgenre of the song (to see the subgenre list, enter 'list')? ");
                        subgenre = scan.nextLine();
                    }
                    songData SD = new songData(genre, artist, album, name, albumReleaseYear, subgenre);
                    SD.addNewSong(SD, objects);
                } else {
                    System.out.println("Sorry, that song already exists in the database.");
                }
            } else if (option.equals("f")) {
                System.out.println("Goodbye " + username + "!");
            } else {
                System.out.println("Unknown option. Please try again.");
            }
        }
    }
    public static String[] userArtists(Scanner scan) {
        System.out.print("How many artists would you like to use for the recommendation? ");
        int NOA = Integer.parseInt(scan.nextLine());
        System.out.print("List the artists: ");
        String artists = scan.nextLine();
        String[] UA = null;
        for (int i = 0; i < NOA; i++) {
            UA = artists.split(", ");
        }
        return UA;
    }
    public static String[] userGenres(Scanner scan) {
        System.out.print("How many genres would you like to use for the recommendation? ");
        int NOG = Integer.parseInt(scan.nextLine());
        System.out.print("List the genres (to see the genre list, enter 'list'): ");
        String genreList = scan.nextLine();
        while (genreList.equalsIgnoreCase("list")) {
            genreData GD = new genreData();
            GD.printGenres();
            System.out.print("List the genres (to see the genre list, enter 'list'): ");
            genreList = scan.nextLine();
        }
        String[] UG = null;
        for (int i = 0; i < NOG; i++) {
            UG = genreList.split(", ");
        }
        return UG;
    }
    public static String[] userMoods(Scanner scan) {
        moodData MD = new moodData();
        MD.printMoods();
        System.out.print("List the mood you like to use for the recommendation: ");
        String moods = scan.nextLine();
        String[] UM = {moods};
        return UM;
    }
    public static int linearSearch(ArrayList<songData> Strings, int begin, int end, String target) {
        if (begin > end) {
            return -1;
        }
        if (Strings.get(begin).getSongName().equals(target)) {
            return begin;
        }
        if (Strings.get(end).getSongName().equals(target)) {
            return end;
        }
        return linearSearch(Strings, begin + 1, end - 1, target);
    }
}