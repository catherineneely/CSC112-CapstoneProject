// Catherine Neely

// FIX BUG IN THIS CLASS !!

import java.io.*;
import java.util.*;

public class moodData {
    private String mood;

    public moodData(){
        mood = "";
    }
    public moodData(String mood) {
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }
    public void setMood(String mood) {
        this.mood = mood;
    }

    public void printMoods(){
        System.out.println("The mood options are...\nmelancholy | bold | serene | euphoric | " +
                "adventurous | romantic | nostalgic | confident | cinematic | upbeat | " +
                "restless | hopeful | grounded");
    }

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
        String line = fileScanner.nextLine();
        int p = 0;
        while (p < objects.size()) {
            if (line.equals("melancholy")) {
                if (objects.get(p).getSongGenre().equals("blues") ||
                        objects.get(p).getSongGenre().equals("jazz") ||
                        objects.get(p).getSongGenre().equals("folk") ||
                        objects.get(p).getSongGenre().equals("soul")) {
                    String mR = objects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack.push(moodArtist);
                    p++;
                }
            } else if (line.equals("bold")) {
                if (objects.get(p).getSongGenre().equals("punk") ||
                        objects.get(p).getSongGenre().equals("hip-hop") ||
                        objects.get(p).getSongGenre().equals("metal") ||
                        objects.get(p).getSongGenre().equals("rock")) {
                    String mR = objects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack.push(moodArtist);
                    p++;
                }
            } else if (line.equals("serene")) {
                if (objects.get(p).getSongGenre().equals("ambient") ||
                        objects.get(p).getSongGenre().equals("classical") ||
                        objects.get(p).getSongGenre().equals("lofi") ||
                        objects.get(p).getSongGenre().equals("indian")) {
                    String mR = objects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack.push(moodArtist);
                    p++;
                }
            } else if (line.equals("euphoric")) {
                if (objects.get(p).getSongGenre().equals("afrobeats") ||
                        objects.get(p).getSongGenre().equals("latin") ||
                        objects.get(p).getSongGenre().equals("pop") ||
                        objects.get(p).getSongGenre().equals("brazilian")) {
                    String mR = objects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack.push(moodArtist);
                    p++;
                }
            } else if (line.equals("adventurous")) {
                if (objects.get(p).getSongGenre().equals("world") ||
                        objects.get(p).getSongGenre().equals("korean") ||
                        objects.get(p).getSongGenre().equals("turkish") ||
                        objects.get(p).getSongGenre().equals("reggae")) {
                    String mR = objects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack.push(moodArtist);
                    p++;
                }
            } else if (line.equals("romantic")) {
                if (objects.get(p).getSongGenre().equals("r&b") ||
                        objects.get(p).getSongGenre().equals("soul") ||
                        objects.get(p).getSongGenre().equals("classical") ||
                        objects.get(p).getSongGenre().equals("jazz")) {
                    String mR = objects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack.push(moodArtist);
                    p++;
                }
            } else if (line.equals("nostalgic")) {
                if (objects.get(p).getSongGenre().equals("country") ||
                        objects.get(p).getSongGenre().equals("folk") ||
                        objects.get(p).getSongGenre().equals("indie") ||
                        objects.get(p).getSongGenre().equals("pop")) {
                    String mR = objects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack.push(moodArtist);
                    p++;
                }
            } else if (line.equals("confident")) {
                if (objects.get(p).getSongGenre().equals("hip-hop") ||
                        objects.get(p).getSongGenre().equals("k-pop") ||
                        objects.get(p).getSongGenre().equals("electronic") ||
                        objects.get(p).getSongGenre().equals("r&b")) {
                    String mR = objects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack.push(moodArtist);
                    p++;
                }
            } else if (line.equals("cinematic")) {
                if (objects.get(p).getSongGenre().equals("ambient") ||
                        objects.get(p).getSongGenre().equals("arabic") ||
                        objects.get(p).getSongGenre().equals("electronic") ||
                        objects.get(p).getSongGenre().equals("classical")) {
                    String mR = objects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack.push(moodArtist);
                    p++;
                }
            } else if (line.equals("upbeat")) {
                if (objects.get(p).getSongGenre().equals("j-pop") ||
                        objects.get(p).getSongGenre().equals("gaming") ||
                        objects.get(p).getSongGenre().equals("pop") ||
                        objects.get(p).getSongGenre().equals("brazilian")) {
                    String mR = objects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack.push(moodArtist);
                    p++;
                }
            } else if (line.equals("restless")) {
                if (objects.get(p).getSongGenre().equals("electronic") ||
                        objects.get(p).getSongGenre().equals("indie") ||
                        objects.get(p).getSongGenre().equals("lofi") ||
                        objects.get(p).getSongGenre().equals("rock")) {
                    String mR = objects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack.push(moodArtist);
                    p++;
                }
            } else if (line.equals("hopeful")) {
                if (objects.get(p).getSongGenre().equals("pop") ||
                        objects.get(p).getSongGenre().equals("soul") ||
                        objects.get(p).getSongGenre().equals("latin") ||
                        objects.get(p).getSongGenre().equals("classical")) {
                    String mR = objects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack.push(moodArtist);
                    p++;
                }
            } else if (line.equals("grounded")) {
                if (objects.get(p).getSongGenre().equals("folk") ||
                        objects.get(p).getSongGenre().equals("country") ||
                        objects.get(p).getSongGenre().equals("indian") ||
                        objects.get(p).getSongGenre().equals("world")) {
                    String mR = objects.get(p).getSongArtist();
                    Node moodArtist = new Node(mR);
                    stack.push(moodArtist);
                    p++;
                }
            } else {
                System.out.println("That mood option is not supported.");
                p = objects.size();
            }
        }

        Random rand = new Random();
        int ss = stack.stackSize();
        int popCount;
        if (ss > 0) {
            popCount = rand.nextInt(ss) + 1;
            for (int j = 0; j < popCount; j++) {
                Node poppedNode = stack.pop();
                String poppedMA = poppedNode.data;

                LinkedList moodListRec = new LinkedList();
                for (int k = 0; k < objects.size(); k++) {
                    songData data = objects.get(k);
                    if (data.getSongArtist().equalsIgnoreCase(poppedMA)) {
                        moodListRec.add(data.getSongName() + " by " + data.getSongArtist());
                    }
                }
                if (moodListRec.size() > 0) {
                    int artistsCount = rand.nextInt(moodListRec.size());
                    Node curr = moodListRec.head;
                    for (int w = 0; w < artistsCount; w++) {
                        curr = curr.next;
                    }
                    return curr.data;
                }
            }
        } else {
            System.out.println("There are no mood objects.");
        }
        return "No mood recommendation available";
    }
}
