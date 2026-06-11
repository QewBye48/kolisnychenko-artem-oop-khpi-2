package ua.khpi.oop.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SportsClubTest {

    @Test
    void clubShouldProcessOperationsWithoutErrors() {
        SportsClub club = new SportsClub("ХПІ Спорт");
        Student student = new Student("Артем");
        Coach coach = new Coach("Іванов", "Бокс");
        Schedule schedule = new Schedule("Понеділок", "18:00");
        SportSection section = new SportSection("Університетський бокс", coach, schedule);

        club.addSection(section);
        club.registerStudent(student);
        club.enrollStudent(student, section, "15.09.2026");

        assertNotNull(club);
    }
}