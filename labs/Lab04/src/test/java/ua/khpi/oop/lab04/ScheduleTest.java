package ua.khpi.oop.lab04;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ScheduleTest {

    @Test
    public void testScheduleFormat() {
        Schedule schedule = new Schedule("Вівторок", "16:30");
        String result = schedule.toString();

        assertEquals(result, "Вівторок о 16:30");
    }
}