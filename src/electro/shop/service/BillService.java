package electro.shop.service;

import electro.shop.dao.ProductDAO;
import electro.shop.model.Product;


import java.sql.SQLException;
import java.util.Map;

public class BillService {
    private CartService cartService = new CartService();
    private ProductDAO productDao=new ProductDAO();

    public void generateBill( int userId) throws SQLException {
        double total = cartService.calculateTotal(userId);
        System.out.println("📑 Bill Summary:");
        System.out.println("---------------");
        System.out.println("Product | Quantity | Price | Total");

        for (Map.Entry<Integer, Integer> entry : cartService.getCartProducts(userId).entrySet()) {
            Product product = productDao.getProductById(entry.getKey());
            if (product != null) {  // Check if the product exists
                double productTotal = product.getPrice() * entry.getValue();
                System.out.println(product.getName() + " | " + entry.getValue() + " | ₹" + product.getPrice() + " | ₹" + productTotal);
            } else {
                System.out.println("Product with ID " + entry.getKey() + " not found!");
            }
        }


        System.out.println("---------------");
        System.out.println("Total Amount: ₹" + total);
        cartService.clearCart(userId); // Clear cart after generating the bill
    }
}
