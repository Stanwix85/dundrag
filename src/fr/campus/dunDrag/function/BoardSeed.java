package fr.campus.dunDrag.function;

import fr.campus.dunDrag.DbQuery.EnemyDAO;
import fr.campus.dunDrag.People.Person;

import java.util.List;

public class BoardSeed {

    public void seedMyBoard(Board board) {

        int totalSquares = board.getSize();

        int mysteryBox = ConsoleUtils.MYSTERY_BOX_COUNT;
        EnemyDAO enemyDAO = new EnemyDAO();
        List<Person> loadedEnemies = enemyDAO.getAllEnemies();
        Person[] enemies = loadedEnemies.toArray(new Person[0]);

        int maxIndex = totalSquares - 2;
        int zone = totalSquares / 8;

        for (int b = 0; b < mysteryBox; b++) {
            int randombox;
            if (b < 2) {
                randombox = ConsoleUtils.numGenrate(zone * 2);
            } else if (b < 4) {
                randombox = (zone * 3) + ConsoleUtils.numGenrate(zone * 2);
            } else {
                randombox = ConsoleUtils.numGenrate(maxIndex);
            }
            while (board.getSquare(randombox).isMysteryBox()) {
                randombox = ConsoleUtils.numGenrate(zone * 6);
            }
            board.getSquare(randombox).setMysteryBox(true);
        }
        for (int e = 0; e < enemies.length; e++) {
            int randombox;
            if (enemies[e].getType().equalsIgnoreCase("Goblin")) {
                randombox = zone + ConsoleUtils.numGenrate(zone * 2);
            } else if (enemies[e].getType().equalsIgnoreCase("Sorcier")) {
                randombox = (zone * 3) + ConsoleUtils.numGenrate(zone * 2);
            } else {
                randombox = (zone * 5) + ConsoleUtils.numGenrate(maxIndex - (zone * 5));
            }
            while (board.getSquare(randombox).isMysteryBox() || board.getSquare(randombox).getEnemy() != null) {
                randombox = (zone * 3) + ConsoleUtils.numGenrate(maxIndex - (zone * 3));
            }

            board.getSquare(randombox).setEnemy(enemies[e]);
        }

    }
}
