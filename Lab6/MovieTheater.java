import java.util.Scanner;

public class MovieTheater {

    public static double calculateTotalProfit(int attendees) {
        final double TICKET_PRICE = 5.00;
        final double FIXED_PERFORMANCE_COST = 20.00;
        final double VARIABLE_COST_PER_ATTENDEE = 0.50;

        double revenue = attendees * TICKET_PRICE;
        double totalCost = FIXED_PERFORMANCE_COST + (attendees * VARIABLE_COST_PER_ATTENDEE);

        return revenue - totalCost;
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("Old-Style Movie Theater Profit Calculator");
        System.out.print("Enter the number of attendees for the show: ");

        if (inp.hasNextInt()) {
            int attendees = inp.nextInt();

            if (attendees < 0) {
                System.out.println("Error: Number of attendees cannot be negative.");
            } else {
                double profit = calculateTotalProfit(attendees);
                System.out.printf("For %d attendees, the total profit is: $%.2f%n", attendees, profit);
            }
        } else {
            System.out.println("Error: Please enter a valid whole number.");
        }

        inp.close();
    }
}