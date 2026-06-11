package ua.khpi.oop.lab08.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BugReportTest {

    @Test
    void bugReportShouldStoreData() {
        BugReport bug = new BugReport(
                "BUG-101",
                "Висока",
                "Іван Петренко",
                1
        );

        assertEquals("BUG-101", bug.getId());
        assertEquals("Висока", bug.getSeverity());
        assertEquals("Іван Петренко", bug.getAssignee());
        assertEquals(1, bug.getCommentsCount());
    }

    @Test
    void bugReportShouldConvertToTextLine() {
        BugReport bug = new BugReport(
                "BUG-101",
                "Висока",
                "Іван Петренко",
                1
        );

        assertEquals(
                "BUG;BUG-101;Висока;Іван Петренко;1",
                bug.toTextLine()
        );
    }

    @Test
    void bugReportShouldRejectWrongData() {
        assertThrows(IllegalArgumentException.class, () ->
                new BugReport("", "Висока", "Артем", 1)
        );

        assertThrows(IllegalArgumentException.class, () ->
                new BugReport("BUG-101", "Висока", "Артем", -1)
        );
    }
}