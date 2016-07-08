package com.rensq.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by toothbond on 16/7/6.
 */
public class ServletConfigDemo1 extends HttpServlet {

    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramValue1 = this.config.getInitParameter("name");
        resp.getWriter().println(paramValue1);

        Enumeration<String> enumeration = this.config.getInitParameterNames();
        while (enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = config.getInitParameter(name);
            resp.getWriter().println("name = " + name + ", value = " + value);
        }

    }
}
