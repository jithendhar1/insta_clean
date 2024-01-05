package com.weblabs.DAO;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.weblabs.beans.InvoiceBean;
import com.weblabs.beans.InvoicitemsBean;

import com.weblabs.utility.DBUtil;

public class InvoiceDAO {

	public static List<InvoiceBean> getFilteredInvoices(String whereClause, int start, int limit) {
		List<InvoiceBean> filteredInvoices = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DBUtil.provideConnection();
			String query;
			if (whereClause != null && !whereClause.isEmpty()) {
				
				query = "SELECT invoiceID, appointmentID, customerID, invoicedate, duedate, totalamt, otherinformation, tax, discount, taxamount from invoice "
				        + "WHERE " + whereClause + " LIMIT ?, ?;";

			} else {
				
				query = "SELECT invoiceID, appointmentID, customerID, invoicedate, duedate, totalamt, otherinformation, tax, discount, taxamount from invoice"
				        + " LIMIT ?, ?;";

			}
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, start);
			preparedStatement.setInt(2, limit);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				InvoiceBean invoice = new InvoiceBean();
				invoice.setInvoiceID(resultSet.getString("invoiceID"));
				invoice.setAppointmentID(resultSet.getString("appointmentID"));
				invoice.setCustomerID(resultSet.getString("customerID"));
				invoice.setInvoicedate(resultSet.getString("invoicedate"));
				invoice.setDuedate(resultSet.getString("duedate"));
				invoice.setTotalamt(resultSet.getString("totalamt"));
				invoice.setOtherinformation(resultSet.getString("otherinformation"));
				invoice.setTax(resultSet.getString("tax"));
				invoice.setDiscount(resultSet.getString("discount"));
				invoice.setTaxamount(resultSet.getString("taxamount"));
				

				filteredInvoices.add(invoice);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
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

		return filteredInvoices;
	}

	public static List<InvoicitemsBean> getInvoiceItemsByInvoiceId(String invoiceID) {
	    List<InvoicitemsBean> invoiceItemsByInvoiceId = new ArrayList<>();
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = DBUtil.provideConnection();
	        String query = "SELECT serviceitem, description, unitcost, qty, amount from invoiceitems WHERE invoiceID = ? ";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, invoiceID);

	        resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	        	InvoicitemsBean invoiceItem = new InvoicitemsBean();
	            
	            invoiceItem.setServiceitem(resultSet.getString("serviceitem"));
	            invoiceItem.setDescription(resultSet.getString("description"));
	            invoiceItem.setUnitcost(resultSet.getString("unitcost"));
	            invoiceItem.setQty(resultSet.getString("qty"));
	            invoiceItem.setAmount(resultSet.getString("amount"));
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
			String query = "select count(*) as count from invoice";
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

	public static double getSumOfAmountForAllItems() {
	    double sum = 0.0;
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = DBUtil.provideConnection();
	        String query = "SELECT SUM(Amount) AS totalamount FROM invoiceitems";
	        preparedStatement = connection.prepareStatement(query);
	        resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            sum = resultSet.getDouble("totalamount");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null)
	                resultSet.close();
	            if (preparedStatement != null)
	                preparedStatement.close();
	            if (connection != null)
	                connection.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return sum;
	}

}
	  
	  