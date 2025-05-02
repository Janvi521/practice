package electro.shop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mobile_shop"; // Your database
        String user = "root"; // Your username
        String password = "Janvi@123"; // Your password
        return DriverManager.getConnection(url, user, password);
    }
}
