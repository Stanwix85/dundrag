package fr.campus.dunDrag.function;


import fr.campus.dunDrag.People.Person;

public class Square {
        private boolean mysteryBox;
        private Person enemy;


        public Square(){
            this.enemy = null;
            this.mysteryBox = false;
        }

    public boolean isMysteryBox() {
        return mysteryBox;
    }

    public void setMysteryBox(boolean mysteryBox) {
        this.mysteryBox = mysteryBox;
    }

    public Person getEnemy() {
        return enemy;
    }

    public void setEnemy(Person enemy) {
        this.enemy = enemy;
    }

    @Override
    public String toString() {
        return "Square{" +
                "mysteryBox=" + mysteryBox +
                ", enemy=" + enemy +
                '}';
    }
}

       /* public Square(Enemy enemy, DefensiveEquipement armeDef, OffensiveEquipment armeOff) {
            this.enemy = enemy;
            this.armeDef = armeDef;
            this.armeOff = armeOff;
        }

        public Enemy getEnemy() { return enemy; }
        public DefensiveEquipement getArmeDef() { return armeDef; }
        public OffensiveEquipment getArmeOff() { return armeOff; }
    }*/

