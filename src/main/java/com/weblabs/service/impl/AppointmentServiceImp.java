
package com.weblabs.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.weblabs.utility.DBUtil;

public class AppointmentServiceImp {

	
	//appointmentID, customerID, vehicleID, serviceID, appointmentdate, status
	
	public String addA(String customerID,String vehicleID,String serviceID,String appointmentdate,String appointmenttime,String status) {
		
		String Status1 = " Adding Failed!";

        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;

        try {
        	ps = con.prepareStatement("INSERT INTO appointment (customerID, vehicleID, serviceID, appointmentdate,appointmenttime, status) VALUES (?,?,?,?,?,?)");
        	ps.setString(1, customerID);
        	ps.setString(2, vehicleID);
            ps.setString(3, serviceID);
            ps.setString(4, appointmentdate);
            ps.setString(5, appointmenttime);
            ps.setString(6, status);
          
           
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
	
	
	public String editA(String appointmentID,String customerID,String vehicleID,String serviceID,String appointmentdate,String appointmenttime,String status)  {
		
			String Status3 = "Updating  Failed!";

	        Connection con = DBUtil.provideConnection();
	        PreparedStatement ps = null;

	        try {
	        	ps = con.prepareStatement("UPDATE appointment SET customerID= ?, vehicleID= ?, serviceID= ?, appointmentdate= ?,appointmenttime=?, status= ? WHERE appointmentID = ?");
	        	
	        	ps.setString(1, customerID);
	        	ps.setString(2, vehicleID);
	            ps.setString(3, serviceID);
	            ps.setString(4, appointmentdate);
	            ps.setString(5, appointmenttime);
	            ps.setString(6, status);
	            ps.setString(7, appointmentID);
	           
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
