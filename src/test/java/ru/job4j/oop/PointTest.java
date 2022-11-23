package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class PointTest {
    @Test
    public void when11And25When4Dot123() {
        Point first = new Point(1, 1);
        Point second = new Point(2, 5);
        double result = first.distance(second);
        double expected = 4.123;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when25And61When5Dot657() {
        Point first = new Point(2, 5);
        Point second = new Point(6, 1);
        double result = first.distance(second);
        double expected = 5.657;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when111And253When4Dot583() {
        Point first = new Point(1, 1, 1);
        Point second = new Point(2, 5, 3);
        double result = first.distance3d(second);
        double expected = 4.583;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when329And468When4Dot243() {
        Point first = new Point(3, 2, 9);
        Point second = new Point(4, 6, 8);
        double result = first.distance3d(second);
        double expected = 4.243;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }
}