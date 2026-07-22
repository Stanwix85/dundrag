package fr.campus.dunDrag.function;

//import java.util.Random;

import fr.campus.dunDrag.People.*;
import fr.campus.dunDrag.People.Character;

import java.util.Random;

public class Game {
    public static final int total = 64;

    public Square[] boardSquare = new Square[total];
    private int playerPosition = 0;
    private Random random = new Random();

    public void setUpBoard(){
        for(int i = 0; i < total; i++) {
            boardSquare[i] = new Square();
        }
    }
    public void seedSquare(){
        int mysteryBox = 5;
        Person[] enemies = {new Goblin("Boris"),new Goblin("Carl"), new Sorcier("Simon"), new Sorcier("Tim"), new Dragon("William") };
        int [] placeEnemy = new int [enemies.length];
        Random rand = new Random();
        for (int b = 0; b < mysteryBox; b++){
            int randombox;
            if (b < 2) {
                randombox = rand.nextInt(24) + 1;
            } else if (b < 4) {
                randombox = 25 + rand.nextInt(25);
            } else {
                randombox = 1 + rand.nextInt(49);
            }
            while (boardSquare[randombox].mysteryBox){
                randombox = 1 + rand.nextInt(49);
            }
            boardSquare[randombox].mysteryBox = true;
        }
        for (int e = 0; e < enemies.length; e++){
            int randombox;
            if (e < 2) {
                randombox = 5 + rand.nextInt(24);
            } else if (e < 4) {
                randombox = 28 + rand.nextInt(25);
            } else {
                randombox = 45 + rand.nextInt(19);
            }
            while(boardSquare[randombox].mysteryBox || boardSquare[randombox].enemy != null) {
                randombox = 25 + rand.nextInt(39);
            }
            placeEnemy[e] = randombox;
            boardSquare[randombox].enemy = enemies[e];
        }}
    public void printBoardDebug(){
        System.out.println("checking for the seeds");
        for (int i = 0; i < boardSquare.length; i++) {
            Square square = boardSquare[i];
            if (square.getEnemy() != null){
                System.out.println("Square " + i + " : Enemy-> " + square.getEnemy().getName() + " (" + square.getEnemy().getType() + ")");
            } else if (square.isMysteryBox()) {
                System.out.println("Square " + i + " is mystery box");
            }
        }
    }

    public int rollDice() {
        return random.nextInt(6) + 1;
    }

    public boolean playTurn(Character player) {
        Square currentSquare = boardSquare[playerPosition];
        int roll = rollDice();
        try {

            playerPosition += roll;

            System.out.println("\n\uD83C\uDFB2 " + player.getName() + " rolled " + roll);
            if (playerPosition == total - 1) {
                System.out.println("\n Congratulations " + player.getName() + " Your quest is complete!!!!");
                return false;
            }
             currentSquare = boardSquare[playerPosition];
            System.out.println(player.getName() + " has reached square " + playerPosition);


            //Square currentSquare = boardSquare[playerPosition];
            //squareEvent(player, currentSquare)
            return true;
        } catch(IndexOutOfBoundsException e){
            System.out.println("You have crossed over the back of the board");
            playerPosition -= roll;
            System.out.println(player.getName() + " remains on square " + playerPosition);
        }



        //squareEvent(player, currentSquare)
        return true;

    }
    //public void squareEvent(Character player, Square square)
    //public void seedSquare(){}
    //public void magicBox

    public int getPlayerPosition(){
        return playerPosition;
    }

}
