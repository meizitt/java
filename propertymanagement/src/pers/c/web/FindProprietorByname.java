package pers.c.web;

import pers.c.domain.ProprietorRecord;
import pers.c.service.RecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "findProprietorByname", urlPatterns = "/findProprietorByname")
public class FindProprietorByname extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String p_name = request.getParameter("p_name");
        RecordService service = new RecordService();
        try {
            List<ProprietorRecord> allRecord = service.findAllRecord(p_name);
            request.setAttribute("allRecord", allRecord);
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
