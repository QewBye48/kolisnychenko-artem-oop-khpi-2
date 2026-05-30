package ua.khpi.oop.lab03;

import java.util.Objects;

public class Student {
    private final String fullName;
    private final String ticketId;
    private final int studyYear;

    public Student(String fullName, String ticketId, int studyYear) {
        if (ticketId == null || ticketId.isEmpty()) {
            throw new IllegalArgumentException("Номер квитка не може бути порожнім");
        }
        this.fullName = fullName;
        this.ticketId = ticketId;
        this.studyYear = studyYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(ticketId, student.ticketId);
    }

    @Override
    public int hashCode() { return Objects.hash(ticketId); }

    @Override
    public String toString() {
        return String.format("Студент [%s, Квиток: %s, Курс: %d]", fullName, ticketId, studyYear);
    }
}