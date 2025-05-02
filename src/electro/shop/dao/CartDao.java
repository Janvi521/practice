package electro.shop.dao;

import electro.shop.model.CartItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    private static final String url = "jdbc:mysql://localhost:3306/mobile_shop";
    private static final String user = "root";
    private static final String password = "Janvi@123";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Add product to cart (optional persistence)
    public void addProductToCart(int userId, int productId, String productName, double price, int quantity) throws SQLException {
        String sql = "INSERT INTO Cart (userId, productId, productName, price, quantity) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, productId);
            pstmt.setString(3, productName);
            pstmt.setDouble(4, price);
            pstmt.setInt(5, quantity);
            pstmt.executeUpdate();
        }
    }

    // Get all items from cart (optional persistence)
    public List<CartItem> getCartItems(int userId) throws SQLException {
        List<CartItem> cartItems = new ArrayList<>();
        String sql = "SELECT * FROM Cart WHERE userId = ?";
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CartItem item = new CartItem(rs.getInt("productId"), rs.getString("productName"), rs.getDouble("price"), rs.getInt("quantity"));
                cartItems.add(item);
            }
        }
        return cartItems;


    }

    public void removeProductFromCart(int userId, int productId) throws SQLException {
        String sql = "DELETE FROM Cart WHERE userId = ? AND productId = ?";
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, productId);
            pstmt.executeUpdate();
        }
    }

    public void clearCart(int userId) throws SQLException {
        String sql = "DELETE FROM Cart WHERE userId = ?";
        try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
        }
    }
}
