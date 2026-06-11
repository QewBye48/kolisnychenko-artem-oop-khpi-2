package ua.khpi.oop.lab14.model;

public class Podcast {
    private final String title;
    private final String host;
    private final int episodesCount;

    public Podcast(String title, String host, int episodesCount) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Назва подкасту не може бути порожньою");
        }
        if (host == null || host.isBlank()) {
            throw new IllegalArgumentException("Ведучий не може бути порожнім");
        }
        if (episodesCount < 0) {
            throw new IllegalArgumentException("Кількість епізодів не може бути від'ємною");
        }

        this.title = title;
        this.host = host;
        this.episodesCount = episodesCount;
    }

    public String getTitle() {
        return title;
    }

    public String getHost() {
        return host;
    }

    public int getEpisodesCount() {
        return episodesCount;
    }

    @Override
    public String toString() {
        return "Подкаст: " + title + ", ведучий: " + host + ", епізодів: " + episodesCount;
    }
}