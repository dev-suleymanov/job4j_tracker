package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UniqueTextTest {
    @Test
    public void IsEquals() {
        String origin = "My cat eats a mouse";
        String duplicate = "My cat eats a mouse";
        assertThat(new UniqueText().isEquals(origin, duplicate)).isTrue();
    }

    @Test
    public void IsNotEquals() {
        String origin = "My cat eats a mouse";
        String duplicate = "A mouse is eaten by a cat";
        assertThat(new UniqueText().isEquals(origin, duplicate)).isFalse();
    }
}