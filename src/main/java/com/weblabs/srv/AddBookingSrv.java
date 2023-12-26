

package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.service.impl.BookingServiceImpl;

@WebServlet("/AddBookingSrv")
public class AddBookingSrv  extends HttpServlet {

		private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	//bookingID, vehicleID, appointmentID, serviceID
	    	
	    	String status1 = "Add Bidding Failed!";
	        String vehicleID = request.getParameter("vehicleID");
	        String appointmentID = request.getParameter("appointmentID");
	        String serviceID = request.getParameter("serviceID");
	      
	      
	        BookingServiceImpl add =new BookingServiceImpl();
	        status1=add.addB(vehicleID, appointmentID, serviceID);
	  	  
	    		   RequestDispatcher rd = request.getRequestDispatcher("add_.jsp?message=" + status1);
	       rd.forward(request, response);
	    } 
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        doGet(request, response);
	    }
	}