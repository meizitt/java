package pers.c.web;

import pers.c.domain.Admin;
import pers.c.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "FindAdmin", urlPatterns = "/findAdmin")
public class FindAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String admin_accout = request.getParameter("adminName");
        String admin_pwd = request.getParameter("adminPwd");
        AdminService service = new AdminService();
        try {
            Admin admin = service.findAdmin(admin_accout, admin_pwd);

            if (admin != null){
                HttpSession session = request.getSession();
                session.setAttribute("admin",admin);
                response.sendRedirect("/admin.jsp");
            }
            else{
                response.getWriter()
                        .write("<script type='text/javascript'>alert('账户或者密码错误，请重新登录');" +
                                "window.history.back(-1);</script>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
