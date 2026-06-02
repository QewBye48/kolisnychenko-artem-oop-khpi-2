package ua.khpi.oop.lab07.model;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab07.contracts.Assignable;
import ua.khpi.oop.lab07.contracts.Commentable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskCardTest {

    @Test
    void taskCardShouldStoreFields() {
        TaskCard task = new TaskCard("Створити сторінку входу", "Додати форму авторизації");

        assertEquals("Створити сторінку входу", task.getTitle());
        assertEquals("Додати форму авторизації", task.getDescription());
        assertEquals("not assigned", task.getAssignee());
        assertEquals(0, task.getCommentsCount());
    }

    @Test
    void taskCardShouldBeAssignableAndCommentable() {
        TaskCard task = new TaskCard("Створити сторінку входу", "Додати форму авторизації");

        Assignable assignable = task;
        Commentable commentable = task;

        assertTrue(assignable.assignTo("Артем").contains("Артем"));
        assertTrue(commentable.addComment("Добре").contains("Добре"));

        assertEquals("Артем", task.getAssignee());
        assertEquals(1, task.getCommentsCount());
    }
}