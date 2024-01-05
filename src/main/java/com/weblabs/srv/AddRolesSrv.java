package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.weblabs.service.impl.RolesServiceImpl;


@WebServlet("/AddRolesSrv")
public class AddRolesSrv extends HttpServlet{

	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String status = "Add Role Failed!";
        String rolename = request.getParameter("rolename");
        String description = request.getParameter("description");
        
        
       
        RolesServiceImpl role =new RolesServiceImpl();
        status=role.addRole(rolename, description);
        
    		  
    		   RequestDispatcher rd = request.getRequestDispatcher("roles.jsp?message=" + status);
       rd.forward(request, response);
    } 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}