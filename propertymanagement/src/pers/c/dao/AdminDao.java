package pers.c.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import pers.c.domain.Admin;
import pers.c.utils.DataSourceUtils;

public class AdminDao {

	public Admin findAdmin(String admin_account,String admin_pwd) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from admin where admin_account=? and admin_pwd=?";
		Admin admin = runner.query(sql, new BeanHandler<Admin>(Admin.class), admin_account,admin_pwd);
		return admin;
		
	}

}
