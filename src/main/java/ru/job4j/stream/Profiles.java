package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(a -> a.getAddress())
                .collect(Collectors.toList());
    }

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        return profiles.stream()
                .map(address -> address.getAddress())
                .sorted((a, b) -> a.getCity().compareTo(b.getCity()))
                .distinct()
                .collect(Collectors.toList());
    }
}