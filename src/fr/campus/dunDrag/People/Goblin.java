package fr.campus.dunDrag.People;

public class Goblin extends Person {
    public Goblin( String name)
    {
        super(name, "Goblin",  6, 1);
    }
    public Goblin(String name, int lifePoints, int attackPoints){
        super(name, "Goblin",  lifePoints, attackPoints);
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", lifePoints=" + lifePoints +
                ", attackPoints=" + attackPoints +
                '}';
    }
}
