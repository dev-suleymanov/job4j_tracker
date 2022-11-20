package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Let run clumsily");
        } else if (position == 2) {
            System.out.println("Good night");
        } else {
            System.out.println("Sound not found");
        }
    }

    public static void main(String[] args) {
        Jukebox disco = new Jukebox();
        disco.music(2);
    }
}
