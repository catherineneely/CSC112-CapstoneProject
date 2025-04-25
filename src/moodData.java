// Catherine Neely

import java.io.*;
import java.util.*;

// Class for handling user mood input and providing song recommendations based on the mood
public class moodData {
    private String mood;

    // Default constructor
    public moodData(){
        mood = "";
    }
    // Parameterized constructor
    public moodData(String mood) {
        this.mood = mood;
    }

    // Setter and getter methods
    public String getMood() {
        return mood;
    }
    public void setMood(String mood) {
        this.mood = mood;
    }

    // Prints all available mood options to the user.
    public void printMoods(){
        System.out.println("The mood options are...\nmelancholy | bold | serene | euphoric | " +
                "adventurous | romantic | reflective | confident | cinematic | upbeat | " +
                "restless | hopeful | grounded");
    }
    // Retrieves a song recommendation based on the user's mood
    public String getMoodRec() {
        FileInputStream fileRead = null;
        try {
            fileRead = new FileInputStream("userMoodData.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        songData songData = new songData();
        ArrayList<songData> objects = songData.songFileRead();
        Stack stack = new Stack();
        Scanner fileScanner = new Scanner(fileRead);
        // Reads the mood from the file
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            line = line.trim();
            // Based on the mood, finds genres that fit and pushes matching artists
            if (line.equals("melancholy")) {
                    for (int p = 0; p < objects.size(); p++) {
                        if (objects.get(p).getSongGenre().equalsIgnoreCase("blues") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("jazz") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("folk") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("soul")) {
                            String mR = objects.get(p).getSongArtist();
                            Node moodArtist = new Node(mR);
                            stack.push(moodArtist);
                        }
                    }
                } else if (line.equals("bold")) {
                    for (int p = 0; p < objects.size(); p++) {
                        if (objects.get(p).getSongGenre().equalsIgnoreCase("punk") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("hip-hop") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("metal") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("rock")) {
                            String mR = objects.get(p).getSongArtist();
                            Node moodArtist = new Node(mR);
                            stack.push(moodArtist);
                        }
                    }
                } else if (line.equals("serene")) {
                    for (int p = 0; p < objects.size(); p++) {
                        if (objects.get(p).getSongGenre().equalsIgnoreCase("ambient") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("classical") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("lofi") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("indian")) {
                            String mR = objects.get(p).getSongArtist();
                            Node moodArtist = new Node(mR);
                            stack.push(moodArtist);
                        }
                    }
                } else if (line.equals("euphoric")) {
                    for (int p = 0; p < objects.size(); p++) {
                        if (objects.get(p).getSongGenre().equalsIgnoreCase("afrobeats") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("latin") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("pop") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("brazilian")) {
                            String mR = objects.get(p).getSongArtist();
                            Node moodArtist = new Node(mR);
                            stack.push(moodArtist);
                        }
                    }
                } else if (line.equals("adventurous")) {
                    for (int p = 0; p < objects.size(); p++) {
                        if (objects.get(p).getSongGenre().equalsIgnoreCase("world") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("korean") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("turkish") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("reggae")) {
                            String mR = objects.get(p).getSongArtist();
                            Node moodArtist = new Node(mR);
                            stack.push(moodArtist);
                        }
                    }
                } else if (line.equals("romantic")) {
                    for (int p = 0; p < objects.size(); p++) {
                        if (objects.get(p).getSongGenre().equalsIgnoreCase("r&b") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("soul") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("classical") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("jazz")) {
                            String mR = objects.get(p).getSongArtist();
                            Node moodArtist = new Node(mR);
                            stack.push(moodArtist);
                        }
                    }
                } else if (line.equals("reflective")) {
                    for (int p = 0; p < objects.size(); p++) {
                        if (objects.get(p).getSongGenre().equalsIgnoreCase("country") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("folk") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("indie") ||
                                objects.get(p).getSongGenre().equalsIgnoreCase("pop")) {
                            String mR = objects.get(p).getSongArtist();
                            Node moodArtist = new Node(mR);
                            stack.push(moodArtist);
                        }
                    }
                } else if (line.equals("confident")) {
                    for (int p = 0; p < objects.size(); p++) {
                        if (objects.get(p).getSongGenre().equals("hip-hop") ||
                                objects.get(p).getSongGenre().equals("k-pop") ||
                                objects.get(p).getSongGenre().equals("electronic") ||
                                objects.get(p).getSongGenre().equals("r&b")) {
                            String mR = objects.get(p).getSongArtist();
                            Node moodArtist = new Node(mR);
                            stack.push(moodArtist);
                        }
                    }
                } else if (line.equals("cinematic")) {
                    for (int p = 0; p < objects.size(); p++) {
                        if (objects.get(p).getSongGenre().equals("ambient") ||
                                objects.get(p).getSongGenre().equals("arabic") ||
                                objects.get(p).getSongGenre().equals("electronic") ||
                                objects.get(p).getSongGenre().equals("classical")) {
                            String mR = objects.get(p).getSongArtist();
                            Node moodArtist = new Node(mR);
                            stack.push(moodArtist);
                        }
                    }
                } else if (line.equals("upbeat")) {
                    for (int p = 0; p < objects.size(); p++) {
                        if (objects.get(p).getSongGenre().equals("j-pop") ||
                                objects.get(p).getSongGenre().equals("gaming") ||
                                objects.get(p).getSongGenre().equals("pop") ||
                                objects.get(p).getSongGenre().equals("brazilian")) {
                            String mR = objects.get(p).getSongArtist();
                            Node moodArtist = new Node(mR);
                            stack.push(moodArtist);
                        }
                    }
                } else if (line.equals("restless")) {
                    for (int p = 0; p < objects.size(); p++) {
                        if (objects.get(p).getSongGenre().equals("electronic") ||
                                objects.get(p).getSongGenre().equals("indie") ||
                                objects.get(p).getSongGenre().equals("lofi") ||
                                objects.get(p).getSongGenre().equals("rock")) {
                            String mR = objects.get(p).getSongArtist();
                            Node moodArtist = new Node(mR);
                            stack.push(moodArtist);
                        }
                    }
                } else if (line.equals("hopeful")) {
                    for (int p = 0; p < objects.size(); p++) {
                        if (objects.get(p).getSongGenre().equals("pop") ||
                                objects.get(p).getSongGenre().equals("soul") ||
                                objects.get(p).getSongGenre().equals("latin") ||
                                objects.get(p).getSongGenre().equals("classical")) {
                            String mR = objects.get(p).getSongArtist();
                            Node moodArtist = new Node(mR);
                            stack.push(moodArtist);
                        }
                    }
                } else if (line.equals("grounded")) {
                    for (int p = 0; p < objects.size(); p++) {
                        if (objects.get(p).getSongGenre().equals("folk") ||
                                objects.get(p).getSongGenre().equals("country") ||
                                objects.get(p).getSongGenre().equals("indian") ||
                                objects.get(p).getSongGenre().equals("world")) {
                            String mR = objects.get(p).getSongArtist();
                            Node moodArtist = new Node(mR);
                            stack.push(moodArtist);
                        }
                    }
                } else {
                    System.out.println("That mood option is not supported.");
                    break;
                }
        }

        Random rand = new Random();
        int ss = stack.stackSize();
        int popCount;
        if (ss > 0) {
            popCount = rand.nextInt(ss) + 1;
            Node poppedNode;
            String poppedMA = "";
            for (int j = 0; j < popCount; j++) {
                poppedNode = stack.pop();
                poppedMA = poppedNode.data;
            }
            // Creates a list of songs by the selected artist
            LinkedList moodListRec = new LinkedList();
            for (int k = 0; k < objects.size(); k++) {
                songData data = objects.get(k);
                if (data.getSongArtist().equalsIgnoreCase(poppedMA)) {
                    moodListRec.add(data.getSongName() + " by " + data.getSongArtist());
                }
            }
            // Chooses a random song from the list
            if (moodListRec.size() > 0) {
                int artistsCount = rand.nextInt(moodListRec.size());
                Node curr = moodListRec.head;
                for (int w = 0; w < artistsCount ; w++) {
                    curr = curr.next;
                }
                if (curr != null) {
                    return curr.data;   // Returns the recommendation
                }
            }
        } else {}
        return "No mood recommendation available";
    }
}
