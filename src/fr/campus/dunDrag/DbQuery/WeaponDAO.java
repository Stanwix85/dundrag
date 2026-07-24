package fr.campus.dunDrag.DbQuery;
import fr.campus.dunDrag.People.Character;
import fr.campus.dunDrag.People.Goblin;
import fr.campus.dunDrag.amory.*;

import java.sql.*;

public class WeaponDAO {

    public OffensiveEquipment createOffWeaponFromTemplate(int classTemplateID) {
        String sql = "SELECT * FROM attack_weapon WHERE class_template_id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, classTemplateID);

            try (ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("weapon_name");
                    String type = rs.getString("weapon_type"); //i might not need this field
                    int attackPoints = rs.getInt("attack_points");

                    if("Spell".equalsIgnoreCase(type)) {
                        return new Spell(id, name, type, attackPoints);

                    }else {
                        return new Weapon(id, name, type, attackPoints);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error creating weapon from template: " + e.getMessage());
        }
        return null;
    }
    public DefensiveEquipement createDefWeaponFromTemplate(int classTemplateID) {
        String sql = "SELECT * FROM defence_weapon WHERE class_template_id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, classTemplateID);

            try (ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("weapon_name");
                    String type = rs.getString("weapon_type");
                    int defencePoints = rs.getInt("defence_points");

                    if ("Potion".equalsIgnoreCase(type)) {
                        return new Potion(id, name, type, defencePoints);
                    }else {

                    return new Shield(id, name, type, defencePoints);
                }}
            }
        } catch (SQLException e) {
            System.err.println("Error creating weapon from template: " + e.getMessage());
        }
        return null;
    }
    public void saveAttWeaponToPlayer (Character player, OffensiveEquipment item) {
        String sql = "UPDATE player SET attack_arme_id = ? WHERE id = ?";

        DatabaseConfig.executeUpdate(sql, item.getId(), player.getId());
    }
    public void saveDefWeaponToPlayer (Character player, DefensiveEquipement item) {
        String sql = "UPDATE player SET defence_arme_id = ? WHERE id = ?";

        DatabaseConfig.executeUpdate(sql, item.getId(), player.getId());
    }
}
