package services;

import models.PasswordEntry;
import utils.Encryptor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasswordManager {

    private List<PasswordEntry> entries;
    private final String fileName = "passwords.db";

    public PasswordManager() {
        entries = new ArrayList<>();
        loadFromFile();
    }

    // Add new password
    public void addPassword(String site, String username, String password) {
        String encrypted = Encryptor.encrypt(password);
        PasswordEntry entry = new PasswordEntry(site, username, encrypted);
        entries.add(entry);
        saveToFile();
        System.out.println("Password added successfully!");
    }

    // List all passwords
    public void listPasswords() {
        if (entries.isEmpty()) {
            System.out.println("No passwords stored.");
            return;
        }
        for (PasswordEntry entry : entries) {
            System.out.println(entry.toString());
        }
    }

    // Search by site
    public void searchPassword(String site) {
        boolean found = false;
        for (PasswordEntry entry : entries) {
            if (entry.getSiteName().equalsIgnoreCase(site)) {
                System.out.println(entry.toString() + ", Password: " + Encryptor.decrypt(entry.getEncryptedPassword()));
                found = true;
            }
        }
        if (!found) System.out.println("No matching site found.");
    }

    // Save to file
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(entries);
        } catch (IOException e) {
            System.out.println("Error saving passwords: " + e.getMessage());
        }
    }

    // Load from file
    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        File file = new File(fileName);
        if (!file.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            entries = (ArrayList<PasswordEntry>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading passwords: " + e.getMessage());
        }
    }
}
