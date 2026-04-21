package Assignment;

public abstract class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    abstract void displayMenu(Database db);

    abstract String getRole();
}
