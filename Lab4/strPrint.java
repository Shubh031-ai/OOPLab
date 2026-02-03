import java.util.Scanner;

public class strPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String input = scanner.nextLine();

        System.out.print("Enter the threshold number (n): ");
        int n = scanner.nextInt();

        int[] frequency = new int[256];

        for (char c : input.toCharArray()) {
            frequency[c]++;
        }

        System.out.print("Characters appearing more than " + n + " times: ");
        boolean found = false;

        for (int i = 0; i < 256; i++) {
            if (frequency[i] > n) {
                System.out.print((char) i + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.print("None");
        }

        scanner.close();
    }
}
