package ua.khpi.oop.lab13.model;

public class OrderReport {
    private final int validRecords;
    private final int invalidRecords;
    private final double totalAmount;

    public OrderReport(int validRecords, int invalidRecords, double totalAmount) {
        this.validRecords = validRecords;
        this.invalidRecords = invalidRecords;
        this.totalAmount = totalAmount;
    }

    public int getValidRecords() {
        return validRecords;
    }

    public int getInvalidRecords() {
        return invalidRecords;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}