package services;

import models.PasswordEntry;
import utils.Encryptor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    // Delete password by site
    public void deletePassword(String site) {
        boolean removed = entries.removeIf(entry -> entry.getSiteName().equalsIgnoreCase(site));
        if (removed) {
            saveToFile();
            System.out.println("Password deleted successfully!");
        } else {
            System.out.println("No matching site found to delete.");
        }
    }

    // Update password by site
    public void updatePassword(String site, String newUsername, String newPassword) {
        boolean found = false;
        for (int i = 0; i < entries.size(); i++) {
            PasswordEntry entry = entries.get(i);
            if (entry.getSiteName().equalsIgnoreCase(site)) {
                entries.set(i, new PasswordEntry(site, newUsername, Encryptor.encrypt(newPassword)));
                found = true;
                break;
            }
        }
        if (found) {
            saveToFile();
            System.out.println("Password updated successfully!");
        } else {
            System.out.println("No matching site found to update.");
        }
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
