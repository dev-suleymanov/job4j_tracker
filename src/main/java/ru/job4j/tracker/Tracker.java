package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                result = i;
                break;
            }
        }
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int length = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                result[length++] = items[i];
            }
        }
        return Arrays.copyOf(result, length);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            items[index] = item;
            item.setId(id);
            return true;
        }
        return false;
    }
}