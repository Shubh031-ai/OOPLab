import java.util.Scanner;

public class Student {

    String average(double mark1, double mark2, double mark3) {
        double avg = (mark1 + mark2 + mark3) / 3;
        if (avg > 50) {
            return "Passed";
        } else {
            return "Failed";
        }
    }

    String inputName(String name) {
        return name;
    }

    public static void main(String[] args) {
        Student s = new Student();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String nameInput = sc.nextLine();
        String name = s.inputName(nameInput);

        System.out.print("Enter 3 marks: ");
        double m1 = sc.nextDouble();
        double m2 = sc.nextDouble();
        double m3 = sc.nextDouble();

        String result = s.average(m1, m2, m3);

        System.out.println("Student Name: " + name);
        System.out.println("Result: " + result);
    }
}