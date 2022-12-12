package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("The bus drove");
    }

    @Override
    public void passengers(int passenger) {
        System.out.println(passenger + " passengers in the bus");
    }

    @Override
    public double getPrice(int fuel) {
        return fuel * FUEL_PRICE;
    }
}
