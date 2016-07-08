package com.rensq.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by toothbond on 16/7/7.
 */
public class SessionDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建session
        createSessionDemo(req, resp);
    }

    private void createSessionDemo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        session.setAttribute("data","就觉得心疼");
        String sessionId = session.getId();
        if (session.isNew()){
            resp.getWriter().print("session创建成功，session的id是："+sessionId);
        }else{
            resp.getWriter().print("服务器已经存在该session了，session的id是："+sessionId);
        }
    }
}
