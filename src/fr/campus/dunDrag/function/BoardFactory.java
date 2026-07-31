package fr.campus.dunDrag.function;

import fr.campus.dunDrag.DbQuery.EnemyDAO;
import fr.campus.dunDrag.People.Person;

import java.util.List;

public class BoardFactory {
    public static Board createBoard(int size) {
        Board board = new Board(size);
        BoardSeed seedBoard = new BoardSeed();
        seedBoard.seedMyBoard(board);
        return board;
    }

    }

