package ru.job4j.tracker;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item el : items) {
                System.out.println(el);
            }
        } else {
            System.out.println("Not found applications in tracker");
        }
        return true;
    }
}
