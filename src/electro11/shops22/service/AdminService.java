package electro11.shops22.service;


import electro11.shops22.dao.AdminDao;
import electro11.shops22.model.AdminLogin;

import java.sql.SQLException;

public class AdminService {
        public AdminDao adminDao;



    public AdminService() {
        this.adminDao = new AdminDao();
    }

   public boolean checkAddminDatail( AdminLogin adminLogin) throws SQLException {

        return adminDao.checkPassword(adminLogin);
   }
    }


