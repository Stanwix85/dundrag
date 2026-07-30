package fr.campus.dunDrag.amory;

public class OffensiveEquipment {
    int id;
    String name;
    String type;
    int OffensivePoints;




    public OffensiveEquipment(int id, String name, String type, int offensivePoints) {
        this.id = id;
        this.name = name;
        this.type = type;
        OffensivePoints = offensivePoints;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", OffensivePoints=" + OffensivePoints +
                '}';
    }
}
