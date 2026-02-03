import java.util.Scanner;

public class computingBMI {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter weight in pounds: ");
        double weight = inp.nextDouble();
        System.out.print("Enter height in inches: ");
        double height = inp.nextDouble();
        double BMI = (weight * 0.45359237) / (height * height * 0.0254 * 0.0254);
        System.out.print("BMI is " + BMI);
        inp.close();
    }
}
