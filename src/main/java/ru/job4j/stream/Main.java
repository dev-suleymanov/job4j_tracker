package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 5, 1, 3, 3);
        list.stream()
                .map(el -> el / 3)
                .forEach(System.out::println);
    }
}
