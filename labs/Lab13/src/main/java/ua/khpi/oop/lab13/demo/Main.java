package ua.khpi.oop.lab13.demo;

import ua.khpi.oop.lab13.service.OrderTextProcessor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> lines = readResourceLines("orders.txt");

            OrderTextProcessor processor = new OrderTextProcessor();
            String receipt = processor.buildReceipt(lines);

            System.out.println(receipt);
        } catch (IOException | URISyntaxException exception) {
            System.out.println("Помилка читання файлу: " + exception.getMessage());
        }
    }

    private static List<String> readResourceLines(String fileName)
            throws IOException, URISyntaxException {
        URL resource = Main.class.getClassLoader().getResource(fileName);

        if (resource == null) {
            throw new IOException("Файл не знайдено: " + fileName);
        }

        return Files.readAllLines(Path.of(resource.toURI()));
    }
}