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
import java.io.IOException;

@WebServlet("/styleloadidservlet")
public class LoadIdServlet extends HttpServlet{
    SpringConfig springConfig=new SpringConfig();
    StyleRepositoryImpl styleRepository=new StyleRepositoryImpl(springConfig.getJdbcTemplate());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        ServletOutputStream out = response.getOutputStream();

if (id==null){
    out.println("<html>");
    out.println("<head><title>Session example</title></head>");
    out.println("<body>");
    out.println("<h3>select id</h3>");
    out.println("</body>");
    out.println("<html>");
}
else{
    Style style=styleRepository.loadByStyleID(id);
    out.println("<html>");
    out.println("<head><title>Session example</title></head>");
    out.println("<body>");
    out.println("<h3>Style Info:</h3>");
    out.println("<p>Style:" + style.toString() + "</p>");
    out.println("</body>");
    out.println("<html>");
}

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doPost(req, resp);
    }
}
