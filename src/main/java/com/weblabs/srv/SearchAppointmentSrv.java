
package com.weblabs.srv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weblabs.beans.AppointmentBean;
import com.weblabs.DAO.AppointmentDAO;


@WebServlet("/SearchAppointmentSrv")
public class SearchAppointmentSrv extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    	String vechicleFilter = request.getParameter("appointmentdate");
        String idFilter = request.getParameter("appointmentID");
  

        String startParam = request.getParameter("start");
        int start = (startParam != null) ? Integer.parseInt(startParam) : 0;
        String limitParam = request.getParameter("limit");
		 
		 
        int limit = (limitParam != null) ? Integer.parseInt(limitParam) : 25;
   
	
      List<AppointmentBean> suppliers;
        
        


      if (vechicleFilter != null && !vechicleFilter.isEmpty() || idFilter != null && !idFilter.isEmpty()) {
         
      	if (idFilter == null || idFilter.isEmpty()) {
      	 int idFilterInt = 0;
      	suppliers = AppointmentDAO.getFilteredAppointment("appointmentdate like '%" + vechicleFilter + "%' or appointmentdate = '" + idFilterInt + "'", start, limit);
      	}
      	else {
      		suppliers = AppointmentDAO.getFilteredAppointment("appointmentID like '%" + vechicleFilter + "%' and appointmentID = '" + idFilter + "'", start, limit);
      	}
      	} else {
          // Retrieve all data
      		suppliers = AppointmentDAO.getFilteredAppointment("", start, limit);
      }

    request.setAttribute("suppliers", suppliers);
    request.setAttribute("search", "true");
    request.getRequestDispatcher("/appointment.jsp").forward(request, response);

    
  }
}
