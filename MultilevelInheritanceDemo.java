class X {
    int i;
    int j;

    public X(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int findSum() {
        return i + j;
    }
}

class Y extends X {
    public Y(int i, int j) {
        super(i, j);
    }

    public int findProduct() {
        return i * j;
    }
}

class Z extends Y {
    public Z(int i, int j) {
        super(i, j);
    }

    public int findDifference() {
        return i - j;
    }
}

public class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        Z obj = new Z(10, 5);

        int sum = obj.findSum();
        int diff = obj.findDifference();
        int prod = obj.findProduct();

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + diff);
        System.out.println("Product: " + prod);
    }
}