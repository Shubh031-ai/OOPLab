package Assignment;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Student extends User {
    private List<String> registeredCourses;
    private HashMap<String, Integer> completedCourses;

    public Student(String email, String password) {
        super(email, password);
        this.registeredCourses = new ArrayList<>();
        this.completedCourses = new HashMap<>();
    }

    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public HashMap<String, Integer> getCompletedCourses() {
        return completedCourses;
    }

    public void assignGrade(String courseCode, int gradePoints) {
        completedCourses.put(courseCode, gradePoints);
        registeredCourses.remove(courseCode);
    }

    public void restoreCourseRecord(String courseCode, String status, int grade) {
        if (status.equals("Registered")) {
            registeredCourses.add(courseCode);
        } else if (status.equals("Completed")) {
            completedCourses.put(courseCode, grade);
        }
    }

    @Override
    public void displayMenu(Database db) {
        Scanner inp = new Scanner(System.in);
        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("\n==================");
            System.out.println("  STUDENT MENU");
            System.out.println("==================");
            System.out.println("1. View available courses");
            System.out.println("2. Register for course");
            System.out.println("3. View schedule");
            System.out.println("4. Track academic progress");
            System.out.println("5. Drop courses");
            System.out.println("6. Submit complains");
            System.out.println("7. Provide Course Feedback");
            System.out.println("8. Logout");
            System.out.print("Enter choice: ");

            int choice = inp.nextInt();
            inp.nextLine();

            switch (choice) {
                case 1:
                    viewAvailableCourses(db);
                    break;
                case 2:
                    registerForCourse(db, inp);
                    break;
                case 3:
                    viewSchedule(db);
                    break;
                case 4:
                    trackAcademicProgress(db);
                    break;
                case 5:
                    dropCourse(db, inp);
                    break;
                case 6:
                    submitComplaint(db, inp);
                    break;
                case 7:
                    submitFeedback(db, inp);
                    break;
                case 8:
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
        return "Student";
    }

    protected void viewAvailableCourses(Database db) {
        System.out.println("\n--- Available Course Catalog ---");
        if (db.getCourseCatalog().isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        for (Course c : db.getCourseCatalog().values()) {
            System.out.println("Code: " + c.getCourseCode() + " | Title: " + c.getTitle() + " | Credits: "
                    + c.getCredits() + " | Prof: " + c.getProfessorEmail() + " | Timings: " + c.getTimings());
        }
    }

    protected void registerForCourse(Database db, Scanner inp) {
        System.out.print("Enter Course Code to register: ");
        String code = inp.nextLine();
        Course c = db.getCourse(code);

        if (c == null) {
            System.out.println("Course not found.");
            return;
        }
        if (registeredCourses.contains(code) || completedCourses.containsKey(code)) {
            System.out.println("You are already registered or have completed this course.");
            return;
        }

        int currentCredits = 0;
        for (String regCode : registeredCourses) {
            currentCredits += db.getCourse(regCode).getCredits();
        }

        if (currentCredits + c.getCredits() > 20) {
            System.out.println("Registration failed. Exceeds 20 credit limit.");
        } else {
            try {
                c.addStudent(this.getEmail());
                registeredCourses.add(code);
                System.out.println("Successfully registered for " + c.getTitle());
            } catch (CourseFullException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    protected void viewSchedule(Database db) {
        System.out.println("\n--- Your Weekly Schedule ---");
        if (registeredCourses.isEmpty()) {
            System.out.println("You are not registered for any courses.");
            return;
        }
        for (String code : registeredCourses) {
            Course c = db.getCourse(code);
            System.out.println(c.getCourseCode() + " - " + c.getTitle() + " | Timings: " + c.getTimings() + " | Prof: "
                    + c.getProfessorEmail());
        }
    }

    protected void trackAcademicProgress(Database db) {
        System.out.println("\n--- Academic Progress ---");
        if (completedCourses.isEmpty()) {
            System.out.println("No completed courses yet. SGPA/CGPA cannot be calculated.");
            return;
        }

        int totalCredits = 0;
        int totalPoints = 0;

        for (Map.Entry<String, Integer> entry : completedCourses.entrySet()) {
            Course c = db.getCourse(entry.getKey());
            System.out.println("Course: " + c.getCourseCode() + " | Grade Points: " + entry.getValue());
            totalCredits += c.getCredits();
            totalPoints += (entry.getValue() * c.getCredits());
        }

        double cgpa = (double) totalPoints / totalCredits;
        System.out.println("-------------------------");
        System.out.printf("Current CGPA: %.2f\n", cgpa);
    }

    protected void dropCourse(Database db, Scanner inp) {
        System.out.print("Enter Course Code to drop: ");
        String code = inp.nextLine();
        Course c = db.getCourse(code);

        if (c == null) {
            System.out.println("Course not found.");
            return;
        }

        try {
            if (c.isDropDeadlinePassed()) {
                throw new DropDeadlinePassedException("The deadline to drop " + code + " has already passed.");
            }
            if (registeredCourses.remove(code)) {
                c.removeStudent(this.getEmail());
                System.out.println("Successfully dropped " + code);
            } else {
                System.out.println("You are not registered for this course.");
            }
        } catch (DropDeadlinePassedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    protected void submitComplaint(Database db, Scanner inp) {
        System.out.print("Describe your complaint/issue: ");
        String text = inp.nextLine();
        db.addComplaint(new Complaint(this.getEmail(), text));
        System.out.println("Complaint submitted successfully.");
    }

    protected void submitFeedback(Database db, Scanner inp) {
        System.out.print("Enter Course Code to provide feedback: ");
        String code = inp.nextLine();

        if (!completedCourses.containsKey(code)) {
            System.out.println("You can only provide feedback for completed courses.");
            return;
        }

        Course c = db.getCourse(code);
        System.out.println("1. Submit Numeric Rating (1-5)");
        System.out.println("2. Submit Textual Comment");
        System.out.print("Choice: ");
        int type = inp.nextInt();
        inp.nextLine();

        if (type == 1) {
            System.out.print("Enter rating (1-5): ");
            int rating = inp.nextInt();
            inp.nextLine();
            c.addFeedback(new Feedback<Integer>(this.getEmail(), rating));
            System.out.println("Numeric feedback submitted.");
        } else if (type == 2) {
            System.out.print("Enter comment: ");
            String comment = inp.nextLine();
            c.addFeedback(new Feedback<String>(this.getEmail(), comment));
            System.out.println("Textual feedback submitted.");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}