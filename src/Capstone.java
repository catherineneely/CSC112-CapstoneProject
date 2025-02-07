// Catherine Neely

import java.util.*;

public class Capstone {
    public static void main(String[] args) {
        String[] userArtists = userMusic();


    }
    public static String[] userMusic() {
        Scanner input = new Scanner(System.in);
        System.out.println("Who are your favorite music artists? ");
        String artists = input.nextLine();
        String[] data = null;
        while (input.hasNextLine()) {
            data = artists.split(",");
        }
        return data;
    }
}
