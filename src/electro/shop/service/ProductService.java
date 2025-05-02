package electro.shop.service;



import electro.shop.model.Product;
import electro.shop.dao.ProductDAO;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final ProductDAO productDAO = new ProductDAO();

    public boolean addProduct(String name, double price, String brand, int stockQuantity) {
        Product product = new Product(0, name, price, brand, stockQuantity);
        return productDAO.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public boolean updateProduct(int productId, String name, double price, String brand, int stockQuantity) {
        Product product = new Product(productId, name, price, brand, stockQuantity);
        return productDAO.updateProduct(product);
    }

    public boolean deleteProduct(int productId) {
        return productDAO.deleteProduct(productId);
    }

    public List<Product> filterProductsByPrice(double minPrice, double maxPrice) {
        List<Product> filteredProducts = new ArrayList<>();
//        List<Product> allProducts = productDAO.getAllProducts();  // Get all products from the database
//
//        // Filter products based on price range
//        for (Product product : allProducts) {
//            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
//                filteredProducts.add(product);  // Add product to the filtered list if it falls within the price range
//            }
//        }
//
//        return filteredProducts;
//    }
        return productDAO.filterProductsByPrice(minPrice, maxPrice);
}
    }
