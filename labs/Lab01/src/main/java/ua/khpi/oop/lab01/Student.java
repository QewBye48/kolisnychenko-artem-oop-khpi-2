package ua.khpi.oop.lab01;

import java.util.Objects;

public class Student {
    private final String fullName;
    private final String ticketId;
    private final int studyYear;

    public Student(String fullName, String ticketId, int studyYear) {
        if (ticketId == null || ticketId.isEmpty()) {
            throw new IllegalArgumentException("ticketId cannot be null or empty");
        }
        this.fullName = fullName;
        this.ticketId = ticketId;
        this.studyYear = studyYear;
    }

    public String getFullName() {
        return fullName;
    }

    public String getTicketId() {
        return ticketId;
    }

    public int getStudyYear() {
        return studyYear;
    }

    // Змістовний метод
    public void enroll(SportSection section) {
        System.out.println(fullName + " успішно записався на секцію: " + section.getSectionName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studyYear == student.studyYear &&
                Objects.equals(fullName, student.fullName) &&
                Objects.equals(ticketId, student.ticketId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, ticketId, studyYear);
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", ticketId='" + ticketId + '\'' +
                ", studyYear=" + studyYear +
                '}';
    }
}