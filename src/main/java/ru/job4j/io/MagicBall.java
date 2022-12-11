package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        System.out.print("I am the great oracle. What do you want to know?");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        int random = new Random().nextInt(3);
        String result = switch (random) {
            case 0 -> "Yes";
            case 1 -> "No";
            default -> "May be";
        };
        System.out.println("- " + answer);
        System.out.println("- " + result);
    }
}
