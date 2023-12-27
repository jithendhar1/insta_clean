
package com.weblabs.srv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weblabs.beans.CustomerBean;
import com.weblabs.DAO.CustomerDAO;


@WebServlet("/SearchCustomerSrv")
public class SearchCustomerSrv extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    	String userFilter = request.getParameter("customername");
        String idFilter = request.getParameter("customerID");
  

        String startParam = request.getParameter("start");
        int start = (startParam != null) ? Integer.parseInt(startParam) : 0;
        String limitParam = request.getParameter("limit");
		 
		 
        int limit = (limitParam != null) ? Integer.parseInt(limitParam) : 25;
   
	
      List<CustomerBean> suppliers;
        
        


      if (userFilter != null && !userFilter.isEmpty() || idFilter != null && !idFilter.isEmpty()) {
         
      	if (idFilter == null || idFilter.isEmpty()) {
      	 int idFilterInt = 0;
      	suppliers = CustomerDAO.getFilteredCustomers("customername like '%" + userFilter + "%' or customerID = '" + idFilterInt + "'", start, limit);
      	}
      	else {
      		suppliers = CustomerDAO.getFilteredCustomers("customername like '%" + userFilter + "%'  customerID = '" + idFilter + "'", start, limit);
      	}
      	} else {
          // Retrieve all data
      		suppliers = CustomerDAO.getFilteredCustomers("", start, limit);
      }

    request.setAttribute("suppliers", suppliers);
    request.setAttribute("search", "true");
    request.getRequestDispatcher("/customerprofile.jsp").forward(request, response);

    
  }
}
