package ua.khpi.oop.lab05;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MedicalBuildingTest {

    @Test
    public void medicalBuildingShouldStoreOwnAndParentFields() {
        MedicalBuilding building = new MedicalBuilding("Kharkiv, Pushkinska St. 15", 2005, 200, 40);

        assertEquals(building.getAddress(), "Kharkiv, Pushkinska St. 15");
        assertEquals(building.getYearBuilt(), 2005);
        assertEquals(building.getVisitorCapacity(), 200);
        assertEquals(building.getDoctorsCount(), 40);
    }

    @Test
    public void medicalBuildingDescriptionShouldContainMainInformation() {
        MedicalBuilding building = new MedicalBuilding("Kharkiv, Pushkinska St. 15", 2005, 200, 40);

        String text = building.description();

        assertTrue(text.contains("Kharkiv, Pushkinska St. 15"));
        assertTrue(text.contains("2005"));
        assertTrue(text.contains("200"));
        assertTrue(text.contains("40"));
    }
}