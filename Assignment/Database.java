package Assignment;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

class Database {
    private HashMap<String, User> users;
    private HashMap<String, Course> courseCatalog;
    private List<Complaint> complaints;

    public Database() {
        this.users = new HashMap<>();
        this.courseCatalog = new HashMap<>();
        this.complaints = new ArrayList<>();
    }

    // --- FILE HANDLING: WRITING DATA ---
    public void saveData() {
        try {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("users.csv"))) {
                for (User u : users.values()) {
                    bw.write(u.getEmail() + "," + u.getPassword() + "," + u.getRole() + "\n");
                }
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter("courses.csv"))) {
                for (Course c : courseCatalog.values()) {
                    bw.write(c.getCourseCode() + "," + c.getTitle() + "," + c.getCredits() + ","
                            + c.getProfessorEmail() + "," + c.getEnrollmentLimit() + ","
                            + c.getTimings() + "," + c.getSyllabus() + "\n");
                }
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter("complaints.csv"))) {
                for (Complaint c : complaints) {
                    bw.write(c.getId() + "," + c.getStudentEmail() + "," + c.getStatus() + "," + c.getDescription()
                            + "\n");
                }
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter("student_records.csv"))) {
                for (User u : users.values()) {
                    if (u instanceof Student) {
                        Student s = (Student) u;
                        for (String code : s.getRegisteredCourses()) {
                            bw.write(s.getEmail() + "," + code + ",Registered,0\n");
                        }
                        for (Map.Entry<String, Integer> entry : s.getCompletedCourses().entrySet()) {
                            bw.write(s.getEmail() + "," + entry.getKey() + ",Completed," + entry.getValue() + "\n");
                        }
                    }
                }
            }
            System.out.println("[System] Data successfully saved to CSV.");
        } catch (IOException e) {
            System.out.println("[Error] Failed to save data: " + e.getMessage());
        }
    }

    // --- FILE HANDLING: READING DATA ---
    public void loadData() {
        try {
            File fUsers = new File("users.csv");
            if (fUsers.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(fUsers))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] data = line.split(",");
                        if (data[2].equals("Administrator"))
                            addUser(new Administrator(data[0], data[1]));
                        else if (data[2].equals("Professor"))
                            addUser(new Professor(data[0], data[1]));
                        else if (data[2].equals("Student"))
                            addUser(new Student(data[0], data[1]));
                        else if (data[2].equals("TA"))
                            addUser(new TA(data[0], data[1]));
                    }
                }
            }

            File fCourses = new File("courses.csv");
            if (fCourses.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(fCourses))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] data = line.split(",");
                        Course c = new Course(data[0], data[1], Integer.parseInt(data[2]));
                        c.setProfessorEmail(data[3]);
                        c.setEnrollmentLimit(Integer.parseInt(data[4]));
                        c.setTimings(data[5]);
                        if (data.length > 6)
                            c.setSyllabus(data[6]);
                        addCourse(c);
                    }
                }
            }

            File fComplaints = new File("complaints.csv");
            if (fComplaints.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(fComplaints))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] data = line.split(",", 4); // limit 4 to keep description commas intact
                        addComplaint(new Complaint(Integer.parseInt(data[0]), data[1], data[3], data[2]));
                    }
                }
            }

            File fRecords = new File("student_records.csv");
            if (fRecords.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(fRecords))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] data = line.split(",");
                        String studentEmail = data[0];
                        String courseCode = data[1];
                        String status = data[2];
                        int grade = Integer.parseInt(data[3]);

                        User u = getUser(studentEmail);
                        Course c = getCourse(courseCode);

                        if (u instanceof Student && c != null) {
                            Student s = (Student) u;
                            s.restoreCourseRecord(courseCode, status, grade);
                            if (status.equals("Registered")) {
                                c.getEnrolledStudentEmails().add(studentEmail);
                            }
                        }
                    }
                }
            }
            System.out.println("[System] Data successfully loaded from CSV.");
        } catch (IOException e) {
            System.out.println("[Error] Failed to load data: " + e.getMessage());
        }
    }

    public void addUser(User user) {
        users.put(user.getEmail(), user);
    }

    public User getUser(String email) {
        return users.get(email);
    }

    public User authenticateUser(String email, String password) throws InvalidLoginException {
        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        throw new InvalidLoginException("Incorrect email or password provided.");
    }

    public void addCourse(Course course) {
        courseCatalog.put(course.getCourseCode(), course);
    }

    public Course getCourse(String courseCode) {
        return courseCatalog.get(courseCode);
    }

    public HashMap<String, Course> getCourseCatalog() {
        return courseCatalog;
    }

    public void addComplaint(Complaint c) {
        complaints.add(c);
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }
}
