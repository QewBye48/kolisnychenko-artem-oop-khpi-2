package ua.khpi.oop.lab07.contracts;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab07.model.BugReport;
import ua.khpi.oop.lab07.model.TaskCard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AssignableContractTest {

    @Test
    void shouldAssignDifferentObjectsThroughInterface() {
        Assignable[] items = {
                new TaskCard("Створити сторінку входу", "Додати форму авторизації"),
                new BugReport("BUG-101", "Висока")
        };

        for (Assignable item : items) {
            String result = item.assignTo("Колісниченко Артем");

            assertTrue(result.contains("Колісниченко Артем"));
            assertEquals("Колісниченко Артем", item.getAssignee());
        }
    }
}