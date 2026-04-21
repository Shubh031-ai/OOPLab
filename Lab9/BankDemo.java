import java.util.Random;

class BankAccount {
    private int balance = 600;
    private boolean fatherTurn = true;

    public synchronized void deposit(int amount) {
        try {
            while (!fatherTurn) {
                wait();
            }
            balance += amount;
            System.out.println("Father deposited: Rs. " + amount + " | Current Balance: Rs. " + balance);

            if (balance > 2000) {
                fatherTurn = false;
                notify();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void withdraw(int amount) {
        try {
            while (fatherTurn) {
                wait();
            }
            balance -= amount;
            System.out.println("Son withdrew: Rs. " + amount + "     | Current Balance: Rs. " + balance);

            if (balance < 500) {
                fatherTurn = true;
                notify();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Father extends Thread {
    private BankAccount account;
    private Random random = new Random();

    public Father(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        while (true) {
            int amount = random.nextInt(200) + 1;
            account.deposit(amount);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

class Son extends Thread {
    private BankAccount account;
    private Random random = new Random();

    public Son(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        while (true) {
            int amount = random.nextInt(150) + 1;
            account.withdraw(amount);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

public class BankDemo {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount();

        Father father = new Father(sharedAccount);
        Son son = new Son(sharedAccount);

        father.start();
        son.start();
    }
}