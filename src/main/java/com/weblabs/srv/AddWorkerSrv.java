

package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.service.impl.WorkerServiceImpl;

@WebServlet("/AddWorkerSrv")
public class AddWorkerSrv  extends HttpServlet {

		private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	    	String status = "Add  Failed!";
	        String worker_name = request.getParameter("worker_name");
	        String phno = request.getParameter("phno");
	        String address = request.getParameter("address");
	        String salary = request.getParameter("salary"); 
	       
	      
	        WorkerServiceImpl add =new WorkerServiceImpl();
	        status=add.addW( worker_name, phno, address, salary);
	  	  
	    		   RequestDispatcher rd = request.getRequestDispatcher("add_.jsp?message=" + status);
	       rd.forward(request, response);
	    } 
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        doGet(request, response);
	    }
	}