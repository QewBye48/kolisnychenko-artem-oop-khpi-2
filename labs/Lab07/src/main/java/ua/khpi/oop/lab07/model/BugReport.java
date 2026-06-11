package ua.khpi.oop.lab07.model;

import ua.khpi.oop.lab07.contracts.Assignable;
import ua.khpi.oop.lab07.contracts.Commentable;

public class BugReport implements Assignable, Commentable {
    private final String bugId;
    private final String severity;
    private String assignee;
    private int commentsCount;

    public BugReport(String bugId, String severity) {
        if (bugId == null || bugId.isBlank()) {
            throw new IllegalArgumentException("Bug id cannot be empty");
        }

        this.bugId = bugId;
        this.severity = severity;
        this.assignee = "not assigned";
        this.commentsCount = 0;
    }

    public String getBugId() {
        return bugId;
    }

    public String getSeverity() {
        return severity;
    }

    @Override
    public String assignTo(String personName) {
        assignee = personName;
        return "Bug " + bugId + " assigned to " + personName;
    }

    @Override
    public String getAssignee() {
        return assignee;
    }

    @Override
    public String addComment(String comment) {
        commentsCount++;
        return "Comment added to bug " + bugId + ": " + comment;
    }

    @Override
    public int getCommentsCount() {
        return commentsCount;
    }

    public String getInfo() {
        return "Bug: " + bugId + ", severity: " + severity + ", assignee: " + assignee + ", comments: " + commentsCount;
    }
}