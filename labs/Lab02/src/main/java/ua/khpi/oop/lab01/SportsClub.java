package ua.khpi.oop.lab02;

import java.util.ArrayList;
import java.util.List;

public class SportsClub {
    private String clubName;
    private List<SportSection> sections = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Enrollment> enrollments = new ArrayList<>();

    public SportsClub(String clubName) {
        this.clubName = clubName;
    }

    public void addSection(SportSection section) {
        sections.add(section);
    }

    public void registerStudent(Student student) {
        students.add(student);
    }

    public void enrollStudent(Student student, SportSection section, String date) {
        Enrollment enrollment = new Enrollment(student, section, date);
        enrollments.add(enrollment);
    }

    public void printClubStats() {
        System.out.println("--- Статистика клубу '" + clubName + "' ---");
        System.out.println("Кількість секцій: " + sections.size());
        System.out.println("Кількість студентів: " + students.size());
        System.out.println("Кількість записів: " + enrollments.size());
        System.out.println("\nЖурнал записів:");
        for (Enrollment e : enrollments) {
            System.out.println(e);
        }
    }
}