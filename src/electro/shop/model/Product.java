package electro.shop.model;

public class Product {
    private int productId;
    private String name;
    private double price;
    private String brand;
    private int stockQuantity;

    public Product(int productId, String name, double price, String brand, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.stockQuantity = stockQuantity;
    }

    // Getters

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }


    //  Setters

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
