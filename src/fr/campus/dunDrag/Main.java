package fr.campus.dunDrag;

import fr.campus.dunDrag.People.Character;
import fr.campus.dunDrag.function.Game;
import fr.campus.dunDrag.function.Menu;

class Main {
    static void main(String[] args) {
        Menu menu = new Menu();
        boolean keepPlayingGame = true;

        while (keepPlayingGame) {
            Character player = menu.createCharacter();
            Game gameBoard = new Game();
            boolean isRunning = true;

            System.out.println("--- Your Quest has begun ---");

            while (isRunning) {
               isRunning = menu.turnPromt(player);
               if (isRunning) {
                   isRunning = gameBoard.playTurn(player);
               }

            }
           keepPlayingGame = menu.askToPlayAgain();

        } // keepPlaying

    } //void class
} //class Main
