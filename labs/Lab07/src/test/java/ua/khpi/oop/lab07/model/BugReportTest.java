package ua.khpi.oop.lab07.model;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab07.contracts.Assignable;
import ua.khpi.oop.lab07.contracts.Commentable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BugReportTest {

    @Test
    void bugReportShouldStoreFields() {
        BugReport bug = new BugReport("BUG-101", "Висока");

        assertEquals("BUG-101", bug.getBugId());
        assertEquals("Висока", bug.getSeverity());
        assertEquals("not assigned", bug.getAssignee());
        assertEquals(0, bug.getCommentsCount());
    }

    @Test
    void bugReportShouldBeAssignableAndCommentable() {
        BugReport bug = new BugReport("BUG-101", "Висока");

        Assignable assignable = bug;
        Commentable commentable = bug;

        assertTrue(assignable.assignTo("Артем").contains("Артем"));
        assertTrue(commentable.addComment("Потрібно виправити").contains("Потрібно виправити"));

        assertEquals("Артем", bug.getAssignee());
        assertEquals(1, bug.getCommentsCount());
    }
}