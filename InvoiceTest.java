import java.util.Scanner;

class Invoice {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;

        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }

        if (pricePerItem > 0.0) {
            this.pricePerItem = pricePerItem;
        } else {
            this.pricePerItem = 0.0;
        }
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPricePerItem(double pricePerItem) {
        if (pricePerItem > 0.0) {
            this.pricePerItem = pricePerItem;
        } else {
            this.pricePerItem = 0.0;
        }
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public double getInvoiceAmount() {
        return quantity * pricePerItem;
    }
}

public class InvoiceTest {
    public static void main(String[] args) {
        System.out.println("--- Hardware Store Invoice Test ---");

        Invoice inv1 = new Invoice("1234", "Hammer", 2, 14.95);
        Invoice inv2 = new Invoice("5678", "Paint Brush", -5, -10.00);

        System.out.println("\nInvoice 1:");
        System.out.println("Part Number: " + inv1.getPartNumber());
        System.out.println("Description: " + inv1.getPartDescription());
        System.out.println("Quantity: " + inv1.getQuantity());
        System.out.printf("Price: %f\n", inv1.getPricePerItem());
        System.out.printf("Total Amount: %f\n", inv1.getInvoiceAmount());

        System.out.println("\nInvoice 2:");
        System.out.println("Part Number: " + inv2.getPartNumber());
        System.out.println("Description: " + inv2.getPartDescription());
        System.out.println("Quantity: " + inv2.getQuantity());
        System.out.printf("Price: %f\n", inv2.getPricePerItem());
        System.out.printf("Total Amount: %f\n", inv2.getInvoiceAmount());
    }
}