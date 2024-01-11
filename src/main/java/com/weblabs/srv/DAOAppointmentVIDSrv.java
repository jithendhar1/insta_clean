
package com.weblabs.srv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.weblabs.DAO.AppointmentDAO;
import com.weblabs.beans.AppointmentBean;

@WebServlet("/DAOAppointmentVIDSrv")
public class DAOAppointmentVIDSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
    	 // Get customerID from request parameter
        String vehicleID = request.getParameter("vehicleID");
    
        // Your existing servlet code here
        List<AppointmentBean> allAppointment = getAppointment(vehicleID);

       
        // Convert the list to JSON
        String jsonResponse = new Gson().toJson(allAppointment);

        // Set the content type and write the JSON response
        response.setContentType("application/json");
        response.getWriter().write(jsonResponse);
    }

  

    public List<AppointmentBean> getAppointment(String vehicleID) {
        List<AppointmentBean> allAppointments = AppointmentDAO.getAppointmentByVehicleID(vehicleID);
        return allAppointments;
    }

    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}