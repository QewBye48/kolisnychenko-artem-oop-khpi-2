package ua.khpi.oop.lab14.service;

import ua.khpi.oop.lab14.model.MediaCatalog;
import ua.khpi.oop.lab14.model.Movie;

import java.util.Comparator;
import java.util.List;

public class MediaService {

    public String scanCatalog(MediaCatalog catalog) {
        return "У каталозі знайдено: " +
                catalog.getMovies().size() + " фільмів, " +
                catalog.getPodcasts().size() + " подкастів, усього: " +
                catalog.getTotalItems();
    }

    public List<Movie> sortMoviesByRating(MediaCatalog catalog) {
        return catalog.getMovies()
                .stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .toList();
    }

    public List<Movie> recommendTopMovies(MediaCatalog catalog, int limit) {
        return catalog.getMovies()
                .stream()
                .filter(movie -> movie.getRating() >= 8.5)
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .limit(limit)
                .toList();
    }

    public double calculateAverageRating(MediaCatalog catalog) {
        return catalog.getMovies()
                .stream()
                .mapToDouble(Movie::getRating)
                .average()
                .orElse(0.0);
    }
}