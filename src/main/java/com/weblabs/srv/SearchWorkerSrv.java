
package com.weblabs.srv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weblabs.beans.WorkerBean;
import com.weblabs.DAO.WorkerDAO;


@WebServlet("/SearchWorkerSrv")
public class SearchWorkerSrv extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    	String vechicleFilter = request.getParameter("supplierName");
        String idFilter = request.getParameter("workerID");
  

        String startParam = request.getParameter("start");
        int start = (startParam != null) ? Integer.parseInt(startParam) : 0;
        String limitParam = request.getParameter("limit");
		 
		 
        int limit = (limitParam != null) ? Integer.parseInt(limitParam) : 25;
   
	
      List<WorkerBean> suppliers;
        
        


      if (vechicleFilter != null && !vechicleFilter.isEmpty() || idFilter != null && !idFilter.isEmpty()) {
         
      	if (idFilter == null || idFilter.isEmpty()) {
      	 int idFilterInt = 0;
      	suppliers = WorkerDAO.getFilteredWorkers("workerID like '%" + vechicleFilter + "%' or workerID = '" + idFilterInt + "'", start, limit);
      	}
      	else {
      		suppliers = WorkerDAO.getFilteredWorkers("workerID like '%" + vechicleFilter + "%' and workerID = '" + idFilter + "'", start, limit);
      	}
      	} else {
          // Retrieve all data
      		suppliers = WorkerDAO.getFilteredWorkers("", start, limit);
      }

    request.setAttribute("suppliers", suppliers);
    request.setAttribute("search", "true");
    request.getRequestDispatcher("/worker.jsp").forward(request, response);

    
  }
}
