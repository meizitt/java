package pers.c.web;

import pers.c.service.RecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "delRecordByRid",urlPatterns = "/delRecordByRid")
public class DelRecordByRid extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String r_id=request.getParameter("r_id");
        RecordService service = new RecordService();
        try {
            service.delRecordByRid(r_id);
             response.sendRedirect("/admin.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
