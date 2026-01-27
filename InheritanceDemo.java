class Figure {
    double r;
    double a;
    double v;

    public void dispArea() {
        System.out.println("Area of the figure: " + a);
    }

    public void dispVolume() {
        System.out.println("Volume of the figure: " + v);
    }
}

class Cone extends Figure {
    double h;
    double s;

    public Cone(double radius, double height, double slant) {
        this.r = radius;
        this.h = height;
        this.s = slant;
    }

    public void calcArea() {
        a = (Math.PI * r * s) + (Math.PI * r * r);
    }

    public void calcVolume() {
        v = (Math.PI * r * r * h) / 3.0;
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Cone newCone = new Cone(3.0, 4.0, 5.0);

        System.out.println("Radius: " + newCone.r);
        System.out.println("Height: " + newCone.h);
        System.out.println("Slant height: " + newCone.s);

        newCone.calcArea();
        newCone.calcVolume();

        newCone.dispArea();
        newCone.dispVolume();
    }
}
