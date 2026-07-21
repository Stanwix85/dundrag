package fr.campus.dunDrag;

public class Weapon extends OffensiveEquipment{
    public Weapon(String name, int offensivePoints){
        super(name, "weapon", offensivePoints);

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

    @Override
    public int getOffensivePoints() {
        return super.getOffensivePoints();
    }

    @Override
    public void setOffensivePoints(int offensivePoints) {
        super.setOffensivePoints(offensivePoints);
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
