

package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.beans.RolesBean;
import com.weblabs.service.impl.RolesServiceImpl;
			
@WebServlet("/EditRolesSrv")
public class EditRolesSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;

   

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


   	 String status = "Add Failed!";
 
   	 String RoleID = request.getParameter("RoleID");
        String RoleName = request.getParameter("rolename");
        String Description= request.getParameter("description");
      
        RolesBean obj = new RolesBean();
    
     obj.setRoleID(RoleID);
     obj.setRoleName(RoleName);
     obj.setDescription(Description);
     
     RolesServiceImpl ass =new RolesServiceImpl();
     status=ass.editRole( RoleID,RoleName, Description );
    
        RequestDispatcher rd = request.getRequestDispatcher("roles_edit.jsp?message=" + status);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}




