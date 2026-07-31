package fr.campus.dunDrag.amory;

public class Weapon extends OffensiveEquipment {
    public Weapon(int id, String name, String type,  int offensivePoints){
        super(id, name,type, offensivePoints);

    }


    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", OffensivePoints=" + OffensivePoints +
                '}';
    }
}
