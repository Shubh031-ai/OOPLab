import java.util.Scanner;

public class Compare {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("Enter 2 numbers");
        int num1 = a.nextInt();
        int num2 = a.nextInt();
        if (num1 > num2) {
            System.out.printf("%d is greater", num1);
        } else if (num1 < num2) {
            System.out.printf("%d is greater", num2);
        } else {
            System.out.println("Both numbers are equal");
        }
        a.close();
    }
}