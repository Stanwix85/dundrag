package fr.campus.dunDrag.People;

import fr.campus.dunDrag.amory.DefensiveEquipement;
import fr.campus.dunDrag.amory.OffensiveEquipment;

public class Character extends Person {
    private OffensiveEquipment armeAttack;
    private DefensiveEquipement armeDefense;
    private int id;

    public Character(int id, String name, String type, int lifePoints, int attackPoints, OffensiveEquipment armeAttack, DefensiveEquipement armeDefense) {
        super(name, type, lifePoints, attackPoints);
        this.id = id;
        this.armeAttack = armeAttack;
        this.armeDefense = armeDefense;

    }
    public Character(int id, String name, String type, int lifePoints, int attackPoints) {
        super(name, type, lifePoints, attackPoints);
        this.id = id;
        this.armeAttack = null;
        this.armeDefense = null;

    }


    public OffensiveEquipment getArmeAttack() {
        return armeAttack;
    }

    public void setArmeAttack(OffensiveEquipment armeAttack) {
        this.armeAttack = armeAttack;
    }

    public DefensiveEquipement getArmeDefense() {
        return armeDefense;
    }

    public void setArmeDefense(DefensiveEquipement armeDefense) {
        this.armeDefense = armeDefense;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String attackWeaponName = (armeAttack != null) ? armeAttack.getName() : "Unarmed";
        String defenseWeaponName = (armeDefense != null) ? armeDefense.getName() : "None";
        return "Character{" +
                "id='" + id + '\'' +
                "name='" + getName() + '\'' +
                ", type='" + getType() + '\'' +
                ", Attack weapon ='" + attackWeaponName + '\'' +
                ", Defensive weapon ='" + defenseWeaponName + '\'' +
                ", lifePoints=" + getLifePoints() +
                ", attackPoints=" + getAttackPoints() +
                '}';
    }
}
