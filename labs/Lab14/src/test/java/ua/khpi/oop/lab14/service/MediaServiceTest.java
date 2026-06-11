package ua.khpi.oop.lab14.service;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab14.model.MediaCatalog;
import ua.khpi.oop.lab14.model.Movie;
import ua.khpi.oop.lab14.model.Podcast;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MediaServiceTest {

    @Test
    void serviceShouldSortMoviesAndCalculateAverageRating() {
        List<Movie> movies = List.of(
                new Movie("Інтерстеллар", "Фантастика", 8.7, 169),
                new Movie("Темний лицар", "Бойовик", 9.0, 152),
                new Movie("Джокер", "Драма", 8.4, 122)
        );

        List<Podcast> podcasts = List.of(
                new Podcast("Java для початківців", "Артем", 12)
        );

        MediaCatalog catalog = new MediaCatalog(movies, podcasts);
        MediaService service = new MediaService();

        List<Movie> sortedMovies = service.sortMoviesByRating(catalog);
        double averageRating = service.calculateAverageRating(catalog);

        assertEquals("Темний лицар", sortedMovies.get(0).getTitle());
        assertEquals("Інтерстеллар", sortedMovies.get(1).getTitle());
        assertEquals("Джокер", sortedMovies.get(2).getTitle());

        assertEquals(8.7, averageRating, 0.001);
    }

    @Test
    void serviceShouldCreateRecommendations() {
        List<Movie> movies = List.of(
                new Movie("Інтерстеллар", "Фантастика", 8.7, 169),
                new Movie("Темний лицар", "Бойовик", 9.0, 152),
                new Movie("Джокер", "Драма", 8.4, 122),
                new Movie("Початок", "Фантастика", 8.8, 148)
        );

        MediaCatalog catalog = new MediaCatalog(movies, List.of());
        MediaService service = new MediaService();

        List<Movie> recommendations = service.recommendTopMovies(catalog, 2);

        assertEquals(2, recommendations.size());
        assertEquals("Темний лицар", recommendations.get(0).getTitle());
        assertEquals("Початок", recommendations.get(1).getTitle());
    }
}