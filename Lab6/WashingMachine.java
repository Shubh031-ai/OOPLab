import java.util.Scanner;

public class WashingMachine {
    public void switchON() {
        System.out.println("Switched ON");
    }

    public int acceptClothes() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter no. of clothes to be washed:");
        int n = inp.nextInt();
        return n;
    }

    public void acceptDetergent() {
        System.out.println("Detergent added");
    }

    public void switchOFF() {
        System.out.println("Switched OFF");
    }

    public static void main(String[] args) {
        WashingMachine clothes = new WashingMachine();
        clothes.switchON();
        int noOfClothes = clothes.acceptClothes();
        System.out.println("You added " + noOfClothes + " clothes to the wash");
        clothes.acceptDetergent();
        System.out.println("Clothes washed");
        clothes.switchOFF();
    }
}
