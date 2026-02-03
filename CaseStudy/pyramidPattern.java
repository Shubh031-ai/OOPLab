public class pyramidPattern {
    public static void main(String[] args) {
        int rows = 8;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < (rows - i - 1); j++) {
                System.out.print("    ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d", (int) Math.pow(2, j));
            }

            for (int j = i - 1; j >= 0; j--) {
                System.out.printf("%4d", (int) Math.pow(2, j));
            }

            System.out.println();
        }
    }
}
