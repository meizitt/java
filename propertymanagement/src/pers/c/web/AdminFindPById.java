package pers.c.web;

import pers.c.domain.Proprietor;
import pers.c.domain.Record;
import pers.c.service.ProprietorService;
import pers.c.service.RecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "adminFindPById", urlPatterns = "/adminFindPById")
public class AdminFindPById extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_id = request.getParameter("p_id");
        ProprietorService service = new ProprietorService();
        boolean isExist = false;
        try {
            Proprietor proprietor = service.findProprietorById(p_id);
            if (proprietor != null)
                isExist = true;
            response.getWriter().write("{\"isExist\":" + isExist + "}");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
