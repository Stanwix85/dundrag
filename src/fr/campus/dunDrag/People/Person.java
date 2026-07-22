package fr.campus.dunDrag.People;

public class Person {

        String name;
        String type;
        int lifePoints;
        int attackPoints;

        public Person( String name, String type, int lifePoints, int attackPoints) {
            this.name = name;
            this.type = type;
            this.lifePoints = lifePoints;
            this.attackPoints = attackPoints;


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
        public int getLifePoints() {
            return lifePoints;
        }

        public void setLifePoints(int lifePoints) {
            this.lifePoints = lifePoints;
        }

        public int getAttackPoints() {
            return attackPoints;
        }

        public void setAttackPoints(int attackPoints) {
            this.attackPoints = attackPoints;
        }

        @Override
        public String toString() {
            return "Character{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", lifePoints=" + lifePoints +
                    ", attackPoints=" + attackPoints +
                    '}';
        }
    }


