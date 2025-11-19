import services.PasswordManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordManager manager = new PasswordManager();
        boolean exit = false;

        System.out.println("=== Mini Password Manager ===");

        while (!exit) {
            System.out.println("\n1. Add Password");
            System.out.println("2. List Passwords");
            System.out.println("3. Search Password");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Site: ");
                    String site = scanner.nextLine();
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    manager.addPassword(site, username, password);
                    break;
                case "2":
                    manager.listPasswords();
                    break;
                case "3":
                    System.out.print("Site to search: ");
                    String searchSite = scanner.nextLine();
                    manager.searchPassword(searchSite);
                    break;
                case "4":
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
