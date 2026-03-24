import java.util.Scanner;
import java.util.Arrays;

public class Name {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] processedNames = new String[10];

        for (int i = 0; i < 10; i++) {
            String name = scanner.nextLine();
            if (name.length() > 3) {
                processedNames[i] = name.substring(3);
            } else {
                processedNames[i] = "";
            }
        }

        Arrays.sort(processedNames);

        for (String name : processedNames) {
            if (!name.isEmpty()) {
                System.out.println(name);
            }
        }

        scanner.close();
    }
}