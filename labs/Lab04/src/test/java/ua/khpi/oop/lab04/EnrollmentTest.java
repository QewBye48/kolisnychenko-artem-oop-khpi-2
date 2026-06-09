package ua.khpi.oop.lab04;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class EnrollmentTest {

    @Test
    public void testEnrollmentToString() {
        Student student = new Student("Артем");
        Coach coach = new Coach("Тренер", "Спорт");
        Schedule schedule = new Schedule("Пн", "10:00");
        SportSection section = new SportSection("Секція 1", coach, schedule);

        Enrollment enrollment = new Enrollment(student, section, "01.09.2026");
        String result = enrollment.toString();

        assertTrue(result.contains("Артем"));
        assertTrue(result.contains("Секція 1"));
        assertTrue(result.contains("01.09.2026"));
    }
}