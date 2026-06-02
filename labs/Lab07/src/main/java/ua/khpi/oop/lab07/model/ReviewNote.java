package ua.khpi.oop.lab07.model;

import ua.khpi.oop.lab07.contracts.Commentable;

public class ReviewNote implements Commentable {
    private final String author;
    private final String text;
    private int commentsCount;

    public ReviewNote(String author, String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Review text cannot be empty");
        }

        this.author = author;
        this.text = text;
        this.commentsCount = 0;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    @Override
    public String addComment(String comment) {
        commentsCount++;
        return "Comment added to review note by " + author + ": " + comment;
    }

    @Override
    public int getCommentsCount() {
        return commentsCount;
    }

    public String getInfo() {
        return "Review note by " + author + ", comments: " + commentsCount;
    }
}