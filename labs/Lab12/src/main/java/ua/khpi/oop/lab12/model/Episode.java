package ua.khpi.oop.lab12.model;

public class Episode {
    private final String title;
    private final int seasonNumber;
    private final int episodeNumber;
    private final int durationMinutes;

    public Episode(String title, int seasonNumber, int episodeNumber, int durationMinutes) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Назва епізоду не може бути порожньою");
        }
        if (seasonNumber <= 0) {
            throw new IllegalArgumentException("Номер сезону має бути додатним");
        }
        if (episodeNumber <= 0) {
            throw new IllegalArgumentException("Номер епізоду має бути додатним");
        }
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Тривалість епізоду має бути додатною");
        }

        this.title = title;
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
        this.durationMinutes = durationMinutes;
    }

    public String getTitle() {
        return title;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public String toString() {
        return "Епізод: " + title + ", сезон: " + seasonNumber + ", серія: " + episodeNumber + ", тривалість: " + durationMinutes + " хв";
    }
}