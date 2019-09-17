package pers.c.web;

import pers.c.domain.Proprietor;
import pers.c.service.ProprietorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "updateProprietorPwd",urlPatterns = "/updateProprietorPwd")
public class UpdateProprietorPwd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String new_pwd = request.getParameter("new_pwd");
        Proprietor proprietor =(Proprietor) request.getSession().getAttribute("proprietor");
        String p_id = proprietor.getP_id();
        System.out.println(new_pwd+"   "+p_id);
        ProprietorService service = new ProprietorService();
        try {
            service.updateProprietorPwd(p_id, new_pwd);
            request.getSession().removeAttribute("proprietor");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter()
                    .write("<script type='text/javascript'>alert('修改成功，请重新登录');</script>");
            response.setHeader("Refresh","0;URL=http://localhost:8080/login.jsp");
//            response.sendRedirect("/login.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
