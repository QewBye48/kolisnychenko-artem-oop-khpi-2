package ua.khpi.oop.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoachTest {

    @Test
    void coachToStringShouldContainData() {
        Coach coach = new Coach("Володимир Кличко", "Бокс");
        String result = coach.toString();

        assertTrue(result.contains("Володимир Кличко"));
        assertTrue(result.contains("Бокс"));
        assertTrue(result.contains("Тренер:"));
    }
}