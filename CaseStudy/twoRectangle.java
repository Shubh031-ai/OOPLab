import java.util.Scanner;

public class twoRectangle {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Enter r1's center x-, y-coordinates, width, and height: ");
        double x1 = inp.nextDouble();
        double y1 = inp.nextDouble();
        double w1 = inp.nextDouble();
        double h1 = inp.nextDouble();

        System.out.print("Enter r2's center x-, y-coordinates, width, and height: ");
        double x2 = inp.nextDouble();
        double y2 = inp.nextDouble();
        double w2 = inp.nextDouble();
        double h2 = inp.nextDouble();

        double xDistance = Math.abs(x1 - x2);
        double yDistance = Math.abs(y1 - y2);

        if ((xDistance <= (w1 - w2) / 2) && (yDistance <= (h1 - h2) / 2)) {
            System.out.println("r2 is inside r1");
        } else if ((xDistance < (w1 + w2) / 2) && (yDistance < (h1 + h2) / 2)) {
            System.out.println("r2 overlaps r1");
        } else {
            System.out.println("r2 does not overlap r1");
        }

        inp.close();
    }
}