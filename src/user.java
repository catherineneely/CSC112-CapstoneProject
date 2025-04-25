// Catherine Neely

import java.io.*;
import java.util.*;

public class user {

    private String username;
    private String artist;
    private String genre;
    private String mood;

    // constructor
    public user(String username) {
        this.username = username;
    }

    // getter and setter methods
    public String getUsername() {
        return username;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getArtist() {
        return artist;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getGenre() {
        return genre;
    }
    public void setMood(String mood) {
        this.mood = mood;
    }
    public String getMood() {
        return mood;
    }

    // sees if the user exists, then loads their preferences
    public boolean loadUserPreferences() {
        FileInputStream userFile = null;
        try {
            userFile = new FileInputStream(username + ".txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return false;
        }
        Scanner fileScanner = new Scanner(userFile);
        try {
            this.artist = fileScanner.nextLine();
            this.genre = fileScanner.nextLine();
            this.mood = fileScanner.nextLine();
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("File not found.");
            return false;
        }
    }
    // saves the user's preferences in their file
    public void saveUserPreferences() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(username + ".txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        writer.println(artist);
        writer.println(genre);
        writer.println(mood);
        System.out.println("Your preferences have been saved.");
        writer.flush();
        writer.close();
    }
    // lets the user enter their preferred artist, genre, and mood
    public void updateUserPreferences() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your preferred artist: ");
        this.artist = scanner.nextLine();
        System.out.print("Enter your preferred genre (to see the genre list, enter 'list'): ");
        this.genre = scanner.nextLine();
        while (this.genre.equalsIgnoreCase("list")) {
            genreData GD = new genreData();
            GD.printGenres();
            System.out.print("Enter your preferred genre (to see the genre list, enter 'list'): ");
            this.genre = scanner.nextLine();
        }
        System.out.print("Enter your preferred mood (to see the mood list, enter 'list'): ");
        this.mood = scanner.nextLine();
        while (this.mood.equalsIgnoreCase("list")) {
            moodData MD = new moodData();
            MD.printMoods();
            System.out.print("Enter your preferred mood (to see the mood list, enter 'list'): ");
            this.mood = scanner.nextLine();
        }
        saveUserPreferences();
    }
}