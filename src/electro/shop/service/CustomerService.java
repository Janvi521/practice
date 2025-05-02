package electro.shop.service;

import electro.shop.model.Customer;
import electro.shop.dao.CustomerDAO;

public class CustomerService {
    private final CustomerDAO customerDAO = new CustomerDAO();

    public boolean addCustomer(String username, String password, String email, String phone) {
        Customer customer = new Customer(0, username, password, email, phone);
        return customerDAO.addCustomer(customer);
    }

    public boolean authenticateCustomer(String username, String password) {
        return customerDAO.authenticateCustomer(username, password);
    }


}
