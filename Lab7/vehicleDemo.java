import java.util.Scanner;

class Vehicle {
    String brand;
    String color;

    public Vehicle(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public void maxSpeed() {
        System.out.println("The maximum speed depends on the specific vehicle type.");
    }
}

class Car extends Vehicle {
    int numberOfDoors;

    public Car(String brand, String color, int numberOfDoors) {
        super(brand, color);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void maxSpeed() {
        System.out.println(brand + " Car maximum speed is 220 km/h.");
    }
}

class Bicycle extends Vehicle {
    boolean hasGears;

    public Bicycle(String brand, String color, boolean hasGears) {
        super(brand, color);
        this.hasGears = hasGears;
    }

    @Override
    public void maxSpeed() {
        System.out.println(brand + " Bicycle maximum speed is 35 km/h.");
    }
}

class Scooter extends Vehicle {
    int engineCapacity;

    public Scooter(String brand, String color, int engineCapacity) {
        super(brand, color);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void maxSpeed() {
        System.out.println(brand + " Scooter maximum speed is 85 km/h.");
    }
}

public class vehicleDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Car Details");
        System.out.print("Brand: ");
        String carBrand = scanner.nextLine();
        System.out.print("Color: ");
        String carColor = scanner.nextLine();
        System.out.print("Number of Doors: ");
        int carDoors = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nEnter Bicycle Details");
        System.out.print("Brand: ");
        String bikeBrand = scanner.nextLine();
        System.out.print("Color: ");
        String bikeColor = scanner.nextLine();
        System.out.print("Has Gears (true/false): ");
        boolean bikeGears = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("\nEnter Scooter Details");
        System.out.print("Brand: ");
        String scooterBrand = scanner.nextLine();
        System.out.print("Color: ");
        String scooterColor = scanner.nextLine();
        System.out.print("Engine Capacity (cc): ");
        int scooterEngine = scanner.nextInt();

        Vehicle myCar = new Car(carBrand, carColor, carDoors);
        Vehicle myBicycle = new Bicycle(bikeBrand, bikeColor, bikeGears);
        Vehicle myScooter = new Scooter(scooterBrand, scooterColor, scooterEngine);

        System.out.println("\nMaximum Speeds");
        myCar.maxSpeed();
        myBicycle.maxSpeed();
        myScooter.maxSpeed();

        scanner.close();
    }
}