import java.util.Scanner;

public class Point3D {
    int x;
    int y;
    int z;

    public Point3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void inputCoordinates() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x, y, and z coordinates:");
        this.x = scanner.nextInt();
        this.y = scanner.nextInt();
        this.z = scanner.nextInt();
    }

    public void displayPoint() {
        System.out.println("(" + x + ", " + y + ", " + z + ")");
    }

    public double computeDistance(Point3D otherPoint) {
        int dx = this.x - otherPoint.x;
        int dy = this.y - otherPoint.y;
        int dz = this.z - otherPoint.z;

        return Math.sqrt((dx * dx) + (dy * dy) + (dz * dz));
    }

    public static void main(String[] args) {

        Point3D originPoint = new Point3D();
        System.out.print("Origin Point: ");
        originPoint.displayPoint();

        Point3D arbitraryPoint = new Point3D(3, 4, 5);
        System.out.print("Arbitrary Point: ");
        arbitraryPoint.displayPoint();

        double distance = originPoint.computeDistance(arbitraryPoint);
        System.out.println("Distance from origin to arbitrary point: " + distance);

        System.out.println();

        Point3D userPoint = new Point3D();
        userPoint.inputCoordinates();
        System.out.print("You entered: ");
        userPoint.displayPoint();

        double newDistance = userPoint.computeDistance(arbitraryPoint);
        System.out.println("Distance between your point and (3, 4, 5): " + newDistance);
    }
}
