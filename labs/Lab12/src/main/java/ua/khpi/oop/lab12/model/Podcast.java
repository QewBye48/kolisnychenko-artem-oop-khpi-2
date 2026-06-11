package ua.khpi.oop.lab12.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Podcast {
    private final String title;
    private final String host;
    private final String topic;
    private final List<Episode> episodes;

    public Podcast(String title, String host, String topic, List<Episode> episodes) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Назва подкасту не може бути порожньою");
        }
        if (host == null || host.isBlank()) {
            throw new IllegalArgumentException("Ведучий подкасту не може бути порожнім");
        }
        if (topic == null || topic.isBlank()) {
            throw new IllegalArgumentException("Тема подкасту не може бути порожньою");
        }
        if (episodes == null) {
            throw new IllegalArgumentException("Список епізодів не може бути null");
        }

        this.title = title;
        this.host = host;
        this.topic = topic;
        this.episodes = new ArrayList<>(episodes);
    }

    public String getTitle() {
        return title;
    }

    public String getHost() {
        return host;
    }

    public String getTopic() {
        return topic;
    }

    public List<Episode> getEpisodes() {
        return Collections.unmodifiableList(episodes);
    }

    public int getEpisodeCount() {
        return episodes.size();
    }

    @Override
    public String toString() {
        return "Подкаст: " + title + ", ведучий: " + host + ", тема: " + topic + ", епізодів: " + episodes.size();
    }
}