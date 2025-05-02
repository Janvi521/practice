package electro.shop.service;

import electro.shop.dao.AdminDAO;
import electro.shop.model.AdminLogin;
import electro.shop.dao.AdminDAO;

import java.sql.SQLException;

public class AdminService {
    private final AdminDAO adminDao;
    AdminDAO adminDAO ;
    public AdminService() {
        this.adminDao = new AdminDAO();
    }

    public boolean checkAdminDetail(AdminLogin adminLogin) throws SQLException {
        return adminDao.validateAdmin(adminLogin);
    }
}

