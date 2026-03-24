import java.util.Scanner;

public class theCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a line of text:");
        String text = scanner.nextLine();

        String target = "the";

        int firstIndex = text.indexOf(target);
        int lastIndex = text.lastIndexOf(target);

        if (firstIndex != -1 && lastIndex != -1 && firstIndex != lastIndex) {
            int startCopyIndex = firstIndex + target.length();
            String extractedString = text.substring(startCopyIndex, lastIndex);

            System.out.println("Position of first 'the': " + firstIndex);
            System.out.println("Position of last 'the': " + lastIndex);
            System.out.println("Extracted text: \"" + extractedString + "\"");

        } else if (firstIndex != -1 && firstIndex == lastIndex) {
            System.out.println("The word 'the' only appeared once. Cannot extract text between two occurrences.");
        } else {
            System.out.println("The word 'the' was not found in the input.");
        }

        scanner.close();
    }
}