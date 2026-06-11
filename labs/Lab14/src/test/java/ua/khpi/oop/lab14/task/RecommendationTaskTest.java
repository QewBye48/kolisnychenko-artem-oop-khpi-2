package ua.khpi.oop.lab14.task;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab14.model.MediaCatalog;
import ua.khpi.oop.lab14.model.Movie;
import ua.khpi.oop.lab14.model.Podcast;
import ua.khpi.oop.lab14.service.MediaService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RecommendationTaskTest {

    @Test
    void recommendationTaskShouldGenerateRecommendations() {
        List<Movie> movies = List.of(
                new Movie("Інтерстеллар", "Фантастика", 8.7, 169),
                new Movie("Темний лицар", "Бойовик", 9.0, 152),
                new Movie("Матриця", "Фантастика", 8.7, 136),
                new Movie("Джокер", "Драма", 8.4, 122)
        );

        List<Podcast> podcasts = List.of(
                new Podcast("Світ кіно", "Олена", 8)
        );

        MediaCatalog catalog = new MediaCatalog(movies, podcasts);
        MediaService service = new MediaService();

        RecommendationTask task = new RecommendationTask(catalog, service);

        assertDoesNotThrow(task::run);

        List<Movie> recommendations = task.getRecommendations();

        assertEquals(3, recommendations.size());
        assertEquals("Темний лицар", recommendations.get(0).getTitle());
        assertEquals("Інтерстеллар", recommendations.get(1).getTitle());
        assertEquals("Матриця", recommendations.get(2).getTitle());
    }
}