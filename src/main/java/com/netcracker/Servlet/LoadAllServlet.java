package com.netcracker.Servlet;

import com.netcracker.config.SpringConfig;
import com.netcracker.entity.Style;
import com.netcracker.infrastructure.repositories.StyleRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/styleloadallservlet")
public class LoadAllServlet extends HttpServlet{
    SpringConfig springConfig=new SpringConfig();

    StyleRepositoryImpl styleRepository=new StyleRepositoryImpl(springConfig.getJdbcTemplate());

    List<Style> styleList=styleRepository.loadAll();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();

        // Получить объект HttpSession.
        HttpSession session = request.getSession();

        // Получить объект UserInfo сохраненный в session
        // после того, как пользователь успешно вошел в систему (login).
        List<Style> styleloadall = (List) session.getAttribute("styleloadall");

        // Если еще не вошел в систему (login), Redirect (перенаправить) на страницу login (LoginServlet).

        out.println("<html>");
        out.println("<head><title>Session example</title></head>");

        out.println("<body>");

        out.println("<h3>Style Info:</h3>");
        for(int i=0;i<styleList.size();i++){
            out.println("<p>Style:" + styleList.get(i).toString() + "</p>");
        }
        out.println("</body>");
        out.println("<html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doPost(req, resp);
    }
}
