package ua.khpi.oop.lab08.persistence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import ua.khpi.oop.lab08.exception.InvalidWorkspaceDataException;
import ua.khpi.oop.lab08.model.BugReport;
import ua.khpi.oop.lab08.model.ReviewNote;
import ua.khpi.oop.lab08.model.TaskCard;
import ua.khpi.oop.lab08.service.ProjectWorkspace;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WorkspaceFileManagerTest {

    @TempDir
    Path tempDir;

    @Test
    void fileManagerShouldSaveAndLoadTextFile()
            throws IOException, InvalidWorkspaceDataException {

        ProjectWorkspace workspace = createWorkspace();
        WorkspaceFileManager manager = new WorkspaceFileManager();

        Path path = tempDir.resolve("workspace.txt");

        manager.saveAsText(workspace, path);
        ProjectWorkspace loaded = manager.loadFromText(path);

        assertTrue(Files.exists(path));
        assertEquals(3, loaded.getTotalCount());
        assertEquals("TASK-1", loaded.getTasks().get(0).getId());
        assertEquals("BUG-101", loaded.getBugs().get(0).getId());
        assertEquals("NOTE-1", loaded.getNotes().get(0).getId());
    }

    @Test
    void fileManagerShouldSerializeAndDeserialize()
            throws IOException, ClassNotFoundException, InvalidWorkspaceDataException {

        ProjectWorkspace workspace = createWorkspace();
        WorkspaceFileManager manager = new WorkspaceFileManager();

        Path path = tempDir.resolve("workspace.bin");

        manager.serialize(workspace, path);
        ProjectWorkspace loaded = manager.deserialize(path);

        assertTrue(Files.exists(path));
        assertEquals(3, loaded.getTotalCount());
        assertEquals("TASK-1", loaded.getTasks().get(0).getId());
    }

    @Test
    void fileManagerShouldThrowExceptionForBrokenTextFile() throws IOException {
        WorkspaceFileManager manager = new WorkspaceFileManager();

        Path path = tempDir.resolve("broken-workspace.txt");

        Files.writeString(
                path,
                "TASK;ONLY_TWO_FIELDS\n",
                StandardCharsets.UTF_8
        );

        assertThrows(InvalidWorkspaceDataException.class, () ->
                manager.loadFromText(path)
        );
    }

    private ProjectWorkspace createWorkspace() throws InvalidWorkspaceDataException {
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

        return workspace;
    }
}