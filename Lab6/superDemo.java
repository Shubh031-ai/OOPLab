class A {
    int i = 10;

    void show() {
        System.out.println("A(in class A) = " + i);
    }
}

class B extends A {
    int i = 20;

    void display() {
        System.out.println("B(in class B) = " + this.i);
        System.out.println("A(in class B) = " + super.i);
        super.show();
    }
}

public class superDemo {
    public static void main(String[] args) {
        B x = new B();
        x.display();
    }
}
