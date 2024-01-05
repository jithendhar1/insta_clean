
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
import java.sql.ResultSet;
import java.util.Arrays;


@WebServlet("/AddInvoiceSrv")
public class AddInvoiceSrv extends HttpServlet {
	
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
	          
	        	
	        	
	            String appointmentID = request.getParameter("appointmentID");
	            String customerID = request.getParameter("customerID");
	            String invoicedate = request.getParameter("invoicedate");
	            String duedate = request.getParameter("duedate");
	            String selectedTax = request.getParameter("taxSelect");
	            double totalamt = Double.parseDouble(request.getParameter("totalamt"));
	            String otherinformation = request.getParameter("otherinformation");
	            double taxValue;

	            if (selectedTax != null) {
	                switch (selectedTax) {
	                    case "10":
	                        taxValue = 10;
	                        break;
	                    case "20":
	                        taxValue = 20;
	                        break;

	                    default:
	                        // Handle the case where an unexpected option is selected
	                        taxValue = 0.0; // You can use any other appropriate default value
	                        break;
	                }
	            } else {
	                // Handle the case where no option is selected
	                taxValue = 0.0; // You can use any other appropriate default value
	            }

	            // Now you have the numeric tax value (1.0, 2.0, or 0.0) in the taxValue variable

	           double tax = taxValue;         
	           double discount = Double.parseDouble(request.getParameter("discount"));
	           String taxamount = request.getParameter("taxamount");
	           
	           
	          
	            String[] serviceitem = request.getParameterValues("serviceitem");
	            String[]	 description = request.getParameterValues("description");
	            double[] unitcost = Arrays.stream(request.getParameterValues("unitcost"))
	                .mapToDouble(Double::parseDouble)
	                .toArray();
	            int[] qty = Arrays.stream(request.getParameterValues("qty"))
	                .mapToInt(Integer::parseInt)
	                .toArray();
	           // double[] amount = Arrays.stream(request.getParameterValues("amount"))
		              //  .mapToDouble(Double::parseDouble)
		             //   .toArray();
	            Connection conn = DBUtil.provideConnection();
	            if (conn != null) {
	            	PreparedStatement invoiceStatement = conn.prepareStatement(
	            		    "INSERT INTO invoice ( appointmentID, customerID, invoicedate, duedate, totalamt, otherinformation, tax, discount, taxamount) " +
	            		    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
	            		    PreparedStatement.RETURN_GENERATED_KEYS
	            		);

	                invoiceStatement.setString(1, appointmentID);
	                invoiceStatement.setString(2, customerID);
	                invoiceStatement.setString(3, invoicedate);
	                invoiceStatement.setString(4, duedate);
	                invoiceStatement.setDouble(5, totalamt);
	                invoiceStatement.setString(6, otherinformation);
	   	            invoiceStatement.setDouble(7, tax);
	   	            invoiceStatement.setDouble(8, discount);  	         
	   	            invoiceStatement.setString(9, taxamount);
	
	   	
			     
	   	      int affectedRows = invoiceStatement.executeUpdate();

	   	   if (affectedRows > 0) {
	   	       ResultSet generatedKeys = invoiceStatement.getGeneratedKeys();
	   	       if (generatedKeys.next()) {
	   	           int invoiceId = generatedKeys.getInt(1);

	   	          
	   	           String itemInsertSQL = "INSERT INTO invoiceitems ( serviceitem, description, unitcost, qty, amount, invoiceid) VALUES (?, ?, ?, ?, ?, ?)";
	   	           PreparedStatement itemStatement = conn.prepareStatement(itemInsertSQL);

	   	        for (int i = 0; i < serviceitem.length; i++) {
	   	               double amount = unitcost[i] * qty[i];
	   	               
	   	               
	   	               itemStatement.setString(1, serviceitem[i]);
	   	               itemStatement.setString(2, description[0]);
	   	               itemStatement.setDouble(3, unitcost[i]);
	   	               itemStatement.setInt(4, qty[i]);
	   	               itemStatement.setDouble(5, amount);
	   	               itemStatement.setInt(6, invoiceId);
	   	               
	   	               
	   	               itemStatement.addBatch();
	   	           }

	   	           
	   	           itemStatement.executeBatch();
	   	           itemStatement.close();
	   	       }

	   	       
	   	       conn.close();
	   	    invoiceStatement.close();
	   	   }

	   	  }   
        
	           
	            response.sendRedirect("invoice.jsp");
	        } catch (Exception e) {
	            e.printStackTrace();
	           
	            response.sendRedirect("error.jsp");
	        }
	    }

		public String getInvoiceItemId() {
			// TODO Auto-generated method stub
			return null;
		}
		
}

	   