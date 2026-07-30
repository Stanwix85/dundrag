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

        seedSquare();
        printBoardDebug();
    }
    private void seedSquare() {
        int mysteryBox = 10;
        EnemyDAO enemyDAO = new EnemyDAO();
        List<Person> loadedEnemies = enemyDAO.getAllEnemies();
        Person[] enemies = loadedEnemies.toArray(new Person[0]);
        int[] placeEnemy = new int[enemies.length];
        int maxIndex = boardSquare.length -2;
        int zone = boardSquare.length / 8;
        for (int b = 0; b < mysteryBox; b++) {
            int randombox;
            if (b < 2) {
                randombox = ConsoleUtils.numGenrate(zone * 2);
            } else if (b < 4) {
                randombox = (zone * 3)  + ConsoleUtils.numGenrate( zone * 2 );
            } else {
                randombox = ConsoleUtils.numGenrate(maxIndex);
            }
            while (boardSquare[randombox].mysteryBox) {
                randombox = ConsoleUtils.numGenrate (zone * 6);
            }
            boardSquare[randombox].mysteryBox = true;
        }
        for (int e = 0; e < enemies.length; e++) {
            int randombox;
            if (enemies[e].getType().equalsIgnoreCase("Goblin")) {
                randombox = zone + ConsoleUtils.numGenrate(zone * 2 );
            } else if (enemies[e].getType().equalsIgnoreCase("Sorcier")) {
                randombox = (zone * 3) + ConsoleUtils.numGenrate(zone * 2);
            } else {
                randombox = (zone * 5) + ConsoleUtils.numGenrate (maxIndex- (zone * 5));
            }
            while (boardSquare[randombox].mysteryBox || boardSquare[randombox].enemy != null) {
                randombox = (zone * 3) + ConsoleUtils.numGenrate (maxIndex - (zone * 3));
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
