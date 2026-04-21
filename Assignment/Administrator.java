package Assignment;

import java.util.List;
import java.util.Scanner;

public class Administrator extends User {
    public Administrator(String email, String password) {
        super(email, password);
    }

    @Override
    public void displayMenu(Database db) {
        Scanner inp = new Scanner(System.in);
        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("\n=========================");
            System.out.println("   ADMINISTRATOR MENU");
            System.out.println("=========================");
            System.out.println("1. Manage Course Catalog (Add/Delete Course)");
            System.out.println("2. Manage Student Records (Assign Grades)");
            System.out.println("3. Assign Professors to Courses");
            System.out.println("4. Handle Complaints");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");

            int choice = inp.nextInt();
            inp.nextLine();

            switch (choice) {
                case 1:
                    manageCourseCatalog(db, inp);
                    break;
                case 2:
                    manageStudentRecords(db, inp);
                    break;
                case 3:
                    assignProfessor(db, inp);
                    break;
                case 4:
                    handleComplaints(db, inp);
                    break;
                case 5:
                    System.out.println("Logging out...");
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    @Override
    public String getRole() {
        return "Administrator";
    }

    public void manageCourseCatalog(Database db, Scanner inp) {
        System.out.println("\n--- Manage Course Catalog ---");
        System.out.println("1. Add a new course");
        System.out.println("2. Delete an existing course");
        System.out.print("Enter your choice: ");

        int action = inp.nextInt();
        inp.nextLine();

        if (action == 1) {

            System.out.print("Enter Course Code (e.g., CSE201): ");
            String code = inp.nextLine();
            System.out.print("Enter Course Title: ");
            String title = inp.nextLine();
            System.out.print("Enter Credits (2 or 4): ");
            int credits = inp.nextInt();
            inp.nextLine();

            try {
                db.addCourse(new Course(code, title, credits));
                System.out.println("Success! Course added.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } else if (action == 2) {

            System.out.print("Enter Course Code to delete: ");
            String code = inp.nextLine();

            if (db.getCourseCatalog().containsKey(code)) {
                db.getCourseCatalog().remove(code);
                System.out.println("Success! Course " + code + " has been removed from the catalog.");
            } else {
                System.out.println("Error: Course not found in the catalog.");
            }

        } else {
            System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    public void manageStudentRecords(Database db, Scanner inp) {
        System.out.print("Enter Student Email: ");
        String email = inp.nextLine();
        User u = db.getUser(email);

        if (u != null && u.getRole().equals("Student")) {

            Student student = (Student) u;

            System.out.print("Enter Course Code to assign grade: ");
            String code = inp.nextLine();
            System.out.print("Enter Grade Points (1-10): ");
            int points = inp.nextInt();
            inp.nextLine();

            student.assignGrade(code, points);
            System.out.println("Grade assigned successfully.");

        } else {
            System.out.println("Error: User not found or is not a Student.");
        }
    }

    public void assignProfessor(Database db, Scanner inp) {
        System.out.print("Enter Course Code: ");
        String courseCode = inp.nextLine();
        System.out.print("Enter Professor Email: ");
        String profEmail = inp.nextLine();

        Course c = db.getCourse(courseCode);
        User p = db.getUser(profEmail);

        if (c != null && p instanceof Professor) {
            c.setProfessorEmail(profEmail);
            System.out.println("Professor assigned successfully.");
        } else {
            System.out.println("Invalid Course Code or Professor Email.");
        }
    }

    public void handleComplaints(Database db, Scanner inp) {
        System.out.println("\n--- Pending Complaints ---");
        List<Complaint> complaints = db.getComplaints();
        boolean hasPending = false;

        for (Complaint c : complaints) {
            if (c.getStatus().equals("Pending")) {
                System.out.println(c.toString());
                System.out.println("--------------------");
                hasPending = true;
            }
        }

        if (!hasPending) {
            System.out.println("No pending complaints.");
            return;
        }

        System.out.print("Enter Complaint ID to resolve (or 0 to cancel): ");
        int id = inp.nextInt();
        inp.nextLine();

        for (Complaint c : complaints) {
            if (c.getId() == id) {
                c.setStatus("Resolved");
                System.out.println("Complaint marked as Resolved.");
                return;
            }
        }
    }
}