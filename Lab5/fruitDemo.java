class Fruit {
    String name;
    String type;
    double price;

    Fruit(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    void displayFruit() {
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Price: " + price);
    }
}

public class fruitDemo {
    public static void main(String[] args) {
        Fruit fruit1 = new Fruit("Apple", "Single fruit", 25.50);
        Fruit fruit2 = new Fruit("Grapes", "Bunch fruit", 60.00);

        fruit1.displayFruit();
        fruit2.displayFruit();
    }
}