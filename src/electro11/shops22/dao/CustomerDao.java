package electro11.shops22.dao;
import java.sql.*;

import electro11.shops22.model.CustomerCreateAccount;
import electro11.shops22.model.CustomerLogin;

public class CustomerDao {
   // CustomerCreateAccount costomerCreateAccount;
    public static final String url="jdbc:mysql://localhost:3306/project";
    public static final String user="root";
    public static final String password= "Janvi@123";
     private Connection getConnection() throws  SQLException{
         return DriverManager.getConnection(url,user,password);
     }

     public void createAccount(CustomerCreateAccount customerCreateAccount) throws  SQLException{
         String sql = "insert into CostomerCreateAccountDatail(firstName ,lastName ,phoneNumber ,emailAddress ,emailpassword ,UserPassword) values(?,?,?,?,?,?)";
         try (Connection con = getConnection();
              PreparedStatement pstmt = con.prepareStatement(sql)) {

             pstmt.setString(1, customerCreateAccount.getFirstName());
             pstmt.setString(2, customerCreateAccount.getLastName());
             pstmt.setString(3, customerCreateAccount.getPhoneNumber());
             pstmt.setString(4, customerCreateAccount.getEmailAddress());
             pstmt.setString(5, customerCreateAccount.getEmailpassword());
             pstmt.setString(6,customerCreateAccount.getUserPassword());

             pstmt.executeUpdate();
         } catch (SQLException e) {
             System.err.println("Error while creating account: " + e.getMessage());
             throw e;  // Optionally rethrow or handle accordingly
         }

     }

    public boolean checkPassword(CustomerLogin customerLogin) throws  SQLException {
        String sql = "SELECT password FROM admin WHERE BINARY username = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {


            pstmt.setString(1, customerLogin.getUserName().trim()); // Set username dynamically

            try (ResultSet rst = pstmt.executeQuery()) {
                if (rst.next()) {  // Check if result exists
                    String storedPassword = rst.getString("password").trim();
                    System.out.println("🔎 Stored Password: " + storedPassword);
                    System.out.println("🔎 Entered Password: " + customerLogin.getPassword());
                    return storedPassword.equals(customerLogin.getPassword().trim());
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Database error: " + e.getMessage());
        }
        return false; // Return false if no matching username/password found
    }



}
