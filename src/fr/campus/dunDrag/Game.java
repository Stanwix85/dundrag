package fr.campus.dunDrag;

//import java.util.Random;

import java.util.Random;

public class Game {
    public static final int total = 64;

    public Square [] boardSquare = new Square[total];
    private int playerPosition = 0;
    private Random random = new Random();

    public void setUpBoard(){
        for(int i = 0; i < total; i++) {
            boardSquare[i] = new Square();
        }
    }
    public int rollDice() {
        return random.nextInt(6) + 1;
    }
    public boolean playTurn(Character player) {
        int roll = rollDice();
        try {

            playerPosition += roll;

            System.out.println("\n\uD83C\uDFB2 " + player.name + " rolled " + roll);
            if (playerPosition == total - 1) {
                System.out.println("\n Congratulations " + player.name + " Your quest is complete!!!!");
                return false;
            }
            Square currentSquare = boardSquare[playerPosition];
            System.out.println(player.name + " has reached square " + playerPosition);

            //Square currentSquare = boardSquare[playerPosition];
            //squareEvent(player, currentSquare)
            return true;
        } catch(IndexOutOfBoundsException e){
            System.out.println("You have crossed over the back of the board");
            playerPosition -= roll;
            System.out.println(player.name + " remains on square " + playerPosition);
        }


        //Square currentSquare = boardSquare[playerPosition];
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
