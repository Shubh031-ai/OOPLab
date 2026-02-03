import java.util.Scanner;

public class runwayLength {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter speed and accelaration: ");
        double speed = inp.nextDouble();
        double accelaration = inp.nextDouble();
        double length = (speed * speed) / (2 * accelaration);
        System.out.println("The minimum length of runway for this airplane is " + length);
        inp.close();
    }
}
