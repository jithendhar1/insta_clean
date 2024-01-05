package com.weblabs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.weblabs.beans.WorkerBean;
import com.weblabs.utility.DBUtil;

public class WorkerDAO {

	 public static List<WorkerBean> getFilteredWorkers(String whereClause, int start, int limit) {
	        List<WorkerBean> FilteredWorkers = new ArrayList<>();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	       
	        try {
	            connection = DBUtil.provideConnection();
	            String query;
	            if (whereClause != null && !whereClause.isEmpty()) {
	                query = "SELECT  workerID, worker_name, phno, address, salary FROM workers_details WHERE " + whereClause + " LIMIT ? , ?;";
	               
	            } else {
	                query = "SELECT  workerID, worker_name, phno, address, salary FROM workers_details LIMIT ? , ?;";
	            }

	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, start);
	            preparedStatement.setInt(2, limit );
	     
	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	            	WorkerBean role = new WorkerBean();
	            role.setWorkerID(resultSet.getString("workerID"));
          	    role.setWorker_name(resultSet.getString("worker_name"));
          	    role.setPhno(resultSet.getString("phno"));
          	    role.setAddress(resultSet.getString("address"));
         	    role.setSalary(resultSet.getString("salary"));
         	    
         	   FilteredWorkers.add(role);
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

	        return FilteredWorkers;
	        
	    } 
	  public static int totalCount() {
			 int count = 0;
			 Connection connection = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
			 try {
				 connection = DBUtil.provideConnection();
			   String query = "select count(*) as count from workers_details";
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
