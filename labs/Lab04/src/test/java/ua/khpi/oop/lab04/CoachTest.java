package ua.khpi.oop.lab04;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CoachTest {

    @Test
    public void testCoachToString() {
        Coach coach = new Coach("Олександр Усик", "Бокс");
        String result = coach.toString();

        assertTrue(result.contains("Олександр Усик"));
        assertTrue(result.contains("Бокс"));
        assertTrue(result.startsWith("Тренер:"));
    }
}