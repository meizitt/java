package pers.c;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import pers.c.domain.user;
import pers.c.utils.c3p0Utils;

/**
 * 注册
 * 
 * @author 爸爸，你好 2019年5月18日
 */
public class userRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public userRegister() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码方式，防止乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取用户名和密码
		String username = request.getParameter("r_username");
		String password = request.getParameter("r_password");
		String email = request.getParameter("email");
		String[] hobbys = request.getParameterValues("hobby");
		String hobby = "";
		for (int i = 0; i < hobbys.length; i++) {
			hobby = hobby + " " + hobbys[i];
			System.out.print(hobbys[i]);
		}
		System.out.println(hobby);
		// 主键id为时间
		Date date = new Date();

		// 从数据库中验证用户名和密码
		QueryRunner runner = new QueryRunner(c3p0Utils.getDataSource("web06"));
		String sqlCheck = "select * from user where username=?";
		String sqlInsert = "insert into user(id,username,password,email,hobby) values(?,?,?,?,?)";
		user user = null;
		try {
			user = runner.query(sqlCheck, new BeanHandler<user>(user.class), username);
			if (user != null) {
				response.getWriter()
						.write("<script type='text/javascript'>alert('用户名重复，请重新注册');window.history.back(-1);</script>");
			} else {
				int rows = runner.update(sqlInsert, date, username, password, email, hobby);
				if (rows > 0) {
					// 插入成功
					response.sendRedirect("/web06/success.html");
				} else {
					// 插入失败
					response.sendRedirect("/web06/fail.html");
				}
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
