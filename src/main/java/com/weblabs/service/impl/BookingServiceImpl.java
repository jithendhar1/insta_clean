

package com.weblabs.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.weblabs.utility.DBUtil;

public class BookingServiceImpl {

	
	//bookingID, vehicleID, appointmentID, serviceID
	
	public String addB(String vehicleID,String appointmentID,String serviceID) {
		
		String Status1 = " Adding Failed!";

        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;

        try {
        	ps = con.prepareStatement("INSERT INTO booking (vehicleID, appointmentID, serviceID) VALUES (?,?,?)");
        	ps.setString(1, vehicleID);
        	ps.setString(2, appointmentID);
            ps.setString(3, serviceID);
            
           
           
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
	
	
	public String editB(String bookingID,String vehicleID,String appointmentID,String serviceID)  {
		
			String Status3 = "Updating  Failed!";

	        Connection con = DBUtil.provideConnection();
	        PreparedStatement ps = null;

	        try {
	        	ps = con.prepareStatement("UPDATE booking SET vehicleID= ?, appointmentID= ?, serviceID= ? WHERE bookingID = ?");
	        	
	        	ps.setString(1, vehicleID);
	        	ps.setString(2, appointmentID);
	            ps.setString(3, serviceID);
	            ps.setString(4, bookingID);
	           
	             
	           
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

	
	public String deleteB(String bookingID) {
		String Status2 = " delete Failed!";

        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;

        try {
        	ps = con.prepareStatement("DELETE FROM booking  WHERE bookingID = ?");
            ps.setString(1, bookingID);
           
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
