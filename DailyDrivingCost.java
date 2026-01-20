import java.util.Scanner;

class DailyDrivingCost {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter total miles driven per day: ");
        float tmiles = inp.nextFloat();
        System.out.print("Enter miles covered using 1 gallon of gasoline: ");
        float mpg = inp.nextFloat();
        System.out.print("Enter the cost of per gallon of gasoline: ");
        float cost = inp.nextFloat();
        System.out.print("Enter fees per day: ");
        int dfees = inp.nextInt();
        System.out.print("Enter toll per day: ");
        int dtoll = inp.nextInt();
        float dcost = (tmiles / mpg) * cost + dfees + dtoll;
        System.out.printf("%f is the daily cost ", dcost);
        inp.close();
    }
}
