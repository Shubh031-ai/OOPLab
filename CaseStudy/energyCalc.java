import java.util.Scanner;

public class energyCalc {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter the amount of water in kilograms: ");
        double M = inp.nextDouble();
        System.out.print("Enter initial tempurature: ");
        double initialTemp = inp.nextDouble();
        System.out.print("Enter final tempurature: ");
        double finalTemp = inp.nextDouble();
        double Q = M * (finalTemp - initialTemp) * 4184;
        System.out.println("The energy needed is " + Q);
        inp.close();
    }
}
