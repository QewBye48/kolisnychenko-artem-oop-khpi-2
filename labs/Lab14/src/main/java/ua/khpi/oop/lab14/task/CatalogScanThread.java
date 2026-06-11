package ua.khpi.oop.lab14.task;

import ua.khpi.oop.lab14.model.MediaCatalog;
import ua.khpi.oop.lab14.service.MediaService;

public class CatalogScanThread extends Thread {
    private final MediaCatalog catalog;
    private final MediaService service;
    private String result;

    public CatalogScanThread(MediaCatalog catalog, MediaService service) {
        this.catalog = catalog;
        this.service = service;
        setName("CatalogScanThread");
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + ": початок сканування каталогу");

            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + ": крок сканування " + i);
                Thread.sleep(200);
            }

            result = service.scanCatalog(catalog);
            System.out.println(Thread.currentThread().getName() + ": сканування завершено");
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + ": потік перервано");
        }
    }

    public String getResult() {
        return result;
    }
}