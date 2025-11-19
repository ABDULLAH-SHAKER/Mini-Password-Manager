package models;

public class PasswordEntry {
    private String siteName;
    private String username;
    private String encryptedPassword;

    public PasswordEntry(String siteName, String username, String encryptedPassword) {
        this.siteName = siteName;
        this.username = username;
        this.encryptedPassword = encryptedPassword;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getUsername() {
        return username;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    @Override
    public String toString() {
        return "Site: " + siteName + ", Username: " + username;
    }
}
