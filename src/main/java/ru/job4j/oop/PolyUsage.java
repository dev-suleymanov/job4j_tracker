package ru.job4j.oop;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle[] vehicles = {airplane, bus, train};
        for (Vehicle el : vehicles) {
            el.move();
        }
    }
}
