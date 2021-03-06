package com.dvdrental.connection.categoryServlet;

import com.dvdrental.dao.categoryDAO.CategoryHibernateDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/category/delete")
public class CategoryDeleteServlet extends HttpServlet {
    private  final CategoryHibernateDAO categoryHibernateDAO = new CategoryHibernateDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            long categoryId = Long.parseLong(req.getParameter("categoryId"));
            categoryHibernateDAO.deleteById(categoryId);
            resp.sendRedirect("/dvd-rental/category");

        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}
