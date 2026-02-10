enum Result {
    CORRECT, WRONG, UNANSWERED
}

public class quizGrader {
    public static void main(String[] args) {
        char[] keys = { 'C', 'A', 'B', 'D', 'B', 'C', 'C', 'A' };
        int correctCount = 0;
        int wrongCount = 0;
        int unansweredCount = 0;

        if (args.length < 8) {
            System.out.println("Please provide exactly 8 answers as arguments.");
            return;
        }

        System.out.println("QUESTION SUBMITTED ANS CORRECT ANS RESULT");

        for (int i = 0; i < 8; i++) {
            char submitted = args[i].charAt(0);
            char key = keys[i];
            Result res;

            if (submitted == 'X') {
                res = Result.UNANSWERED;
                unansweredCount++;
            } else if (submitted == key) {
                res = Result.CORRECT;
                correctCount++;
            } else {
                res = Result.WRONG;
                wrongCount++;
            }

            System.out.printf("%-8d %-13c %-11c %s%n", (i + 1), submitted, key, res);
        }

        System.out.println();
        System.out.println("No. of correct answers: " + correctCount);
        System.out.println("No: of wrong answers. " + wrongCount);
        System.out.println("No of questions unanswered: " + unansweredCount);

        if (correctCount >= 5) {
            System.out.println("Status: PASSED");
        } else {
            System.out.println("Status: FAILED");
        }
    }
}