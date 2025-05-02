package electro11.shops22.model;

public class AdminLogin {
    private String username;
    private String  password;

    public AdminLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  String getUsername() {
        return username;
    }

    public  String getPassword() {
        return password;
    }
}
