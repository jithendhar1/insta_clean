
package com.weblabs.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.weblabs.utility.DBUtil;

public class AddressServiceImpl {

	
	//addressID, customerID, street, city, postal_code, state, hno
	
	public String addV(String customerID,String street,String city,String postal_code,String state,String hno) {
		
		String Status1 = " Adding Failed!";

        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;

        try {
        	ps = con.prepareStatement("INSERT INTO address ( customerID, street, city, postal_code, state, hno) VALUES (?,?,?,?,?,?)");
        	ps.setString(1, customerID);
        	ps.setString(2, street);
            ps.setString(3, city);
            ps.setString(4, postal_code);
            ps.setString(5, state);
            ps.setString(6, hno);
           
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
	
	
	public String editV(String addressID,String customerID,String street,String city,String postal_code,String state,String hno)  {
		
			String Status3 = "Updating  Failed!";

	        Connection con = DBUtil.provideConnection();
	        PreparedStatement ps = null;

	        try {
	        	ps = con.prepareStatement("UPDATE address SET  customerID = ?, street = ?, city = ?, postal_code = ?, state = ?, hno = ? WHERE addressID = ?");
	        	
	        	ps.setString(1, customerID);
	        	ps.setString(2, street);
	            ps.setString(3, city);
	            ps.setString(4, postal_code);
	            ps.setString(5, state);
	            ps.setString(6, hno);
	            ps.setString(7, addressID);
	             
	           
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

	
	public String deleteV(String addressID) {
		String Status2 = " delete Failed!";

        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;

        try {
        	ps = con.prepareStatement("DELETE FROM address  WHERE addressID = ?");
            ps.setString(1, addressID);
           
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
