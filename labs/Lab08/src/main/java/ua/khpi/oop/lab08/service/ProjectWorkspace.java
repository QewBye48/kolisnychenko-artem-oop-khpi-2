package ua.khpi.oop.lab08.service;

import ua.khpi.oop.lab08.exception.InvalidWorkspaceDataException;
import ua.khpi.oop.lab08.model.BugReport;
import ua.khpi.oop.lab08.model.ReviewNote;
import ua.khpi.oop.lab08.model.TaskCard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectWorkspace implements Serializable {
    private static final long serialVersionUID = 1L;

    private final List<TaskCard> tasks = new ArrayList<>();
    private final List<BugReport> bugs = new ArrayList<>();
    private final List<ReviewNote> notes = new ArrayList<>();

    public void addTask(TaskCard task) throws InvalidWorkspaceDataException {
        if (findTaskById(task.getId()).isPresent()) {
            throw new InvalidWorkspaceDataException("Task with id " + task.getId() + " already exists");
        }
        tasks.add(task);
    }

    public void addBug(BugReport bug) throws InvalidWorkspaceDataException {
        if (findBugById(bug.getId()).isPresent()) {
            throw new InvalidWorkspaceDataException("Bug with id " + bug.getId() + " already exists");
        }
        bugs.add(bug);
    }

    public void addReviewNote(ReviewNote note) throws InvalidWorkspaceDataException {
        if (findReviewNoteById(note.getId()).isPresent()) {
            throw new InvalidWorkspaceDataException("Review note with id " + note.getId() + " already exists");
        }
        notes.add(note);
    }

    public Optional<TaskCard> findTaskById(String id) {
        return tasks.stream()
                .filter(task -> task.getId().equalsIgnoreCase(id))
                .findFirst();
    }

    public Optional<BugReport> findBugById(String id) {
        return bugs.stream()
                .filter(bug -> bug.getId().equalsIgnoreCase(id))
                .findFirst();
    }

    public Optional<ReviewNote> findReviewNoteById(String id) {
        return notes.stream()
                .filter(note -> note.getId().equalsIgnoreCase(id))
                .findFirst();
    }

    public List<TaskCard> getTasks() {
        return List.copyOf(tasks);
    }

    public List<BugReport> getBugs() {
        return List.copyOf(bugs);
    }

    public List<ReviewNote> getNotes() {
        return List.copyOf(notes);
    }

    public int getTotalCount() {
        return tasks.size() + bugs.size() + notes.size();
    }

    public String showAll() {
        StringBuilder builder = new StringBuilder();

        builder.append("Завдання\n");
        for (TaskCard task : tasks) {
            builder.append(task).append("\n");
        }

        builder.append("Помилки\n");
        for (BugReport bug : bugs) {
            builder.append(bug).append("\n");
        }

        builder.append("Примітки рев'ю\n");
        for (ReviewNote note : notes) {
            builder.append(note).append("\n");
        }

        return builder.toString();
    }
}