package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        int size = evenElements.size();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                builder.append(evenElements.getFirst());
            }
            evenElements.pollFirst();
        }
        return builder.toString();
    }

    private String getDescendingElements() {
        int size = descendingElements.size();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(descendingElements.getLast());
            descendingElements.pollLast();
        }
        return builder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}