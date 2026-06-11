package ua.khpi.oop.lab11.service;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab11.model.Achievement;
import ua.khpi.oop.lab11.model.GameItem;
import ua.khpi.oop.lab11.model.Player;

import static org.junit.jupiter.api.Assertions.*;

class GameProfileServiceTest {

    @Test
    void serviceShouldAddAndFindItem() {
        Player player = new Player("Artem", 15);
        GameProfileService service = new GameProfileService(player);

        GameItem sword = new GameItem("Сталевий меч", "Зброя", 25);
        GameItem armor = new GameItem("Залізна броня", "Броня", 18);

        service.addItem(sword);
        service.addItem(armor);

        assertEquals(2, service.getItemCount());
        assertEquals(sword, service.findItemByName("Сталевий меч"));
        assertEquals(armor, service.findItemByName("Залізна броня"));
        assertNull(service.findItemByName("Невідомий предмет"));
    }

    @Test
    void serviceShouldRemoveItem() {
        Player player = new Player("Artem", 15);
        GameProfileService service = new GameProfileService(player);

        GameItem sword = new GameItem("Сталевий меч", "Зброя", 25);
        GameItem potion = new GameItem("Зілля лікування", "Витратний предмет", 10);

        service.addItem(sword);
        service.addItem(potion);

        boolean removed = service.removeItemByName("Зілля лікування");

        assertTrue(removed);
        assertEquals(1, service.getItemCount());
        assertNull(service.findItemByName("Зілля лікування"));
        assertEquals(sword, service.findItemByName("Сталевий меч"));
    }

    @Test
    void serviceShouldStoreUniqueAchievements() {
        Player player = new Player("Artem", 15);
        GameProfileService service = new GameProfileService(player);

        Achievement first = new Achievement(
                "Перший бій",
                "Гравець переміг першого ворога"
        );

        Achievement duplicate = new Achievement(
                "Перший бій",
                "Дублікат такого самого досягнення"
        );

        boolean addedFirst = service.addAchievement(first);
        boolean addedDuplicate = service.addAchievement(duplicate);

        assertTrue(addedFirst);
        assertFalse(addedDuplicate);
        assertEquals(1, service.getAchievementCount());
        assertTrue(service.hasAchievement("Перший бій"));
    }

    @Test
    void serviceShouldShowProfileText() {
        Player player = new Player("Artem", 15);
        GameProfileService service = new GameProfileService(player);

        service.addItem(new GameItem("Сталевий меч", "Зброя", 25));
        service.addAchievement(new Achievement(
                "Перший бій",
                "Гравець переміг першого ворога"
        ));

        String text = service.showProfile();

        assertTrue(text.contains("Artem"));
        assertTrue(text.contains("Сталевий меч"));
        assertTrue(text.contains("Перший бій"));
    }
}