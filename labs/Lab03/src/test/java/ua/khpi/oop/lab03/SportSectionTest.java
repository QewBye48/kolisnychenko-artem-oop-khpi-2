package ua.khpi.oop.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SportSectionTest {

    @Test
    void testSectionCreationAndGetters() {
        SportSection section = new SportSection("Бокс", "Єдиноборства", "Зал 1");

        assertEquals("Бокс", section.getSectionName());
        assertTrue(section.isOpenForRegistration(), "За замовчуванням секція має бути відкрита");
    }

    @Test
    void testExceptionOnEmptyName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new SportSection("", "Єдиноборства", "Зал 1");
        });

        assertEquals("Назва секції не може бути порожньою", exception.getMessage());
    }

    @Test
    void testChangeRegistrationStatus() {
        SportSection section = new SportSection("Плавання", "Водний спорт", "Басейн");

        section.setRegistrationStatus(false);
        assertFalse(section.isOpenForRegistration());
    }
}