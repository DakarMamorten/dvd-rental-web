package com.dvdrental.connection;

import com.dvdrental.dao.CategoryHibernateDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategoryServlet", urlPatterns = "/category")
public class CategoryServlet extends HttpServlet {
    private static final CategoryHibernateDAO category = new CategoryHibernateDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("category", category.findAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/category.jsp");
        dispatcher.forward(req, resp);
    }
}
