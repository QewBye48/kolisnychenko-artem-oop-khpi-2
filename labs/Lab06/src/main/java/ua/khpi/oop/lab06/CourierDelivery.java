package ua.khpi.oop.lab06;

public class CourierDelivery extends DeliveryMethod {
    private final int distanceKm;

    public CourierDelivery(String orderId, String address, double basePrice, int distanceKm) {
        super(orderId, address, basePrice);
        this.distanceKm = distanceKm;
    }

    public int getDistanceKm() {
        return distanceKm;
    }

    @Override
    public double calculatePrice() {
        return basePrice + distanceKm * 10;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", courier distance: " + distanceKm + " km";
    }
}