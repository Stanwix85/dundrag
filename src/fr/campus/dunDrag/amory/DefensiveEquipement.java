package fr.campus.dunDrag.amory;

public class DefensiveEquipement {
    int id;
    String name;
    String type;
    int defensivePoints;


    public DefensiveEquipement(int id, String name, String type, int defensivePoints) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.defensivePoints = defensivePoints;

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", defensivePoints=" + defensivePoints +
                '}';
    }
}
