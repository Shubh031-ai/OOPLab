class Example extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println(Thread.currentThread().getName() + " completed " + i + " times");
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Example ex = new Example();
        ex.start();
    }
}
