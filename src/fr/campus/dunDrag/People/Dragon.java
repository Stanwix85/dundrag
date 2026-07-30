package fr.campus.dunDrag.People;

public class Dragon extends Person {
    public Dragon(String name) {
        super(name, "Dragon",  12, 7);}
         public Dragon(String name, int lifePoints, int attackPoints){
            super(name, "Dragon",  lifePoints, attackPoints);

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
