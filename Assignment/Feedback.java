package Assignment;

public class Feedback {
    private String studentEmail;
    private String feedbackData;

    public Feedback(String studentEmail, String feedbackData) {
        this.studentEmail = studentEmail;
        this.feedbackData = feedbackData;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getFeedbackData() {
        return feedbackData;
    }

    @Override
    public String toString() {
        return "From: " + studentEmail + " | Feedback: " + feedbackData;
    }
}
