package pers.c.web;

import pers.c.domain.Proprietor;
import pers.c.domain.Record;
import pers.c.service.RecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "findAllRecordByPid",urlPatterns = "/findAllRecordByPid")
public class FindAllRecordByPid extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_id=request.getParameter("p_id");
        RecordService service = new RecordService();
        try {
            List<Record> recordList = service.findAllRecordByPid(p_id);
            request.setAttribute("recordList",recordList);
            request.getRequestDispatcher("proprietor.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
