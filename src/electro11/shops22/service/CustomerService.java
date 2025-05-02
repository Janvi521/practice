package electro11.shops22.service;

import electro11.shops22.dao.CustomerDao;
import electro11.shops22.model.CustomerCreateAccount;
import electro11.shops22.model.CustomerLogin;

import java.sql.SQLException;

public class CustomerService {
    public CustomerDao customerDao;

    //costructor
public CustomerService()
{
    this.customerDao= new CustomerDao();
}
    //
    public void addCustomerCreateAccount(CustomerCreateAccount customerCreateAccount) throws SQLException {
    customerDao.createAccount(customerCreateAccount);
    }

    public boolean checkCustomerDatail( CustomerLogin customerLogin) throws SQLException {

        return customerDao.checkPassword(customerLogin);
    }
}
