package com.weblabs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.weblabs.beans.ServiceBean;
import com.weblabs.utility.DBUtil;

public class ServiceDAO {

	 public static List<ServiceBean> getFilteredServices(String whereClause, int start, int limit) {
	        List<ServiceBean> FilteredServices = new ArrayList<>();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	       
	        try {
	            connection = DBUtil.provideConnection();
	            String query;
	            if (whereClause != null && !whereClause.isEmpty()) {
	                query = "SELECT  serviceID, servicename, description, price, discount, coupons,type FROM service WHERE " + whereClause + " LIMIT ? , ?;";
	               
	            } else {
	                query = "SELECT  serviceID, servicename, description, price, discount, coupons,type FROM service LIMIT ? , ?;";
	            }

	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, start);
	            preparedStatement.setInt(2, limit );
	     
	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	            	ServiceBean role = new ServiceBean();
	            role.setServiceID(resultSet.getString("serviceID"));
          	    role.setServicename(resultSet.getString("servicename"));
          	    role.setDescription(resultSet.getString("description"));
          	    role.setPrice(resultSet.getString("price"));
         	    role.setDiscount(resultSet.getString("discount"));
         	   role.setCoupons(resultSet.getString("coupons"));
         	  role.setType(resultSet.getString("type"));
         	  FilteredServices.add(role);
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

	        return FilteredServices;
	        
	    } 
	  public static int totalCount() {
			 int count = 0;
			 Connection connection = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
			 try {
				 connection = DBUtil.provideConnection();
			   String query = "select count(*) as count from service";
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
	  
	  public static List<ServiceBean> getAllService() {
		    List<ServiceBean> allS = new ArrayList<>();
		    Connection connection = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;

		    try {
		        connection = DBUtil.provideConnection();
		        String query = "SELECT  serviceID, servicename, description, price, discount, coupons,type FROM service;";
		        
		        preparedStatement = connection.prepareStatement(query);
		        resultSet = preparedStatement.executeQuery();

		        while (resultSet.next()) {
		        	ServiceBean aa = new ServiceBean();
		        	aa.setServiceID(resultSet.getString("serviceID"));
		        	aa.setServicename(resultSet.getString("servicename"));
		        	aa.setDescription(resultSet.getString("description"));
		        	aa.setPrice(resultSet.getString("price"));
		        	aa.setDiscount(resultSet.getString("discount"));
		        	aa.setCoupons(resultSet.getString("coupons"));
		            aa.setType(resultSet.getString("type"));
		            allS.add(aa);
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

		    return allS;
		}
	  
	  
	  //type (car or bike)
	  public static List<ServiceBean> getAllService(String type) {
		    List<ServiceBean> allS = new ArrayList<>();
		    Connection connection = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;

		    try {
		        connection = DBUtil.provideConnection();
		        
		        // Modify the query based on the specified type
		        String query = "SELECT serviceID, servicename, description, price, discount, coupons, type " +
		                       "FROM service WHERE type = ?;";
		        
		        preparedStatement = connection.prepareStatement(query);
		        preparedStatement.setString(1, type); // Set the type parameter
		        resultSet = preparedStatement.executeQuery();

		        while (resultSet.next()) {
		            ServiceBean aa = new ServiceBean();
		            aa.setServiceID(resultSet.getString("serviceID"));
		            aa.setServicename(resultSet.getString("servicename"));
		            aa.setDescription(resultSet.getString("description"));
		            aa.setPrice(resultSet.getString("price"));
		            aa.setDiscount(resultSet.getString("discount"));
		            aa.setCoupons(resultSet.getString("coupons"));
		            aa.setType(resultSet.getString("type"));
		            allS.add(aa);
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

		    return allS;
		}

}
	  

