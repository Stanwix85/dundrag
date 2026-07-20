package fr.campus.dunDrag;

public class OffensiveEquipment {
    String name;
    String type;
    int OffensivePoints;

    public OffensiveEquipment(String name, String type, int offensivePoints) {
        this.name = name;
        this.type = type;
        this.OffensivePoints = offensivePoints;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getOffensivePoints() {
        return OffensivePoints;
    }
}
