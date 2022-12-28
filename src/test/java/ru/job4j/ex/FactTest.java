package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FactTest {
    @Test
    public void whenException() {
        int number = 5;
        int expected = 120;
        int result = new Fact().calc(number);
        assertThat(result).isEqualTo(expected);
    }
}