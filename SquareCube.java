public class SquareCube {
    public static void main(String[] args) {
        int a;
        System.out.println("a\ta^2\ta^3");
        for (a = 1; a < 11; a++) {
            System.out.printf("%d\t%d\t%d", a, a * a, a * a * a);
            System.out.println("\n");
        }
    }
}
