package com.netcracker.Servlet;

import com.netcracker.config.SpringConfig;
import com.netcracker.entity.Style;
import com.netcracker.infrastructure.repositories.StyleRepositoryImpl;
import com.netcracker.infrastructure.services.ServiceStyle;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/login")
public class ExampelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletOutputStream out = response.getOutputStream();

        out.println("<html>");
        out.println("<head><title>Session example</title></head>");
        out.println("<body>");
        out.println("<h3>You are logined!, info stored in session</h3>");
        out.println("<p><a href='styleloadallservlet'>View all styles</a><p>");
        out.println("<p><a href='styleloadidservlet'>View style by id</a><p>");
        out.println("<p><a href='addservlet'>add style</a><p>");
        out.println("</body>");
        out.println("<html>");
    }

@Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException
    {
        super.doPost(request,response);
    }
}
