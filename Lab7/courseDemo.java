import java.util.Scanner;

class Course {
    int id;
    String description;
    String duration;
    double fees;

    public Course(int id, String description, String duration, double fees) {
        this.id = id;
        this.description = description;
        this.duration = duration;
        this.fees = fees;
    }

    public void GetData() {
        System.out.println("Course ID: " + id);
        System.out.println("Description: " + description);
        System.out.println("Duration: " + duration);
        System.out.println("Fees: $" + fees);
    }
}

public class courseDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Course[] courses = new Course[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for Course " + (i + 1) + ":");

            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Description: ");
            String description = scanner.nextLine();

            System.out.print("Duration: ");
            String duration = scanner.nextLine();

            System.out.print("Fees: ");
            double fees = scanner.nextDouble();
            scanner.nextLine();

            courses[i] = new Course(id, description, duration, fees);
            System.out.println();
        }

        System.out.println("All Course Details");
        for (int i = 0; i < 5; i++) {
            courses[i].GetData();
        }

        scanner.close();
    }
}
