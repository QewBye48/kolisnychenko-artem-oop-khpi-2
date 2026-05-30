package ua.khpi.oop.lab01;

import java.util.Objects;

public class Student {
    private String fullName;
    private String ticketId;
    private int studyYear;

    public Student() {
    }

    public Student(String fullName, String ticketId, int studyYear) {
        this.fullName = fullName;
        this.ticketId = ticketId;
        this.studyYear = studyYear;
    }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }

    public int getStudyYear() { return studyYear; }
    public void setStudyYear(int studyYear) { this.studyYear = studyYear; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(ticketId, student.ticketId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId);
    }

    @Override
    public String toString() {
        return String.format("Student [Name='%s', Ticket='%s', Year=%d]",
                fullName, ticketId, studyYear);
    }
}