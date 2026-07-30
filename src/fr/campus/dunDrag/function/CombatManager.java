package fr.campus.dunDrag.function;
import fr.campus.dunDrag.DbQuery.CombatDAO;
import fr.campus.dunDrag.People.*;
import fr.campus.dunDrag.People.Character;
import fr.campus.dunDrag.amory.*;
import fr.campus.dunDrag.People.Person;

public class CombatManager {
    private static final CombatDAO combatDAO = new CombatDAO();
    public static boolean combat(Character player, Person adversary) {
      combatDAO.downloadPlayerStats(player);

        int totalPlayerAttack = player.getAttackPoints();
        int totalAdverseAttack = adversary.getAttackPoints();
        System.out.print("You have disturbed " + adversary.getName() + " the " + adversary.getType());
        System.out.print("\nPress Enter to attack");
        ConsoleUtils.waitForEnter();
        ConsoleUtils.pause(800);
        if (player.getArmeAttack() != null) {
            totalPlayerAttack += player.getArmeAttack().getOffensivePoints();
        }
        if (player.getArmeDefense() != null) {
            totalAdverseAttack = Math.max (0,adversary.getAttackPoints() - player.getArmeDefense().getDefensivePoints());
        }
        while (player.getLifePoints() > 0 && adversary.getLifePoints() > 0) {
            adversary.setLifePoints(adversary.getLifePoints() - totalPlayerAttack);
            System.out.println("\nStrike, You have hit " + adversary.getName());
            ConsoleUtils.pause(800);
            if (adversary.getLifePoints() <= 0) {
                combatDAO.updatePlayerHealthAfterCombat(player);
                return true;
            } else {
                System.out.println("\n" + adversary.getName() + " has " + adversary.getLifePoints() + " life points remaining!");
            }
            ConsoleUtils.pause(800);
            //enemy attack
            player.setLifePoints(player.getLifePoints() - totalAdverseAttack);
            System.out.println("\nowww!!!, You have been hit by  " + adversary.getName());
            ConsoleUtils.pause(800);
            if (player.getLifePoints() <= 0) {
                player.setLifePoints(0);

                combatDAO.updatePlayerHealthAfterCombat(player);

                return false;
            } else {
                System.out.println("\n" + player.getName() + " has " + player.getLifePoints() + " life points remaining! ");


            }
        }//while
        return player.getLifePoints() > 0;

    }//combat
} //class


