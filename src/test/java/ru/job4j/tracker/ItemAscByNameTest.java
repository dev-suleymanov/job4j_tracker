package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemAscByNameTest {
    @Test
    public void whenSortingNameByAscending() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Rustam"));
        items.add(new Item("Vadim"));
        items.add(new Item("Alan"));
        items.add(new Item("Rauf"));
        items.add(new Item("Oleg"));
        items.sort(new ItemAscByName());
        List<Item> expected = List.of(
                new Item("Alan"),
                new Item("Oleg"),
                new Item("Rauf"),
                new Item("Rustam"),
                new Item("Vadim")
        );
        assertThat(items).isEqualTo(expected);
    }
}