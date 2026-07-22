package fr.campus.dunDrag.function;
import  java.util.Scanner;
import java.util.Random;

public class ConsoleUtils {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

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
}
