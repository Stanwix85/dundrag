package fr.campus.dunDrag.People;

import fr.campus.dunDrag.amory.DefensiveEquipement;
import fr.campus.dunDrag.amory.OffensiveEquipment;

public class Character extends Person {
    private OffensiveEquipment armeAttack;
    private DefensiveEquipement armeDefense;

    public Character(String name, String type, int lifePoints, int attackPoints, OffensiveEquipment armeAttack, DefensiveEquipement armeDefense) {
        super(type, name, lifePoints, attackPoints);
        this.armeAttack = armeAttack;
        this.armeDefense = armeDefense;
    }
    public Character( String name, String type, int lifePoints, int attackPoints) {
        super(name, type, lifePoints, attackPoints);
        this.armeAttack = null;
        this.armeDefense = null;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
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



    @Override
    public String toString() {
        String attackWeaponName = (armeAttack != null) ? armeAttack.getName() : "Unarmed";
        String defenseWeaponName = (armeDefense != null) ? armeDefense.getName() : "None";
        return "Character{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", Attack weapon ='" + armeAttack + '\'' +
                ", Defensive weapon ='" + armeDefense + '\'' +
                ", lifePoints=" + lifePoints +
                ", attackPoints=" + attackPoints +
                '}';
    }
}
