package DAO;

import model.User;
import java.sql.*;

public class UserDAO {

    public User findByUsername(String username) {
        User user = null;
        String sql = "SELECT username, password FROM users WHERE username = ?";

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                System.out.println("DEBUG: Found user - " + username + ", password: " + user.getPassword());
            } else {
                System.out.println("DEBUG: User not found - " + username);
            }
            rs.close();

        } catch (SQLException e) {
            System.err.println("Database error in findByUsername: " + e.getMessage());
            e.printStackTrace();
        }

        return user;
    }

    public boolean validateUser(String username, String password) {
        User user = findByUsername(username);
        if (user != null) {
            boolean isValid = user.getPassword().equals(password);
            System.out.println("DEBUG: Password validation - " + isValid);
            return isValid;
        }
        return false;
    }
}