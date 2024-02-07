package com.weblabs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.weblabs.beans.AppointmentBean;
import com.weblabs.beans.AppointmentServicesBean;
import com.weblabs.utility.DBUtil;

public class AppointmentServicesDAO {

	
	public static List<AppointmentServicesBean> getAppointmentServicesBean(String whereClause, int start, int limit) {
	    List<AppointmentServicesBean> appointmentServicesList = new ArrayList<>();
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = DBUtil.provideConnection();
	        String query;
	        if (whereClause != null && !whereClause.isEmpty()) {
	        	query = "SELECT appointment_services.ID, appointment_services.serviceID, " +
	        	        "appointment_services.servicename, appointment_services.price, " +
	        	        "appointment_services.timetakes, appointment_services.appointmentID, " +
	        	        "appointment_services.workerID, appointment.appointmentdate, " +
	        	        "appointment.status " +
	        	        "FROM appointment_services " +
	        	        "JOIN appointment ON appointment_services.appointmentID = appointment.appointmentID " +
	        	        "WHERE appointment.status = 'current' AND "+ whereClause + " LIMIT ? , ?;";
  } else {
	            query = "SELECT appointment_services.ID, appointment_services.serviceID, " +
	                    "appointment_services.servicename, appointment_services.price, " +
	                    "appointment_services.timetakes, appointment_services.appointmentID, " +
	                    "appointment_services.workerID, appointment.appointmentdate, " +
	                    "appointment.status " +
	                    "FROM appointment_services " +
	                    "JOIN appointment ON appointment_services.appointmentID = appointment.appointmentID " +
	                    "WHERE appointment.status = 'current' LIMIT ?, ?;";
	        }

	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, start);
	        preparedStatement.setInt(2, limit);

	        resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            AppointmentServicesBean appointmentService = new AppointmentServicesBean();
	            AppointmentBean appointment = new AppointmentBean();

	            appointmentService.setID(resultSet.getString("ID"));
	            appointmentService.setServiceID(resultSet.getString("serviceID"));
	            appointmentService.setServicename(resultSet.getString("servicename"));
	            appointmentService.setPrice(resultSet.getString("price"));
	            appointmentService.setTimetakes(resultSet.getString("timetakes"));
	            appointmentService.setAppointmentID(resultSet.getString("appointmentID"));
	            appointmentService.setWorkerID(resultSet.getString("workerID"));

	            appointment.setAppointmentdate(resultSet.getString("appointmentdate"));
	            appointment.setStatus(resultSet.getString("status"));

	            appointmentService.setAppointment(appointment);

	            appointmentServicesList.add(appointmentService);
	        }
	    } catch (Exception e) {
	        // Handle exceptions more appropriately, log or throw a custom exception
	        e.printStackTrace();
	    } finally {
	        // Close database resources using try-with-resources to simplify code
	        try {
	            if (resultSet != null) resultSet.close();
	            if (preparedStatement != null) preparedStatement.close();
	            if (connection != null) connection.close();
	        } catch (Exception e) {
	            // Handle exceptions more appropriately, log or throw a custom exception
	            e.printStackTrace();
	        }
	    }

	    return appointmentServicesList;
	}

	
	public static int totalCount() {
		 int count = 0;
		 Connection connection = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
		 try {
			 connection = DBUtil.provideConnection();
		   String query = "select count(*) as count from appointment_services";
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
