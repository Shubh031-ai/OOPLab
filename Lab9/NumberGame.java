import java.util.Scanner;
import java.util.Random;

class Game extends Thread {
    private String playerName;
    private int genNum;

    public Game(String name) {
        this.playerName = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        genNum = random.nextInt(100) + 1;
        System.out.println(playerName + " -> " + genNum);
    }

    public int getGenNum() {
        return genNum;
    }
}

public class NumberGame {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter player 1 name:");
        String p1 = inp.nextLine();
        System.out.println("Enter player 2 name:");
        String p2 = inp.nextLine();

        Game g1 = new Game(p1);
        Game g2 = new Game(p2);

        g1.start();
        g2.start();

        try {
            g1.join();
            g2.join();
        } catch (InterruptedException ex) {
            System.out.println("Thread interrupted: " + ex.getMessage());
        }

        int score1 = g1.getGenNum();
        int score2 = g2.getGenNum();

        if (score1 > score2)
            System.out.println(p1 + " wins by " + (score1 - score2) + " points");
        else if (score2 > score1)
            System.out.println(p1 + " wins by " + (score2 - score1) + " points");
        else
            System.out.println("Draw");
        inp.close();
    }
}
