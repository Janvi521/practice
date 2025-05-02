package electro.shop.service;

import electro.shop.dao.CartDao;
import electro.shop.model.CartItem;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartService {
    private CartDao cartDao;

    public CartService() {
        this.cartDao = new CartDao();
    }

    // Add product to cart
    public void addProductToCart(int userId, int productId, String productName, double price, int quantity) throws SQLException {
        cartDao.addProductToCart(userId, productId, productName, price, quantity);
    }

    // Get all products in cart
    public List<CartItem> getCartItems(int userId) throws SQLException {
        return cartDao.getCartItems(userId);
    }


    public Map<Integer, Integer> getCartProducts(int userId) throws SQLException {
        List<CartItem> cartItems = getCartItems(userId);
        Map<Integer, Integer> cartProducts = new HashMap<>();
        for (CartItem item : cartItems) {
            cartProducts.put(item.getProductId(), item.getQuantity());
        }
        return cartProducts;
    }

    // Remove product from cart
    public void removeProductFromCart(int userId, int productId) throws SQLException {
        cartDao.removeProductFromCart(userId, productId);
    }

    // Calculate total price of items in the cart
    public double calculateTotal(int userId) throws SQLException {
        List<CartItem> cartItems = getCartItems(userId);
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }

    // Clear the entire cart
    public void clearCart(int userId) throws SQLException {
        cartDao.clearCart(userId);
    }
}


