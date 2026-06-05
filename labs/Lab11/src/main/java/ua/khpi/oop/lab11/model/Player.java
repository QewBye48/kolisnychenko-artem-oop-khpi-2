package ua.khpi.oop.lab11.model;

public class Player {
    private final String nickname;
    private final int level;

    public Player(String nickname, int level) {
        if (nickname == null || nickname.isBlank()) {
            throw new IllegalArgumentException("Нікнейм гравця не може бути порожнім");
        }
        if (level <= 0) {
            throw new IllegalArgumentException("Рівень гравця має бути додатним");
        }

        this.nickname = nickname;
        this.level = level;
    }

    public String getNickname() {
        return nickname;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Гравець: " + nickname + ", рівень: " + level;
    }
}