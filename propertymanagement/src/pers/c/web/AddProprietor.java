package pers.c.web;

import pers.c.domain.Proprietor;
import pers.c.service.ProprietorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet(name = "AddProprietor", urlPatterns = "/addProprietor")
public class AddProprietor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String p_id = UUID.randomUUID().toString().substring(0,4);
        String p_name = request.getParameter("userRegisterName");
        String p_pwd = request.getParameter("userRegisterPwd");
        String p_sex = request.getParameter("sex");
        String p_a_dong = request.getParameter("dong");
        String p_a_dan = request.getParameter("danyuan");
        String p_a_lou = request.getParameter("lou");
        String p_a_shi = request.getParameter("shi");
        String p_addres = p_a_dong+"栋"+p_a_dan+"单元"+p_a_lou+"楼"+p_a_shi+"室";
        String p_phonenumber = request.getParameter("phoneNumber");
        String p_check_in_time = request.getParameter("inTime");
        Proprietor proprietor = new Proprietor(p_id, p_name, p_pwd,p_sex,p_addres, p_phonenumber,p_check_in_time);
        ProprietorService service = new ProprietorService();
        try {
            service.addProprietor(proprietor);
            response.getWriter()
                    .write("<script type='text/javascript'>alert('注册成功，返回登录');" +
                            "window.history.back(-1);</script>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
