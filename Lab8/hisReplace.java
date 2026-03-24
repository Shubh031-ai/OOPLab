import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class hisReplace {
    public static void main(String[] args) {
        File file = new File("sdj.txt");
        StringBuilder content = new StringBuilder();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();

            String updatedContent = content.toString().replace("his", "her");

            PrintWriter writer = new PrintWriter(file);
            writer.print(updatedContent);
            writer.close();

            System.out.println("Replacement complete.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
