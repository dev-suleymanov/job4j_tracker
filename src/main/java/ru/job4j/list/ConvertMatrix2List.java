package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public static List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<>();
        int length = 0;
        for (int[] row : array) {
            for (int cell : row) {
                result.add(length++, cell);
            }
        }
        return result;
    }
}