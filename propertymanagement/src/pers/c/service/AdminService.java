package pers.c.service;

import java.sql.SQLException;

import pers.c.dao.AdminDao;
import pers.c.domain.Admin;

public class AdminService {

	public Admin findAdmin(String admin_account,String admin_pwd) throws SQLException {
		AdminDao dao = new AdminDao();
		return dao.findAdmin(admin_account,admin_pwd);
	}

}
