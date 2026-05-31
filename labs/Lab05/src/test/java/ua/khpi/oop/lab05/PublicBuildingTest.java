package ua.khpi.oop.lab05;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PublicBuildingTest {

    @Test
    public void publicBuildingShouldStoreOwnAndParentFields() {
        PublicBuilding building = new PublicBuilding("Kharkiv, Sumskaya St. 20", 1995, 300);

        Assert.assertEquals(building.getAddress(), "Kharkiv, Sumskaya St. 20");
        Assert.assertEquals(building.getYearBuilt(), 1995);
        Assert.assertEquals(building.getVisitorCapacity(), 300);
    }

    @Test
    public void publicBuildingDescriptionShouldContainMainInformation() {
        PublicBuilding building = new PublicBuilding("Kharkiv, Sumskaya St. 20", 1995, 300);

        String text = building.description();

        Assert.assertTrue(text.contains("Kharkiv, Sumskaya St. 20"));
        Assert.assertTrue(text.contains("1995"));
        Assert.assertTrue(text.contains("300"));
    }
}