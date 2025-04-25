// Catherine Neely

import java.io.*;
import java.util.*;

// Class for saving arrays of user data (artists, genres, moods) to text files
public class userData {
    // Saves an array of user input artists to "userArtistData.txt"
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
     // Saves an array of user input genres to "userGenreData.txt"
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
    // Saves an array of user input moods to "userMoodData.txt"
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
    // Recursive method that writes a file with information depending on user input in the main
    public static void writeToFileRecursive(String[] data, int index, PrintWriter pw) {
        if (index == data.length) {
            return;
        }
        pw.println(data[index]);
        writeToFileRecursive(data, index + 1, pw);
    }
    // Generates recommendations based on the stored user preferences
    public static void prefRecs(user user) {
        FileInputStream prefFile = null;
        try {
            prefFile = new FileInputStream(user.getUsername() + ".txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        // Loads all the songs
        songData songData = new songData();
        ArrayList<songData> songObjects = songData.songFileRead();
        Scanner fileScanner = new Scanner(prefFile);
        Stack stack = new Stack();
        ArrayList<String> userPref = new ArrayList<>();

        // Reads the user preferences from the file
        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            userPref.add(line);
        }

        // Artist recommendation
        // Find artists matching preferred artist, push their genres into stack
        // Randomly recommends a similar artist from that genre
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
                        System.out.println("Your recommended artist is " + pg +
                                " for your preferred artist " + userPref.getFirst() + ".");
                    } else {
                        continue;
                    }
                }
            }
        } else {}

        // Genre recommendation
        // Pushes the subgenres related to the preferred genre into a new stack
        // Pops a random subgenre, finds the genre+subgenre combos and recommends one
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

        // Mood recommendation
        // Each mood has a genre mapping, so artists from those genres are selected,
        // then a random one is picked and used to find songs to recommend based on the mood
        // Pushes matching artists to a stack, then randomly pops one and recommends a song
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
