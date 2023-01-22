package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String result = "";
        for (int i = 0; i < count; i++) {
            result = queue.element().name();
            queue.poll();
        }
        return result;
    }

    public String getLastUpsetCustomer() {
        String result = "";
        for (int i = 0; i <= count; i++) {
            result = queue.element().name();
            queue.poll();
        }
        return result;
    }
}