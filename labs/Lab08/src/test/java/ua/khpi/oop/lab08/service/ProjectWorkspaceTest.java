package ua.khpi.oop.lab08.service;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab08.exception.InvalidWorkspaceDataException;
import ua.khpi.oop.lab08.model.BugReport;
import ua.khpi.oop.lab08.model.ReviewNote;
import ua.khpi.oop.lab08.model.TaskCard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProjectWorkspaceTest {

    @Test
    void workspaceShouldAddAndFindItems() throws InvalidWorkspaceDataException {
        ProjectWorkspace workspace = new ProjectWorkspace();

        workspace.addTask(new TaskCard(
                "TASK-1",
                "Створити сторінку входу",
                "Колісниченко Артем",
                2
        ));

        workspace.addBug(new BugReport(
                "BUG-101",
                "Висока",
                "Іван Петренко",
                1
        ));

        workspace.addReviewNote(new ReviewNote(
                "NOTE-1",
                "Артем",
                "Код потребує невеликих виправлень",
                3
        ));

        assertEquals(1, workspace.getTasks().size());
        assertEquals(1, workspace.getBugs().size());
        assertEquals(1, workspace.getNotes().size());
        assertEquals(3, workspace.getTotalCount());

        assertTrue(workspace.findTaskById("TASK-1").isPresent());
        assertTrue(workspace.findBugById("BUG-101").isPresent());
        assertTrue(workspace.findReviewNoteById("NOTE-1").isPresent());
    }

    @Test
    void workspaceShouldRejectDuplicateTask() throws InvalidWorkspaceDataException {
        ProjectWorkspace workspace = new ProjectWorkspace();

        workspace.addTask(new TaskCard(
                "TASK-1",
                "Перше завдання",
                "Артем",
                1
        ));

        assertThrows(InvalidWorkspaceDataException.class, () ->
                workspace.addTask(new TaskCard(
                        "TASK-1",
                        "Друге завдання",
                        "Іван",
                        0
                ))
        );
    }
}