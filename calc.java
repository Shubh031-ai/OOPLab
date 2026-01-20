package prac;

import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("Enter 2 numbers: ");
        int num1 = a.nextInt();
        int num2 = a.nextInt();
        System.out.println("Sum:");
        System.out.println(num1 + num2);
        System.out.println("Differance:");
        System.out.println(num1 - num2);
        System.out.println("Product:");
        System.out.println(num1 * num2);
        System.out.println("Quotient:");
        System.out.println(num1 / num2);
        a.close();
    }
}
