package Assignment;

import java.util.Scanner;

public class TA extends Student {

    public TA(String email, String password) {
        super(email, password);
    }

    @Override
    public String getRole() {
        return "TA";
    }

    @Override
    public void displayMenu(Database db) {
        Scanner inp = new Scanner(System.in);
        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("\n==================");
            System.out.println("     TA MENU");
            System.out.println("==================");
            System.out.println("1. View available courses");
            System.out.println("2. Register for course");
            System.out.println("3. View schedule");
            System.out.println("4. Track academic progress");
            System.out.println("5. Drop courses");
            System.out.println("6. Submit complains");
            System.out.println("7. Provide Course Feedback");
            System.out.println("8. Manage Student Grades (TA privilege)");
            System.out.println("9. Logout");
            System.out.print("Enter choice: ");

            int choice = inp.nextInt();
            inp.nextLine();

            switch (choice) {
                case 1:
                    super.viewAvailableCourses(db);
                    break;
                case 2:
                    super.registerForCourse(db, inp);
                    break;
                case 3:
                    super.viewSchedule(db);
                    break;
                case 4:
                    super.trackAcademicProgress(db);
                    break;
                case 5:
                    super.dropCourse(db, inp);
                    break;
                case 6:
                    super.submitComplaint(db, inp);
                    break;
                case 7:
                    super.submitFeedback(db, inp);
                    break;
                case 8:
                    manageGrades(db, inp);
                    break;
                case 9:
                    System.out.println("Logging out...");
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void manageGrades(Database db, Scanner inp) {
        System.out.print("Enter Student Email: ");
        String email = inp.nextLine();
        User u = db.getUser(email);

        if (u != null && (u instanceof Student)) {
            Student student = (Student) u;
            System.out.print("Enter Course Code to assign grade: ");
            String code = inp.nextLine();
            System.out.print("Enter Grade Points (1-10): ");
            int points = inp.nextInt();
            inp.nextLine();

            student.assignGrade(code, points);
            System.out.println("Grade assigned successfully by TA.");
        } else {
            System.out.println("Error: Student not found.");
        }
    }
}