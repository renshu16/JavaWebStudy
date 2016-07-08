package com.rensq.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by toothbond on 16/7/7.
 */
public class RequestDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = "request对象同时也是一个域对象(Map容器)";
        req.setAttribute("data",data);
        req.getRequestDispatcher("/test.jsp").forward(req,resp);
    }
}
