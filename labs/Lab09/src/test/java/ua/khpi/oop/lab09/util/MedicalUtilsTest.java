package ua.khpi.oop.lab09.util;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab09.model.Patient;
import ua.khpi.oop.lab09.model.Prescription;
import ua.khpi.oop.lab09.model.Visit;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MedicalUtilsTest {

    @Test
    void findMaximumShouldFindLatestVisit() {
        Patient patient = new Patient("PAT-1", "Колісниченко Артем", 20);

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

        Visit result = MedicalUtils.findMaximum(List.of(visit1, visit2));

        assertEquals(visit2, result);
    }

    @Test
    void findMaximumShouldFindLongestPrescription() {
        Patient patient = new Patient("PAT-1", "Колісниченко Артем", 20);

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

        Prescription result = MedicalUtils.findMaximum(List.of(prescription1, prescription2));

        assertEquals(prescription2, result);
    }

    @Test
    void findMaximumShouldWorkWithInteger() {
        Integer result = MedicalUtils.findMaximum(List.of(10, 25, 8, 42, 15));

        assertEquals(42, result);
    }

    @Test
    void findMaximumShouldReturnNullForEmptyList() {
        List<Integer> emptyList = Collections.emptyList();

        Integer result = MedicalUtils.findMaximum(emptyList);

        assertNull(result);
    }

    @Test
    void findMaximumShouldReturnNullForNullList() {
        List<Integer> numbers = null;

        Integer result = MedicalUtils.findMaximum(numbers);

        assertNull(result);
    }
}