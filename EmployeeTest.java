import java.util.Scanner;

class Employee {
    private String fName;
    private String lName;
    private double mSal;

    public Employee(String fName, String lName, double mSal) {
        this.fName = fName;
        this.lName = lName;
        if (mSal > 0.0) {
            this.mSal = mSal;
        }
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getFName() {
        return fName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getLName() {
        return lName;
    }

    public void setMSal(double mSal) {
        if (mSal > 0.0) {
            this.mSal = mSal;
        }
    }

    public double getMSal() {
        return mSal;
    }

    public double getYearlySalary() {
        return mSal * 12;
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("Manoj", "Kumar", 85000);
        Employee e2 = new Employee("Kiran", "Rana", 90000);

        System.out.println("Yearly Salary before raise");
        System.out.printf("%s %s: %f\n", e1.getFName(), e1.getLName(), e1.getYearlySalary());
        System.out.printf("%s %s: %f\n", e2.getFName(), e2.getLName(), e2.getYearlySalary());

        e1.setMSal(e1.getMSal() * 1.10);
        e2.setMSal(e2.getMSal() * 1.10);

        System.out.println("\nYearly Salary after 10% hike");
        System.out.printf("%s %s: %f\n", e1.getFName(), e1.getLName(), e1.getYearlySalary());
        System.out.printf("%s %s: %f\n", e2.getFName(), e2.getLName(), e2.getYearlySalary());
    }
}
