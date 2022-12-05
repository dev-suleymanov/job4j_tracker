package ru.job4j.pojo;

public class Book {
    private String bookName;
    private int bookPages;

    public Book(String bookName, int bookPages) {
        this.bookName = bookName;
        this.bookPages = bookPages;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPages() {
        return bookPages;
    }

    public void setBookPages(int bookPages) {
        this.bookPages = bookPages;
    }
}
