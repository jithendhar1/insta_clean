package com.weblabs.srv;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.weblabs.DAO.CustomerDAO;
import com.weblabs.beans.CustomerBean;

@WebServlet("/DAOCustomerProfileCIDSrv")
public class DAOCustomerProfileCIDSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	 String customerID = request.getParameter("customerID");
    	 
        List<CustomerBean> all = getCustomer(customerID);

        // Convert the list to JSON
        String jsonResponse = new Gson().toJson(all);

        // Set the content type and write the JSON response
        response.setContentType("application/json");
        response.getWriter().write(jsonResponse);
    }

    // Your existing servlet code here

    public List<CustomerBean> getCustomer(String customerID) {
        List<CustomerBean> all = CustomerDAO.getCustomerProfileByCustomerID(customerID);
        return all;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}