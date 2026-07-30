package fr.campus.dunDrag.DbQuery;

import fr.campus.dunDrag.People.Character;
import fr.campus.dunDrag.amory.*;

import java.sql.*;

public class CombatDAO {
    public void downloadPlayerStats(Character player) {
        String sql = "SELECT p.current_life_points, p.current_attack_points, " +
                "a.id AS att_id, a.weapon_name AS att_name, a.weapon_type AS att_type, a.attack_points AS weapon_atk, " +
                "d.id AS def_id, d.weapon_name AS def_name, d.weapon_type AS def_type, d.defence_points AS weapon_def " +
                "FROM player p " +
                "LEFT JOIN attack_weapon a ON p.attack_arme_id = a.id " +
                "LEFT JOIN defence_weapon d ON p.defence_arme_id = d.id " +
                "WHERE p.id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, player.getId());

            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()){
                    player.setLifePoints(rs.getInt("current_life_points"));
                    player.setAttackPoints(rs.getInt("current_attack_points"));

                    int attID = rs.getInt("att_id");
                    if(!rs.wasNull()) {
                        String name = rs.getString("att_name");
                        String type = rs.getString("att_type");
                        int atkPoints = rs.getInt("weapon_atk");

                        OffensiveEquipment weapon = "Spell".equalsIgnoreCase(type)
                                ? new Spell(attID, name, type,atkPoints)
                                : new Weapon(attID, name, type,atkPoints);
                        player.setArmeAttack(weapon);

                    }
                    int defID = rs.getInt("def_id");
                    if(!rs.wasNull()){
                        String name = rs.getString("def_name");
                        String type = rs.getString("def_type");
                        int defPoints = rs.getInt("weapon_def");

                        DefensiveEquipement defence = "Potion".equalsIgnoreCase(type)
                                ? new Potion(defID, name, type, defPoints)
                                : new Shield(defID, name, type, defPoints);
                        player.setArmeDefense(defence);

                    }
                }
            }

         } catch (SQLException e) {
        System.err.println("Error downloading player stats: " + e.getMessage());
    }
    }
    public void updatePlayerHealthAfterCombat(Character player) {
        String sql = "UPDATE player SET current_life_points = ? WHERE id = ?";
        DatabaseConfig.executeUpdate(sql, player.getLifePoints(), player.getId());
    }
}
