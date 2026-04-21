public class RunnableDemo implements Runnable {

    public RunnableDemo(String threadName) {
        Thread thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println(Thread.currentThread().getName() + " completed " + i + " times");
        }
    }

    public static void main(String[] args) {
        new RunnableDemo("t1");
    }
}
