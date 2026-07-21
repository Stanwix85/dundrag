package fr.campus.dunDrag;

public class OffensiveEquipment {
    String name;
    String type;
    int OffensivePoints;

    public OffensiveEquipment(String name, String type, int offensivePoints) {
        this.name = name;
        this.type = type;
        OffensivePoints = offensivePoints;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }
    public int getOffensivePoints() {
        return OffensivePoints;
    }

    public void setOffensivePoints(int offensivePoints) {
        OffensivePoints = offensivePoints;
    }

    @Override
    public String toString() {
        return "OffensiveEquipment{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", OffensivePoints=" + OffensivePoints +
                '}';
    }
}
