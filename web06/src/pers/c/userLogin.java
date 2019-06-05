package pers.c;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import pers.c.domain.user;
import pers.c.utils.c3p0Utils;

/**
 * 登录
 * @author 爸爸，你好
 *2019年5月18日
 */
public class userLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public userLogin() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码方式，防止乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取用户名和密码
		String username = request.getParameter("l_username");
		String password = request.getParameter("l_password");
		// 从数据库中验证用户名和密码
		QueryRunner runner = new QueryRunner(c3p0Utils.getDataSource("web06"));
		String sql = "select * from user where username=? and password=?";
		user user = null;
		try {
			user = runner.query(sql, new BeanHandler<user>(user.class), username, password);
			if (user != null) {
				// 存在该用户
				// 实现定时刷新和跳转
//				response.setHeader("Refresh", "1;URL=http://localhost:8081/web06/welcome.html");
				// 重定向
				response.sendRedirect("/web06/welcome.html");
			} else {
				// 不存在该用户
				response.sendRedirect("/web06/loginfail.html");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
