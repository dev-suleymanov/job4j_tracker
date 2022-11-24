package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + divide(y) + multiply(y);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println("sum : " + result);
        result = minus(5);
        System.out.println("minus : " + result);
        Calculator calculator = new Calculator();
        result = calculator.divide(5);
        System.out.println("divide : " + result);
        result = calculator.multiply(2);
        System.out.println("multiply : " + result);
        result = calculator.sumAllOperation(9);
        System.out.println("sumAllOperation : " + result);
    }
}
