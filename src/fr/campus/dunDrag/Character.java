package fr.campus.dunDrag;

public class Character {
    String name;
    String type;
    String arme;
    int lifePoints;
    int attackPoints;

    public Character(String type, String name, String arme, int lifePoints, int attackPoints) {
        this.type = type;
        this.name = name;
        this.arme = arme;
        this.lifePoints = lifePoints;
        this.attackPoints = attackPoints;


    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getArme() {
        return arme;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }
}
