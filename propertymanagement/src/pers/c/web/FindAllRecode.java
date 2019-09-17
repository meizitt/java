package pers.c.web;

import pers.c.domain.Proprietor;
import pers.c.domain.ProprietorRecord;
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
import java.util.List;

@WebServlet(name = "findAllRecode", urlPatterns = "/findAllRecode")
public class FindAllRecode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecordService service = new RecordService();
        List<ProprietorRecord> proprietorRecordList;
        try {
            proprietorRecordList = service.findAllRecord();
            request.setAttribute("proprietorRecordList",proprietorRecordList);
            request.getRequestDispatcher("admin.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
