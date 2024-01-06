
package com.weblabs.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.weblabs.utility.DBUtil;

public class ServiceServiceImpl {

	
	//serviceID, servicename, description, price, discount, coupons
	
	public String addS(String servicename,String description,String price,String discount,String coupons,String type) {
		
		String Status1 = " Adding Failed!";

        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;

        try {
        	ps = con.prepareStatement("INSERT INTO service ( servicename, description, price, discount, coupons,type) VALUES (?,?,?,?,?,?)");
        	ps.setString(1, servicename);
        	ps.setString(2, description);
            ps.setString(3, price);
            ps.setString(4, discount);
            ps.setString(5, coupons);
            ps.setString(6, type);
           
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
	
	
	public String editS(String serviceID,String servicename,String description,String price,String discount,String coupons,String type)  {
		
			String Status3 = "Updating  Failed!";

	        Connection con = DBUtil.provideConnection();
	        PreparedStatement ps = null;

	        try {
	        	ps = con.prepareStatement("UPDATE service SET  servicename= ?, description= ?, price= ?, discount= ?, coupons= ?,type= ? WHERE serviceID = ?");
	        	
	        	ps.setString(1, servicename);
	        	ps.setString(2, description);
	            ps.setString(3, price);
	            ps.setString(4, discount);
	            ps.setString(5, coupons);
	            ps.setString(6, type);
	            ps.setString(7, serviceID);
	           
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

	
	public String deleteS(String serviceID) {
		String Status2 = " delete Failed!";

        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;

        try {
        	ps = con.prepareStatement("DELETE FROM service  WHERE serviceID = ?");
            ps.setString(1, serviceID);
           
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
