package ua.khpi.oop.lab06;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DroneDeliveryTest {

    @Test
    public void droneDeliveryShouldStoreOwnAndBaseFields() {
        DroneDelivery delivery = new DroneDelivery(
                "ORD-003",
                "Харків, вул. Кирпичова, 2",
                150,
                2.5
        );

        Assert.assertEquals(delivery.getOrderId(), "ORD-003");
        Assert.assertEquals(delivery.getAddress(), "Харків, вул. Кирпичова, 2");
        Assert.assertEquals(delivery.getBasePrice(), 150.0);
        Assert.assertEquals(delivery.getWeightKg(), 2.5);
    }

    @Test
    public void droneDeliveryShouldCalculatePrice() {
        DroneDelivery delivery = new DroneDelivery(
                "ORD-003",
                "Харків, вул. Кирпичова, 2",
                150,
                2.5
        );

        Assert.assertEquals(delivery.calculatePrice(), 225.0);
    }

    @Test
    public void droneDeliveryInfoShouldContainMainData() {
        DroneDelivery delivery = new DroneDelivery(
                "ORD-003",
                "Харків, вул. Кирпичова, 2",
                150,
                2.5
        );

        String text = delivery.getInfo();

        Assert.assertTrue(text.contains("ORD-003"));
        Assert.assertTrue(text.contains("Харків, вул. Кирпичова, 2"));
        Assert.assertTrue(text.contains("150"));
        Assert.assertTrue(text.contains("2.5"));
    }
}