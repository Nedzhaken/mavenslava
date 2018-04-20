package com.netcracker;

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

@WebServlet("/addservlet")
public class AddServlet extends HttpServlet{
    SpringConfig springConfig=new SpringConfig();
    StyleRepositoryImpl styleRepository=new StyleRepositoryImpl(springConfig.getJdbcTemplate());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        ServletOutputStream out = response.getOutputStream();

        if (id==null||name==null){
            out.println("<html>");
            out.println("<head><title>Session example</title></head>");
            out.println("<body>");
            out.println("<h3>add style parameter</h3>");
            out.println("</body>");
            out.println("<html>");
        }
        else{
            styleRepository.insert(new Style(id,name));
            out.println("<html>");
            out.println("<head><title>Session example</title></head>");
            out.println("<body>");
            out.println("<h3>add success</h3>");
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
