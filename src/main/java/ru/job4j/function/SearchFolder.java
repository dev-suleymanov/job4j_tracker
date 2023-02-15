package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    public static List<Folder> filterSize(List<Folder> list) {
        return filter(list, el -> el.getSize() > 100);
    }

    public static List<Folder> filterName(List<Folder> list) {
        return filter(list, el -> el.getName().contains("bug"));
    }

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> result = new ArrayList<>();
        for (Folder f : list) {
            if (pred.test(f)) {
                result.add(f);
            }
        }
        return result;
    }
}