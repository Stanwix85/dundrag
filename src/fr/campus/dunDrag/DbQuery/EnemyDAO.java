package fr.campus.dunDrag.DbQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import fr.campus.dunDrag.People.*;
import java.util.HashMap;
import java.util.Map;

public class EnemyDAO {



    public List<Person> getAllEnemies() {
        List<Person> enemies = new ArrayList<>();
        String dbQuery = "SELECT *, class_template.character_type FROM enemy JOIN class_template ON enemy.character_id = class_template.id";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(dbQuery);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Person enemy = createEnemyFromResultSet(rs);
                enemies.add(enemy);
            }
        } catch (SQLException e) {
            System.err.println("Database error while loading enemies: " + e.getMessage());
            e.printStackTrace();
        }
        return enemies;
    }

    private Person createEnemyFromResultSet(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String type = rs.getString("character_type");
        int lifePoints = rs.getInt("current_life_points");
        int attackPoints = rs.getInt("current_attack_points");
        return EnemyFactory.createEnemy(name, type, lifePoints, attackPoints);

    }
}
