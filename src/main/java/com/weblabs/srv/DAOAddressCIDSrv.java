
package com.weblabs.srv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.weblabs.DAO.AddressDAO;
import com.weblabs.beans.AddressBean;

@WebServlet("/DAOAddressCIDSrv")
public class DAOAddressCIDSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
        String customerID = request.getParameter("customerID");
    
        // Your existing servlet code here
        List<AddressBean> alladdresses = getAddress(customerID);

       
        // Convert the list to JSON
        String jsonResponse = new Gson().toJson(alladdresses);

        // Set the content type and write the JSON response
        response.setContentType("application/json");
        response.getWriter().write(jsonResponse);
    }

  

    public List<AddressBean> getAddress(String customerID) {
        List<AddressBean> alladds = AddressDAO.getAddressByCustomerID(customerID);
        return alladds;
    }

    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}