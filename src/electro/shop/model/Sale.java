package electro.shop.model;

public class Sale {
    private int saleId;
    private int productId;
    private int quantitySold;
    private double revenue;

    public Sale(int saleId, int productId, int quantitySold, double revenue) {
        this.saleId = saleId;
        this.productId = productId;
        this.quantitySold = quantitySold;
        this.revenue = revenue;
    }

    // Getters and Setters

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}
