
package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.beans.VechicleBean;
import com.weblabs.service.impl.VechicleServiceImpl;
			
@WebServlet("/EditVechicleSrv")
public class EditVechicleSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;

    //vehicleID, customerID, vehicleType, vehicleModel, VIN

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       // String status = "Edit  Failed!"; 
        String vehicleID= request.getParameter("vehicleID");
        String customerID = request.getParameter("customerID");
        String vehicleType = request.getParameter("vehicleType");
        String vehicleModel = request.getParameter("vehicleModel");
        String VIN = request.getParameter("VIN");
        
        
        VechicleBean dept = new VechicleBean();
        dept.setVehicleID(vehicleID);
        dept.setCustomerID(customerID);
        dept.setVehicleType(vehicleType);
        dept.setVehicleModel(vehicleModel);
        dept.setVIN(VIN);
        
        
        VechicleServiceImpl dao = new VechicleServiceImpl();
   
        String status1 = dao.editV(vehicleID, customerID, vehicleType, vehicleModel, VIN);

        RequestDispatcher rd = request.getRequestDispatcher("edit_vechicle.jsp?message=" + status1);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}