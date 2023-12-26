
package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.service.impl.AppointmentServiceImp;

import javax.servlet.RequestDispatcher;
@WebServlet("/DeleteAppointmentSrv")
public class DeleteAppointmentSrv  extends HttpServlet {

	    private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	  
	    	String appointmentID = request.getParameter("appointmentID");

	    	AppointmentServiceImp b = new AppointmentServiceImp();

			String status = b.deleteA(appointmentID);
			
	        RequestDispatcher rd = request.getRequestDispatcher("delete_.jsp?message=" + status);
	        rd.forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        doGet(request, response);
	    }
	}


