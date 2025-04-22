// Catherine Neely

import java.util.*;

public class genreData {
    String genreName;
    String subgenre;

    public genreData() {
        genreName = "";
        subgenre = "";
    }
    public genreData(String genreName, String subgenre) {
        this.genreName = genreName;
        this.subgenre = subgenre;
    }

    public String getGenreName() {
        return genreName;
    }
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
    public String getSubgenre() {
        return subgenre;
    }
    public void setSubgenre(String subgenre) {
        this.subgenre = subgenre;
    }

    public ArrayList<String> collectGenres() {
        ArrayList<songData> objects = songData.songFileRead();
        ArrayList<String> genreList = new ArrayList<>();

        for (int i = 0; i < objects.size(); i++) {
            String newGenre = objects.get(i).getSongGenre();

            if (!genreList.contains(newGenre)) {
                genreList.add(newGenre);
                Node songGenre = new Node(newGenre);
            }
        }
        return genreList;
    }
    public void printGenres() {
        ArrayList<String> genres = collectGenres();
        System.out.println("These are the current genres in the database...");
        for (int i = 0; i < genres.size()/2; i++) {
            System.out.print(genres.get(i) + " | ");
        }
        System.out.println();
        for (int j = genres.size()/2; j < genres.size(); j++) {
            System.out.print(genres.get(j) + " | ");
        }
        System.out.println();
    }

    public ArrayList<String> collectSubgenres() {
        ArrayList<songData> objects = songData.songFileRead();
        ArrayList<String> subgenreList = new ArrayList<>();

        for (int i = 0; i < objects.size(); i++) {
            String newSubgenre = objects.get(i).getSongSubgenre();

            if (!subgenreList.contains(newSubgenre)) {
                subgenreList.add(newSubgenre);
                Node songGenre = new Node(newSubgenre);
            }
        }
        return subgenreList;
    }
    public void printSubgenres() {
        ArrayList<String> subgenres = collectSubgenres();
        System.out.println("These are the current subgenres in the database...");
        for (double i = 0; i < subgenres.size()*((double)1/3); i++) {
            System.out.print(subgenres.get((int)i) + " | ");
        }
        System.out.println();
        for (double j = subgenres.size()*((double)1/3) + 1; j < subgenres.size()*((double)2/3); j++) {
            System.out.print(subgenres.get((int)j) + " | ");
        }
        System.out.println();
        for (double k = subgenres.size()*((double)2/3); k < subgenres.size(); k++) {
            System.out.print(subgenres.get((int)k) + " | ");
        }
        System.out.println();
    }
}
