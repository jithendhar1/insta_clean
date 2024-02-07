
package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.service.impl.AddressServiceImpl;

@WebServlet("/AddAddressSrv")
public class AddAddressSrv extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String status1 = "Add  Failed!";
    	 String customerID = request.getParameter("customerID");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String postal_code = request.getParameter("postal_code");
        String state = request.getParameter("state");
        String hno = request.getParameter("hno");
        AddressServiceImpl add = new AddressServiceImpl();
        status1 = add.addV( customerID, street, city, postal_code, state, hno);

       
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}








