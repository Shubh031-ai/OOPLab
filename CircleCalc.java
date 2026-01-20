import java.util.Scanner;

public class CircleCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        double radius = input.nextInt();
        double pi = 3.14159;
        double circumference = 2 * pi * radius;
        double area = pi * (radius * radius);
        System.out.printf("Diameter: %f\n", 2 * radius);
        System.out.printf("Circumference: %f\n", circumference);
        System.out.printf("Area: %f\n", area);
        input.close();
    }
}