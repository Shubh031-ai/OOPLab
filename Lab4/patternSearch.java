import java.util.Scanner;

public class patternSearch {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("enter range :");
        int a = inp.nextInt();
        int b = inp.nextInt();

        System.out.print("Enter pattern: ");
        int n = inp.nextInt();

        String pattern = String.valueOf(n);
        int count = 0;

        for (int i = a; i <= b; i++) {
            String currentNumber = String.valueOf(i);
            if (currentNumber.contains(pattern)) {
                count++;
            }
        }

        System.out.println("the no. times " + n + " occurred betwwn " + a + " to " + b + ":" + count);
        inp.close();
    }
}