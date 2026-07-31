package fr.campus.dunDrag.People;
import java.util.HashMap;
import java.util.Map;


public class EnemyFactory {

    @FunctionalInterface
    public interface EnemyConstructor {
        Person create(String name, int lifePoints, int attackPoints);
    }

    private static final Map<String, EnemyConstructor> FACTORY_MAP = new HashMap<>();

    static {
        FACTORY_MAP.put("goblin", Goblin::new);
        FACTORY_MAP.put("sorcier", Sorcier::new);
        FACTORY_MAP.put("dragon", Dragon::new);
    }

    public static Person createEnemy(String name, String type, int lifePoints, int attackPoints){
      if(type != null) {
          EnemyConstructor constructor = FACTORY_MAP.get(type.toLowerCase().trim());
          if(constructor != null) {
              return constructor.create(name, lifePoints, attackPoints);
          }
      }
      System.out.println("Unknown enemy type [" + type + "]. Defaulting to Goblin");
      return new Goblin(name, lifePoints, attackPoints);
    }


}





