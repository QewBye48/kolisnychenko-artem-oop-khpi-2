package ua.khpi.oop.lab09.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrescriptionTest {

    @Test
    void prescriptionShouldStoreData() {
        Patient patient = new Patient("PAT-1", "Колісниченко Артем", 20);

        Prescription prescription = new Prescription(
                "PRES-1",
                patient,
                "Парацетамол",
                500,
                5
        );

        assertEquals("PRES-1", prescription.getPrescriptionId());
        assertEquals(patient, prescription.getPatient());
        assertEquals("Парацетамол", prescription.getMedicineName());
        assertEquals(500, prescription.getDoseMg());
        assertEquals(5, prescription.getDays());
    }

    @Test
    void prescriptionShouldCompareByDays() {
        Patient patient = new Patient("PAT-1", "Колісниченко Артем", 20);

        Prescription shortPrescription = new Prescription(
                "PRES-1",
                patient,
                "Парацетамол",
                500,
                5
        );

        Prescription longPrescription = new Prescription(
                "PRES-2",
                patient,
                "Ібупрофен",
                400,
                7
        );

        assertTrue(longPrescription.compareTo(shortPrescription) > 0);
    }
}