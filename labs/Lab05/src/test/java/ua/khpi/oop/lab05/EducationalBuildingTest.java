package ua.khpi.oop.lab05;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EducationalBuildingTest {

    @Test
    public void educationalBuildingShouldStoreOwnAndParentFields() {
        EducationalBuilding building = new EducationalBuilding("Kharkiv, Kyrpychova St. 2", 1965, 500, 25);

        assertEquals(building.getAddress(), "Kharkiv, Kyrpychova St. 2");
        assertEquals(building.getYearBuilt(), 1965);
        assertEquals(building.getVisitorCapacity(), 500);
        assertEquals(building.getClassroomsCount(), 25);
    }

    @Test
    public void educationalBuildingDescriptionShouldContainMainInformation() {
        EducationalBuilding building = new EducationalBuilding("Kharkiv, Kyrpychova St. 2", 1965, 500, 25);

        String text = building.description();

        assertTrue(text.contains("Kharkiv, Kyrpychova St. 2"));
        assertTrue(text.contains("1965"));
        assertTrue(text.contains("500"));
        assertTrue(text.contains("25"));
    }
}