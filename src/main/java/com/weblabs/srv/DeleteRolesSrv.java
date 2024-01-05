

package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.service.impl.RolesServiceImpl;


@WebServlet("/DeleteRolesSrv")
public class DeleteRolesSrv extends HttpServlet{

	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String RoleID = request.getParameter("RoleID");
        RolesServiceImpl role = new RolesServiceImpl();

		String status = role.deleteRole(RoleID);
		
        RequestDispatcher rd = request.getRequestDispatcher("roles_delete.jsp?message=" + status);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}