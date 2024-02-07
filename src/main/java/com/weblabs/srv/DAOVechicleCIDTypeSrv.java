
package com.weblabs.srv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.weblabs.DAO.VechicleDAO;
import com.weblabs.beans.VechicleBean;

@WebServlet("/DAOVechicleCIDTypeSrv")
public class DAOVechicleCIDTypeSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
        String customerID = request.getParameter("customerID");
        String vehicleType = request.getParameter("vehicleType");
    
        // Your existing servlet code here
        List<VechicleBean> allVehicless = getVechcilewithtype(customerID,vehicleType);

       
        // Convert the list to JSON
        String jsonResponse = new Gson().toJson(allVehicless);

        // Set the content type and write the JSON response
        response.setContentType("application/json");
        response.getWriter().write(jsonResponse);
    }

  

    public List<VechicleBean> getVechcilewithtype(String customerID,String vehicleType) {
        List<VechicleBean> allVehicles = VechicleDAO.getVehiclesByCustomerIDAndVehicleType(customerID,vehicleType);
        return allVehicles;
    }

    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}