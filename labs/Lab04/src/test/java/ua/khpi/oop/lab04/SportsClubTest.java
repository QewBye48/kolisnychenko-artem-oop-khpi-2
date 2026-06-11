package ua.khpi.oop.lab04;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class SportsClubTest {
    private SportsClub club;
    private Student student;
    private SportSection section;

    @BeforeMethod
    public void setUp() {
        club = new SportsClub("ХПІ Спорт");
        student = new Student("Артем");
        Coach coach = new Coach("Володимир Кличко", "Бокс");
        Schedule schedule = new Schedule("Понеділок", "18:00");
        section = new SportSection("Університетський бокс", coach, schedule);
    }

    @Test(groups = {"smoke"})
    public void testClubInitialization() {
        assertNotNull(club);
    }

    @Test(groups = {"domain"})
    public void testEnrollStudent() {
        club.registerStudent(student);
        club.addSection(section);
        club.enrollStudent(student, section, "15.09.2026");

        assertNotNull(club);
    }


    @Test(groups = {"negative"}, expectedExceptions = NullPointerException.class)
    public void enrollStudent_nullStudent_throwsNPE() {
        Enrollment enrollment = new Enrollment(null, section, "15.09.2026");
        enrollment.toString(); // Це викличе NullPointerException, бо student = null
    }
}