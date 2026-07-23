package fr.campus.dunDrag.function;
import fr.campus.dunDrag.People.Character;
import fr.campus.dunDrag.amory.Potion;
import fr.campus.dunDrag.amory.Shield;
import fr.campus.dunDrag.amory.Spell;
import fr.campus.dunDrag.amory.Weapon;

public class BoxManager {
    public static void openBox(Character player) {
        int offOrDef = ConsoleUtils.numGenrate(100);
        if (player.getArmeAttack() != null || player.getArmeDefense() != null) {
            if (player.getArmeAttack() != null) {
                offOrDef = 90;
            } else if (player.getArmeDefense() != null) {
                offOrDef = 10;
            } else {
                System.out.println("\n" + player.getName() + " is fully equipped, you cannot carry any more.");
                return;
            }
        }


        if (offOrDef <= 50) {

            if (player.getType().equalsIgnoreCase("Warrior")) {
                Weapon item = new Weapon("Sword", 3);
                player.setArmeAttack(item);
                System.out.print("\n" + player.getName() + " has discovered a " + item.getName());
            } else {
                Spell item = new Spell("Explosive spell", 2);
                player.setArmeAttack(item);
                System.out.print("\n" + player.getName() + " has discovered a " + item.getName());
            }

        } else {
            if (player.getType().equalsIgnoreCase("Warrior")) {
                Shield item = new Shield("Round shield", 3);
                player.setArmeDefense(item);
                System.out.print("\n" + player.getName() + " has discovered a " + item.getName());
            } else {
                Potion item = new Potion("Slowing Potion", 2);
                player.setArmeDefense(item);
                System.out.print("\n" + player.getName() + " has discovered a " + item.getName());
            }


        }
    }
}
