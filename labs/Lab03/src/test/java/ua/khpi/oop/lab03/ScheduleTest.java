package ua.khpi.oop.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScheduleTest {

    @Test
    void testScheduleCreation() {
        Schedule schedule = new Schedule("Понеділок", "15:00", 90);
        assertNotNull(schedule);
    }

    @Test
    void testScheduleEquality() {
        Schedule schedule1 = new Schedule("Вівторок", "10:00", 60);
        Schedule schedule2 = new Schedule("Вівторок", "10:00", 60);

        assertEquals(schedule1, schedule2, "Розклади з однаковими даними мають бути рівними");
    }
}