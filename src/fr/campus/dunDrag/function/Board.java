package fr.campus.dunDrag.function;

import fr.campus.dunDrag.DbQuery.EnemyDAO;
import fr.campus.dunDrag.People.Dragon;
import fr.campus.dunDrag.People.Goblin;
import fr.campus.dunDrag.People.Person;
import fr.campus.dunDrag.People.Sorcier;

import java.util.List;

public class Board {
    //public static final int total = 64;
    private final Square[] boardSquare;
    public  Board(int size) {
        this.boardSquare = new Square[size];
        for (int i = 0; i < size; i++) {
            this.boardSquare[i] = new Square();
        }
    }
    public Square getSquare(int position) {
        if (position >= 0 && position < boardSquare.length){
            return boardSquare[position];
        }
        return null;
    }
    public int getSize(){
        return boardSquare.length;
    }




   /* public void printBoardDebug() {
        System.out.println("checking for the seeds");
        for (int i = 0; i < boardSquare.length; i++) {
            Square square = boardSquare[i];
            if (square.getEnemy() != null) {
                System.out.println("Square " + i + " : Enemy-> " + square.getEnemy().getName() + " (" + square.getEnemy().getType() + ")");
            } else if (square.isMysteryBox()) {
                System.out.println("Square " + i + " is mystery box");
            }
        }
    }*/

}
