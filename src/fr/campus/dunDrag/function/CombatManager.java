package fr.campus.dunDrag.function;
import fr.campus.dunDrag.People.*;
import fr.campus.dunDrag.People.Character;
import fr.campus.dunDrag.amory.*;
import fr.campus.dunDrag.People.Person;

public class CombatManager {
    public static boolean combat(Character player, Person adversary) {

        int totalPlayerAttack = player.getAttackPoints();
        int totalAdverseAttack = adversary.getAttackPoints();
        System.out.print("You have disturbed " + adversary.getName() + " the " + adversary.getType());
        System.out.print("\nPress Enter to attack");
        ConsoleUtils.waitForEnter();
        ConsoleUtils.pause(800);
        if (player.getArmeAttack() != null) {
            totalPlayerAttack = player.getAttackPoints() + player.getArmeAttack().getOffensivePoints();
        }
        if (player.getArmeDefense() != null) {
            totalAdverseAttack = adversary.getAttackPoints() - player.getArmeDefense().getDefensivePoints();
            if (totalAdverseAttack < 0) {
                totalAdverseAttack = 0;
            }
        }
        while (player.getLifePoints() > 0 && adversary.getLifePoints() > 0) {
            int newAdhp = adversary.getLifePoints() - totalPlayerAttack;
            adversary.setLifePoints(newAdhp);
            System.out.println("\nStrike, You have hit " + adversary.getName());
            ConsoleUtils.pause(800);
            if (adversary.getLifePoints() <= 0) {

                return true;
            } else {
                System.out.println("\n" + adversary.getName() + " has " + adversary.getLifePoints() + " life points remaining!");
            }
            ConsoleUtils.pause(800);
            int newhp = player.getLifePoints() - totalAdverseAttack;
            player.setLifePoints(newhp);
            System.out.println("\nowww!!!, You have been hit by  " + adversary.getName());
            ConsoleUtils.pause(800);
            if (player.getLifePoints() <= 0) {

                return false;
            } else {
                System.out.println("\n" + player.getName() + " has " + player.getLifePoints() + " life points remaining! ");


            }
        }//while
        return true;

    }//combat
} //class


