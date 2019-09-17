package pers.c.web;

import pers.c.domain.Proprietor;
import pers.c.service.ProprietorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "findProprietor", urlPatterns = "/findProprietor")
public class FindProprietor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProprietorService service = new ProprietorService();
        String p_name = request.getParameter("userLoginName");
        String p_pwd = request.getParameter("userLoginPwd");
        response.setContentType("text/html;charset=utf-8");
        try {
            Proprietor proprietor = service.findProprietor(p_name, p_pwd);
            if (proprietor != null){
                HttpSession session = request.getSession();
                session.setAttribute("proprietor",proprietor);
                response.sendRedirect("/proprietor.jsp");
            }
            else
                response.getWriter()
                        .write("<script type='text/javascript'>alert('账户或者密码错误，请重新登录');" +
                                "window.history.back(-1);</script>");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
