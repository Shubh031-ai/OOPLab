import java.util.Scanner;

public class perfectString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String input = scanner.nextLine();

        int[] frequency = new int[256];

        for (char c : input.toCharArray()) {
            frequency[c]++;
        }

        int sum = 0;
        for (int i = 0; i < 256; i++) {
            sum += frequency[i];
        }

        if (sum == 26) {
            System.out.println("Perfect String");
        }

        else {
            System.out.println("Not a perfect string");
        }
        scanner.close();
    }
}
