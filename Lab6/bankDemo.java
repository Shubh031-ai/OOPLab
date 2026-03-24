public class bankDemo {
    public double deposit(double amount, double balance) {
        return balance + amount;
    }

    public double withdraw(double amount, double balance) {
        if (balance >= amount) {
            return balance - amount;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        bankDemo myAccount = new bankDemo();

        double currentBalance = 1000.0;
        System.out.println("Starting Balance: Rs. " + currentBalance);

        currentBalance = myAccount.deposit(500.0, currentBalance);
        System.out.println("After depositing 500: Rs. " + currentBalance);

        currentBalance = myAccount.withdraw(300.0, currentBalance);
        System.out.println("After withdrawing 300: Rs. " + currentBalance);

        double failedWithdrawal = myAccount.withdraw(2000.0, currentBalance);
        System.out.println("Result of withdrawing 2000: Rs. " + failedWithdrawal);
    }
}