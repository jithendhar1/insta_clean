
package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.service.impl.VechicleServiceImpl;

import javax.servlet.RequestDispatcher;
@WebServlet("/DeleteVechicleSrv")
public class DeleteVechicleSrv  extends HttpServlet {

	    private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	  
	    	String vehicleID = request.getParameter("vehicleID");

	    	VechicleServiceImpl b = new VechicleServiceImpl();

			String status = b.deleteV(vehicleID);
			
	        RequestDispatcher rd = request.getRequestDispatcher("delete_vechicle.jsp?message=" + status);
	        rd.forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        doGet(request, response);
	    }
	}


