import java.util.Scanner;

public class Physics {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter v0,v1 and time:");
        double v0 = inp.nextDouble();
        double v1 = inp.nextDouble();
        double t = inp.nextDouble();
        System.out.print("Average accelaration: " + (v0 + v1) / t);
        inp.close();
    }
}
