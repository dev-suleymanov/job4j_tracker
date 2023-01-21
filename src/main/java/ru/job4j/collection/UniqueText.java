package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String el : origin) {
            check.add(el);
        }
        for (String el : text) {
            if (!check.contains(el)) {
                result = false;
                break;
            }
        }
        return result;
    }
}


