
package com.weblabs.srv;

import java.io.IOException; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weblabs.utility.DBUtil;

@WebServlet("/LoginSrv")
public class LoginSrv extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
        String phno = request.getParameter("phno");
        String otp = request.getParameter("otp");
       
     
        
        
        
   /*if (validate(request, phno, otp)) {
            
            response.sendRedirect("home.jsp");
        } else {
            String errorMessage = "Invalid username or password";
            request.setAttribute("error", errorMessage);
            request.setAttribute("wrongusername", "true"); // Set wrongusername attribute
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }

    }*/
        
        
        if (validate(request, phno, otp)) {
            // Authentication successful
            response.getWriter().write("Authentication successful"); // You can send any response message
            response.setStatus(HttpServletResponse.SC_OK);
            
            
            
            
         //   HttpSession session = request.getSession();
         //   String customerID = (String) session.getAttribute("customerID");
         //   String customername = (String) session.getAttribute("customername");

         //   String successMessage = "Authentication successful for customername: " + customername;
         //   response.getWriter().write(successMessage);
         //   response.setStatus(HttpServletResponse.SC_OK);
            
            
            
            
        } else {
            // Invalid username or password
            response.getWriter().write("Invalid username or password");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
    

    
    
    private boolean validate(HttpServletRequest request, String phno, String otp)  {
    	Connection con = DBUtil.provideConnection();
	    
        try {
          
        	String sql = "SELECT customer.phno,otp.otp,customer.customerID,customer.customername from customer INNER JOIN otp ON otp.customerID=customer.customerID WHERE phno = ? AND otp = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, phno);
            statement.setString(2, otp);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
            	
            	 HttpSession session = request.getSession();
				session.setAttribute("otp",  result.getString("otp"));
				session.setAttribute("customerID",  result.getString("customerID"));
				session.setAttribute("phno",  result.getString("phno"));
				session.setAttribute("customername",  result.getString("customername"));
                con.close();
                
             // Call TwilloSrv servlet using RequestDispatcher
               // request.getRequestDispatcher("/TwilloSrv").forward(request, response);

                return true;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("wrongpassword", "true"); 
        } finally {
            // Rest of your code remains unchanged
        }

        return false;
    }
}