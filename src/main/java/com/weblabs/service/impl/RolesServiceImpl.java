package com.weblabs.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.weblabs.utility.DBUtil;

public class RolesServiceImpl {

	public String addRole(String rolename, String description) {
		// TODO Auto-generated method stub
		
		
		
		String status = "Role Adding Failed!";

        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;

        try {
        	ps = con.prepareStatement("INSERT INTO roles (RoleName,Description) VALUES (?,?)");
            ps.setString(1, rolename);
            ps.setString(2, description);
           
            
           
            int k = ps.executeUpdate();

            if (k > 0) {
                status = "Role Added Successfully!";
         
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

 public String deleteRole(String RoleID) {
	// TODO Auto-generated method stub
	
	 String status = "delete Role Failed!";

	    Connection con = DBUtil.provideConnection();
	    PreparedStatement ps = null;

	    try {
	        ps = con.prepareStatement("DELETE FROM roles WHERE RoleID = ?");
	        ps.setString(1, RoleID);

	        int k = ps.executeUpdate();

	        if (k > 0) {
	            status = "Role Removed Successfully!";
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



 public String editRole(String RoleID,String RoleName,String Description ) {
	    String status = "Role updation failed!";
	    
	    Connection con = DBUtil.provideConnection();
	    PreparedStatement ps = null;

	    try {
	        ps = con.prepareStatement("UPDATE roles SET RoleName =?, Description =? WHERE RoleID=?");  
	        ps.setString(1, RoleName);
	        ps.setString(2, Description);
	        ps.setString(3, RoleID); 

	        int k = ps.executeUpdate();

	        if (k > 0) {
	            status = "Role Position Updated Successfully!";
	        }
	    } catch (SQLException | NumberFormatException e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.closeConnection(con);
	        DBUtil.closeConnection(ps);
	    }

	    return status;
	}

	
	
	
	
	
	
	
	/*
	 * public List<AddRolesBean> getRoles() { List<AddRolesBean> roles = new
	 * ArrayList<>();
	 * 
	 * Connection connection = null; PreparedStatement preparedStatement = null;
	 * ResultSet resultSet = null;
	 * 
	 * try { // Establish a database connection (you should use your database
	 * connection method) connection = DBUtil.provideConnection(); // Replace with
	 * your connection method
	 * 
	 * // Create an SQL query to fetch data from the roles table String query =
	 * "SELECT * FROM roles"; preparedStatement =
	 * connection.prepareStatement(query); resultSet =
	 * preparedStatement.executeQuery();
	 * 
	 * while (resultSet.next()) { // Create an AddRolesBean object for each row in
	 * the result set AddRolesBean role = new AddRolesBean();
	 * role.setRoleID(resultSet.getString("RoleID"));
	 * role.setRoleName(resultSet.getString("RoleName"));
	 * role.setDescription(resultSet.getString("Description"));
	 * 
	 * // Add the role to the list roles.add(role); } } catch (SQLException e) {
	 * e.printStackTrace(); } finally { // Close database resources (connection,
	 * statement, and result set) in a finally block
	 * DBUtil.closeConnection(resultSet); DBUtil.closeConnection(preparedStatement);
	 * DBUtil.closeConnection(connection); }
	 * 
	 * return roles; }
	 */
	}