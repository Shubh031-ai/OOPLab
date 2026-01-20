import java.util.Scanner;

public class NumPlay {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a 5 digit number:");
        int a = s.nextInt();
        int d1 = a / 10000;
        int d2 = (a / 1000) % 10;
        int d3 = (a / 100) % 10;
        int d4 = (a / 10) % 10;
        int d5 = a % 10;
        System.out.printf("%d %d %d %d %d ", d1, d2, d3, d4, d5);
        s.close();
    }
}
