package ua.khpi.oop.lab05;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UniversityCampusBuildingTest {

    @Test
    public void universityCampusBuildingShouldStoreAllFields() {
        UniversityCampusBuilding building = new UniversityCampusBuilding(
                "Kharkiv, Kyrpychova St. 2",
                1965,
                500,
                25,
                "Computer Science"
        );

        assertEquals(building.getAddress(), "Kharkiv, Kyrpychova St. 2");
        assertEquals(building.getYearBuilt(), 1965);
        assertEquals(building.getVisitorCapacity(), 500);
        assertEquals(building.getClassroomsCount(), 25);
        assertEquals(building.getFacultyName(), "Computer Science");
    }

    @Test
    public void universityCampusBuildingDescriptionShouldContainAllInformation() {
        UniversityCampusBuilding building = new UniversityCampusBuilding(
                "Kharkiv, Kyrpychova St. 2",
                1965,
                500,
                25,
                "Computer Science"
        );

        String text = building.description();

        assertTrue(text.contains("Kharkiv, Kyrpychova St. 2"));
        assertTrue(text.contains("1965"));
        assertTrue(text.contains("500"));
        assertTrue(text.contains("25"));
        assertTrue(text.contains("Computer Science"));
    }
}