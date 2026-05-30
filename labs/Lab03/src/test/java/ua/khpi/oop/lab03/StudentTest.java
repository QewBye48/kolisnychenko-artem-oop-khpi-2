package ua.khpi.oop.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    void studentShouldReturnCorrectName() {
        Student student = new Student("Артем");
        assertEquals("Артем", student.getName());
    }

    @Test
    void studentToStringShouldContainName() {
        Student student = new Student("Артем");
        assertTrue(student.toString().contains("Артем"));
        assertTrue(student.toString().contains("Студент:"));
    }
}