
package com.weblabs.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.weblabs.utility.DBUtil;

public class PaymentTransactionsServiceImpl {

	
	
	public String addP(String transactionID,String customerID,String paymentamount,String paymentmethod,String transactionstatus,String datetimestamp,String cardholdername,String maskedcardnumber) {
		
		String Status1 = " Adding Failed!";

        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;

        try {
        	ps = con.prepareStatement("INSERT INTO paymenttransactions ( transactionID, customerID, paymentamount, paymentmethod, transactionstatus, datetimestamp, cardholdername, maskedcardnumber) VALUES (?,?,?,?,?,?,?,?)");
        	ps.setString(1, transactionID);
        	ps.setString(2, customerID);
            ps.setString(3, paymentamount);
            ps.setString(4, paymentmethod);
            ps.setString(5, transactionstatus);
            ps.setString(6, datetimestamp);
        	ps.setString(7, cardholdername);
            ps.setString(8, maskedcardnumber);
            
           
            int k = ps.executeUpdate();

            if (k > 0) {
                Status1 = " Added Successfully!";
            }
        } catch (SQLException e) {
            Status1 = "Error: " + e.getMessage();
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(con);
            DBUtil.closeConnection(ps);
        }

        return Status1;
	}
}