package ua.khpi.oop.lab11.service;

import ua.khpi.oop.lab11.model.Achievement;
import ua.khpi.oop.lab11.model.GameItem;
import ua.khpi.oop.lab11.model.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GameProfileService {
    private final Player player;
    private final List<GameItem> items;
    private final Set<Achievement> achievements;

    public GameProfileService(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Гравець не може бути null");
        }

        this.player = player;
        this.items = new ArrayList<>();
        this.achievements = new LinkedHashSet<>();
    }

    public Player getPlayer() {
        return player;
    }

    public void addItem(GameItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Предмет не може бути null");
        }

        items.add(item);
    }

    public GameItem findItemByName(String name) {
        for (GameItem item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }

        return null;
    }

    public boolean removeItemByName(String name) {
        Iterator<GameItem> iterator = items.iterator();

        while (iterator.hasNext()) {
            GameItem item = iterator.next();

            if (item.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    public boolean addAchievement(Achievement achievement) {
        if (achievement == null) {
            throw new IllegalArgumentException("Досягнення не може бути null");
        }

        return achievements.add(achievement);
    }

    public boolean hasAchievement(String title) {
        for (Achievement achievement : achievements) {
            if (achievement.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }

        return false;
    }

    public List<GameItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public Set<Achievement> getAchievements() {
        return Collections.unmodifiableSet(achievements);
    }

    public int getItemCount() {
        return items.size();
    }

    public int getAchievementCount() {
        return achievements.size();
    }

    public String showProfile() {
        StringBuilder builder = new StringBuilder();

        builder.append(player).append("\n");

        builder.append("\nПредмети:\n");
        for (GameItem item : items) {
            builder.append("- ").append(item).append("\n");
        }

        builder.append("\nДосягнення:\n");
        for (Achievement achievement : achievements) {
            builder.append("- ").append(achievement).append("\n");
        }

        return builder.toString();
    }
}