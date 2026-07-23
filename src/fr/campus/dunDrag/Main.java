package fr.campus.dunDrag;

import fr.campus.dunDrag.People.Character;
import fr.campus.dunDrag.function.ConsoleUtils;
import fr.campus.dunDrag.function.Game;
import fr.campus.dunDrag.function.Menu;

import java.util.Scanner;

class Main {
     static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        boolean keepPlayingGame = true;

        while(keepPlayingGame) {
        Character player = menu.createCharacter();
        Game gameBoard = new Game();



        boolean isRunning = true;
        System.out.println("--- Your Quest has begun ---");

        while (isRunning) {
            System.out.println("\n Press return key to roll the dice or enter 'm' for menu: ");
            String input = ConsoleUtils.readLine();

            if (input.equalsIgnoreCase("m")) {
                isRunning = menu.openInGameMenu(player);
            } else {
                isRunning = gameBoard.playTurn(player);
            }



        }
        System.out.println("\n -------------------------------------");
        System.out.println("\nWould you like to play again? (y/n): ");
        String choice = ConsoleUtils.readLine();
        if(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("yes")) {
            keepPlayingGame = false;
            System.out.println("\nThank you for playing, Goodbye");
        }
        } // keepPlaying

    } //void class
} //class Main
