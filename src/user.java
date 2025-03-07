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
    // lets the user enter their preferred artist, genre, and mood
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