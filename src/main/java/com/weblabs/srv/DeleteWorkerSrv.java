
package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.service.impl.WorkerServiceImpl;

import javax.servlet.RequestDispatcher;
@WebServlet("/DeleteWorkerSrv")
public class DeleteWorkerSrv  extends HttpServlet {

	    private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	  
	    	String workerID = request.getParameter("workerID");

	    	WorkerServiceImpl b = new WorkerServiceImpl();

			String status = b.deleteW(workerID);
			
	        RequestDispatcher rd = request.getRequestDispatcher("delete_.jsp?message=" + status);
	        rd.forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        doGet(request, response);
	    }
	}


