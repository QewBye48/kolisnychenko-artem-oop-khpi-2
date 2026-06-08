package ua.khpi.oop.lab14.model;

public class Movie {
    private final String title;
    private final String genre;
    private final double rating;
    private final int durationMinutes;

    public Movie(String title, String genre, double rating, int durationMinutes) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Назва фільму не може бути порожньою");
        }
        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("Жанр фільму не може бути порожнім");
        }
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Рейтинг має бути від 0 до 10");
        }
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Тривалість має бути додатною");
        }

        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.durationMinutes = durationMinutes;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public String toString() {
        return "Фільм: " + title + ", жанр: " + genre + ", рейтинг: " + rating + ", тривалість: " + durationMinutes + " хв";
    }
}