package ua.khpi.oop.lab07.model;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab07.contracts.Commentable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReviewNoteTest {

    @Test
    void reviewNoteShouldStoreFields() {
        ReviewNote note = new ReviewNote("Артем", "Код потребує невеликих виправлень");

        assertEquals("Артем", note.getAuthor());
        assertEquals("Код потребує невеликих виправлень", note.getText());
        assertEquals(0, note.getCommentsCount());
    }

    @Test
    void reviewNoteShouldBeCommentable() {
        ReviewNote note = new ReviewNote("Артем", "Код потребує невеликих виправлень");

        Commentable commentable = note;

        String result = commentable.addComment("Погоджуюсь із приміткою");

        assertTrue(result.contains("Погоджуюсь із приміткою"));
        assertEquals(1, note.getCommentsCount());
    }
}