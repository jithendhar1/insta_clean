
package com.weblabs.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.weblabs.utility.DBUtil;

public class AppointmentServiceImp {



	
	public String addA(String customerID,String VIN,String appointmentdate,String A11,String A12,String A13,String A14,String A15,String A16,String A17,String A18,String start_time,String end_time,String total_price,String total_timetakes) {
		
		String Status1 = " Adding Failed!";

        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;

        try {
        	ps = con.prepareStatement("INSERT INTO appointment (customerID, VIN, appointmentdate,A11, A12, A13, A14, A15, A16, A17, A18,status, start_time, end_time, end_datetime,total_price,total_timetakes) VALUES (?,?,?,?,?,?,?,?,?,?,?,'current',?,?,DATE_ADD(appointmentdate, INTERVAL end_time MINUTE),?,?)");
        	
        	ps.setString(1, customerID);
        	ps.setString(2, VIN);
            ps.setString(3, appointmentdate);
            ps.setString(4, A11);
            ps.setString(5, A12);
            ps.setString(6, A13);
            ps.setString(7, A14);
            ps.setString(8, A15);
            ps.setString(9, A16);
            ps.setString(10, A17);
            ps.setString(11, A18);
            ps.setString(12, start_time);
            ps.setString(13, end_time);
            ps.setString(14, total_price);
            ps.setString(15, total_timetakes);
           
           
            int k = ps.executeUpdate();

            if (k > 0) {
                Status1 = " Added Successfully!";
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
	
	
	public String editA(String appointmentID,String customerID,String VIN,String appointmentdate,String A11,String A12,String A13,String A14,String A15,String A16,String A17,String A18)  {
		
			String Status3 = "Updating  Failed!";

	        Connection con = DBUtil.provideConnection();
	        PreparedStatement ps = null;

	        try {
	        	ps = con.prepareStatement("UPDATE appointment SET customerID= ?, VIN= ?,  appointmentdate= ?, A11=?, A12=?, A13=?, A14=?, A15=?, A16=?, A17=?, A18=? WHERE appointmentID = ?");
	        	
	        	ps.setString(1, customerID);
	        	ps.setString(2, VIN);
	            ps.setString(3, appointmentdate);
	            ps.setString(4, A11);
	            ps.setString(5, A12);
	            ps.setString(6, A13);
	            ps.setString(7, A14);
	            ps.setString(8, A15);
	            ps.setString(9, A16);
	            ps.setString(10, A17);
	            ps.setString(11, A18);
	           
	            int k = ps.executeUpdate();

	            if (k > 0) {
	            	Status3 = "Updating Successfully!";
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

	
	public String deleteA(String appointmentID) {
		String Status2 = " delete Failed!";

        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;

        try {
        	ps = con.prepareStatement("DELETE FROM appointment  WHERE appointmentID = ?");
            ps.setString(1, appointmentID);
           
            int k = ps.executeUpdate();

            if (k > 0) {
            	Status2 = " deleted Successfully!";
            }
        } catch (SQLException e) {
        	Status2 = "Error: " + e.getMessage();
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(con);
            DBUtil.closeConnection(ps);
        }

        return Status2;
	}
}
