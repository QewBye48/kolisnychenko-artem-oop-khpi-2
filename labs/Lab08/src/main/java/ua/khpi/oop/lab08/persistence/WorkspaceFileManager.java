package ua.khpi.oop.lab08.persistence;

import ua.khpi.oop.lab08.exception.InvalidWorkspaceDataException;
import ua.khpi.oop.lab08.model.BugReport;
import ua.khpi.oop.lab08.model.ReviewNote;
import ua.khpi.oop.lab08.model.TaskCard;
import ua.khpi.oop.lab08.service.ProjectWorkspace;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkspaceFileManager {

    public void saveAsText(ProjectWorkspace workspace, Path path) throws IOException {
        ensureParentDirectory(path);

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (TaskCard task : workspace.getTasks()) {
                writer.write(task.toTextLine());
                writer.newLine();
            }

            for (BugReport bug : workspace.getBugs()) {
                writer.write(bug.toTextLine());
                writer.newLine();
            }

            for (ReviewNote note : workspace.getNotes()) {
                writer.write(note.toTextLine());
                writer.newLine();
            }
        }
    }

    public ProjectWorkspace loadFromText(Path path) throws IOException, InvalidWorkspaceDataException {
        ProjectWorkspace workspace = new ProjectWorkspace();

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) {
                    readLine(workspace, line, lineNumber);
                }
                lineNumber++;
            }
        }

        return workspace;
    }

    private void readLine(ProjectWorkspace workspace, String line, int lineNumber)
            throws InvalidWorkspaceDataException {
        String[] parts = line.split(";", -1);

        if (parts.length != 5) {
            throw new InvalidWorkspaceDataException("Invalid field count at line " + lineNumber);
        }

        try {
            switch (parts[0]) {
                case "TASK" -> workspace.addTask(TaskCard.fromTextParts(parts));
                case "BUG" -> workspace.addBug(BugReport.fromTextParts(parts));
                case "REVIEW" -> workspace.addReviewNote(ReviewNote.fromTextParts(parts));
                default -> throw new InvalidWorkspaceDataException("Unknown record type at line " + lineNumber);
            }
        } catch (NumberFormatException exception) {
            throw new InvalidWorkspaceDataException("Invalid number format at line " + lineNumber, exception);
        } catch (IllegalArgumentException exception) {
            throw new InvalidWorkspaceDataException("Invalid data at line " + lineNumber, exception);
        }
    }

    public void serialize(ProjectWorkspace workspace, Path path) throws IOException {
        ensureParentDirectory(path);

        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(Files.newOutputStream(path))) {
            outputStream.writeObject(workspace);
        }
    }

    public ProjectWorkspace deserialize(Path path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream =
                     new ObjectInputStream(Files.newInputStream(path))) {
            return (ProjectWorkspace) inputStream.readObject();
        }
    }

    private void ensureParentDirectory(Path path) throws IOException {
        Path parent = path.getParent();

        if (parent != null) {
            Files.createDirectories(parent);
        }
    }
}