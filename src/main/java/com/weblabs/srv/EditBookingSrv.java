
package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.beans.BookingBean;
import com.weblabs.service.impl.BookingServiceImpl;
			
@WebServlet("/EditBookingSrv")
public class EditBookingSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;

    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       // String status1 = "Edit Failed!"; 
        String bookingID= request.getParameter("bookingID");
        String vehicleID = request.getParameter("vehicleID");
        String appointmentID = request.getParameter("appointmentID");
        String serviceID = request.getParameter("serviceID");
        
        BookingBean dept = new BookingBean();
        
        dept.setBookingID(bookingID);
        dept.setVehicleID(vehicleID);
        dept.setAppointmentID(appointmentID);
        dept.setServiceID(serviceID);
        
        BookingServiceImpl dao = new BookingServiceImpl();
   
        String status2 = dao.editB(bookingID, vehicleID, appointmentID, serviceID);

        RequestDispatcher rd = request.getRequestDispatcher("edit_.jsp?message=" + status2);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}