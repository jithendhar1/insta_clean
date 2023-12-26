

package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.service.impl.ServiceServiceImpl;

@WebServlet("/AddServiceSrv")
public class AddServiceSrv  extends HttpServlet {

		private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	//serviceID, servicename, description, price, discount, coupons
	    	
	    	String status1 = "Add Bidding Failed!";
	        String servicename = request.getParameter("servicename");
	        String description = request.getParameter("description");
	        String price = request.getParameter("price");
	        String discount = request.getParameter("discount"); 
	        String coupons = request.getParameter("coupons");
	       
	      
	        ServiceServiceImpl add =new ServiceServiceImpl();
	        status1=add.addS( servicename, description, price, discount, coupons);
	  	  
	    		   RequestDispatcher rd = request.getRequestDispatcher("add_.jsp?message=" + status1);
	       rd.forward(request, response);
	    } 
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        doGet(request, response);
	    }
	}