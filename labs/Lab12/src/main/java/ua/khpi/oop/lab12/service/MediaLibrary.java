package ua.khpi.oop.lab12.service;

import ua.khpi.oop.lab12.model.Episode;
import ua.khpi.oop.lab12.model.Movie;
import ua.khpi.oop.lab12.model.Podcast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MediaLibrary {
    private final List<Movie> movies;
    private final List<Podcast> podcasts;

    public MediaLibrary(List<Movie> movies, List<Podcast> podcasts) {
        if (movies == null) {
            throw new IllegalArgumentException("Список фільмів не може бути null");
        }
        if (podcasts == null) {
            throw new IllegalArgumentException("Список подкастів не може бути null");
        }

        this.movies = new ArrayList<>(movies);
        this.podcasts = new ArrayList<>(podcasts);
    }

    public List<Movie> getAllMovies() {
        return Collections.unmodifiableList(movies);
    }

    public List<Podcast> getAllPodcasts() {
        return Collections.unmodifiableList(podcasts);
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return movies.stream()
                .filter(movie -> movie.getGenre().equalsIgnoreCase(genre))
                .toList();
    }

    public List<String> getMovieTitlesSortedByRating() {
        return movies.stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .map(Movie::getTitle)
                .toList();
    }

    public List<Movie> getTopMovies(int limit) {
        return movies.stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .limit(limit)
                .toList();
    }

    public long countMoviesByGenre(String genre) {
        return movies.stream()
                .filter(movie -> movie.getGenre().equalsIgnoreCase(genre))
                .count();
    }

    public Map<String, List<Movie>> groupMoviesByGenre() {
        return movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));
    }

    public Map<String, Long> countMoviesByGenreMap() {
        return movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));
    }

    public double getAverageMovieRating() {
        return movies.stream()
                .mapToDouble(Movie::getRating)
                .average()
                .orElse(0.0);
    }

    public Optional<Movie> getLongestMovie() {
        return movies.stream()
                .max(Comparator.comparingInt(Movie::getDurationMinutes));
    }

    public DoubleSummaryStatistics getMovieRatingStatistics() {
        return movies.stream()
                .collect(Collectors.summarizingDouble(Movie::getRating));
    }

    public List<String> getPodcastTitles() {
        return podcasts.stream()
                .map(Podcast::getTitle)
                .toList();
    }

    public List<String> getAllEpisodeTitles() {
        return podcasts.stream()
                .flatMap(podcast -> podcast.getEpisodes().stream())
                .map(Episode::getTitle)
                .toList();
    }

    public Map<String, Long> countEpisodesByPodcast() {
        return podcasts.stream()
                .collect(Collectors.toMap(
                        Podcast::getTitle,
                        podcast -> (long) podcast.getEpisodeCount()
                ));
    }

    public String buildMovieReport() {
        return movies.stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .map(movie -> movie.getTitle() + " — " + movie.getRating())
                .collect(Collectors.joining("\n"));
    }

    public List<Movie> getMoviesByGenreImperative(String genre) {
        List<Movie> result = new ArrayList<>();

        for (Movie movie : movies) {
            if (movie.getGenre().equalsIgnoreCase(genre)) {
                result.add(movie);
            }
        }

        return result;
    }
}