package ru.job4j.strategy;

import java.util.StringJoiner;

public class Square implements Shape {
    @Override
    public String draw() {
        String result = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result += "* ";
            }
            result += System.lineSeparator();
        }
        return result;
    }
}
