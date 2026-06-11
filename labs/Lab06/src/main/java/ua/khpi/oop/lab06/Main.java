package ua.khpi.oop.lab06;

public class Main {
    public static void main(String[] args) {
        DeliveryMethod[] deliveries = {
                new CourierDelivery("ORD-001", "Харків, вул. Сумська, 20", 100, 5),
                new ParcelLockerDelivery("ORD-002", "Харків, проспект Науки, 10", 80, "A-15"),
                new DroneDelivery("ORD-003", "Харків, вул. Кирпичова, 2", 150, 2.5)
        };

        for (DeliveryMethod delivery : deliveries) {
            System.out.println(delivery.getInfo());
            System.out.println("Price: " + delivery.calculatePrice());
            System.out.println();
        }
    }
}