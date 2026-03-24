abstract class ProjectBase {
    void debug() {
        System.out.println("Debugging start");
    }

    abstract void execute();
}

class A extends ProjectBase {
    void execute() {
        System.out.println("Executing  A");
    }
}

class B extends ProjectBase {
    void execute() {
        System.out.println("Executing  B");
    }
}

public class project {
    public static void main(String[] args) {

        ProjectBase obj1 = new A();
        ProjectBase obj2 = new B();

        obj1.debug();
        obj1.execute();

        System.out.println();

        obj2.debug();
        obj2.execute();
    }
}
