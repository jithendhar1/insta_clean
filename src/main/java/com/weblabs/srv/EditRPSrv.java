package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.beans.RolePermissionBean;
import com.weblabs.service.impl.RPServiceImpl;
			

@WebServlet("/EditRPSrv")
public class EditRPSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String status1 = "rp Failed!";
        String rolepermissionId= request.getParameter("RolePermissionID");
        String roleid = request.getParameter("roleid");
        String modulename = request.getParameter("modulename");
        String formname = request.getParameter("formname");
        String permissiontype = request.getParameter("permissiontype");
        

        RolePermissionBean role = new RolePermissionBean();
          role.setRolePermissionID(rolepermissionId);
          role.setRoleID(roleid);
          role.setModuleName(modulename);
          role.setFormName(formname);
          role.setPermissionType(permissiontype);
        
          RPServiceImpl dao = new RPServiceImpl();
        

        String status11= dao.updateRP(rolepermissionId,roleid,modulename,formname,permissiontype);

        RequestDispatcher rd = request.getRequestDispatcher("rolepermission.jsp?message=" + status11);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}




