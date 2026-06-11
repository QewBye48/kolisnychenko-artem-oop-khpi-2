package ua.khpi.oop.lab07.contracts;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab07.model.BugReport;
import ua.khpi.oop.lab07.model.ReviewNote;
import ua.khpi.oop.lab07.model.TaskCard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommentableContractTest {

    @Test
    void shouldCommentDifferentObjectsThroughInterface() {
        Commentable[] items = {
                new TaskCard("Створити сторінку входу", "Додати форму авторизації"),
                new BugReport("BUG-101", "Висока"),
                new ReviewNote("Артем", "Код потребує невеликих виправлень")
        };

        for (Commentable item : items) {
            String result = item.addComment("Перевірено");

            assertTrue(result.contains("Перевірено"));
            assertEquals(1, item.getCommentsCount());
        }
    }
}