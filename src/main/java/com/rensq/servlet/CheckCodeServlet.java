package com.rensq.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by toothbond on 16/7/6.
 * 服务器端接收到验证码后的处理
 */
public class CheckCodeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientPostCode = req.getParameter("validateCode");
        String serverCheckCode = (String) req.getSession().getAttribute("checkcode");
        if (null != clientPostCode && clientPostCode.equals(serverCheckCode)){
            System.out.println("验证码验证通过！");
        }else{
            System.out.println("验证码验证失败！");
        }

    }
}
