abstract class Figure {
    double pi = 3.1490;
    double a;
    double v;

    public abstract void dispArea();

    public abstract void dispVolume();

    public abstract void calcArea();

    public abstract void calcVolume();
}

class Cone extends Figure {
    double r;
    double s;

    public Cone(double radius, double slant) {
        this.r = radius;
        this.s = slant;
    }

    public void calcArea() {
        a = pi * r * (r + s);
    }

    public void calcVolume() {
        v = (pi * r * r * Math.sqrt((s * s) - (r * r))) / 3.0;
    }

    public void dispArea() {
        System.out.println("Area of the Cone: " + a);
    }

    public void dispVolume() {
        System.out.println("Volume of the Cone: " + v);
    }
}

class Sphere extends Figure {
    double r;

    public Sphere(double radius) {
        this.r = radius;
    }

    public void calcArea() {
        a = 4.0 * pi * r * r;
    }

    public void calcVolume() {
        v = (4.0 * pi * r * r * r) / 3.0;
    }

    public void dispArea() {
        System.out.println("Area of the Sphere: " + a);
    }

    public void dispVolume() {
        System.out.println("Volume of the Sphere: " + v);
    }
}

class Cylinder extends Figure {
    double r;
    double h;

    public Cylinder(double radius, double height) {
        this.r = radius;
        this.h = height;
    }

    public void calcArea() {
        a = 2 * pi * r * (r + h);
    }

    public void calcVolume() {
        v = pi * r * r * h;
    }

    public void dispArea() {
        System.out.println("Area of the Cylinder: " + a);
    }

    public void dispVolume() {
        System.out.println("Volume of the Cylinder: " + v);
    }
}

public class Demo {
    public static void main(String[] args) {
        Cone newCone = new Cone(3.0, 5.0);

        System.out.println("Cone: ");
        newCone.calcArea();
        newCone.calcVolume();
        newCone.dispArea();
        newCone.dispVolume();

        Sphere newSphere = new Sphere(4.0);

        System.out.println("Sphere: ");
        newSphere.calcArea();
        newSphere.calcVolume();
        newSphere.dispArea();
        newSphere.dispVolume();

        Cylinder newCylinder = new Cylinder(2.0, 5.0);

        System.out.println("Cylinder: ");
        newCylinder.calcArea();
        newCylinder.calcVolume();
        newCylinder.dispArea();
        newCylinder.dispVolume();
    }
}