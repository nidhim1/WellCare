package edu.neu.csye6200.Model;

import edu.neu.csye6200.DB.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Data Access Object for user authentication
public class UserDAO {
    private DatabaseConnection databaseConnection = new DatabaseConnection();

    public boolean validateUser(String username, String password) {
        String query = "SELECT * FROM patient WHERE username = ? AND password = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
