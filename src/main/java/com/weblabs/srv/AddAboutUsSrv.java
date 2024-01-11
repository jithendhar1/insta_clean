package com.weblabs.srv;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.weblabs.service.impl.AboutUsServiceImpl;

@WebServlet("/AddAboutUsSrv")
public class AddAboutUsSrv extends HttpServlet {
	
		private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	
	    	String status = "Add about Failed!";
	    	// String aboutID = request.getParameter("aboutID");
	        String title = request.getParameter("title");
	        String content = request.getParameter("content");
	       
	        AboutUsServiceImpl add =new AboutUsServiceImpl();
	        status=add.addabout(title, content);
	  	  
	    		   RequestDispatcher rd = request.getRequestDispatcher("about.jsp?message=" + status);
	       rd.forward(request, response);
	    } 
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        doGet(request, response);
	    }
	}































