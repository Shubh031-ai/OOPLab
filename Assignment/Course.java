package Assignment;

import java.util.List;
import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String title;
    private String professorEmail;
    private int credits;
    private String timings;
    private int enrollmentLimit;
    private String syllabus;
    private List<String> enrolledStudentEmails;

    private List<Feedback> feedbacks;
    private boolean dropDeadlinePassed;

    public Course(String courseCode, String title, int credits) {
        this.courseCode = courseCode;
        this.title = title;
        if (credits == 2 || credits == 4) {
            this.credits = credits;
        } else {
            throw new IllegalArgumentException("Credits must be 2 or 4.");
        }
        this.enrolledStudentEmails = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
        this.dropDeadlinePassed = false;
        this.enrollmentLimit = 50;
        this.timings = "TBD";
        this.syllabus = "TBD";
        this.professorEmail = "Unassigned";
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getProfessorEmail() {
        return professorEmail;
    }

    public void setProfessorEmail(String professorEmail) {
        this.professorEmail = professorEmail;
    }

    public int getCredits() {
        return credits;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public int getEnrollmentLimit() {
        return enrollmentLimit;
    }

    public void setEnrollmentLimit(int enrollmentLimit) {
        this.enrollmentLimit = enrollmentLimit;
    }

    public List<String> getEnrolledStudentEmails() {
        return enrolledStudentEmails;
    }

    public void addStudent(String email) throws CourseFullException {
        if (enrolledStudentEmails.size() < enrollmentLimit) {
            enrolledStudentEmails.add(email);
        } else {
            throw new CourseFullException("Registration failed: The course " + title + " is already full.");
        }
    }

    public void removeStudent(String email) {
        enrolledStudentEmails.remove(email);
    }

    public void addFeedback(Feedback f) {
        feedbacks.add(f);
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public boolean isDropDeadlinePassed() {
        return dropDeadlinePassed;
    }

    public void setDropDeadlinePassed(boolean passed) {
        this.dropDeadlinePassed = passed;
    }
}