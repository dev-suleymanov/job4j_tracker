package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemDescByNameTest {
    @Test
    public void whenSortingNameByDecreasing() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Rustam"));
        items.add(new Item("Vadim"));
        items.add(new Item("Alan"));
        items.add(new Item("Rauf"));
        items.add(new Item("Oleg"));
        items.sort(new ItemDescByName());
        List<Item> expected = List.of(
                new Item("Vadim"),
                new Item("Rustam"),
                new Item("Rauf"),
                new Item("Oleg"),
                new Item("Alan")
        );
        assertThat(items).isEqualTo(expected);
    }
}