package Assignment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        db.loadData();

        if (db.getUser("admin@univ.edu") == null) {
            db.addUser(new Administrator("admin@univ.edu", "admin123"));
            db.addUser(new Student("student@univ.edu", "pass123"));
            db.addUser(new TA("ta@univ.edu", "ta123")); // Seed a default TA
            db.addUser(new Professor("prof@univ.edu", "teach123"));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to the University System");

        while (true) {
            System.out.print("\nEnter Email (or 'exit'): ");
            String email = scanner.nextLine();
            if (email.equalsIgnoreCase("exit"))
                break;

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            try {
                User loggedInUser = db.authenticateUser(email, password);
                loggedInUser.displayMenu(db);
            } catch (InvalidLoginException e) {
                System.out.println("Login Error: " + e.getMessage());
            }
        }

        db.saveData();
        System.out.println("Exiting application.");
        scanner.close();
    }
}
