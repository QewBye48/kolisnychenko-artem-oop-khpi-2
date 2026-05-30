package ua.khpi.oop.lab02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SportsClub {
    private final String name;
    private final String address;
    private final List<SportSection> sections = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();
    private final List<Enrollment> enrollments = new ArrayList<>();

    public SportsClub(String name, String address) {
        if (name == null || address == null) {
            throw new IllegalArgumentException("Назва та адреса клубу не можуть бути null");
        }
        this.name = name;
        this.address = address;
    }

    public void addSection(SportSection section) {
        sections.add(Objects.requireNonNull(section));
    }

    public void registerStudent(Student student) {
        students.add(Objects.requireNonNull(student));
    }

    public Enrollment enrollStudent(Student student, SportSection section, String date) {
        if (!sections.contains(section)) {
            throw new IllegalArgumentException("Ця секція не належить нашому клубу");
        }
        if (!section.isOpenForRegistration()) {
            throw new IllegalStateException("Реєстрацію на цю секцію закрито!");
        }

        Enrollment enrollment = new Enrollment(student, section, date);
        enrollments.add(enrollment);
        return enrollment;
    }

    @Override
    public String toString() {
        return String.format("Спортивний Клуб '%s' [Адреса: %s, Секцій: %d, Студентів: %d, Записів: %d]",
                name, address, sections.size(), students.size(), enrollments.size());
    }
}