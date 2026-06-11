package ua.khpi.oop.lab09.model;

public class Patient {
    private final String patientId;
    private final String fullName;
    private final int age;

    public Patient(String patientId, String fullName, int age) {
        if (patientId == null || patientId.isBlank()) {
            throw new IllegalArgumentException("Ідентифікатор пацієнта не може бути порожнім");
        }
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("ПІБ пацієнта не може бути порожнім");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Вік пацієнта має бути додатним числом");
        }

        this.patientId = patientId;
        this.fullName = fullName;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Пацієнт: " + patientId +
                ", ПІБ: " + fullName +
                ", вік: " + age;
    }
}