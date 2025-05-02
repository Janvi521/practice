package electro.shop.model;

public class Customer {
    private int customerId;
    private String username;
    private String password;
    private String email;
    private String phone;

    public Customer(int customerId, String username, String password, String email, String phone) {
        this.customerId = customerId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    // Getters  & setter

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



}
