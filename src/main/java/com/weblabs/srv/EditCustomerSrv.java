
package com.weblabs.srv;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weblabs.utility.DBUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;



@WebServlet("/EditCustomerSrv")
public class EditCustomerSrv extends HttpServlet {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Your code to handle GET requests
		 commonLogic(request, response);
	    }
	
	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   	 commonLogic(request, response);
	    
	    }
	    
	    private void commonLogic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	        try {

	            String customername = request.getParameter("customername");
	            String email = request.getParameter("email");
	            String phno = request.getParameter("phno");
	            String firstname = request.getParameter("firstname");
	            String lastname = request.getParameter("lastname");
	            String customerID = request.getParameter("customerID");
	   

	            
	            String[] street = request.getParameterValues("street");
	            String[] city = request.getParameterValues("city");
	            String[] postal_code = request.getParameterValues("postal_code");
	            String[] state = request.getParameterValues("state");
	            String[] hno = request.getParameterValues("hno");
	            String addressID = request.getParameter("addressID");
	            Connection conn = DBUtil.provideConnection();
	            if (conn != null) {
	            	PreparedStatement customerStatement = conn.prepareStatement(
	            		    "UPDATE customer SET customername=?, email=?, phno=?, firstname=?, lastname=?, customername=? WHERE customerID=?",
	            		    PreparedStatement.RETURN_GENERATED_KEYS
	            		);


	            	customerStatement.setString(1, customername);
	            	customerStatement.setString(2, email);
	            	customerStatement.setString(3, phno);
	            	customerStatement.setString(4, firstname);
	            	customerStatement.setString(5, lastname);
	            	customerStatement.setString(6, customerID);
	            	
	   	      int affectedRows = customerStatement.executeUpdate();

	   	   if (affectedRows > 0) {
	   	      // ResultSet generatedKeys = customerStatement.getGeneratedKeys();
	   	        //   if (generatedKeys.next()) {
	   	           //     int customerID = generatedKeys.getInt(1);
	   	                
	   	           String itemInsertSQL = "UPDATE address SET street=?, city=?, postal_code=?, state=?, hno=? WHERE addressID=?";
	   	           PreparedStatement itemStatement = conn.prepareStatement(itemInsertSQL);

	   	   
	   	               
	   	               itemStatement.setString(1, street[0]);
	   	               itemStatement.setString(2, city[0]);
	   	               itemStatement.setString(3, postal_code[0]);
	   	               itemStatement.setString(4, state[0]);
	   	               itemStatement.setString(5, hno[0]);
	   	               itemStatement.setString(6, addressID);
	   	               
	   	           
	   	               itemStatement.addBatch();
	   	           

	   	           
	   	           itemStatement.executeBatch();
	   	           itemStatement.close();
	   	       }

	   	    
	   	       conn.close();
	   	    customerStatement.close();
	   	   }

	   	
	            response.sendRedirect("customer.jsp");
	        } catch (Exception e) {
	            e.printStackTrace();

	            response.sendRedirect("error.jsp");
	        }
	    }

		public String getInvoiceItemId() {
		
			return null;
		}
		
}