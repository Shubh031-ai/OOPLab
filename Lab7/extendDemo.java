class Teacher {
    String name;
    String institution;

    public void setCommonDetails(String name, String institution) {
        this.name = name;
        this.institution = institution;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Institution: " + institution);
    }
}

class Student extends Teacher {
    int rollNumber;
    char grade;

    public void setStudentSpecificDetails(int rollNumber, char grade) {
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public void displayStudentInfo() {
        displayDetails();
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }
}

public class extendDemo {
    public static void main(String[] args) {
        Student student = new Student();

        student.setCommonDetails("Shubh", "New Era Senior Secondary School");

        student.setStudentSpecificDetails(31, 'A');

        System.out.println("Student Record");
        student.displayStudentInfo();
    }
}
