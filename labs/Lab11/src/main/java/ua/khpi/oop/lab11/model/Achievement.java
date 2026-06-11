package ua.khpi.oop.lab11.model;

import java.util.Objects;

public class Achievement {
    private final String title;
    private final String description;

    public Achievement(String title, String description) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Назва досягнення не може бути порожньою");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Опис досягнення не може бути порожнім");
        }

        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Досягнення: " + title + " — " + description;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Achievement achievement)) {
            return false;
        }
        return Objects.equals(title, achievement.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}