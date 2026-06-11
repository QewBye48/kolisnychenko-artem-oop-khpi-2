package ua.khpi.oop.lab10.container;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab10.model.EquipmentSlot;
import ua.khpi.oop.lab10.model.Item;

import static org.junit.jupiter.api.Assertions.*;

class InventoryContainerTest {

    @Test
    void containerShouldAddGetAndRemoveItems() {
        InventoryContainer<Item> inventory = new InventoryContainer<>();

        Item sword = new Item("Сталевий меч", EquipmentSlot.WEAPON, 25);
        Item armor = new Item("Залізна броня", EquipmentSlot.ARMOR, 18);

        assertTrue(inventory.isEmpty());

        inventory.add(sword);
        inventory.add(armor);

        assertEquals(2, inventory.size());
        assertEquals(sword, inventory.get(0));
        assertEquals(armor, inventory.get(1));

        Item removed = inventory.remove(0);

        assertEquals(sword, removed);
        assertEquals(1, inventory.size());
        assertEquals(armor, inventory.get(0));
    }

    @Test
    void containerShouldWorkWithForEach() {
        InventoryContainer<Item> inventory = new InventoryContainer<>();

        inventory.add(new Item("Сталевий меч", EquipmentSlot.WEAPON, 25));
        inventory.add(new Item("Кільце сили", EquipmentSlot.RING, 7));

        int count = 0;

        for (Item item : inventory) {
            assertNotNull(item);
            count++;
        }

        assertEquals(2, count);
    }
}