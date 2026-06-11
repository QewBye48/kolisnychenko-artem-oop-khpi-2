package ua.khpi.oop.lab09.demo;

import ua.khpi.oop.lab09.model.MedicalRecord;
import ua.khpi.oop.lab09.util.MedicalUtils;
import ua.khpi.oop.lab09.model.Patient;
import ua.khpi.oop.lab09.model.Prescription;
import ua.khpi.oop.lab09.model.Visit;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Patient patient = new Patient(
                "PAT-1",
                "Колісниченко Артем",
                20
        );

        Visit visit1 = new Visit(
                "VISIT-1",
                patient,
                LocalDate.of(2026, 4, 10),
                "Олена Володимирівна"
        );

        Visit visit2 = new Visit(
                "VISIT-2",
                patient,
                LocalDate.of(2026, 5, 15),
                "Ігор Миколайович"
        );

        Prescription prescription1 = new Prescription(
                "PRES-1",
                patient,
                "Парацетамол",
                500,
                5
        );

        Prescription prescription2 = new Prescription(
                "PRES-2",
                patient,
                "Ібупрофен",
                400,
                7
        );

        System.out.println("Generic-клас MedicalRecord");

        MedicalRecord<Visit, String> visitRecord =
                new MedicalRecord<>(visit1, "Плановий візит");

        MedicalRecord<Prescription, Integer> prescriptionRecord =
                new MedicalRecord<>(prescription1, 1);

        System.out.println(visitRecord);
        System.out.println(prescriptionRecord);

        System.out.println();
        System.out.println("Generic-метод findMaximum");

        List<Visit> visits = List.of(visit1, visit2);
        Visit latestVisit = MedicalUtils.findMaximum(visits);

        System.out.println("Найпізніший візит:");
        System.out.println(latestVisit);

        List<Prescription> prescriptions = List.of(prescription1, prescription2);
        Prescription longestPrescription = MedicalUtils.findMaximum(prescriptions);

        System.out.println();
        System.out.println("Рецепт з найбільшою тривалістю:");
        System.out.println(longestPrescription);
    }
}