package pers.c.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "checkImgText",urlPatterns = "/checkImgText")
public class CheckImgText extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imgText = request.getParameter("imgText");
        String imgWord = (String) request.getSession().getAttribute("checkcode_session");
        boolean isTrue = false;
        if(imgText.equals(imgWord))
            isTrue = true;
        response.getWriter().write("{\"isTrue\":" + isTrue + "}");
    }
}
