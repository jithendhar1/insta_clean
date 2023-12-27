package com.weblabs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.weblabs.beans.AddressBean;
import com.weblabs.beans.CustomerBean;
import com.weblabs.utility.DBUtil;

public class CustomerDAO {

	
	public static List<CustomerBean> getFilteredCustomers(String whereClause, int start, int limit) {
		List<CustomerBean> FilteredCustomers = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DBUtil.provideConnection();
			String query;
			if (whereClause != null && !whereClause.isEmpty()) {
				
				query = "SELECT customerID, customername, email, phno, firstname, lastname from customer  WHERE " + whereClause + " LIMIT ?, ?;";

			} else {
				
				query = "SELECT customerID, customername, email, phno, firstname, lastname from customer" + " LIMIT ?, ?;";
			}
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, start);
			preparedStatement.setInt(2, limit);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				CustomerBean invoice = new CustomerBean();
				invoice.setCustomerID(resultSet.getString("customerID"));
				invoice.setCustomername(resultSet.getString("customername"));
				invoice.setEmail(resultSet.getString("email"));
				invoice.setPhno(resultSet.getString("phno"));
				invoice.setFirstname(resultSet.getString("firstname"));
				invoice.setLastname(resultSet.getString("lastname"));
				

				FilteredCustomers.add(invoice);
			}
		} catch (SQLException e) {
			// Handle exceptions or log them properly
			e.printStackTrace();
		} finally {
			// closeResources(connection, preparedStatement, resultSet);
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// Handle exceptions
				e.printStackTrace();
			}
		}

		return FilteredCustomers;
	}

	
	public static List<AddressBean> getInvoiceItemsByInvoiceId(String invoiceId) {
	    List<AddressBean> invoiceItemsByInvoiceId = new ArrayList<>();
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = DBUtil.provideConnection();
	        String query = "SELECT addressID, customerID, street, city, postal_code, state, hno FROM address WHERE customerID = ?";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, invoiceId);

	        resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	        	AddressBean invoiceItem = new AddressBean();
	            invoiceItem.setAddressID(resultSet.getString("addressID"));
	            invoiceItem.setCustomerID(resultSet.getString("customerID"));
	            invoiceItem.setStreet(resultSet.getString("street"));
	            invoiceItem.setCity(resultSet.getString("city"));
	            invoiceItem.setPostal_code(resultSet.getString("postal_code"));
	            invoiceItem.setState(resultSet.getString("state"));
	            invoiceItem.setHno(resultSet.getString("hno"));
	            invoiceItemsByInvoiceId.add(invoiceItem);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (Exception e) {
	            // Handle exceptions
	            e.printStackTrace();
	        }
	    }

	    return invoiceItemsByInvoiceId;
	}


	public static int totalCount() {
		int count = 0;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = DBUtil.provideConnection();
			String query = "select count(*) as count from customer";
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
