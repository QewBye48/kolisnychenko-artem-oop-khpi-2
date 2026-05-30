package ua.khpi.oop.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SportSectionTest {

    @Test
    void sectionShouldReturnCorrectName() {
        Coach coach = new Coach("Іванов", "Бокс");
        Schedule schedule = new Schedule("Понеділок", "18:00");
        SportSection section = new SportSection("Університетський бокс", coach, schedule);

        assertEquals("Університетський бокс", section.getName());
    }

    @Test
    void sectionToStringShouldContainDependencies() {
        Coach coach = new Coach("Іванов", "Бокс");
        Schedule schedule = new Schedule("Понеділок", "18:00");
        SportSection section = new SportSection("Університетський бокс", coach, schedule);

        String result = section.toString();

        assertTrue(result.contains("Університетський бокс"));
        assertTrue(result.contains("Іванов"));
        assertTrue(result.contains("Понеділок"));
    }
}