package ua.khpi.oop.lab14.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MediaCatalog {
    private final List<Movie> movies;
    private final List<Podcast> podcasts;

    public MediaCatalog(List<Movie> movies, List<Podcast> podcasts) {
        if (movies == null) {
            throw new IllegalArgumentException("Список фільмів не може бути null");
        }
        if (podcasts == null) {
            throw new IllegalArgumentException("Список подкастів не може бути null");
        }

        this.movies = new ArrayList<>(movies);
        this.podcasts = new ArrayList<>(podcasts);
    }

    public List<Movie> getMovies() {
        return Collections.unmodifiableList(movies);
    }

    public List<Podcast> getPodcasts() {
        return Collections.unmodifiableList(podcasts);
    }

    public int getTotalItems() {
        return movies.size() + podcasts.size();
    }
}