package com.weblabs.srv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.beans.VechicleBean;

@WebServlet("/TableVechicleSrv")
public class TableVechicleSrv extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	
    	// Retrieve tasks or data from your database
        List<VechicleBean> vechicles = retrieveTasksFromDatabase();

        // Set the retrieved tasks as a request attribute
        request.setAttribute("vechicles", vechicles);

        // Forward the request to the JSP page for rendering
        RequestDispatcher dispatcher = request.getRequestDispatcher("taskTable.jsp");
        dispatcher.forward(request, response);
    }

    // Example method to retrieve tasks from the database
    private List<VechicleBean> retrieveTasksFromDatabase() {
        // Implement your database retrieval logic here
        // Return a List of TasksBean objects
        return new ArrayList<>();
    }
}
