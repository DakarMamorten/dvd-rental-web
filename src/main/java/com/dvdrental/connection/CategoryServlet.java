package com.dvdrental.connection;

import com.dvdrental.dao.CategoryHibernateDAO;
import com.dvdrental.dto.CategoryDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategoryServlet", urlPatterns = "/category")
public class CategoryServlet extends HttpServlet {
	private static final CategoryHibernateDAO categoryHibernateDAO = new CategoryHibernateDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

		req.setAttribute("category", categoryHibernateDAO.findAll());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/category.jsp");
		try {
			dispatcher.forward(req, resp);
		}
		catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		String categoryName = req.getParameter("categoryName");
		CategoryDTO category = new CategoryDTO(categoryName);
		categoryHibernateDAO.save(category);
        try{
            resp.sendRedirect("/dvd-rental/category");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
