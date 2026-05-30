package ua.khpi.oop.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScheduleTest {

    @Test
    void scheduleToStringShouldContainData() {
        Schedule schedule = new Schedule("Понеділок", "18:00");
        String result = schedule.toString();

        assertTrue(result.contains("Понеділок"));
        assertTrue(result.contains("18:00"));
    }
}