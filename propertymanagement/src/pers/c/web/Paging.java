package pers.c.web;

import pers.c.domain.PageBean;
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
import java.util.Set;

@WebServlet(name = "paging", urlPatterns = "/paging")
public class Paging extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Proprietor proprietor = (Proprietor) request.getSession().getAttribute("proprietor");
        String p_id = proprietor.getP_id();

        String currentPageStr = request.getParameter("currentPage");
        if (currentPageStr.isEmpty())
            currentPageStr = "1";
        int currentPage = Integer.parseInt(currentPageStr);
//        System.out.println(currentPage);
//        int currentPage = 2;
        int currentCount = 3;
        RecordService service = new RecordService();
        PageBean pageBean = null;
        try {
            pageBean = service.findPageBean(p_id, currentPage, currentCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("pageBean", pageBean);

        request.getRequestDispatcher("/proprietor.jsp").forward(request, response);
    }
}
