abstract class Car {
    String brandName;

    public Car(String brandName) {
        this.brandName = brandName;
    }

    public void show() {
        System.out.println("Car is of " + brandName);
    }

    public abstract void avg();

    public abstract void mode();
}

class Maruti extends Car {
    public Maruti() {
        super("Maruti Suzuki");
    }

    @Override
    public void avg() {
        System.out.println("Average mileage is 24 km/l");
    }

    @Override
    public void mode() {
        System.out.println("Manual");
    }
}

class Santro extends Car {
    public Santro() {
        super("Hyundai");
    }

    @Override
    public void avg() {
        System.out.println("Average mileage is 20 km/l");
    }

    @Override
    public void mode() {
        System.out.println("Automatic");
    }
}

public class carDemo {
    public static void main(String[] args) {
        Car car1 = new Maruti();
        System.out.println("Maruti");
        car1.show();
        car1.avg();
        car1.mode();
        System.out.println();
        Car car2 = new Santro();
        System.out.println("Santro");
        car2.show();
        car2.avg();
        car2.mode();
    }
}
