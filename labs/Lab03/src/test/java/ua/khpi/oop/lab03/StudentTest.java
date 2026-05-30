package ua.khpi.oop.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    void testStudentCreation() {
        Student student = new Student("Колісніченко Артем", "КН-924в", 2);
        assertNotNull(student);
    }

    @Test
    void testEmptyTicketIdThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Student("Колісніченко Артем", "", 2);
        });
        assertEquals("Номер квитка не може бути порожнім", exception.getMessage());
    }
}