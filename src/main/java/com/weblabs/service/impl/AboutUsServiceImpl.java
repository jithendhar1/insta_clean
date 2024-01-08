package com.weblabs.service.impl;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.weblabs.utility.DBUtil;


public class AboutUsServiceImpl  {
	
		
		public String addabout( String title, String content ) {
			
				String status = "about Adding Failed!";

		        Connection con = DBUtil.provideConnection();
		        PreparedStatement ps = null;

		        try {
		        	ps = con.prepareStatement("INSERT INTO about (title,content) VALUES (?,?)");
		            ps.setString(1, title);
		            ps.setString(2, content);
		           
		           
		
		            int k = ps.executeUpdate();

		            if (k > 0) {
		                status = "about Added Successfully!";
		            }
		        } catch (SQLException e) {
		            status = "Error: " + e.getMessage();
		            e.printStackTrace();
		        } finally {
		            DBUtil.closeConnection(con);
		            DBUtil.closeConnection(ps);
		        }

		        return status;
		}

		
		public String deleteabout(String aboutID) {
			
				String status = "about Removal Failed!";

			    Connection con = DBUtil.provideConnection();
			    PreparedStatement ps = null;

			    try {
			        ps = con.prepareStatement("DELETE FROM about WHERE aboutID = ?");
			        ps.setString(1, aboutID);

			        int k = ps.executeUpdate();

			        if (k > 0) {
			            status = "about Removed Successfully!";
			        }
			    } catch (SQLException e) {
			        status = "Error: " + e.getMessage();
			        e.printStackTrace();
			    } finally {
			        DBUtil.closeConnection(con);
			        DBUtil.closeConnection(ps);
			    }

			    return status;
		}

		
		public String editabout(String aboutID, String title, String content) {
			String status = "about Failed!";

		    Connection con = DBUtil.provideConnection();
		    PreparedStatement ps = null;

		    try {
		        ps = con.prepareStatement("UPDATE about SET title =?, content =?  WHERE aboutID=?");  
		   
		        ps.setString(1, title);
		        ps.setString(2, content);
		        ps.setString(3, aboutID);
		       

		        int k = ps.executeUpdate();

		        if (k > 0) {
		            status = "about Updated Successfully!";
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        DBUtil.closeConnection(con);
		        DBUtil.closeConnection(ps);
		    }

		    return status;
		

		}
			
}