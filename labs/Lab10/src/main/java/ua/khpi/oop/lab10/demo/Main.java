package ua.khpi.oop.lab10.demo;

import ua.khpi.oop.lab10.container.InventoryContainer;
import ua.khpi.oop.lab10.model.Item;
import ua.khpi.oop.lab10.model.Player;
import ua.khpi.oop.lab10.model.EquipmentSlot;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Artem", 15);

        Item sword = new Item("Сталевий меч", EquipmentSlot.WEAPON, 25);
        Item armor = new Item("Залізна броня", EquipmentSlot.ARMOR, 18);
        Item ring = new Item("Кільце сили", EquipmentSlot.RING, 7);
        Item potion = new Item("Зілля лікування", EquipmentSlot.POTION, 10);

        InventoryContainer<Item> inventory = new InventoryContainer<>(3);

        System.out.println("ІНВЕНТАР");
        System.out.println(player);

        System.out.println("\nДодавання предметів:");
        inventory.add(sword);
        inventory.add(armor);
        inventory.add(ring);
        inventory.add(potion);

        System.out.println("Кількість предметів: " + inventory.size());
        System.out.println("Місткість контейнера: " + inventory.capacity());

        System.out.println("\nОтримання предмета за індексом:");
        System.out.println(inventory.get(0));

        System.out.println("\nОбхід через звичайний Iterator:");
        Iterator<Item> iterator = inventory.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nОбхід через for-each:");
        for (Item item : inventory) {
            System.out.println(item);
        }

        System.out.println("\nВидалення предмета з індексом 1:");
        Item removed = inventory.remove(1);
        System.out.println("Видалено: " + removed);

        System.out.println("\nІнвентар після видалення:");
        for (Item item : inventory) {
            System.out.println(item);
        }

        System.out.println("\nДемонстрація generic-контейнера з іншим типом");
        InventoryContainer<String> notes = new InventoryContainer<>();

        notes.add("Ключ від підземелля");
        notes.add("Карта локації");
        notes.add("Записка NPC");

        for (String note : notes) {
            System.out.println(note);
        }
    }
}