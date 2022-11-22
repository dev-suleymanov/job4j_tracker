package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error first = new Error();
        Error second = new Error(true, 2, "Please, fix the error");
        Error third = new Error(true, 10, "Please, fix the error");
        first.printInfo();
        second.printInfo();
        third.printInfo();
    }
}
