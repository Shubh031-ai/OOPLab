class Date {
    private int month;
    private int day;
    private int year;

    public Date(int day, int month, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void displayDate() {
        System.out.printf("%d/%d/%d\n", day, month, year);
    }
}

public class DateTest {
    public static void main(String[] args) {
        Date myDate = new Date(16, 2, 2007);

        System.out.print("Initial date: ");
        myDate.displayDate();

        myDate.setMonth(12);
        myDate.setDay(25);
        myDate.setYear(2025);

        System.out.print("Updated date: ");
        myDate.displayDate();
    }
}