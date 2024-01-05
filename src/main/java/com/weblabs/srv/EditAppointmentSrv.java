
package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.beans.AppointmentBean;
import com.weblabs.service.impl.AppointmentServiceImp;
			
@WebServlet("/EditAppointmentSrv")
public class EditAppointmentSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;

    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       // String status1 = "Edit  Failed!"; 
    	//in jsp order write*****************
        String appointmentID = request.getParameter("appointmentID");
        String customerID= request.getParameter("customerID");
        String vehicleID = request.getParameter("vehicleID");
        String serviceID = request.getParameter("serviceID");
        String appointmentdate = request.getParameter("appointmentdate");
        String status = request.getParameter("status");
        
        AppointmentBean dept = new AppointmentBean();
        //same above order
        dept.setAppointmentID(appointmentID);
        dept.setCustomerID(customerID);
        dept.setVehicleID(vehicleID);
        dept.setServiceID(serviceID);
        dept.setAppointmentdate(appointmentdate);
        dept.setStatus(status);
        //dept.setAppointmentID(appointmentID);
        
        AppointmentServiceImp dao = new AppointmentServiceImp();
   
        String status2 = dao.editA(appointmentID,customerID, vehicleID, serviceID, appointmentdate, status);

        RequestDispatcher rd = request.getRequestDispatcher("appointment_edit.jsp?message=" + status2);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}