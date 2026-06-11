package ua.khpi.oop.lab14.task;

import ua.khpi.oop.lab14.model.MediaCatalog;
import ua.khpi.oop.lab14.model.Movie;
import ua.khpi.oop.lab14.service.MediaService;

import java.util.ArrayList;
import java.util.List;

public class RecommendationTask implements Runnable {
    private final MediaCatalog catalog;
    private final MediaService service;
    private List<Movie> recommendations;

    public RecommendationTask(MediaCatalog catalog, MediaService service) {
        this.catalog = catalog;
        this.service = service;
        this.recommendations = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + ": початок генерації рекомендацій");
            Thread.sleep(300);

            recommendations = service.recommendTopMovies(catalog, 3);

            System.out.println(Thread.currentThread().getName() + ": рекомендації сформовано");
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + ": потік перервано");
        }
    }

    public List<Movie> getRecommendations() {
        return recommendations;
    }
}