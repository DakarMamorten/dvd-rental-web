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

@WebServlet(name = "AddressByIdServlet", urlPatterns = "/address/find")
public class AddressByIdServlet extends HttpServlet {
    public static final AddressHibernateDAO addressHibernateDAO = new AddressHibernateDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("address",new AddressDTO());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/addressById.jsp");
        try {
            dispatcher.forward(req, resp);
        }
        catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        Long addressId = Long.parseLong((req.getParameter("addressId")));
        AddressDTO addressDTO  = addressHibernateDAO.findById(addressId);
        req.setAttribute("address",addressDTO);
        try{
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/addressById.jsp");
            dispatcher.forward(req,resp);
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
