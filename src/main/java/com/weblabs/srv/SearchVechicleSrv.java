
package com.weblabs.srv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weblabs.beans.VechicleBean;
import com.weblabs.DAO.VechicleDAO;


@WebServlet("/SearchVechicleSrv")
public class SearchVechicleSrv extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    	String vechicleFilter = request.getParameter("customerID");
        String idFilter = request.getParameter("vehicleID");
  

        String startParam = request.getParameter("start");
        int start = (startParam != null) ? Integer.parseInt(startParam) : 0;
        String limitParam = request.getParameter("limit");
		 
		 
        int limit = (limitParam != null) ? Integer.parseInt(limitParam) : 25;
   
	
      List<VechicleBean> suppliers;
        
        


      if (vechicleFilter != null && !vechicleFilter.isEmpty() || idFilter != null && !idFilter.isEmpty()) {
         
      	if (idFilter == null || idFilter.isEmpty()) {
      	 int idFilterInt = 0;
      	suppliers = VechicleDAO.getFilteredVechicles("customerID like '%" + vechicleFilter + "%' or customerID = '" + idFilterInt + "'", start, limit);
      	}
      	else {
      		suppliers = VechicleDAO.getFilteredVechicles("vehicleID like '%" + vechicleFilter + "%' and vehicleID = '" + idFilter + "'", start, limit);
      	}
      	} else {
          // Retrieve all data
      		suppliers = VechicleDAO.getFilteredVechicles("", start, limit);
      }

    request.setAttribute("suppliers", suppliers);
    request.setAttribute("search", "true");
    request.getRequestDispatcher("/vechicle.jsp").forward(request, response);

    
  }
}
