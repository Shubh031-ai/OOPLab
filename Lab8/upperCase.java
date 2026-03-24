import java.util.Scanner;

public class upperCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String[] words = text.split(" ");
        String result = "";

        for (String word : words) {
            if (!word.isEmpty()) {
                result += word.substring(0, 1).toUpperCase() + word.substring(1) + " ";
            }
        }

        System.out.println(result.trim());
        scanner.close();
    }
}
