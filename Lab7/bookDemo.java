import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;
    double price;

    public Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void display() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

class Periodical extends Book {
    String period;

    public Periodical(int bookId, String title, String author, double price, String period) {
        super(bookId, title, author, price);
        this.period = period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Period: " + period);
    }
}

public class bookDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Periodical Details");
        System.out.print("Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Period (weekly, monthly, yearly): ");
        String period = scanner.nextLine();

        Periodical periodical = new Periodical(id, title, author, price, period);

        System.out.println("\nInitial Periodical Details");
        periodical.display();

        System.out.println("\nModify Details");
        System.out.print("Enter new Price: ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter new Period: ");
        String newPeriod = scanner.nextLine();

        periodical.setPrice(newPrice);
        periodical.setPeriod(newPeriod);

        System.out.println("\nUpdated Periodical Details");
        periodical.display();

        scanner.close();
    }
}
