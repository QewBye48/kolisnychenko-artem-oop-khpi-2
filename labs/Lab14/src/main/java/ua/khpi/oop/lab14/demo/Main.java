package ua.khpi.oop.lab14.demo;

import ua.khpi.oop.lab14.model.MediaCatalog;
import ua.khpi.oop.lab14.model.Movie;
import ua.khpi.oop.lab14.model.Podcast;
import ua.khpi.oop.lab14.service.MediaService;
import ua.khpi.oop.lab14.task.CatalogScanThread;
import ua.khpi.oop.lab14.task.RecommendationTask;
import ua.khpi.oop.lab14.task.SortTask;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = List.of(
                new Movie("Інтерстеллар", "Фантастика", 8.7, 169),
                new Movie("Темний лицар", "Бойовик", 9.0, 152),
                new Movie("Матриця", "Фантастика", 8.7, 136),
                new Movie("Джокер", "Драма", 8.4, 122),
                new Movie("Початок", "Фантастика", 8.8, 148)
        );

        List<Podcast> podcasts = List.of(
                new Podcast("Java для початківців", "Артем", 12),
                new Podcast("Світ кіно", "Олена", 8)
        );

        MediaCatalog catalog = new MediaCatalog(movies, podcasts);
        MediaService service = new MediaService();

        CatalogScanThread scanThread = new CatalogScanThread(catalog, service);

        SortTask sortTask = new SortTask(catalog, service);
        Thread sortThread = new Thread(sortTask, "SortThread");

        RecommendationTask recommendationTask = new RecommendationTask(catalog, service);
        Thread recommendationThread = new Thread(recommendationTask, "RecommendationThread");

        System.out.println("Запуск потоків медіатеки");

        scanThread.start();
        sortThread.start();
        recommendationThread.start();

        try {
            scanThread.join();
            sortThread.join();
            recommendationThread.join();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.out.println("Головний потік перервано");
        }

        System.out.println();
        System.out.println("Усі потоки завершили роботу");

        System.out.println();
        System.out.println("Результат сканування:");
        System.out.println(scanThread.getResult());

        System.out.println();
        System.out.println("Фільми після сортування за рейтингом:");
        sortTask.getSortedMovies().forEach(System.out::println);

        System.out.println();
        System.out.println("Рекомендовані фільми:");
        recommendationTask.getRecommendations().forEach(System.out::println);

        System.out.println();
        System.out.println("Середній рейтинг фільмів:");
        System.out.println(service.calculateAverageRating(catalog));
    }
}