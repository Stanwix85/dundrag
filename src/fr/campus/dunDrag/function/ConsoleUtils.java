package fr.campus.dunDrag.function;
import  java.util.Scanner;
import java.util.Random;

public class ConsoleUtils {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();


    public static final int DEFAULT_BOARD_SIZE = 64;
    public static final int MYSTERY_BOX_COUNT = 10;
    public static final int DEFAULT_DICE_SIDES = 6;
    public static final int DEFAULT_PAUSE = 800;

    public static void pause(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public static String readLine(){
        return SCANNER.nextLine().trim();
    }
    public static void waitForEnter(){
        SCANNER.nextLine();
    }
    public static int numGenrate(int sides){
         return RANDOM.nextInt(sides) + 1;
    }
    public static int getRandomIndex(int maxExclusive) {
        return RANDOM.nextInt(maxExclusive);
    }

    public static int getRandomInRange(int min, int max) {
        if (min >= max) return min;
        return RANDOM.nextInt((max - min) + 1) + min;
    }

    public static int rollDice() {
        return ConsoleUtils.numGenrate(DEFAULT_DICE_SIDES);
    }

    public static int rollDice(int sides) {
        return numGenrate(sides);
    }

}
