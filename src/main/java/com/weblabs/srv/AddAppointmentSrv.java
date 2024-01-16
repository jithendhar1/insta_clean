
package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.service.impl.AppointmentServiceImp;

@WebServlet("/AddAppointmentSrv")
public class AddAppointmentSrv  extends HttpServlet {

		private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	//appointmentID, customerID, vehicleID, serviceID, appointmentdate, status
	    	
	    	String status1 = "Add Bidding Failed!";
	        String customerID = request.getParameter("customerID");
	        String vehicleID = request.getParameter("vehicleID");
	        String serviceID = request.getParameter("serviceID");
	        String appointmentdate = request.getParameter("appointmentdate"); 
	        String appointmenttime = request.getParameter("appointmenttime"); 
	        String status = request.getParameter("status");
	       
	      
	        AppointmentServiceImp add =new AppointmentServiceImp();
	        status1=add.addA(customerID, vehicleID, serviceID, appointmentdate,appointmenttime,status);
	  	  
	    		   RequestDispatcher rd = request.getRequestDispatcher("add_appointment.jsp?message=" + status1);
	       rd.forward(request, response);
	    } 
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        doGet(request, response);
	    }
	}