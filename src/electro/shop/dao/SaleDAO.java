package electro.shop.dao;



import electro.shop.model.Product;
import electro.shop.model.Sale;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mobile_shop"; // Your database
        String user = "root"; // Your username
        String password = "Janvi@123"; // Your password
        return DriverManager.getConnection(url, user, password);
    }
    private ProductDAO productDAO = new ProductDAO();

    public boolean addSale(Sale sale) {
        String query = "INSERT INTO sales (product_id, quantity_sold, revenue) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, sale.getProductId());
            stmt.setInt(2, sale.getQuantitySold());
            stmt.setDouble(3, sale.getRevenue());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Product> getBestSellingProducts() {
        List<Product> bestSellers = new ArrayList<>( );
        String query = "SELECT product_id, SUM(quantity_sold) AS total_sales FROM sales GROUP BY product_id ORDER BY total_sales DESC LIMIT 5";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                Product product = productDAO.getProductById(productId);
                bestSellers.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bestSellers;
    }

}
