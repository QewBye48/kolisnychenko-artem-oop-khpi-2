package ua.khpi.oop.lab03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SportsClubTest {

    private SportsClub club;
    private SportSection section;
    private Student student;

    @BeforeEach
    void setUp() {
        club = new SportsClub("ХПІ Спорт", "вул. Пушкінська 79");
        section = new SportSection("Теніс", "Ракетний спорт", "Корт 2");
        student = new Student("Артем Колісніченко", "КН-924в", 2);

        club.addSection(section);
        club.registerStudent(student);
    }

    @Test
    void testSuccessfulEnrollment() {
        Enrollment enrollment = club.enrollStudent(student, section, "2026-05-30");

        assertNotNull(enrollment);
        assertTrue(enrollment.isActive());
    }

    @Test
    void testEnrollmentOnClosedSectionThrowsException() {
        section.setRegistrationStatus(false);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            club.enrollStudent(student, section, "2026-05-31");
        });

        assertEquals("Реєстрацію на цю секцію закрито!", exception.getMessage());
    }

    @Test
    void testEnrollmentToUnknownSectionThrowsException() {
        SportSection unknownSection = new SportSection("Кіберспорт", "PC", "Гуртожиток");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            club.enrollStudent(student, unknownSection, "2026-05-31");
        });

        assertEquals("Ця секція не належить нашому клубу", exception.getMessage());
    }
}