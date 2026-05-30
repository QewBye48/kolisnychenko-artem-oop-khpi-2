package ua.khpi.oop.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoachTest {

    @Test
    void testCoachCreation() {
        Coach coach = new Coach("Олександр Усик", "Бокс", 15);
        assertNotNull(coach);
    }

    @Test
    void testEmptyNameThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Coach("", "Бокс", 15);
        });
        assertEquals("ПІБ тренера не може бути порожнім", exception.getMessage());
    }
}