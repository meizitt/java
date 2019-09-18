package pers.c.web;

import pers.c.service.ProprietorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "delProprietorById" ,urlPatterns = "/deleteProprietorById")
public class DelProprietorById extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_id = request.getParameter("p_id");
        ProprietorService service = new ProprietorService();
        try {
            service.deleteById(p_id);
            response.sendRedirect("/findAllProprietor");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
