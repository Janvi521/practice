package electro.shop.dao;


import electro.shop.model.AdminLogin;
import java.sql.*;


public class AdminDAO {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mobile_shop"; // Your database
        String user = "root"; // Your username
        String password = "Janvi@123"; // Your password
        return DriverManager.getConnection(url, user, password);
    }
    public boolean validateAdmin(AdminLogin adminLogin) throws SQLException {
        boolean isValid = false;
        String query = "SELECT password FROM admins WHERE username = ? ";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, adminLogin.getUsername());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");

                // Directly compare the entered password with the stored password (Plain-text)
                if (adminLogin.getPassword().equals(storedPassword)) {
                    return true; // Valid admin login
                }
            }
        } catch (SQLException e) {
            System.err.println("Error while validating admin: " + e.getMessage());
            throw e;
        }
        return false; // Invalid username or password
    }
}

