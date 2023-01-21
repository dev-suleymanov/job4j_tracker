package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> result = new HashSet<>();
        for (Account el : accounts) {
            result.add(el);
        }
        return result;
    }
}