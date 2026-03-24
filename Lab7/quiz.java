import java.util.Scanner;

enum Result {
    CORRECT, WRONG, UNANSWERED
}

public class quiz {
    public static void main(String[] args) {
        char[] correctAnswers = { 'C', 'A', 'B', 'D' };
        char[] submittedAnswers = new char[4];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter answers for 4 questions (A, B, C, D) or X for unanswered:");
        for (int i = 0; i < 4; i++) {
            System.out.print("Question " + (i + 1) + ": ");
            submittedAnswers[i] = scanner.next().toUpperCase().charAt(0);
        }

        System.out.println("\nQUESTION SUBMITTED ANS CORRECT ANS RESULT");

        int correctCount = 0;
        int wrongCount = 0;

        for (int i = 0; i < 4; i++) {
            Result result;

            if (submittedAnswers[i] == 'X') {
                result = Result.UNANSWERED;
                wrongCount++;
            } else if (submittedAnswers[i] == correctAnswers[i]) {
                result = Result.CORRECT;
                correctCount++;
            } else {
                result = Result.WRONG;
                wrongCount++;
            }

            System.out.printf("%-9d%-14c%-12c%s\n", (i + 1), submittedAnswers[i], correctAnswers[i], result);
        }

        System.out.println("\nNo. of correct answers: " + correctCount);
        System.out.println("No: of wrong answers: " + wrongCount);

        if (correctCount >= 2) {
            System.out.println("The candidate passed");
        } else {
            System.out.println("The candidate failed");
        }

        scanner.close();
    }
}