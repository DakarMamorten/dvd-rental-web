package com.dvdrental.connection.customer_servlet;

import com.dvdrental.dao.customer.CustomerHibernateDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sergey Manko
 */
@WebServlet(urlPatterns = "/customer/list")
public class CustomerServlet extends HttpServlet {
	final CustomerHibernateDAO customerHibernateDAO = new CustomerHibernateDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("customer",customerHibernateDAO.findAll());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/customer/list.jsp");
		try {
			dispatcher.forward(req, resp);
		}
		catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
