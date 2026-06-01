package ua.khpi.oop.lab06;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CourierDeliveryTest {

    @Test
    public void courierDeliveryShouldStoreOwnAndBaseFields() {
        CourierDelivery delivery = new CourierDelivery(
                "ORD-001",
                "Харків, вул. Сумська, 20",
                100,
                5
        );

        Assert.assertEquals(delivery.getOrderId(), "ORD-001");
        Assert.assertEquals(delivery.getAddress(), "Харків, вул. Сумська, 20");
        Assert.assertEquals(delivery.getBasePrice(), 100.0);
        Assert.assertEquals(delivery.getDistanceKm(), 5);
    }

    @Test
    public void courierDeliveryShouldCalculatePrice() {
        CourierDelivery delivery = new CourierDelivery(
                "ORD-001",
                "Харків, вул. Сумська, 20",
                100,
                5
        );

        Assert.assertEquals(delivery.calculatePrice(), 150.0);
    }

    @Test
    public void courierDeliveryInfoShouldContainMainData() {
        CourierDelivery delivery = new CourierDelivery(
                "ORD-001",
                "Харків, вул. Сумська, 20",
                100,
                5
        );

        String text = delivery.getInfo();

        Assert.assertTrue(text.contains("ORD-001"));
        Assert.assertTrue(text.contains("Харків, вул. Сумська, 20"));
        Assert.assertTrue(text.contains("100"));
        Assert.assertTrue(text.contains("5"));
    }
}