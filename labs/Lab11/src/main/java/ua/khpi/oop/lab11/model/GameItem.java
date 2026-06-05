package ua.khpi.oop.lab11.model;

public class GameItem {
    private final String name;
    private final String type;
    private final int power;

    public GameItem(String name, String type, int power) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Назва предмета не може бути порожньою");
        }
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Тип предмета не може бути порожнім");
        }
        if (power < 0) {
            throw new IllegalArgumentException("Сила предмета не може бути від'ємною");
        }

        this.name = name;
        this.type = type;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Предмет: " + name + ", тип: " + type + ", сила: " + power;
    }
}