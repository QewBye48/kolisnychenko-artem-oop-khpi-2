package ua.khpi.oop.lab06;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeliveryMethodPolymorphismTest {

    @Test
    public void shouldCallCalculatePriceThroughBaseType() {
        DeliveryMethod[] deliveries = {
                new CourierDelivery("ORD-001", "Харків, вул. Сумська, 20", 100, 5),
                new ParcelLockerDelivery("ORD-002", "Харків, проспект Науки, 10", 80, "A-15"),
                new DroneDelivery("ORD-003", "Харків, вул. Кирпичова, 2", 150, 2.5)
        };

        Assert.assertEquals(deliveries[0].calculatePrice(), 150.0);
        Assert.assertEquals(deliveries[1].calculatePrice(), 100.0);
        Assert.assertEquals(deliveries[2].calculatePrice(), 225.0);
    }

    @Test
    public void shouldUseConcreteInfoThroughBaseType() {
        DeliveryMethod[] deliveries = {
                new CourierDelivery("ORD-001", "Харків, вул. Сумська, 20", 100, 5),
                new ParcelLockerDelivery("ORD-002", "Харків, проспект Науки, 10", 80, "A-15"),
                new DroneDelivery("ORD-003", "Харків, вул. Кирпичова, 2", 150, 2.5)
        };

        Assert.assertTrue(deliveries[0].getInfo().contains("courier distance"));
        Assert.assertTrue(deliveries[1].getInfo().contains("locker number"));
        Assert.assertTrue(deliveries[2].getInfo().contains("drone package weight"));
    }
}