import java.util.Scanner;

public class ParkingGarage {

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);

        double hoursParked = 0.0;
        double currentCharge = 0.0;
        double totalReceipts = 0.0;

        System.out.println("Enter hours parked for each customer: ");
        System.out.println("Enter -1 to stop");

        while (true) {
            System.out.print("\nEnter hours parked: ");
            hoursParked = a.nextDouble();
            if (hoursParked == -1) {
                break;
            }
            currentCharge = 2.0 + (hoursParked - 3.0) * 0.5;
            if (currentCharge > 10.0) {
                currentCharge = 10.0;
            }
            totalReceipts += currentCharge;
            System.out.printf("Customer Charge: %f\n", currentCharge);
            System.out.printf("Running Total: %f\n", totalReceipts);
        }
        System.out.printf("Total Receipt: %f\n", totalReceipts);
        a.close();
    }
}