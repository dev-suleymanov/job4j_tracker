package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Lord of the Rings", 675);
        Book second = new Book("Mad Max", 367);
        Book third = new Book("Alice in Wonderland", 459);
        Book fourth = new Book("Clean code", 598);
        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = fourth;
        for (int i = 0; i < books.length; i++) {
            System.out.println("name: " + books[i].getBookName() + ", " + "pages: " + books[i].getBookPages());
        }
        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;
        for (Book el : books) {
            if ("Clean code".equals(el.getBookName())) {
                System.out.println("name: " + el.getBookName() + ", " + "pages: " + el.getBookPages());
                break;
            }
        }
    }
}
