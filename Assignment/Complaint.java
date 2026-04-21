package Assignment;

public class Complaint {
    private static int counter = 1;
    private int id;
    private String studentEmail;
    private String description;
    private String status;

    public Complaint(String studentEmail, String description) {
        this.id = counter++;
        this.studentEmail = studentEmail;
        this.description = description;
        this.status = "Pending";
    }

    public Complaint(int id, String studentEmail, String description, String status) {
        this.id = id;
        this.studentEmail = studentEmail;
        this.description = description;
        this.status = status;
        if (id >= counter)
            counter = id + 1;
    }

    public int getId() {
        return id;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | From: " + studentEmail + " | Status: " + status + "\nIssue: " + description;
    }
}