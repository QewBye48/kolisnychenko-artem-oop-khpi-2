package ua.khpi.oop.lab08.model;

import java.io.Serializable;

public class TaskCard implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private final String title;
    private final String assignee;
    private final int commentsCount;

    public TaskCard(String id, String title, String assignee, int commentsCount) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Task id cannot be empty");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Task title cannot be empty");
        }
        if (assignee == null || assignee.isBlank()) {
            throw new IllegalArgumentException("Task assignee cannot be empty");
        }
        if (commentsCount < 0) {
            throw new IllegalArgumentException("Comments count cannot be negative");
        }

        this.id = id;
        this.title = title;
        this.assignee = assignee;
        this.commentsCount = commentsCount;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAssignee() {
        return assignee;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public String toTextLine() {
        return "TASK;" + id + ";" + title + ";" + assignee + ";" + commentsCount;
    }

    public static TaskCard fromTextParts(String[] parts) {
        return new TaskCard(
                parts[1],
                parts[2],
                parts[3],
                Integer.parseInt(parts[4])
        );
    }

    @Override
    public String toString() {
        return "Завдання: " + id +
                ", назва: " + title +
                ", виконавець: " + assignee +
                ", коментарів: " + commentsCount;
    }
}