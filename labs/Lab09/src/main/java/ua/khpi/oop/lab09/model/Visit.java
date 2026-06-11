package ua.khpi.oop.lab09.model;

import java.time.LocalDate;

public class Visit implements Comparable<Visit> {
    private final String visitId;
    private final Patient patient;
    private final LocalDate visitDate;
    private final String doctorName;

    public Visit(String visitId, Patient patient, LocalDate visitDate, String doctorName) {
        if (visitId == null || visitId.isBlank()) {
            throw new IllegalArgumentException("Ідентифікатор візиту не може бути порожнім");
        }
        if (patient == null) {
            throw new IllegalArgumentException("Пацієнт не може бути null");
        }
        if (visitDate == null) {
            throw new IllegalArgumentException("Дата візиту не може бути null");
        }
        if (doctorName == null || doctorName.isBlank()) {
            throw new IllegalArgumentException("Ім'я лікаря не може бути порожнім");
        }

        this.visitId = visitId;
        this.patient = patient;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
    }

    public String getVisitId() {
        return visitId;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    @Override
    public int compareTo(Visit other) {
        return this.visitDate.compareTo(other.visitDate);
    }

    @Override
    public String toString() {
        return "Візит: " + visitId +
                ", пацієнт: " + patient.getFullName() +
                ", дата: " + visitDate +
                ", лікар: " + doctorName;
    }
}