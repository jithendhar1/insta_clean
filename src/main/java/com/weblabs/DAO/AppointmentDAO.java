package com.weblabs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.weblabs.beans.AppointmentBean;
import com.weblabs.utility.DBUtil;

public class AppointmentDAO {

	 public static List<AppointmentBean> getFilteredAppointment(String whereClause, int start, int limit) {
	        List<AppointmentBean> FilteredAppointments = new ArrayList<>();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	       
	        try {
	            connection = DBUtil.provideConnection();
	            String query;
	            if (whereClause != null && !whereClause.isEmpty()) {
	                query = "SELECT  appointmentID, customerID, vehicleID, serviceID, appointmentdate, status FROM appointment WHERE " + whereClause + " LIMIT ? , ?;";
	               
	            } else {
	                query = "SELECT  appointmentID, customerID, vehicleID, serviceID, appointmentdate, status FROM appointment LIMIT ? , ?;";
	            }

	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, start);
	            preparedStatement.setInt(2, limit );
	     
	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	            	AppointmentBean aaa = new AppointmentBean();
	            	aaa.setAppointmentID(resultSet.getString("appointmentID"));
	            	aaa.setCustomerID(resultSet.getString("customerID"));
	            	aaa.setVehicleID(resultSet.getString("vehicleID"));
	            	aaa.setServiceID(resultSet.getString("serviceID"));
	            	aaa.setAppointmentdate(resultSet.getString("appointmentdate"));
	            	aaa.setStatus(resultSet.getString("status"));
            	    
	            	FilteredAppointments.add(aaa);
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

	        return FilteredAppointments;
	        
	    } 
	  public static int totalCount() {
			 int count = 0;
			 Connection connection = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
			 try {
				 connection = DBUtil.provideConnection();
			   String query = "select count(*) as count from appointment";
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
