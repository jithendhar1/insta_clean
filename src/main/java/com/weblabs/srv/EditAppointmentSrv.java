
package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.beans.AppointmentBean;
import com.weblabs.service.impl.AppointmentServiceImp;
			
@WebServlet("/EditAppointmentSrv")
public class EditAppointmentSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;

    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       // String status1 = "Edit  Failed!"; 
    	//in jsp order write*****************
        String appointmentID = request.getParameter("appointmentID");
        String customerID= request.getParameter("customerID");
        String VIN = request.getParameter("VIN");
        String appointmentdate = request.getParameter("appointmentdate");
        String A11 = request.getParameter("A11"); 
        String A12  = request.getParameter("A12");
        String A13 = request.getParameter("A13"); 
        String A14 = request.getParameter("A14"); 
        String A15 = request.getParameter("A15");
        String A16 = request.getParameter("A16");
        String A17 = request.getParameter("A17"); 
        String A18 = request.getParameter("A18");
        
        AppointmentBean dept = new AppointmentBean();
        dept.setAppointmentID(appointmentID);
        dept.setCustomerID(customerID);
        dept.setVIN(VIN);
        dept.setAppointmentdate(appointmentdate);
        dept.setA11(A11);
        dept.setA12(A12);		
        dept.setA13(A13);
        dept.setA14(A14);
        dept.setA15(A15);		
        dept.setA16(A16);
        dept.setA17(A17);
        dept.setA18(A18);		
    	
        
        AppointmentServiceImp dao = new AppointmentServiceImp();
   
        String status2 = dao.editA(appointmentID,customerID, VIN, appointmentdate,A11, A12, A13, A14, A15, A16, A17, A18);

        RequestDispatcher rd = request.getRequestDispatcher("appointment_edit.jsp?message=" + status2);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}