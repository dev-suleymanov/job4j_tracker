package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.assertj.core.api.Assertions.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindById() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll()[0];
        assertThat(result.getName()).isEqualTo(first.getName());
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        Item[] result = tracker.findByName(first.getName());
        assertThat(result.length).isEqualTo(3);
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        Item[] result = tracker.findByName(second.getName());
        assertThat(result[1].getName()).isEqualTo(second.getName());
    }

    @Test
    public void whenReplaceItemIsSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bug");
        tracker.add(item);
        int id = item.getId();
        Item updateItem = new Item("Bug with description");
        tracker.replace(id, updateItem);
        assertThat(tracker.findById(id).getName()).isEqualTo("Bug with description");
    }

    @Test
    public void whenReplaceItemIsNotSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bug");
        tracker.add(item);
        Item updateItem = new Item("Bug with description");
        boolean result = tracker.replace(1000, updateItem);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("Bug");
        assertThat(result).isFalse();
    }

    @Test
    public void whenDeleteItemIsSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bug");
        tracker.add(item);
        int id = item.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id)).isNull();
    }

    @Test
    public void whenDeleteItemIsNotSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bug");
        tracker.add(item);
        boolean result = tracker.delete(1000);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("Bug");
        assertThat(result).isFalse();
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new EditAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        one.setName("New Test Name");
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit" + ln
                        + "=== Edit item ===" + ln
                        + "Replace application: " + one + ln
                        + "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit" + ln
                        + "The tracker successful closed" + ln
        );
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("test1"));
        Item second = tracker.add(new Item("test2"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ShowAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln
                        + first + ln
                        + second + ln
                        + "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln
                        + "The tracker successful closed" + ln
        );
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", "test1", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByNameAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit" + ln
                        + "=== Find item by name ===" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit" + ln
                        + "The tracker successful closed" + ln
        );
    }

    @Test
    public void FindByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByIdAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit" + ln
                        + "The tracker successful closed" + ln
        );
    }
}