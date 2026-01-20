import java.util.Scanner;

public class CreditLimitCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int accountNumber;
        int beginningBalance;
        int totalCharges;
        int totalCredits;
        int creditLimit;
        int newBalance;

        System.out.print("Enter Account Number (or -1 to quit): ");
        accountNumber = input.nextInt();

        while (accountNumber != -1) {
            System.out.print("Enter Balance at Beginning of Month: ");
            beginningBalance = input.nextInt();

            System.out.print("Enter Total Charges this Month: ");
            totalCharges = input.nextInt();

            System.out.print("Enter Total Credits this Month: ");
            totalCredits = input.nextInt();

            System.out.print("Enter Credit Limit: ");
            creditLimit = input.nextInt();

            newBalance = beginningBalance + totalCharges - totalCredits;

            System.out.printf("New Balance is: %d\n", newBalance);

            if (newBalance > creditLimit) {
                System.out.println("Credit Limit Exceeded\n");
            }

            System.out.print("Enter Account Number (or -1 to quit): ");
            accountNumber = input.nextInt();
        }
    }
}