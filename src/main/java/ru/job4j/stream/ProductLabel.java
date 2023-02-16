package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream().filter(p -> p.getStandard() - p.getActual() >= 0)
                .filter(p -> p.getStandard() - p.getActual() <= 3)
                .map(p -> new Label(p.getName(), p.getPrice() / 2))
                .map(p -> p.toString())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        ProductLabel productLabel = new ProductLabel();
        List<Product> products = Arrays.asList(
                new Product("bread", 20, 5, 4),
                new Product("butter", 80, 30, 27),
                new Product("orange", 120, 20, 3),
                new Product("coffee", 75, 120, 30),
                new Product("potato", 45, 90, 15),
                new Product("cherry", 150, 10, 8),
                new Product("watermelon", 70, 7, 7)
        );
        List<String> result = productLabel.generateLabels(products);
        result.forEach(System.out::println);
    }
}