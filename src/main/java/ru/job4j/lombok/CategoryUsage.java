package ru.job4j.lombok;

public class CategoryUsage {
    public static void main(String[] args) {
        Category category1 = new Category(1);
        category1.setName("first");
        Category category2 = new Category(1);
        category2.setName("second");
        System.out.println(category1.equals(category2));
    }
}
