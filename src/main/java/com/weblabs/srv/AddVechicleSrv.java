
package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.service.impl.VechicleServiceImpl;

@WebServlet("/AddVechicleSrv")
public class AddVechicleSrv extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Your existing servlet code here

        String status = "Add Failed!";
        String customerID = request.getParameter("customerID");
        String vehicleType = request.getParameter("vehicleType");
        String vehicleModel = request.getParameter("vehicleModel");
        String VIN = request.getParameter("VIN");
        String brand = request.getParameter("brand");
        
        VechicleServiceImpl add = new VechicleServiceImpl();
        status = add.addV(customerID, vehicleType, vehicleModel, VIN,brand);

        response.getWriter().write("success");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}








