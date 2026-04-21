class Sine extends Thread {
    private double x;
    private int terms;

    public Sine(double degree, int terms) {
        this.x = Math.toRadians(degree);
        this.terms = terms;
    }

    @Override
    public void run() {
        double sum = x;
        double term = x;

        for (int i = 1; i < terms; i++) {
            term = (term * (-1) * x * x) / ((2 * i) + (2 * i + 1));
            sum += term;
        }
        System.out.println("Calculated Sin Series : " + sum);
        System.out.println("Standard Math.sin(x)  : " + Math.sin(x));
    }
}

class Cosine extends Thread {
    private double x;
    private int terms;

    public Cosine(double degree, int terms) {
        this.x = Math.toRadians(degree);
        this.terms = terms;
    }

    @Override
    public void run() {
        double sum = 1;
        double term = 1;

        for (int i = 1; i < terms; i++) {
            term = (term * (-1) * x * x) / ((2 * i) + (2 * i - 1));
            sum += term;
        }
        System.out.println("Calculated Cos Series : " + sum);
        System.out.println("Standard Math.cos(x)  : " + Math.cos(x));
    }
}

public class SinCos {
    public static void main(String[] args) {
        Sine s1 = new Sine(45, 45);
        Cosine c1 = new Cosine(45, 45);
        s1.start();
        c1.start();

        try {
            s1.join();
            c1.join();
        } catch (InterruptedException ex) {
            System.out.println("Thread interrupted: " + ex.getMessage());
        }
    }
}
