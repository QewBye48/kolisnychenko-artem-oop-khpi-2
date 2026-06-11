package ua.khpi.oop.lab06;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ParcelLockerDeliveryTest {

    @Test
    public void parcelLockerDeliveryShouldStoreOwnAndBaseFields() {
        ParcelLockerDelivery delivery = new ParcelLockerDelivery(
                "ORD-002",
                "Харків, проспект Науки, 10",
                80,
                "A-15"
        );

        Assert.assertEquals(delivery.getOrderId(), "ORD-002");
        Assert.assertEquals(delivery.getAddress(), "Харків, проспект Науки, 10");
        Assert.assertEquals(delivery.getBasePrice(), 80.0);
        Assert.assertEquals(delivery.getLockerNumber(), "A-15");
    }

    @Test
    public void parcelLockerDeliveryShouldCalculatePrice() {
        ParcelLockerDelivery delivery = new ParcelLockerDelivery(
                "ORD-002",
                "Харків, проспект Науки, 10",
                80,
                "A-15"
        );

        Assert.assertEquals(delivery.calculatePrice(), 100.0);
    }

    @Test
    public void parcelLockerDeliveryInfoShouldContainMainData() {
        ParcelLockerDelivery delivery = new ParcelLockerDelivery(
                "ORD-002",
                "Харків, проспект Науки, 10",
                80,
                "A-15"
        );

        String text = delivery.getInfo();

        Assert.assertTrue(text.contains("ORD-002"));
        Assert.assertTrue(text.contains("Харків, проспект Науки, 10"));
        Assert.assertTrue(text.contains("80"));
        Assert.assertTrue(text.contains("A-15"));
    }
}