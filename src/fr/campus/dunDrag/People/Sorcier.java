package fr.campus.dunDrag.People;

public class Sorcier extends Person {
    public Sorcier( String name) {
        super( name, "Sorcier", 8, 4);
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
