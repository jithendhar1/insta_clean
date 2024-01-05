
package com.weblabs.srv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weblabs.beans.ServiceBean;
import com.weblabs.DAO.ServiceDAO;


@WebServlet("/SearchServiceSrv")
public class SearchServiceSrv extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    	String vechicleFilter = request.getParameter("supplierName");
        String idFilter = request.getParameter("serviceID");
  

        String startParam = request.getParameter("start");
        int start = (startParam != null) ? Integer.parseInt(startParam) : 0;
        String limitParam = request.getParameter("limit");
		 
		 
        int limit = (limitParam != null) ? Integer.parseInt(limitParam) : 25;
   
	
      List<ServiceBean> suppliers;
        
        


      if (vechicleFilter != null && !vechicleFilter.isEmpty() || idFilter != null && !idFilter.isEmpty()) {
         
      	if (idFilter == null || idFilter.isEmpty()) {
      	 int idFilterInt = 0;
      	suppliers = ServiceDAO.getFilteredServices("serviceID like '%" + vechicleFilter + "%' or serviceID = '" + idFilterInt + "'", start, limit);
      	}
      	else {
      		suppliers = ServiceDAO.getFilteredServices("serviceID like '%" + vechicleFilter + "%' and serviceID = '" + idFilter + "'", start, limit);
      	}
      	} else {
          // Retrieve all data
      		suppliers = ServiceDAO.getFilteredServices("", start, limit);
      }

    request.setAttribute("suppliers", suppliers);
    request.setAttribute("search", "true");
    request.getRequestDispatcher("/service.jsp").forward(request, response);

    
  }
}
