package fr.campus.dunDrag.function;



import fr.campus.dunDrag.People.*;
import fr.campus.dunDrag.People.Character;
import fr.campus.dunDrag.amory.*;




public class Game {
    private int playerPosition = 0;
    Board board = new Board(64);
    Square currentSquare = board.getSquare(playerPosition);


    public int rollDice() {
        return ConsoleUtils.numGenrate(6);
    }

    public boolean playTurn(Character player) {
        //Square currentSquare = bboardSquare[playerPosition];
        int roll = rollDice();

            playerPosition += roll;
            if (playerPosition >= board.getSize()) {
                System.out.println("\n\uD83C\uDFB2 " + player.getName() + " rolled " + roll);
                System.out.println("\nYou overshot the end of the board!");
                playerPosition -= roll; // Roll back the move
                System.out.println(player.getName() + " remains on square " + playerPosition);
                return true;
            }

            currentSquare = board.getSquare(playerPosition);

            System.out.println("\n\uD83C\uDFB2 " + player.getName() + " rolled " + roll);
            if (playerPosition == board.getSize() - 1) {
                System.out.println("\n Congratulations " + player.getName() + " Your quest is complete!!!!");
                return false;
            }
           // currentSquare = boardSquare[playerPosition];
            Person adversary = currentSquare.getEnemy();
            if (adversary != null) {
                boolean winner = CombatManager.combat(player, adversary);
                if (winner) {
                    System.out.print("\n" + adversary.getName() + " is a very tough " + adversary.getType() + "! But you have killed him, continue on your quest ");
                    ConsoleUtils.pause(800);
                    System.out.println("\n" + player.getName() + " has reached square " + playerPosition);
                    currentSquare.setEnemy(null);
                    ConsoleUtils.pause(800);
                } else {
                    System.out.print("\n" + adversary.getName() + " is a very tough " + adversary.getType() + "! He has killed you, game over better luck next time");
                    ConsoleUtils.pause(800);
                    return false;
                }
            }
                if (currentSquare.isMysteryBox()) {
                    System.out.print("\nYou have good fortune you have found a mystery box");
                    BoxManager.openBox(player);

                }
                System.out.println("\n" + player.getName() + " has reached square " + playerPosition);
                return true;
        }

    }

