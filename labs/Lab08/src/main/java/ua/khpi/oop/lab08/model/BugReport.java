package ua.khpi.oop.lab08.model;

import java.io.Serializable;

public class BugReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private final String severity;
    private final String assignee;
    private final int commentsCount;

    public BugReport(String id, String severity, String assignee, int commentsCount) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Bug id cannot be empty");
        }
        if (severity == null || severity.isBlank()) {
            throw new IllegalArgumentException("Bug severity cannot be empty");
        }
        if (assignee == null || assignee.isBlank()) {
            throw new IllegalArgumentException("Bug assignee cannot be empty");
        }
        if (commentsCount < 0) {
            throw new IllegalArgumentException("Comments count cannot be negative");
        }

        this.id = id;
        this.severity = severity;
        this.assignee = assignee;
        this.commentsCount = commentsCount;
    }

    public String getId() {
        return id;
    }

    public String getSeverity() {
        return severity;
    }

    public String getAssignee() {
        return assignee;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public String toTextLine() {
        return "BUG;" + id + ";" + severity + ";" + assignee + ";" + commentsCount;
    }

    public static BugReport fromTextParts(String[] parts) {
        return new BugReport(
                parts[1],
                parts[2],
                parts[3],
                Integer.parseInt(parts[4])
        );
    }

    @Override
    public String toString() {
        return "Помилка: " + id +
                ", важливість: " + severity +
                ", виконавець: " + assignee +
                ", коментарів: " + commentsCount;
    }
}