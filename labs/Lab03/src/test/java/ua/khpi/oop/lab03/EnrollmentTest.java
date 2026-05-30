package ua.khpi.oop.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnrollmentTest {

    @Test
    void testEnrollmentCreationAndCancellation() {
        Student student = new Student("Іван Іванов", "КН-111", 1);
        SportSection section = new SportSection("Шахи", "Інтелектуальні", "Ауд. 201");

        Enrollment enrollment = new Enrollment(student, section, "2026-05-30");

        assertEquals(student, enrollment.getStudent());
        assertEquals(section, enrollment.getSection());
        assertTrue(enrollment.isActive());

        enrollment.cancel();
        assertFalse(enrollment.isActive());
    }
}