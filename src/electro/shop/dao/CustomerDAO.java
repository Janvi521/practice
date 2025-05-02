package electro.shop.dao;



import electro.shop.model.Customer;


import java.sql.*;

public class CustomerDAO {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mobile_shop"; // Your database
        String user = "root"; // Your username
        String password = "Janvi@123"; // Your password
        return DriverManager.getConnection(url, user, password);
    }

    public boolean addCustomer(Customer customer) {
        String query = "INSERT INTO customers (username, password, email, phone) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, customer.getUsername());
            stmt.setString(2, customer.getPassword());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPhone());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean authenticateCustomer(String username, String password) {
        String query = "SELECT * FROM customers WHERE username=? AND password=?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Returns true if a customer with that username/password exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validateCustomer(String username, String password) {
        boolean isValid = false;
        String query = "SELECT * FROM customers WHERE username = ? AND password = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);  // Set the username
            stmt.setString(2, password);  // Set the password

            ResultSet rs = stmt.executeQuery();

            // If a matching row is found, credentials are valid
            if (rs.next()) {
                isValid = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isValid;
    }
}


