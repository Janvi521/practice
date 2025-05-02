package electro.shop.service;

import electro.shop.model.Product;
import electro.shop.model.Sale;
import electro.shop.dao.SaleDAO;

import java.util.List;

public class SaleService {
    private final SaleDAO saleDAO = new SaleDAO();

    public boolean addSale(int productId, int quantitySold, double revenue) {
        Sale sale = new Sale(0, productId, quantitySold, revenue);
        return saleDAO.addSale(sale);
    }

    public List<Product> getBestSellingProducts() {
        return saleDAO.getBestSellingProducts();  // Fetch data from DAO layer
    }
}
