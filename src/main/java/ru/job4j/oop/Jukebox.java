package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        String name = switch (position) {
            case 1 -> "Let run clumsily";
            case 2 -> "Good night";
            default -> "Sound not found";
        };
        System.out.println(name);
    }

    public static void main(String[] args) {
        Jukebox disco = new Jukebox();
        disco.music(2);
    }
}
