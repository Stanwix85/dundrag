package fr.campus.dunDrag;

public class Shield extends DefensiveEquipement{
    public Shield(String name, int defensivePoints) {
        super(name, "Shield", defensivePoints);
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
    public int getDefensivePoints() {
        return super.getDefensivePoints();
    }

    @Override
    public void setDefensivePoints(int defensivePoints) {
        super.setDefensivePoints(defensivePoints);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
