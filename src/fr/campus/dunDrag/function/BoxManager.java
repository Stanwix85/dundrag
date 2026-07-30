package fr.campus.dunDrag.function;
import fr.campus.dunDrag.DbQuery.WeaponDAO;
import fr.campus.dunDrag.People.Character;
import fr.campus.dunDrag.amory.*;

public class BoxManager {
    private static final WeaponDAO weaponDAO = new WeaponDAO();
    public static void openBox(Character player) {

        if (player.getArmeAttack() != null && player.getArmeDefense() != null) {
            System.out.println("\n" + player.getName() + " is fully equipped, you cannot carry any more.");
            return;}

        int offOrDef = ConsoleUtils.numGenrate(100);

        if (player.getArmeAttack() != null) {
                offOrDef = 90;
        } else if (player.getArmeDefense() != null) {
                offOrDef = 10;
        }
        int templateId = player.getType().equalsIgnoreCase("wizard") ? 1:2;

        if (offOrDef <= 50) {
            OffensiveEquipment newWeapon = weaponDAO.createOffWeaponFromTemplate(templateId);
            if (newWeapon != null) {
                player.setArmeAttack(newWeapon);
                weaponDAO.saveAttWeaponToPlayer(player, newWeapon);
                System.out.print("\n" + player.getName() + " has discovered a " + newWeapon.getName());
            }

            } else {
            DefensiveEquipement newDefence = weaponDAO.createDefWeaponFromTemplate(templateId);
            if (newDefence != null) {
                player.setArmeDefense(newDefence);
                weaponDAO.saveDefWeaponToPlayer(player, newDefence);
                System.out.print("\n" + player.getName() + " has discovered a " + newDefence.getName());
            }



        }
        } //openbox
} //boxManger
