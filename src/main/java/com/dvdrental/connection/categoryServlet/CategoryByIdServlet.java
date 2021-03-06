package com.dvdrental.connection.categoryServlet;

import com.dvdrental.dao.categoryDAO.CategoryHibernateDAO;
import com.dvdrental.dto.CategoryDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategoryByIdServlet", urlPatterns = "/category/find")
public class CategoryByIdServlet extends HttpServlet {
    private  final CategoryHibernateDAO categoryHibernateDAO = new CategoryHibernateDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        req.setAttribute("category",new CategoryDTO());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/categoryById.jsp");
        try {
            dispatcher.forward(req, resp);
        }
        catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
            Long categoryId = Long.parseLong(req.getParameter("categoryId"));
        CategoryDTO categoryDTO = categoryHibernateDAO.findById(categoryId);
        req.setAttribute("category",categoryDTO);
        try{
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/categoryById.jsp");
            dispatcher.forward(req,resp);
            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
