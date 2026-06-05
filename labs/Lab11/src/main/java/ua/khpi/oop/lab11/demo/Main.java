package ua.khpi.oop.lab11.demo;

import ua.khpi.oop.lab11.model.Achievement;
import ua.khpi.oop.lab11.model.GameItem;
import ua.khpi.oop.lab11.model.Player;
import ua.khpi.oop.lab11.service.GameProfileService;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Artem", 15);
        GameProfileService service = new GameProfileService(player);

        GameItem sword = new GameItem("Сталевий меч", "Зброя", 25);
        GameItem armor = new GameItem("Залізна броня", "Броня", 18);
        GameItem potion = new GameItem("Зілля лікування", "Витратний предмет", 10);

        service.addItem(sword);
        service.addItem(armor);
        service.addItem(potion);

        service.addAchievement(new Achievement(
                "Перший бій",
                "Гравець переміг першого ворога"
        ));

        service.addAchievement(new Achievement(
                "Колекціонер",
                "Гравець отримав три предмети"
        ));

        service.addAchievement(new Achievement(
                "Перший бій",
                "Дублікат не буде доданий через Set"
        ));

        System.out.println("Ігровий профіль");
        System.out.println(service.showProfile());

        System.out.println("Кількість предметів: " + service.getItemCount());
        System.out.println("Кількість досягнень: " + service.getAchievementCount());

        System.out.println("\nПошук предмета:");
        GameItem foundItem = service.findItemByName("Сталевий меч");
        System.out.println(foundItem != null ? foundItem : "Предмет не знайдено");

        System.out.println("\nВидалення предмета:");
        boolean removed = service.removeItemByName("Зілля лікування");
        System.out.println(removed ? "Предмет видалено" : "Предмет не знайдено");

        System.out.println("\nПредмети після видалення:");
        for (GameItem item : service.getItems()) {
            System.out.println(item);
        }

        System.out.println("\nДосягнення через for-each:");
        for (Achievement achievement : service.getAchievements()) {
            System.out.println(achievement);
        }
    }
}