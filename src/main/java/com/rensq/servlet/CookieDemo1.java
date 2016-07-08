package com.rensq.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by toothbond on 16/7/7.
 */
public class CookieDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            out.print("您上次访问的时间是:");
            for (int i=0; i<cookies.length; i++){
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("lastAccessTime")){
                    Long lastAccessTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastAccessTime);
                    out.print(date.toLocaleString());
                }
            }
        }else {
            out.println("这是您第一次访问本站！");
        }

        Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis() + "");
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
    }
}
