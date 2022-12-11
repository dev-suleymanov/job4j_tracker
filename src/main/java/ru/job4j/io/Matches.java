package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Game \"ELEVEN\":");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "First player" : "Second player";
            System.out.println(player + " enter a number from 1 to 3");
            int matches = Integer.parseInt(input.nextLine());
            turn = !turn;
            if (isValidValue(count, matches)) {
                count -= matches;
                System.out.println("The " + count + " matches left on the table");
            }
        }
        if (!turn) {
            System.out.println("The first player to won");
        } else {
            System.out.println("The second player to won");
        }
    }

    public static boolean isValidValue(int count, int input) {
        boolean result = true;
        if (input >= 1 && input <= 3) {
            if (input > count) {
                System.out.println("The input number more by default value");
                result = false;
            }
        } else {
            System.out.println("Please, enter the number from 1 to 3");
            result = false;
        }
        return result;
    }
}
