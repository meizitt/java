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
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "addRecord", urlPatterns = "/addRecord")
public class AddRecord extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String r_id = UUID.randomUUID().toString().substring(0,6);
        Date date_now = new Date();
        java.sql.Date date = new java.sql.Date(date_now.getTime());
        String p_id = request.getParameter("p_id");
        String money = request.getParameter("money");
        String r_remark = request.getParameter("remark");
        double r_money=Double.parseDouble(money);
        Record record = new Record(r_id, p_id, date, r_money, r_remark);
        RecordService service = new RecordService();
        response.setContentType("text/html;charset=utf-8");
        try {
            service.addRecord(record);
            response.getWriter()
                    .write("<script type='text/javascript'>alert('添加成功');" +
                            "window.history.back(-1);</script>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
