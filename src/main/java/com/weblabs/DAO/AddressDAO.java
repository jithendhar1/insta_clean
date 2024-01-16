package com.weblabs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.weblabs.beans.AddressBean;
import com.weblabs.utility.DBUtil;

public class AddressDAO {

	
	 public static List<AddressBean> getAddressByCustomerID(String customerID) {
		    List<AddressBean> customerAddresses = new ArrayList<>();
		    Connection connection = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;

		    try {
		        connection = DBUtil.provideConnection();
		        String query = "SELECT addressID, customerID, street, city, postal_code, state, hno FROM address WHERE customerID = ?;";
		        
		        preparedStatement = connection.prepareStatement(query);
		        preparedStatement.setString(1, customerID);
		        resultSet = preparedStatement.executeQuery();

		        while (resultSet.next()) {
		        	AddressBean vehicle = new AddressBean();
		            vehicle.setAddressID(resultSet.getString("addressID"));
		            vehicle.setCustomerID(resultSet.getString("customerID"));
		            vehicle.setStreet(resultSet.getString("street"));
		            vehicle.setCity(resultSet.getString("city"));
		            vehicle.setPostal_code(resultSet.getString("postal_code"));
		            vehicle.setState(resultSet.getString("state"));
		            vehicle.setHno(resultSet.getString("hno"));
		            
		            customerAddresses.add(vehicle);
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

		    return customerAddresses;
		}
	
}
