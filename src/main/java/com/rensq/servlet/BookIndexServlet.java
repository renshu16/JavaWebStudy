package com.rensq.servlet;

import com.rensq.dao.BookDB;
import com.rensq.model.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

/**
 * Created by toothbond on 16/7/7.
 * 列出所有的书
 */
public class BookIndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        req.getSession();
        out.write("本网站有如下书：<br/>");
        Set<Map.Entry<String, Book>> bookSet = BookDB.getAll().entrySet();
        for (Map.Entry<String, Book> entry : bookSet){
            Book book = entry.getValue();
            String url = req.getContextPath() + "/servlet/bookbuy?id=" + book.getId();
            url = resp.encodeURL(url);
            out.println(book.getName() + "<a href='"+url+"'>购买</a><br/>");
        }
    }
}
