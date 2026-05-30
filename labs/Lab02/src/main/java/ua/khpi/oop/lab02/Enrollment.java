package ua.khpi.oop.lab02;

import java.util.Objects;

public class Enrollment {
    private final Student student;
    private final SportSection section;
    private final String enrollmentDate;
    private boolean active;

    public Enrollment(Student student, SportSection section, String enrollmentDate) {
        this.student = Objects.requireNonNull(student, "Студент не може бути null");
        this.section = Objects.requireNonNull(section, "Секція не може бути null");
        this.enrollmentDate = enrollmentDate;
        this.active = true;
    }

    public Student getStudent() { return student; }
    public SportSection getSection() { return section; }
    public boolean isActive() { return active; }

    public void cancel() { this.active = false; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enrollment)) return false;
        Enrollment that = (Enrollment) o;
        return active == that.active &&
                Objects.equals(student, that.student) &&
                Objects.equals(section, that.section) &&
                Objects.equals(enrollmentDate, that.enrollmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, section, enrollmentDate, active);
    }

    @Override
    public String toString() {
        return String.format("Запис [Студент=%s, Секція=%s, Дата=%s, Активний=%b]",
                student.toString(), section.getSectionName(), enrollmentDate, active);
    }
}