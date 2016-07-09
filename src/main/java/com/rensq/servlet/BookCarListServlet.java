package com.rensq.servlet;

import com.rensq.model.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by toothbond on 16/7/7.
 * 已经购买的书
 */
public class BookCarListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        List<Book> list = (List<Book>) session.getAttribute("booklist");
        if (list == null || list.size() <= 0){
            out.write("对不起，您还没有购买任何商品!!");
            return;
        }

        out.write("您买过如下商品:<br>");
        for (Book book : list){
            out.write(book.getName() + "<br/>");
        }

    }
}
