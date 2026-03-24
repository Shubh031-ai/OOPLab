import java.util.Scanner;

public class interestCalc {
    double p;
    double r;
    int t;

    public void Balance() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter principal amount:");
        double p = inp.nextDouble();
        System.out.println("Enter simple annual rate:");
        double r = inp.nextDouble();
        System.out.println("Enter no. of months:");
        int t = inp.nextInt();
        System.out.println("Final balance after " + t + " months is: " + (p + (r / 100) * (t / 12.0)));
    }

    public void totalInterest() {
        double interest = (p * (r / 100.0) * (t / 12.0));
        System.out.println("Total interest earned: " + interest);
    }

    public static void main(String[] args) {
        interestCalc a = new interestCalc();
        a.Balance();
        a.totalInterest();
    }
}
