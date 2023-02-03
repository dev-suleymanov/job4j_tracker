package ru.job4j.tracker;

import java.util.List;

public class ShowAction implements UserAction {
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findAll();
        if (items.size() > 0) {
            for (Item el : items) {
                out.println(el);
            }
        } else {
            out.println("Not found applications in tracker");
        }
        return true;
    }
}
