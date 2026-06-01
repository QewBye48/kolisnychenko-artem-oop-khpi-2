package ua.khpi.oop.lab06;

public class DroneDelivery extends DeliveryMethod {
    private final double weightKg;

    public DroneDelivery(String orderId, String address, double basePrice, double weightKg) {
        super(orderId, address, basePrice);
        this.weightKg = weightKg;
    }

    public double getWeightKg() {
        return weightKg;
    }

    @Override
    public double calculatePrice() {
        return basePrice + weightKg * 30;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", drone package weight: " + weightKg + " kg";
    }
}