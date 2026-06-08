package ua.khpi.oop.lab14.task;

import ua.khpi.oop.lab14.model.MediaCatalog;
import ua.khpi.oop.lab14.model.Movie;
import ua.khpi.oop.lab14.service.MediaService;

import java.util.ArrayList;
import java.util.List;

public class SortTask implements Runnable {
    private final MediaCatalog catalog;
    private final MediaService service;
    private List<Movie> sortedMovies;

    public SortTask(MediaCatalog catalog, MediaService service) {
        this.catalog = catalog;
        this.service = service;
        this.sortedMovies = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + ": початок сортування фільмів");
            Thread.sleep(250);

            sortedMovies = service.sortMoviesByRating(catalog);

            System.out.println(Thread.currentThread().getName() + ": сортування завершено");
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + ": потік перервано");
        }
    }

    public List<Movie> getSortedMovies() {
        return sortedMovies;
    }
}