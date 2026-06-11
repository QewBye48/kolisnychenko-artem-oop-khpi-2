package ua.khpi.oop.lab08.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReviewNoteTest {

    @Test
    void reviewNoteShouldStoreData() {
        ReviewNote note = new ReviewNote(
                "NOTE-1",
                "Артем",
                "Код потребує невеликих виправлень",
                3
        );

        assertEquals("NOTE-1", note.getId());
        assertEquals("Артем", note.getAuthor());
        assertEquals("Код потребує невеликих виправлень", note.getText());
        assertEquals(3, note.getCommentsCount());
    }

    @Test
    void reviewNoteShouldConvertToTextLine() {
        ReviewNote note = new ReviewNote(
                "NOTE-1",
                "Артем",
                "Код потребує невеликих виправлень",
                3
        );

        assertEquals(
                "REVIEW;NOTE-1;Артем;Код потребує невеликих виправлень;3",
                note.toTextLine()
        );
    }

    @Test
    void reviewNoteShouldRejectWrongData() {
        assertThrows(IllegalArgumentException.class, () ->
                new ReviewNote("", "Артем", "Текст", 1)
        );

        assertThrows(IllegalArgumentException.class, () ->
                new ReviewNote("NOTE-1", "Артем", "", 1)
        );

        assertThrows(IllegalArgumentException.class, () ->
                new ReviewNote("NOTE-1", "Артем", "Текст", -1)
        );
    }
}