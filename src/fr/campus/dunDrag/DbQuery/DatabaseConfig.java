package fr.campus.dunDrag.DbQuery;

import java.sql.*;

public class DatabaseConfig {
    private static final String DB_URL = System.getenv("DB_URL");
    private static final String USER = System.getenv("DB_USER");
    private static final String PASS = System.getenv("DB_PASS");

    public static Connection getConnection() throws SQLException {
        if (DB_URL == null || USER == null || PASS == null){
            System.err.println("❌ ERROR: Environment variables missing!");
            System.err.println("DB_URL: " + DB_URL);
            System.err.println("USER:   " + USER);
            System.err.println("PASS:   " + (PASS == null ? "null" : "[SET]"));
        }
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public static int executeUpdate(String sql, Object... params) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Database Update Error; " + e.getMessage());
            return 0;
        }
    }
        public static int executeInsert(String sql, Object... params){
            try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                for(int i = 0; i < params.length; i++) {
                    stmt.setObject(i + 1, params[i]);
                }
                stmt.executeUpdate();

                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Database Insert Error: " + e.getMessage());
            }
            return 0;
        }

}
