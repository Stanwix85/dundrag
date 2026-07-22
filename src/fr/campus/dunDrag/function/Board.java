package fr.campus.dunDrag.function;

import fr.campus.dunDrag.People.Dragon;
import fr.campus.dunDrag.People.Goblin;
import fr.campus.dunDrag.People.Person;
import fr.campus.dunDrag.People.Sorcier;

public class Board {
    //public static final int total = 64;
    private final Square[] boardSquare;
    public  Board(int size) {
        this.boardSquare = new Square[size];
        for (int i = 0; i < size; i++) {
            this.boardSquare[i] = new Square();
        }

        seedSquare();
        printBoardDebug();
    }
    private void seedSquare() {
        int mysteryBox = 10;
        Person[] enemies = {new Goblin("Boris"), new Goblin("Carl"), new Sorcier("Simon"), new Sorcier("Tim"), new Dragon("William")};
        int[] placeEnemy = new int[enemies.length];
        for (int b = 0; b < mysteryBox; b++) {
            int randombox;
            if (b < 2) {
                randombox = ConsoleUtils.numGenrate(24) + 1;
            } else if (b < 4) {
                randombox = 25 + ConsoleUtils.numGenrate( 25);
            } else {
                randombox = 1 + ConsoleUtils.numGenrate(49);
            }
            while (boardSquare[randombox].mysteryBox) {
                randombox = 1 + ConsoleUtils.numGenrate (49);
            }
            boardSquare[randombox].mysteryBox = true;
        }
        for (int e = 0; e < enemies.length; e++) {
            int randombox;
            if (e < 2) {
                randombox = 5 + ConsoleUtils.numGenrate(24);
            } else if (e < 4) {
                randombox = 28 + ConsoleUtils.numGenrate(25);
            } else {
                randombox = 45 + ConsoleUtils.numGenrate (19);
            }
            while (boardSquare[randombox].mysteryBox || boardSquare[randombox].enemy != null) {
                randombox = 25 + ConsoleUtils.numGenrate (37);
            }
            placeEnemy[e] = randombox;
            boardSquare[randombox].enemy = enemies[e];
        }
    }

    public void printBoardDebug() {
        System.out.println("checking for the seeds");
        for (int i = 0; i < boardSquare.length; i++) {
            Square square = boardSquare[i];
            if (square.getEnemy() != null) {
                System.out.println("Square " + i + " : Enemy-> " + square.getEnemy().getName() + " (" + square.getEnemy().getType() + ")");
            } else if (square.isMysteryBox()) {
                System.out.println("Square " + i + " is mystery box");
            }
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
}
