package ua.khpi.oop.lab08.model;

import java.io.Serializable;

public class ReviewNote implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private final String author;
    private final String text;
    private final int commentsCount;

    public ReviewNote(String id, String author, String text, int commentsCount) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Review note id cannot be empty");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Review note author cannot be empty");
        }
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Review note text cannot be empty");
        }
        if (commentsCount < 0) {
            throw new IllegalArgumentException("Comments count cannot be negative");
        }

        this.id = id;
        this.author = author;
        this.text = text;
        this.commentsCount = commentsCount;
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public String toTextLine() {
        return "REVIEW;" + id + ";" + author + ";" + text + ";" + commentsCount;
    }

    public static ReviewNote fromTextParts(String[] parts) {
        return new ReviewNote(
                parts[1],
                parts[2],
                parts[3],
                Integer.parseInt(parts[4])
        );
    }

    @Override
    public String toString() {
        return "Примітка рев'ю: " + id +
                ", автор: " + author +
                ", текст: " + text +
                ", коментарів: " + commentsCount;
    }
}