// Catherine Neely

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
                prefRecs(user);
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
    public static void prefRecs(user user) {
        FileInputStream prefFile = null;
        try {
            prefFile = new FileInputStream(user.getUsername() + ".txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        songData songData = new songData();
        ArrayList<songData> songObjects = songData.songFileRead();
        Scanner fileScanner = new Scanner(prefFile);
        Stack stack = new Stack();
        ArrayList<String> userPref = new ArrayList<>();

        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            userPref.add(line);
        }

        // artist rec
        ArrayList<String> userArtists = new ArrayList<>();
        for (int p = 0; p < songObjects.size(); p++) {
            if (userPref.getFirst().contains(songObjects.get(p).getSongArtist())) {
                String genre = songObjects.get(p).getSongGenre();
                Node songGenre = new Node(genre);
                stack.push(songGenre);
                userArtists.add(songObjects.get(p).getSongArtist());

            }
        }
        Random rand = new Random();
        int ss = stack.stackSize();
        int popCount;
        if (ss > 0) {
            popCount = rand.nextInt(ss) + 1;
            for (int j = 0; j < popCount; j++) {
                Node poppedNode = stack.pop();
                String poppedGenre = poppedNode.data;

                LinkedList genreArtists = new LinkedList();
                for (int k = 0; k < songObjects.size(); k++) {
                    songData data = songObjects.get(k);
                    if (data.getSongGenre().equalsIgnoreCase(poppedGenre)) {
                        genreArtists.add(data.getSongArtist());
                    }
                }
                if (genreArtists.size() > 0) {
                    int artistsCount = rand.nextInt(genreArtists.size());
                    Node curr = genreArtists.head;
                    for (int w = 0; w < artistsCount; w++) {
                        curr = curr.next;
                    }
                    String pg = curr.data;
                    if (pg.contains(", ")) {
                        String[] singleArtist = pg.split(", ");
                        pg = singleArtist[0].trim();
                    }
                    if (!userArtists.contains(pg)) {
                        System.out.println("Your recommended artist is " + pg + " for your preferred artist " + userPref.getFirst() + ".");
                    } else {
                        continue;
                    }
                }
            }
        } else {}

        // genre rec
        Stack stack2 = new Stack();
        for (int p = 0; p < songObjects.size(); p++) {
            if (userPref.get(1).contains(songObjects.get(p).getSongGenre())) {
                String genre = songObjects.get(p).getSongSubgenre();
                Node songSubgenre = new Node(genre);
                stack2.push(songSubgenre);
            }
        }
        int ss2 = stack2.stackSize();
        int popCount2;
        if (ss2 > 0) {
            popCount2 = rand.nextInt(ss2) + 1;
            Node selectedNode = null;
            for (int j = 0; j < popCount2; j++) {
                selectedNode = stack2.pop();
            }
            String selectedSubgenre = selectedNode.data;

            LinkedList genreSubgenres = new LinkedList();
            for (int k = 0; k < songObjects.size(); k++) {
                songData data = songObjects.get(k);
                if (data.getSongSubgenre().equalsIgnoreCase(selectedSubgenre)) {
                    genreSubgenres.add(data.getSongGenre() + " " + data.getSongSubgenre());
                }
            }

            Node curr = genreSubgenres.head;
            if (genreSubgenres.size() > 0) {
                int artistsCount = rand.nextInt(genreSubgenres.size());
                for (int w = 0; w < artistsCount; w++) {
                    curr = curr.next;
                }
                System.out.println("Your recommended genre is " + curr.data + ".");
            }
        } else {}

        //mood rec
        Stack stack3 = new Stack();
        userPref.get(2).trim();
        if (userPref.get(2).equals("melancholy")) {
            for (int p = 0; p < songObjects.size(); p++) {
                if (songObjects.get(p).getSongGenre().equalsIgnoreCase("blues") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("jazz") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("folk") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("soul")) {
                    String mR = songObjects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack3.push(moodArtist);
                }
            }
        } else if (userPref.get(2).equals("bold")) {
            for (int p = 0; p < songObjects.size(); p++) {
                if (songObjects.get(p).getSongGenre().equalsIgnoreCase("punk") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("hip-hop") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("metal") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("rock")) {
                    String mR = songObjects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack3.push(moodArtist);
                }
            }
        } else if (userPref.get(2).equals("serene")) {
            for (int p = 0; p < songObjects.size(); p++) {
                if (songObjects.get(p).getSongGenre().equalsIgnoreCase("ambient") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("classical") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("lofi") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("indian")) {
                    String mR = songObjects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack3.push(moodArtist);
                }
            }
        } else if (userPref.get(2).equals("euphoric")) {
            for (int p = 0; p < songObjects.size(); p++) {
                if (songObjects.get(p).getSongGenre().equalsIgnoreCase("afrobeats") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("latin") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("pop") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("brazilian")) {
                    String mR = songObjects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack3.push(moodArtist);
                }
            }
        } else if (userPref.get(2).equals("adventurous")) {
            for (int p = 0; p < songObjects.size(); p++) {
                if (songObjects.get(p).getSongGenre().equalsIgnoreCase("world") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("korean") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("turkish") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("reggae")) {
                    String mR = songObjects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack3.push(moodArtist);
                }
            }
        } else if (userPref.get(2).equals("romantic")) {
            for (int p = 0; p < songObjects.size(); p++) {
                if (songObjects.get(p).getSongGenre().equalsIgnoreCase("r&b") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("soul") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("classical") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("jazz")) {
                    String mR = songObjects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack3.push(moodArtist);
                }
            }
        } else if (userPref.get(2).equals("reflective")) {
            for (int p = 0; p < songObjects.size(); p++) {
                if (songObjects.get(p).getSongGenre().equalsIgnoreCase("country") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("folk") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("indie") ||
                        songObjects.get(p).getSongGenre().equalsIgnoreCase("pop")) {
                    String mR = songObjects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack3.push(moodArtist);
                }
            }
        } else if (userPref.get(2).equals("confident")) {
            for (int p = 0; p < songObjects.size(); p++) {
                if (songObjects.get(p).getSongGenre().equals("hip-hop") ||
                        songObjects.get(p).getSongGenre().equals("k-pop") ||
                        songObjects.get(p).getSongGenre().equals("electronic") ||
                        songObjects.get(p).getSongGenre().equals("r&b")) {
                    String mR = songObjects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack3.push(moodArtist);
                }
            }
        } else if (userPref.get(2).equals("cinematic")) {
            for (int p = 0; p < songObjects.size(); p++) {
                if (songObjects.get(p).getSongGenre().equals("ambient") ||
                        songObjects.get(p).getSongGenre().equals("arabic") ||
                        songObjects.get(p).getSongGenre().equals("electronic") ||
                        songObjects.get(p).getSongGenre().equals("classical")) {
                    String mR = songObjects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack3.push(moodArtist);
                }
            }
        } else if (userPref.get(2).equals("upbeat")) {
            for (int p = 0; p < songObjects.size(); p++) {
                if (songObjects.get(p).getSongGenre().equals("j-pop") ||
                        songObjects.get(p).getSongGenre().equals("gaming") ||
                        songObjects.get(p).getSongGenre().equals("pop") ||
                        songObjects.get(p).getSongGenre().equals("brazilian")) {
                    String mR = songObjects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack3.push(moodArtist);
                }
            }
        } else if (userPref.get(2).equals("restless")) {
            for (int p = 0; p < songObjects.size(); p++) {
                if (songObjects.get(p).getSongGenre().equals("electronic") ||
                        songObjects.get(p).getSongGenre().equals("indie") ||
                        songObjects.get(p).getSongGenre().equals("lofi") ||
                        songObjects.get(p).getSongGenre().equals("rock")) {
                    String mR = songObjects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack3.push(moodArtist);
                }
            }
        } else if (userPref.get(2).equals("hopeful")) {
            for (int p = 0; p < songObjects.size(); p++) {
                if (songObjects.get(p).getSongGenre().equals("pop") ||
                        songObjects.get(p).getSongGenre().equals("soul") ||
                        songObjects.get(p).getSongGenre().equals("latin") ||
                        songObjects.get(p).getSongGenre().equals("classical")) {
                    String mR = songObjects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack3.push(moodArtist);
                }
            }
        } else if (userPref.get(2).equals("grounded")) {
            for (int p = 0; p < songObjects.size(); p++) {
                if (songObjects.get(p).getSongGenre().equals("folk") ||
                        songObjects.get(p).getSongGenre().equals("country") ||
                        songObjects.get(p).getSongGenre().equals("indian") ||
                        songObjects.get(p).getSongGenre().equals("world")) {
                    String mR = songObjects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack3.push(moodArtist);
                }
            }
        } else {
            System.out.println("That mood option is not supported.");
            return;
        }
        int ss3 = stack3.stackSize();
        int popCount3;
        if (ss3 > 0) {
            popCount3 = rand.nextInt(ss3) + 1;
            Node poppedNode;
            String poppedMA = "";
            for (int j = 0; j < popCount3; j++) {
                poppedNode = stack3.pop();
                poppedMA = poppedNode.data;
            }
            LinkedList moodListRec = new LinkedList();
            for (int k = 0; k < songObjects.size(); k++) {
                songData data = songObjects.get(k);
                if (data.getSongArtist().equalsIgnoreCase(poppedMA)) {
                    moodListRec.add(data.getSongName() + " by " + data.getSongArtist());
                }
            }
            if (moodListRec.size() > 0) {
                int artistsCount = rand.nextInt(moodListRec.size());
                Node curr = moodListRec.head;
                for (int w = 0; w < artistsCount ; w++) {
                    curr = curr.next;
                }
                if (curr != null) {
                    System.out.println("Your recommended song for a " + userPref.get(2) + " mood is " + curr.data + ".");
                }
            }
        } else {
            System.out.println("There are no mood objects.");
        }
    }
}