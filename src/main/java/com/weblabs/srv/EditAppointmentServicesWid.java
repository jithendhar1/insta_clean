

package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.beans.AppointmentServicesBean;
import com.weblabs.service.impl.AppointmentServicesServiceImpl;
			
@WebServlet("/EditAppointmentServicesWid")
public class EditAppointmentServicesWid extends HttpServlet {
    private static final long serialVersionUID = 1L;

    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       // String status1 = "Edit Failed!"; ID, serviceID, servicename, price, timetakes, appointmentID, workerID
        String ID= request.getParameter("ID");
        String serviceID = request.getParameter("serviceID");
        String servicename = request.getParameter("servicename");
        String price = request.getParameter("price");
        String timetakes = request.getParameter("timetakes");
        String appointmentID = request.getParameter("appointmentID");
        String workerID = request.getParameter("workerID");
        
        AppointmentServicesBean dept = new AppointmentServicesBean();
        
        dept.setID(ID);
        dept.setServiceID(serviceID);
        dept.setServicename(servicename);
        dept.setPrice(price);
        dept.setTimetakes(timetakes);
        dept.setAppointmentID(appointmentID);
        dept.setWorkerID(workerID);
        
        
        AppointmentServicesServiceImpl dao = new AppointmentServicesServiceImpl();
   
        String status2 = dao.editV(ID, serviceID, servicename, price, timetakes, appointmentID, workerID);

      
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}