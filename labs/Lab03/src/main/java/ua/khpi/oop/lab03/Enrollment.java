package ua.khpi.oop.lab03;

public class Enrollment {
    private Student student;
    private SportSection section;
    private String date;

    public Enrollment(Student student, SportSection section, String date) {
        this.student = student;
        this.section = section;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Запис: " + student.getName() + " -> " + section.getName() + " (Дата: " + date + ")";
    }
}