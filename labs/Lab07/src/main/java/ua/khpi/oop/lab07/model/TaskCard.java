package ua.khpi.oop.lab07.model;

import ua.khpi.oop.lab07.contracts.Assignable;
import ua.khpi.oop.lab07.contracts.Commentable;

public class TaskCard implements Assignable, Commentable {
    private final String title;
    private final String description;
    private String assignee;
    private int commentsCount;

    public TaskCard(String title, String description) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Task title cannot be empty");
        }

        this.title = title;
        this.description = description;
        this.assignee = "not assigned";
        this.commentsCount = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String assignTo(String personName) {
        assignee = personName;
        return "Task \"" + title + "\" assigned to " + personName;
    }

    @Override
    public String getAssignee() {
        return assignee;
    }

    @Override
    public String addComment(String comment) {
        commentsCount++;
        return "Comment added to task \"" + title + "\": " + comment;
    }

    @Override
    public int getCommentsCount() {
        return commentsCount;
    }

    public String getInfo() {
        return "Task: " + title + ", assignee: " + assignee + ", comments: " + commentsCount;
    }
}