package fr.campus.dunDrag.amory;

public class EquipmentFactory {
    public static OffensiveEquipment createOffensive(int id, String name, String type, int points) {
        if("Spell".equalsIgnoreCase(type)) {
            return new Spell(id, name, type, points);
        }
        return new Weapon(id, name, type, points);
    }
    public static DefensiveEquipement createDefensive(int id, String name, String type, int points) {
        if ("Potion".equalsIgnoreCase(type)) {
            return new Potion(id, name, type, points);
        }
        return new Shield(id, name, type, points);
    }
}
