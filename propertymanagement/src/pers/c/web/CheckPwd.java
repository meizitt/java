package pers.c.web;

import pers.c.domain.Proprietor;
import pers.c.service.ProprietorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "checkPwd", urlPatterns = "/checkPwd")
public class CheckPwd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String old_pwd = request.getParameter("old_pwd");
        Proprietor proprietor = (Proprietor) request.getSession().getAttribute("proprietor");
        System.out.println("old pwd  "+old_pwd);
        System.out.println(proprietor.getP_pwd());
        boolean is_true = false;
        if (old_pwd.equals(proprietor.getP_pwd()))
            is_true = true;
        response.getWriter().write("{\"is_true\":" + is_true + "}");
        System.out.println(is_true);
    }
}
