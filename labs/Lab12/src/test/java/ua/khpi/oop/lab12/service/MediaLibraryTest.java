package ua.khpi.oop.lab12.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab12.model.Episode;
import ua.khpi.oop.lab12.model.Movie;
import ua.khpi.oop.lab12.model.Podcast;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MediaLibraryTest {
    private MediaLibrary library;

    @BeforeEach
    void setUp() {
        List<Movie> movies = List.of(
                new Movie("Інтерстеллар", "Фантастика", 2014, 8.7, 169),
                new Movie("Початок", "Фантастика", 2010, 8.8, 148),
                new Movie("Темний лицар", "Бойовик", 2008, 9.0, 152),
                new Movie("Форрест Гамп", "Драма", 1994, 8.8, 142),
                new Movie("Матриця", "Фантастика", 1999, 8.7, 136)
        );

        List<Episode> javaEpisodes = List.of(
                new Episode("Що таке Stream API", 1, 1, 35),
                new Episode("Колекції в Java", 1, 2, 28)
        );

        List<Episode> cinemaEpisodes = List.of(
                new Episode("Фантастика в кіно", 1, 1, 39),
                new Episode("Найкращі фільми 2000-х", 1, 2, 42)
        );

        List<Podcast> podcasts = List.of(
                new Podcast("Java для початківців", "Артем", "Програмування", javaEpisodes),
                new Podcast("Світ кіно", "Олена", "Кіно", cinemaEpisodes)
        );

        library = new MediaLibrary(movies, podcasts);
    }

    @Test
    void shouldFindMoviesByGenre() {
        List<Movie> result = library.getMoviesByGenre("Фантастика");

        assertEquals(3, result.size());
        assertEquals("Інтерстеллар", result.get(0).getTitle());
        assertEquals("Початок", result.get(1).getTitle());
        assertEquals("Матриця", result.get(2).getTitle());
    }

    @Test
    void shouldSortMovieTitlesByRating() {
        List<String> titles = library.getMovieTitlesSortedByRating();

        assertEquals(5, titles.size());
        assertEquals("Темний лицар", titles.get(0));
        assertTrue(titles.contains("Початок"));
        assertTrue(titles.contains("Форрест Гамп"));
    }

    @Test
    void shouldCountAndGroupMoviesByGenre() {
        assertEquals(1, library.countMoviesByGenre("Драма"));

        Map<String, List<Movie>> grouped = library.groupMoviesByGenre();

        assertEquals(3, grouped.get("Фантастика").size());
        assertEquals(1, grouped.get("Бойовик").size());
        assertEquals(1, grouped.get("Драма").size());
    }

    @Test
    void shouldCalculateAverageRatingAndFindLongestMovie() {
        assertEquals(8.8, library.getAverageMovieRating(), 0.001);

        Optional<Movie> longest = library.getLongestMovie();

        assertTrue(longest.isPresent());
        assertEquals("Інтерстеллар", longest.get().getTitle());
    }

    @Test
    void shouldGetAllEpisodeTitles() {
        List<String> titles = library.getAllEpisodeTitles();

        assertEquals(4, titles.size());
        assertTrue(titles.contains("Що таке Stream API"));
        assertTrue(titles.contains("Колекції в Java"));
        assertTrue(titles.contains("Фантастика в кіно"));
        assertTrue(titles.contains("Найкращі фільми 2000-х"));
    }

    @Test
    void shouldBuildMovieReport() {
        String report = library.buildMovieReport();

        assertTrue(report.contains("Темний лицар — 9.0"));
        assertTrue(report.contains("Початок — 8.8"));
        assertTrue(report.contains("Матриця — 8.7"));
    }

    @Test
    void imperativeAndStreamResultsShouldBeEqual() {
        List<Movie> imperative = library.getMoviesByGenreImperative("Фантастика");
        List<Movie> stream = library.getMoviesByGenre("Фантастика");

        assertEquals(imperative.size(), stream.size());
        assertEquals(imperative, stream);
    }
}