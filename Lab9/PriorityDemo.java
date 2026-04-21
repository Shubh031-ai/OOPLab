class PrimeThread extends Thread {
    @Override
    public void run() {
        int count = 0;
        int num = 2;
        System.out.println("Prime Thread Started (Priority: " + this.getPriority() + ")");

        while (count < 25) {
            boolean isPrime = true;
            // Check if num is prime
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println("Prime [" + (count + 1) + "]: " + num);
                count++;
            }
            num++;
        }
        System.out.println("Prime Thread Finished");
    }
}

class FibonacciThread extends Thread {
    @Override
    public void run() {
        System.out.println("Fibonacci Thread Started (Priority: " + this.getPriority() + ")");
        long f1 = 1, f2 = 1;
        System.out.println("Fibonacci [1]: " + f1);
        System.out.println("Fibonacci [2]: " + f2);

        for (int i = 3; i <= 50; i++) {
            long fn = f1 + f2;
            System.out.println("Fibonacci [" + i + "]: " + fn);
            f1 = f2;
            f2 = fn;
        }

        try {
            System.out.println("\n[Fibonacci Thread] Computed 50 numbers. Going to sleep so Prime Thread can work...");
            Thread.sleep(1000);

            System.out.println("\n[Fibonacci Thread] Woke up! Continuing to final execution.");
            System.out.println("Fibonacci Thread Finished");
        } catch (InterruptedException e) {
            System.out.println("Fibonacci Thread interrupted: " + e.getMessage());
        }
    }
}

public class PriorityDemo {
    public static void main(String[] args) {
        System.out.println("Starting Threads...\n");

        PrimeThread primeThread = new PrimeThread();
        FibonacciThread fibonacciThread = new FibonacciThread();

        primeThread.setPriority(Thread.NORM_PRIORITY);
        fibonacciThread.setPriority(Thread.MAX_PRIORITY);

        fibonacciThread.start();
        primeThread.start();
    }
}
