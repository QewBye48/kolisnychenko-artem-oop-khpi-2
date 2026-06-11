package ua.khpi.oop.lab04;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class SportSectionTest {

    @Test
    public void testSectionGetters() {
        Coach coach = new Coach("Іванов", "Бокс");
        Schedule schedule = new Schedule("Пн", "18:00");
        SportSection section = new SportSection("Бокс ХПІ", coach, schedule);

        assertEquals(section.getName(), "Бокс ХПІ");
    }

    @Test
    public void testSectionToStringContainsDependencies() {
        Coach coach = new Coach("Іванов", "Бокс");
        Schedule schedule = new Schedule("Пн", "18:00");
        SportSection section = new SportSection("Бокс ХПІ", coach, schedule);

        String result = section.toString();
        assertTrue(result.contains("Бокс ХПІ"));
        assertTrue(result.contains("Іванов"));
        assertTrue(result.contains("Пн"));
    }
}