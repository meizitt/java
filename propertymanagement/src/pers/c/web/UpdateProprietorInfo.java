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

@WebServlet(name = "updateProprietorInfo",urlPatterns = "/updateProprietorInfo")
public class UpdateProprietorInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_id = request.getParameter("p_id");
        String p_name = request.getParameter("userRegisterName");
        String p_sex = request.getParameter("sex");
        String p_a_dong = request.getParameter("dong");
        String p_a_dan = request.getParameter("danyuan");
        String p_a_lou = request.getParameter("lou");
        String p_a_shi = request.getParameter("shi");
        String p_addres = p_a_dong+"栋"+p_a_dan+"单元"+p_a_lou+"楼"+p_a_shi+"室";
        String p_phonenumber = request.getParameter("phoneNumber");
        String p_check_in_time = request.getParameter("inTime");
        ProprietorService service=new ProprietorService();
        try {
            Proprietor proprietor = new Proprietor(p_id,p_name,"",p_sex,p_addres,p_phonenumber,p_check_in_time);
            service.updateProprietorInfo(proprietor);
            response.sendRedirect("/admin.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
