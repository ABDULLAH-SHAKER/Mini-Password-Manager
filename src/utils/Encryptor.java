package utils;

import java.util.Base64;

public class Encryptor {

    // Encrypt a plain password
    public static String encrypt(String plainPassword) {
        String base64 = Base64.getEncoder().encodeToString(plainPassword.getBytes());
        return "MPM_" + base64; //  Base64
    }

    // Decrypt the encrypted password
    public static String decrypt(String encrypted) {
        if (!encrypted.startsWith("MPM_")) {
            return "Invalid encrypted format!";
        }

        String base64Part = encrypted.substring(4);
        byte[] decodedBytes = Base64.getDecoder().decode(base64Part);
        return new String(decodedBytes);
    }
}
