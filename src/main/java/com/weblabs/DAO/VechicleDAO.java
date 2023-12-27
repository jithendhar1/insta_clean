package com.weblabs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.weblabs.beans.VechicleBean;
import com.weblabs.utility.DBUtil;

public class VechicleDAO {

	 public static List<VechicleBean> getFilteredVechicles(String whereClause, int start, int limit) {
	        List<VechicleBean> FilteredVechicles = new ArrayList<>();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	       
	        try {
	            connection = DBUtil.provideConnection();
	            String query;
	            if (whereClause != null && !whereClause.isEmpty()) {
	                query = "SELECT  vehicleID, customerID, vehicleType, vehicleModel, VIN FROM vehicle WHERE " + whereClause + " LIMIT ? , ?;";
	               
	            } else {
	                query = "SELECT  vehicleID, customerID, vehicleType, vehicleModel, VIN FROM vehicle LIMIT ? , ?;";
	            }

	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, start);
	            preparedStatement.setInt(2, limit );
	     
	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	            	VechicleBean role = new VechicleBean();
	            	role.setVehicleID(resultSet.getString("vehicleID"));
             	    role.setCustomerID(resultSet.getString("customerID"));
             	    role.setVehicleType(resultSet.getString("vehicleType"));
             	    role.setVehicleModel(resultSet.getString("vehicleModel"));
            	    role.setVIN(resultSet.getString("VIN"));
            	    
            	    FilteredVechicles.add(role);
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

	        return FilteredVechicles;
	        
	    } 
	  public static int totalCount() {
			 int count = 0;
			 Connection connection = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
			 try {
				 connection = DBUtil.provideConnection();
			   String query = "select count(*) as count from vehicle";
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
}
