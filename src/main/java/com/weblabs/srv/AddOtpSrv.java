package com.weblabs.srv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weblabs.service.impl.OtpServiceImpl;
import com.weblabs.utility.DBUtil;
import java.time.LocalTime;
import java.security.SecureRandom;

@WebServlet("/AddOtpSrv")
public class AddOtpSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	   	
        String phno = request.getParameter("phno");
        //String otp = request.getParameter("otp");
        OTPGenerator otp1 = new OTPGenerator();
        String otp = otp1.generateOTP();
        
        LocalTime currentTime = LocalTime.now();
        String time = currentTime.toString();
        
        
        
        
     TwilloSrv tv = new TwilloSrv();
      tv.sendOtp(phno, otp);
      
        
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBUtil.provideConnection();

            // Check if customer with given phno exists
            String sql = "SELECT customerID, phno FROM customer WHERE phno = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, phno);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                // Customer with the given phno exists
                String customerID = result.getString("customerID");

                // Add or update OTP using OtpServiceImpl
                OtpServiceImpl otpService = new OtpServiceImpl();
                if (customerIDExists(customerID)) {
                    // CustomerID exists, update OTP
                    String updateStatus = otpService.editO(customerID, time, otp);
                    sendResponse(response, updateStatus);
                } else {
                    // CustomerID doesn't exist, add OTP
                    String addStatus = otpService.addO(customerID, time, otp);
                    sendResponse(response, addStatus);
                }
            } else {
                // Customer with the given phno doesn't exist
                sendResponse(response, "Customer not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            sendResponse(response, "Error: " + e.getMessage());
        } finally {
        	 DBUtil.closeConnection(con);
             DBUtil.closeConnection(ps);// Close both connection and PreparedStatement
        }
    }
    

    private boolean customerIDExists(String customerID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.provideConnection();
            String query = "SELECT customerID FROM otp WHERE customerID = ?";
            
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customerID);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                // If there is a matching customerID, return true
                return true;
            } else {
                // If there is no matching customerID, return false
                return false;
            }

        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace();
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        } finally {
            // Close resources in a finally block to ensure they are closed
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false; // If an exception occurs, return false
    }

    private void sendResponse(HttpServletResponse response, String status) throws IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.write(status);
    }
    
    
   

}




