package ru.job4j.poly;

public interface Transport {
    double FUEL_PRICE = 65.5;

    void drive();

    void passengers(int passenger);

    double getPrice(int fuel);
}
