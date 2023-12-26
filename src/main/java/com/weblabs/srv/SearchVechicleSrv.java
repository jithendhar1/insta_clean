
package com.weblabs.srv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weblabs.beans.VechicleBean;
import com.weblabs.service.impl.VechicleDAO;


@WebServlet("/SearchVechicleSrv")
public class SearchVechicleSrv extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    	String vechicleFilter = request.getParameter("supplierName");
        String idFilter = request.getParameter("supplierID");
  

        String startParam = request.getParameter("start");
        int start = (startParam != null) ? Integer.parseInt(startParam) : 0;
        String limitParam = request.getParameter("limit");
		 
		 
        int limit = (limitParam != null) ? Integer.parseInt(limitParam) : 25;
   
	
      List<VechicleBean> suppliers;
        
        


      if (vechicleFilter != null && !vechicleFilter.isEmpty() || idFilter != null && !idFilter.isEmpty()) {
         
      	if (idFilter == null || idFilter.isEmpty()) {
      	 int idFilterInt = 0;
      	suppliers = SupplierDAO.getFilteredSuppliers("supplierName like '%" + vechicleFilter + "%' or supplierID = '" + idFilterInt + "'", start, limit);
      	}
      	else {
      		suppliers = SupplierDAO.getFilteredSuppliers("supplierName like '%" + vechicleFilter + "%' and supplierID = '" + idFilter + "'", start, limit);
      	}
      	} else {
          // Retrieve all data
      		suppliers = SupplierDAO.getFilteredSuppliers("", start, limit);
      }

    request.setAttribute("suppliers", suppliers);
    request.setAttribute("search", "true");
    request.getRequestDispatcher("/supplier.jsp").forward(request, response);

    
  }
}
