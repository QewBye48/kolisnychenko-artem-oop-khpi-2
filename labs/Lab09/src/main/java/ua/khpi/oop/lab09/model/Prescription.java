package ua.khpi.oop.lab09.model;

public class Prescription implements Comparable<Prescription> {
    private final String prescriptionId;
    private final Patient patient;
    private final String medicineName;
    private final int doseMg;
    private final int days;

    public Prescription(String prescriptionId, Patient patient, String medicineName, int doseMg, int days) {
        if (prescriptionId == null || prescriptionId.isBlank()) {
            throw new IllegalArgumentException("Ідентифікатор рецепта не може бути порожнім");
        }
        if (patient == null) {
            throw new IllegalArgumentException("Пацієнт не може бути null");
        }
        if (medicineName == null || medicineName.isBlank()) {
            throw new IllegalArgumentException("Назва препарату не може бути порожньою");
        }
        if (doseMg <= 0) {
            throw new IllegalArgumentException("Доза препарату має бути додатним числом");
        }
        if (days <= 0) {
            throw new IllegalArgumentException("Кількість днів має бути додатним числом");
        }

        this.prescriptionId = prescriptionId;
        this.patient = patient;
        this.medicineName = medicineName;
        this.doseMg = doseMg;
        this.days = days;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public int getDoseMg() {
        return doseMg;
    }

    public int getDays() {
        return days;
    }

    @Override
    public int compareTo(Prescription other) {
        return Integer.compare(this.days, other.days);
    }

    @Override
    public String toString() {
        return "Рецепт: " + prescriptionId +
                ", пацієнт: " + patient.getFullName() +
                ", препарат: " + medicineName +
                ", доза: " + doseMg + " мг" +
                ", тривалість: " + days + " днів";
    }
}