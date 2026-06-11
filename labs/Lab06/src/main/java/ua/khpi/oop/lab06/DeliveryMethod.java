package ua.khpi.oop.lab06;

public abstract class DeliveryMethod {
    protected final String orderId;
    protected final String address;
    protected final double basePrice;

    public DeliveryMethod(String orderId, String address, double basePrice) {
        this.orderId = orderId;
        this.address = address;
        this.basePrice = basePrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getAddress() {
        return address;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getInfo() {
        return "Order: " + orderId + ", address: " + address + ", base price: " + basePrice;
    }

    public abstract double calculatePrice();
}