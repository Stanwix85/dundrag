package fr.campus.dunDrag.DbQuery;
import fr.campus.dunDrag.People.Character;
import java.sql.*;

public class PlayerDAO {
    public Character createPlayerFromTemplate(String playerName, String chosenType){
        String sql = "SELECT * FROM class_template WHERE character_type ILIKE ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, chosenType);

            try (ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    int baseLife = rs.getInt("base_life_points");
                    int baseAttack = rs.getInt("base_attack_points");
                    int characterID = rs.getInt("id");

                    Character player = new Character(0,playerName, chosenType, baseLife, baseAttack);


                    int generatedID = saveNewPlayer(player, characterID);
                    player.setId(generatedID);

                    return player;
                }
            }
        } catch (SQLException e){
            System.err.println("Error creating player from template: " + e.getMessage());
        }
        return null;

    }
    public int saveNewPlayer(Character player, int characterId) {
        String sql = "INSERT INTO player (name, current_life_points, current_attack_points, character_id) " +
                "VALUES (?, ?, ?, ?)";

        return DatabaseConfig.executeInsert(sql, player.getName(), player.getLifePoints(), player.getAttackPoints(), characterId);
    }
}