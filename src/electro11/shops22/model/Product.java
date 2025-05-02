package electro11.shops22.model;

public class Product {
    private String p_Id;
    private String p_Name;
    private String p_Category;
    private String p_Price;

    public Product(String p_Id, String p_Name, String p_Category, String p_Price) {
        this.p_Id = p_Id;
        this.p_Name = p_Name;
        this.p_Category = p_Category;
        this.p_Price = p_Price;
    }

    public void setP_Id(String p_Id) {
        this.p_Id = p_Id;
    }

    public void setP_Name(String p_Name) {
        this.p_Name = p_Name;
    }

    public void setP_Category(String p_Category) {
        this.p_Category = p_Category;
    }

    public void setP_Price(String p_Price) {
        this.p_Price = p_Price;
    }

    public String getP_Id() {
        return p_Id;
    }

    public String getP_Name() {
        return p_Name;
    }

    public String getP_Category() {
        return p_Category;
    }

    public String getP_Price() {
        return p_Price;
    }
}
