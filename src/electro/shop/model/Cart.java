package electro.shop.model;



import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, Integer> productsInCart = new HashMap<>(); // productId -> quantity

    public void addProduct(int productId, int quantity) {
        productsInCart.put(productId, productsInCart.getOrDefault(productId, 0) + quantity);
    }

    public void removeProduct(int productId) {
        productsInCart.remove(productId);
    }

    public Map<Integer, Integer> getProductsInCart() {
        return productsInCart;
    }

    public void clearCart() {
        productsInCart.clear();
    }
}

