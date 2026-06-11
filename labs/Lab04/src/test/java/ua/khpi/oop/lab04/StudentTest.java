package ua.khpi.oop.lab04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class StudentTest {

    @DataProvider(name = "studentNames")
    public Object[][] studentNames() {
        return new Object[][] {
                {"Артем Колісніченко"},
                {"Іван Іванов"},
                {"Олена Петрівна"}
        };
    }

    @Test
    public void testStudentCreation(String name) {
        Student student = new Student(name);
        assertEquals(student.getName(), name);
        assertTrue(student.toString().contains(name));
    }
}