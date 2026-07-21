package fr.campus.dunDrag;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        Character player = menu.createCharacter();
        Game gameBoard = new Game();
        gameBoard.setUpBoard();

        boolean isRunning = true;
        System.out.println("--- Your Quest has begun ---");

        while (isRunning) {
            System.out.println("\n Press return key to roll the dice or enter 'm' for menu: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("m")) {
                isRunning = menu.openInGameMenu(player);
            } else {
                isRunning = gameBoard.playTurn(player);
            }



        }

    }
}
