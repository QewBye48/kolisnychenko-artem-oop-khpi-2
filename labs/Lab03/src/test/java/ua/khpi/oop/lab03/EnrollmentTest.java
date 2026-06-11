package ua.khpi.oop.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnrollmentTest {

    @Test
    void enrollmentToStringShouldContainAllData() {
        Student student = new Student("Артем");
        Coach coach = new Coach("Іванов", "Бокс");
        Schedule schedule = new Schedule("Понеділок", "18:00");
        SportSection section = new SportSection("Університетський бокс", coach, schedule);

        Enrollment enrollment = new Enrollment(student, section, "15.09.2026");
        String result = enrollment.toString();

        assertTrue(result.contains("Артем"));
        assertTrue(result.contains("Університетський бокс"));
        assertTrue(result.contains("15.09.2026"));
    }
}