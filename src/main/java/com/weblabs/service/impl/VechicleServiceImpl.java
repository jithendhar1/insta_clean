
package com.weblabs.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.weblabs.utility.DBUtil;

public class VechicleServiceImpl {

	
	//vehicleID, customerID, vehicleType, vehicleModel, VIN
	
	public String addV(String customerID,String vehicleType,String vehicleModel,String VIN) {
		
		String Status1 = "Vechicle Adding Failed!";

        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;

        try {
        	ps = con.prepareStatement("INSERT INTO vehicle (customerID, vehicleType, vehicleModel, VIN) VALUES (?,?,?,?)");
        	ps.setString(1, customerID);
        	ps.setString(2, vehicleType);
            ps.setString(3, vehicleModel);
            ps.setString(4, VIN);
            
           
           
            int k = ps.executeUpdate();

            if (k > 0) {
                Status1 = "Vechicle Added Successfully!";
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
	
	
	public String editV(String vehicleID,String customerID,String vehicleType,String vehicleModel,String VIN)  {
		
			String Status3 = "Updating  Failed!";

	        Connection con = DBUtil.provideConnection();
	        PreparedStatement ps = null;

	        try {
	        	ps = con.prepareStatement("UPDATE vehicle SET  customerID= ?, vehicleType= ?, vehicleModel= ?, VIN= ? WHERE vehicleID = ?");
	        	
	        	ps.setString(1, customerID);
	        	ps.setString(2, vehicleType);
	            ps.setString(3, vehicleModel);
	            ps.setString(4, VIN);
	            ps.setString(5, vehicleID);
	             
	           
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

	
	public String deleteV(String vehicleID) {
		String Status2 = " delete Failed!";

        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;

        try {
        	ps = con.prepareStatement("DELETE FROM vehicle  WHERE vehicleID = ?");
            ps.setString(1, vehicleID);
           
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
