package com.weblabs.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.weblabs.utility.DBUtil;

public class OtpServiceImpl {

	
public String addO(String customerID,String time,String otp) {
	
	String Status1 = " Adding Failed!";

    Connection con = DBUtil.provideConnection();
    PreparedStatement ps = null;

    try {
    	ps = con.prepareStatement("INSERT INTO otp (customerID, time, otp) VALUES (?,?,?)");
    	ps.setString(1, customerID);
    	ps.setString(2, time);
        ps.setString(3, otp);
        
 
        int k = ps.executeUpdate();

        if (k > 0) {
            Status1 = " Added Successfully!";
            
            updateExpiredOTPs(con);
        }
    } catch (SQLException e) {
        Status1 = "Error: " + e.getMessage();
        e.printStackTrace();
    } finally {
        DBUtil.closeConnection(con);
        DBUtil.closeConnection(ps);
    }

    return Status1;
}


public String editO(String customerID,String time,String otp)  {
	
		String Status3 = "Updating  Failed!";

        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;

        try {
        	ps = con.prepareStatement("UPDATE otp SET  time= ?, otp= ? WHERE customerID = ?");
        	
        	ps.setString(1, time);
        	ps.setString(2, otp);
            ps.setString(3, customerID);
           
             
           
            int k = ps.executeUpdate();

            if (k > 0) {
            	Status3 = "Updating Successfully!";
            	updateExpiredOTPs(con);
            }
        }
         catch (SQLException e) {
        	Status3 = "Error: " + e.getMessage();
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(con);
            DBUtil.closeConnection(ps);
        }

        return Status3 ;
}


private void updateExpiredOTPs(Connection con) {
    PreparedStatement updatePs = null;

    try {
        // Update OTPs older than 10 minutes to NULL
        updatePs = con.prepareStatement("UPDATE otp SET otp = NULL WHERE TIMESTAMPDIFF(MINUTE, time, NOW()) > 10");
        updatePs.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DBUtil.closeConnection(updatePs);
    }
}}