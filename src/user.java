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
        File userFile = new File(username + ".txt");
        if (!userFile.exists()) {
            return false;
        }
        try {
            Scanner fileScanner = new Scanner(userFile);
            this.artist = fileScanner.nextLine();
            this.genre = fileScanner.nextLine();
            this.mood = fileScanner.nextLine();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return false;
        }
    }
    public void saveUserPreferences() {
        try {
            PrintWriter writer = new PrintWriter(username + ".txt");
            writer.println(artist);
            writer.println(genre);
            writer.println(mood);
            System.out.println("Your preferences have been saved.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
    }
    public void updateUserPreferences() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your preferred artist: ");
        this.artist = scanner.nextLine();
        System.out.print("Enter your preferred genre: ");
        this.genre = scanner.nextLine();
        System.out.print("Enter your mood: ");
        this.mood = scanner.nextLine();
        saveUserPreferences();
    }
}


// I suggest that you use a username to track each user and create one file for each user
// where they can have their preferences there, which genre, artist, mood so when the user
// enter their username again you find and read their preferences from their file.
// The filename could be their username, and you can ask them if they want to update their
// preferences.