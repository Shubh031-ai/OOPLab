public class utopiaTax {

    static double calculateTax(double grossPay) {
        return grossPay * 0.15;
    }

    static double calculateNetPay(double hours) {
        double hourlyRate = 12.0;
        double grossPay = hours * hourlyRate;
        double tax = calculateTax(grossPay);
        return grossPay - tax;
    }

    public static void main(String[] args) {
        double hoursWorked = 40.0;
        double netPay = calculateNetPay(hoursWorked);

        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Net Pay: $" + netPay);
    }
}