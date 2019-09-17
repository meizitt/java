package pers.c.web;

import pers.c.domain.Record;
import pers.c.service.RecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "updateRecord", urlPatterns = "/updateRecord")
public class UpdateRecord extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecordService service = new RecordService();
        String r_id = request.getParameter("r_id");
        String p_id = request.getParameter("p_id");
        String money = request.getParameter("money");
        String r_remark = request.getParameter("remark");
        String time = request.getParameter("time");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date changeTime = null;
        try {
            changeTime = format.parse(time);
            java.sql.Date r_time = new java.sql.Date(changeTime.getTime());
            double r_money = Double.parseDouble(money);
            Record record = new Record(r_id, p_id, r_time, r_money, r_remark);
            service.UpdateRecord(record);
            response.sendRedirect("/admin.jsp");
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }
}
