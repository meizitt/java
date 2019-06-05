package pers.c.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class c3p0Utils {
	private static ComboPooledDataSource dataSource;

	/**
	 * 从c3p0输入数据库名称中获取数据源
	 * 
	 * @param database
	 * @return
	 */
	public static DataSource getDataSource(String database) {
		dataSource = new ComboPooledDataSource(database);
		return dataSource;
	}

	/**
	 *从c3p0输入数据库名称 获得conn连接
	 * 
	 * @return
	 */
	public static Connection getConnection(String database) {
		Connection conn = null;
		try {
			dataSource = new ComboPooledDataSource(database);
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
