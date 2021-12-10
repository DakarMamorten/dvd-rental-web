package com.dvdrental.connection.addressServlet;

import com.dvdrental.dao.addressDAO.AddressHibernateDAO;
import com.dvdrental.dto.AddressDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddressServlet", urlPatterns = "/address")
public class AddressServlet  extends HttpServlet {
    public static final AddressHibernateDAO addressHibernateDAO = new AddressHibernateDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        req.setAttribute("address",addressHibernateDAO.findAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/address.jsp");
        try {
            dispatcher.forward(req, resp);
        }
        catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
         String address = req.getParameter("address");
         String address2 = req.getParameter("address2");
         String district = req.getParameter("district");
         int cityId = Integer.parseInt(req.getParameter("cityId"));
         String postalCode = req.getParameter("postalCode");
         String phone = req.getParameter("phone");
        AddressDTO addressDTO = new AddressDTO(address,address2,district,cityId,postalCode,phone);

        addressHibernateDAO.save(addressDTO);
        try{
            resp.sendRedirect("/dvd-rental/address");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
