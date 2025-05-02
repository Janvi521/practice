package electro11.shops22.dao;

import electro11.shops22.model.AdminLogin;

import java.sql.*;

public class AdminDao {
    private static final String URL = "jdbc:mysql://localhost:3306/project";
    private static final String USER = "root";
    private static final String PASSWORD = "Janvi@123";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public boolean checkPassword( AdminLogin adminLogin) throws  SQLException {
        String sql = "SELECT password FROM admin WHERE BINARY username = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {


            pstmt.setString(1, adminLogin.getUsername().trim()); // Set username dynamically

            try (ResultSet rst = pstmt.executeQuery()) {
                if (rst.next()) {  // Check if result exists
                    String storedPassword = rst.getString("password").trim();
                    System.out.println("🔎 Stored Password: " + storedPassword);
                    System.out.println("🔎 Entered Password: " + adminLogin.getPassword());
                    return storedPassword.equals(adminLogin.getPassword().trim());
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Database error: " + e.getMessage());
        }
        return false; // Return false if no matching username/password found
    }
}

