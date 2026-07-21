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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArme() {
        return arme;
    }

    public void setArme(String arme) {
        this.arme = arme;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", arme='" + arme + '\'' +
                ", lifePoints=" + lifePoints +
                ", attackPoints=" + attackPoints +
                '}';
    }
}
