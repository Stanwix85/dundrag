package fr.campus.dunDrag.amory;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public int getDefensivePoints() {
        return defensivePoints;
    }
    public void setDefensivePoints(int defensivePoints) {
        this.defensivePoints = defensivePoints;
    }

    @Override
    public String toString() {
        return "DefensiveEquipement{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", defensivePoints=" + defensivePoints +
                '}';
    }
}
