package fr.campus.dunDrag;

public class DefensiveEquipement {
    String name;
    String type;
    int defensivePoints;

    public DefensiveEquipement(String name, String type, int defensivePoints) {
        this.name = name;
        this.type = type;
        this.defensivePoints = defensivePoints;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getDefensivePoints() {
        return defensivePoints;
    }
}
