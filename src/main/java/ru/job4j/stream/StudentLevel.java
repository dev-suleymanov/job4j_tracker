package ru.job4j.stream;

import java.util.List;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(s -> s != null)
                .sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
                .takeWhile(s -> s.getScore() > bound)
                .toList();
    }
}
