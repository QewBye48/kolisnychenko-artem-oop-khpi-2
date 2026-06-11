package ua.khpi.oop.lab06;

public class ParcelLockerDelivery extends DeliveryMethod {
    private final String lockerNumber;

    public ParcelLockerDelivery(String orderId, String address, double basePrice, String lockerNumber) {
        super(orderId, address, basePrice);
        this.lockerNumber = lockerNumber;
    }

    public String getLockerNumber() {
        return lockerNumber;
    }

    @Override
    public double calculatePrice() {
        return basePrice + 20;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", locker number: " + lockerNumber;
    }
}