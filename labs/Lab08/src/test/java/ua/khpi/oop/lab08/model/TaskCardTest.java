package ua.khpi.oop.lab08.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaskCardTest {

    @Test
    void taskCardShouldStoreData() {
        TaskCard task = new TaskCard(
                "TASK-1",
                "Створити сторінку входу",
                "Колісниченко Артем",
                2
        );

        assertEquals("TASK-1", task.getId());
        assertEquals("Створити сторінку входу", task.getTitle());
        assertEquals("Колісниченко Артем", task.getAssignee());
        assertEquals(2, task.getCommentsCount());
    }

    @Test
    void taskCardShouldConvertToTextLine() {
        TaskCard task = new TaskCard(
                "TASK-1",
                "Створити сторінку входу",
                "Колісниченко Артем",
                2
        );

        assertEquals(
                "TASK;TASK-1;Створити сторінку входу;Колісниченко Артем;2",
                task.toTextLine()
        );
    }

    @Test
    void taskCardShouldRejectWrongData() {
        assertThrows(IllegalArgumentException.class, () ->
                new TaskCard("", "Назва", "Артем", 1)
        );

        assertThrows(IllegalArgumentException.class, () ->
                new TaskCard("TASK-1", "Назва", "Артем", -1)
        );
    }
}