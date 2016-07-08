package com.rensq.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by toothbond on 16/7/6.
 */
public class ServletContext1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
//        String url = servletContext.getInitParameter("url");
//        resp.getWriter().println(url);

        String data = "<h1><font color='red'>abcdefghjkl</font></h1>";
        resp.getOutputStream().write(data.getBytes());
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/servlet/context2");
        requestDispatcher.forward(req,resp);




    }
}
