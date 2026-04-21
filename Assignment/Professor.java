package Assignment;

import java.util.List;
import java.util.Scanner;

public class Professor extends User {
    public Professor(String email, String password) {
        super(email, password);
    }

    @Override
    public void displayMenu(Database db) {
        Scanner inp = new Scanner(System.in);
        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("\n==================");
            System.out.println(" PROFESSOR MENU");
            System.out.println("==================");
            System.out.println("1. Manage Courses (Update details)");
            System.out.println("2. View Enrolled Students");
            System.out.println("3. View Course Feedback");
            System.out.println("4. Toggle Drop Deadline");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");

            int choice = inp.nextInt();
            inp.nextLine();

            switch (choice) {
                case 1:
                    manageCourses(db, inp);
                    break;
                case 2:
                    viewEnrolledStudents(db, inp);
                    break;
                case 3:
                    viewFeedback(db, inp);
                    break;
                case 4:
                    toggleDropDeadline(db, inp);
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
        return "Professor";
    }

    public void manageCourses(Database db, Scanner inp) {
        System.out.print("Enter Course Code to update: ");
        String code = inp.nextLine();
        Course c = db.getCourse(code);

        if (c != null && c.getProfessorEmail().equals(this.getEmail())) {
            System.out.print("Enter new Syllabus details: ");
            c.setSyllabus(inp.nextLine());
            System.out.print("Enter new Timings (e.g., Mon/Wed 10AM): ");
            c.setTimings(inp.nextLine());
            System.out.print("Enter new Enrollment Limit: ");
            c.setEnrollmentLimit(inp.nextInt());
            inp.nextLine();
            System.out.println("Course updated successfully.");
        } else {
            System.out.println("Course not found or you are not assigned to it.");
        }
    }

    public void viewEnrolledStudents(Database db, Scanner inp) {
        System.out.print("Enter Course Code to view roster: ");
        String code = inp.nextLine();
        Course c = db.getCourse(code);

        if (c != null && c.getProfessorEmail().equals(this.getEmail())) {
            List<String> students = c.getEnrolledStudentEmails();
            System.out.println("\n--- Enrolled Students for " + code + " ---");
            if (students.isEmpty()) {
                System.out.println("No students enrolled.");
                return;
            }
            for (String s : students) {
                System.out.println("- " + s);
            }
        } else {
            System.out.println("Course not found or you are not assigned to it.");
        }
    }

    public void viewFeedback(Database db, Scanner inp) {
        System.out.print("Enter Course Code to view feedback: ");
        String code = inp.nextLine();
        Course c = db.getCourse(code);

        if (c != null && c.getProfessorEmail().equals(this.getEmail())) {
            System.out.println("\n--- Feedback for " + code + " ---");
            if (c.getFeedbacks().isEmpty()) {
                System.out.println("No feedback available.");
            } else {
                for (Feedback f : c.getFeedbacks()) {
                    System.out.println(f);
                }
            }
        } else {
            System.out.println("Course not found or you are not assigned to it.");
        }
    }

    public void toggleDropDeadline(Database db, Scanner inp) {
        System.out.print("Enter Course Code to toggle drop deadline: ");
        String code = inp.nextLine();
        Course c = db.getCourse(code);

        if (c != null && c.getProfessorEmail().equals(this.getEmail())) {
            c.setDropDeadlinePassed(!c.isDropDeadlinePassed());
            System.out.println("Drop deadline passed status for " + code + " is now: " + c.isDropDeadlinePassed());
        } else {
            System.out.println("Course not found or not assigned to you.");
        }
    }
}