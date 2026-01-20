import java.util.Scanner;

public class GasMileage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double miles;
        double gallons;
        double totalMiles = 0.0;
        double totalGallons = 0.0;

        System.out.print("Enter miles driven or -1 to quit: ");
        miles = input.nextDouble();

        while (miles != -1) {
            System.out.print("Enter gallons used: ");
            gallons = input.nextDouble();

            double tripMPG = miles / gallons;
            System.out.printf("MPG for this trip: %f\n", tripMPG);

            totalMiles += miles;
            totalGallons += gallons;

            if (totalGallons != 0) {
                double combinedMPG = totalMiles / totalGallons;
                System.out.printf("Combined MPG for all trips: %f\n", combinedMPG);
            }

            System.out.println();
            System.out.print("Enter miles driven or -1 to quit: ");
            miles = input.nextDouble();
        }
    }
}
