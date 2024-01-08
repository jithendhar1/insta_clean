package com.weblabs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.weblabs.beans.AboutUsBean;
import com.weblabs.utility.DBUtil;

public class AboutUsDAO {

	//to retrive and show in data
	
	 public static List<AboutUsBean> getAllAboutUs() {
	        List<AboutUsBean> allAboutUsBean = new ArrayList<>();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            connection = DBUtil.provideConnection();
	            String query = "SELECT  aboutID, title, content FROM about ";
	            preparedStatement = connection.prepareStatement(query);
	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	            	AboutUsBean ss = new AboutUsBean();
	                ss.setAboutID(resultSet.getString("aboutID"));
	                ss.setTitle(resultSet.getString("title"));
	                ss.setContent(resultSet.getString("content"));
	                allAboutUsBean.add(ss);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	            // Close database resources (connection, statement, result set)
	        	 finally {
	        		 try {
	        			 connection.close();
	        		 } catch (SQLException ex) {
	        		 ex.printStackTrace();
	        		 }
	        	 }
	     

	        return allAboutUsBean;
	    }
	    
	    //-------------------------------------------------------------------
	    
	 
	    public static void addOrUpdateAS(AboutUsBean cs) {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connection = DBUtil.provideConnection();

	            // Check if a record already exists
	            if (getAboutUsCount() > 0) {
	                // Update existing record
	                String updateQuery = "UPDATE about SET title=?, content=? WHERE aboutID=?";
	                preparedStatement = connection.prepareStatement(updateQuery);
	                preparedStatement.setString(1, cs.getTitle());
	               
	            } else {
	                // Insert new record
	                String insertQuery = "INSERT INTO about (title, content) VALUES (?,?)";
	                preparedStatement = connection.prepareStatement(insertQuery);
	                preparedStatement.setString(1, cs.getTitle());
	                preparedStatement.setString(2, cs.getContent());
	                
	            }

	            // Execute the query
	            preparedStatement.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                // Close database resources (connection, statement)
	                preparedStatement.close();
	                connection.close();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	    }

	    private static int getAboutUsCount() throws SQLException {
	        Connection connection = DBUtil.provideConnection();
	        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM about");
	        ResultSet resultSet = preparedStatement.executeQuery();

	        int count = 0;
	        if (resultSet.next()) {
	            count = resultSet.getInt(1);
	        }

	        // Close database resources (connection, statement, result set)
	        resultSet.close();
	        preparedStatement.close();
	        connection.close();

	        return count;
	    }
	
}
