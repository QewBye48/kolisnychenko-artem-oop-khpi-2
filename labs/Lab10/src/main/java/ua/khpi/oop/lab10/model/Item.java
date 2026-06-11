package ua.khpi.oop.lab10.model;

public class Item {
    private final String name;
    private final EquipmentSlot slot;
    private final int power;

    public Item(String name, EquipmentSlot slot, int power) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Назва предмета не може бути порожньою");
        }
        if (slot == null) {
            throw new IllegalArgumentException("Слот предмета не може бути null");
        }
        if (power < 0) {
            throw new IllegalArgumentException("Сила предмета не може бути від'ємною");
        }

        this.name = name;
        this.slot = slot;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public EquipmentSlot getSlot() {
        return slot;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Предмет: " + name + ", слот: " + slot + ", сила: " + power;
    }
}