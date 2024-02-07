package com.weblabs.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.weblabs.utility.DBUtil;

public class AppointmentServicesServiceImpl {

	

public String editV(String ID,String serviceID,String servicename,String price,String timetakes,String appointmentID,String workerID)  {
	
	String Status3 = "Updating  Failed!";

    Connection con = DBUtil.provideConnection();
    PreparedStatement ps = null;

    try {
    	ps = con.prepareStatement("UPDATE appointment_services SET   serviceID=?, servicename=?, price=?, timetakes=?, appointmentID=?, workerID=? WHERE ID = ?");
    	
    	ps.setString(1, serviceID);
    	ps.setString(2, servicename);
        ps.setString(3, price);
        ps.setString(4, timetakes);
        ps.setString(5, appointmentID);
        ps.setString(6, workerID);
        ps.setString(7, ID); 
       
        int k = ps.executeUpdate();

        if (k > 0) {
        	Status3 = "Updating Successfully!";
        }
    }
     catch (SQLException e) {
    	Status3 = "Error: " + e.getMessage();
        e.printStackTrace();
    } finally {
        DBUtil.closeConnection(con);
        DBUtil.closeConnection(ps);
    }

    return Status3 ;
}}