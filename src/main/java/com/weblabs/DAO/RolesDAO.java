package com.weblabs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.weblabs.beans.RolesBean;
import com.weblabs.utility.DBUtil;

public class RolesDAO {

	    public static List<RolesBean> getFilteredEmployees(String whereClause, int start, int limit) {
	        List<RolesBean> filteredroles = new ArrayList<>();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	       
	        try {
	            connection = DBUtil.provideConnection();
	            String query;
	            if (whereClause != null && !whereClause.isEmpty()) {
	                query = "SELECT  RoleID, RoleName ,Description FROM roles WHERE " + whereClause + " LIMIT ? , ?;";
	               
	            } else {
	                query = "SELECT  RoleID, RoleName ,Description FROM roles LIMIT ? , ?;";
	            }

	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, start);
	            preparedStatement.setInt(2, limit );
	     
	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	            	RolesBean role = new RolesBean();
	            	role.setRoleID(resultSet.getString("roleID"));
                	role.setRoleName(resultSet.getString("roleName"));
                	role.setDescription(resultSet.getString("description"));
	                filteredroles.add(role);
	            }
	        } catch (Exception e) {
	            // Handle exceptions
	            e.printStackTrace();
	        } finally {
	            // Close database resources (connection, statement, result set)
	            try {
	                if (resultSet != null) resultSet.close();
	                if (preparedStatement != null) preparedStatement.close();
	                if (connection != null) connection.close();
	            } catch (Exception e) {
	                // Handle exceptions
	                e.printStackTrace();
	            }
	        }

	        return filteredroles;
	        
	    } 
	        
	        public int getRecordCount() {
	            Connection connection = null;
	            PreparedStatement statement = null;
	            ResultSet resultSet = null;
	            int recordCount = 0;

	            try {
	                // Establish a database connection (you should configure your database URL, username, and password)
	                connection =  DBUtil.provideConnection();
	                // Define the SQL query to count the records
	                String sql = "SELECT COUNT(1) FROM roles";

	                // Prepare the statement
	                statement = connection.prepareStatement(sql);

	                // Execute the query and retrieve the count
	                resultSet = statement.executeQuery();
	                if (resultSet.next()) {
	                    recordCount = resultSet.getInt(1);
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	                // Handle any database errors here
	            } finally {
	                // Close the resources
	                try {
	                    if (resultSet != null) resultSet.close();
	                    if (statement != null) statement.close();
	                    if (connection != null) connection.close();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }

	            return recordCount;
	        }
	        
	        public static List<RolesBean> getAllRoles() {
	            List<RolesBean> allEmployees = new ArrayList<>();
	            Connection connection = null;
	            PreparedStatement preparedStatement = null;
	            ResultSet resultSet = null;

	            try {
	                connection = DBUtil.provideConnection();
	                String query = "SELECT  RoleID, RoleName ,Description FROM roles";
	                preparedStatement = connection.prepareStatement(query);
	                resultSet = preparedStatement.executeQuery();

	                while (resultSet.next()) {
	                	RolesBean role = new RolesBean();
	                   
	                	role.setRoleID(resultSet.getString("roleID"));
	                	role.setRoleName(resultSet.getString("roleName"));
	                	role.setDescription(resultSet.getString("description"));
	                    
	                    allEmployees.add(role);
	                }
	            } catch (Exception e) {
	                // Handle exceptions
	                e.printStackTrace();
	            } finally {
	                // Close database resources (connection, statement, result set)
	                try {
	                    if (resultSet != null) resultSet.close();
	                    if (preparedStatement != null) preparedStatement.close();
	                    if (connection != null) connection.close();
	                } catch (Exception e) {
	                    // Handle exceptions
	                    e.printStackTrace();
	                }
	            }

	            return allEmployees;
	        }
	        
	        public static int totalCount() {
				 int count = 0;
				 Connection connection = null;
			        PreparedStatement ps = null;
			        ResultSet rs = null;
				 try {
					 connection = DBUtil.provideConnection();
				   String query = "select count(*) as count from roles";
				 ps = connection.prepareStatement(query);
				 rs = ps.executeQuery();
				 while (rs.next()) {
				 count = rs.getInt("count");
				 }
				 } catch (Exception e) {
				 e.printStackTrace();
				 } finally {
				 try {
					 connection.close();
				 } catch (SQLException ex) {
				 ex.printStackTrace();
				 }
				 }
				 return count;
				 }
	

	        public List<RolesBean> getRoles() {
	    	    List<RolesBean> roles = new ArrayList<>();

	    	    Connection connection = null;
	    	    PreparedStatement preparedStatement = null;
	    	    ResultSet resultSet = null;

	    	    try {
	    	        // Establish a database connection (you should use your database connection method)
	    	        connection = DBUtil.provideConnection(); // Replace with your connection method

	    	        // Create an SQL query to fetch data from the roles table
	    	        String query = "SELECT * FROM roles";
	    	        preparedStatement = connection.prepareStatement(query);
	    	        resultSet = preparedStatement.executeQuery();

	    	        while (resultSet.next()) {
	    	            // Create an AddRolesBean object for each row in the result set
	    	        	RolesBean role = new RolesBean();
	    	            role.setRoleID(resultSet.getString("RoleID"));
	    	            role.setRoleName(resultSet.getString("RoleName"));
	    	            role.setDescription(resultSet.getString("Description"));

	    	            // Add the role to the list
	    	            roles.add(role);
	    	        }
	    	    } catch (SQLException e) {
	    	        e.printStackTrace();
	    	    } finally {
	    	        // Close database resources (connection, statement, and result set) in a finally block
	    	        DBUtil.closeConnection(resultSet);
	    	        DBUtil.closeConnection(preparedStatement);
	    	        DBUtil.closeConnection(connection);
	    	    }

	    	    return roles;
	    	}
}

