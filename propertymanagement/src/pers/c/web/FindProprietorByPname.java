package pers.c.web;

import pers.c.dao.ProprietorDao;
import pers.c.domain.Proprietor;
import pers.c.service.ProprietorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

@WebServlet(name = "findProprietorByName", urlPatterns = "/findProprietorByName")
public class FindProprietorByPname extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_name = request.getParameter("p_name");
        p_name = URLDecoder.decode(p_name, "UTF-8");
        ProprietorService service = new ProprietorService();
        boolean isExist = false;
        try {
            Proprietor proprietor = service.findProprietorByName(p_name);
            if (proprietor != null)
                isExist = true;
            response.getWriter().write("{\"isExist\":" + isExist + "}");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
