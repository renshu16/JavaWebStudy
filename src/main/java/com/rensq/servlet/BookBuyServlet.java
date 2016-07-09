package com.rensq.servlet;

import com.rensq.dao.BookDB;
import com.rensq.model.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toothbond on 16/7/7.
 * 购买书
 */
public class BookBuyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Book book = BookDB.getAll().get(id);
        HttpSession session = req.getSession();
        List<Book> list = (List<Book>) session.getAttribute("booklist");
        if (list == null){
            list = new ArrayList<Book>();
            session.setAttribute("booklist",list);
        }
        list.add(book);

        String url = resp.encodeRedirectURL(req.getContextPath() + "/servlet/bookcarlist");
        System.out.println(url);
        resp.sendRedirect(url);
    }
}
