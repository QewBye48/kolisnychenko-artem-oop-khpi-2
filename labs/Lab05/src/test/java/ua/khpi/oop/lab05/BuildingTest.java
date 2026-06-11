package ua.khpi.oop.lab05;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BuildingTest {

    @Test
    public void constructorSetsFields() {
        Building building = new Building("Kharkiv, Nauky Ave. 10", 1980);

        assertEquals(building.getAddress(), "Kharkiv, Nauky Ave. 10");
        assertEquals(building.getYearBuilt(), 1980);
    }

    @Test
    public void descriptionReturnsCorrectText() {
        Building building = new Building("Kharkiv, Nauky Ave. 10", 1980);

        String text = building.description();

        assertTrue(text.contains("Kharkiv, Nauky Ave. 10"));
        assertTrue(text.contains("1980"));
    }
}