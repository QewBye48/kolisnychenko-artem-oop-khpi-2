package ua.khpi.oop.lab12.demo;

import ua.khpi.oop.lab12.model.Episode;
import ua.khpi.oop.lab12.model.Movie;
import ua.khpi.oop.lab12.model.Podcast;
import ua.khpi.oop.lab12.service.MediaLibrary;

import java.util.List;

public class Main {
    public static void main(String[] args) {
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

        MediaLibrary library = new MediaLibrary(movies, podcasts);

        System.out.println("Stream API Media Library Demo");
        System.out.println("Усього фільмів: " + library.getAllMovies().size());

        System.out.println("\nФільми жанру Фантастика");
        library.getMoviesByGenre("Фантастика").forEach(System.out::println);

        System.out.println("\nНазви фільмів за рейтингом");
        library.getMovieTitlesSortedByRating()
                .forEach(title -> System.out.println("- " + title));

        System.out.println("\nКількість фільмів жанру Драма");
        System.out.println(library.countMoviesByGenre("Драма"));

        System.out.println("\nГрупування фільмів за жанром");
        library.groupMoviesByGenre()
                .forEach((genre, list) -> System.out.println(genre + ": " + list.size()));

        System.out.println("\nСередній рейтинг фільмів");
        System.out.println(library.getAverageMovieRating());

        System.out.println("\nНайдовший фільм");
        library.getLongestMovie().ifPresent(System.out::println);

        System.out.println("\nУсі епізоди подкастів");
        library.getAllEpisodeTitles()
                .forEach(title -> System.out.println("- " + title));

        System.out.println("\nТекстовий звіт за фільмами");
        System.out.println(library.buildMovieReport());

        System.out.println("\nПорівняння циклу та Stream API");
        System.out.println("Через цикл: " + library.getMoviesByGenreImperative("Фантастика").size());
        System.out.println("Через Stream API: " + library.getMoviesByGenre("Фантастика").size());
    }
}