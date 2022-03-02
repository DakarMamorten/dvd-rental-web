package com.dvdrental.connection.controller;

import com.dvdrental.dao.address.AddressHibernateDAO;
import com.dvdrental.dto.AddressDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/address/page")
public class PageServlet extends HttpServlet {
	public static final AddressHibernateDAO addressHibernateDAO = new AddressHibernateDAO();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = Integer.parseInt(request.getParameter("pageNumber"));
		final List<AddressDTO> list = addressHibernateDAO.findAllByPage(currentPage);
		request.setAttribute("address",list);
		int pages = addressHibernateDAO.countPages();
		request.setAttribute("pages", pages);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/address/list.jsp");
		try {
			dispatcher.forward(request, response);
		}
		catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
