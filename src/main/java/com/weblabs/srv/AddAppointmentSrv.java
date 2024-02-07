package com.weblabs.srv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.service.impl.AppointmentServiceImp;

@WebServlet("/AddAppointmentSrv")
public class AddAppointmentSrv extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       

        String status1 = "Add Failed!";
        String customerID = request.getParameter("customerID");
        String VIN = request.getParameter("VIN");
        String appointmentdate = request.getParameter("appointmentdate");
        String start_time = request.getParameter("start_time");
        String end_time = request.getParameter("end_time");
        String total_price = request.getParameter("total_price");
        String total_timetakes = request.getParameter("total_timetakes");
        
        String A11 = null;
        String A12 = null;
        String A13 = null;
        String A14 = null;
        String A15 = null;
        String A16 = null;
        String A17 = null;
        String A18 = null;

      
        int startHour = Integer.parseInt(start_time.split(" ")[0]);
        int endHour = Integer.parseInt(end_time.split(" ")[0]);
        for (int i = startHour; i <= endHour; i++) {
            String currentSlot = i + " " + (i == 12 ? "PM" : (i < 12 ? "AM" : "PM"));

            switch (currentSlot) {
                case "11 AM":
                    A11 = "11";
                    break;
                case "12 PM":
                    A12 = "12";
                    break;
                case "13 PM":
                    A13 = "13";
                    break;
                case "14 PM":
                    A14 = "14";
                    break;
                case "15 PM":
                    A15 = "15";
                    break;
                case "16 PM":
                    A16 = "16";
                    break;
                case "17 PM":
                    A17 = "17";
                    break;
                case "18 PM":
                    A18 = "18";
                    break;
               
            }
        }

      
        
        AppointmentServiceImp add = new AppointmentServiceImp();
        status1 = add.addA( customerID, VIN, appointmentdate, A11, A12, A13, A14, A15, A16, A17, A18, start_time, end_time, total_price, total_timetakes) ;

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
