import java.util.Scanner;

public class hello {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter name");
        String name = s.nextLine();
        System.out.println("Hello" + name + "!");
        int a = 6;
        int b = 7;
        System.out.println(a + b);
        System.out.println(a / b);
        s.close();
    }
}