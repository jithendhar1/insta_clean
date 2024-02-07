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

public class AppointmentDAO {
	
	
//ADMIN
	 public static List<AppointmentBean> getFilteredAppointment(String whereClause, int start, int limit) {
	        List<AppointmentBean> FilteredAppointments = new ArrayList<>();
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	       
	        try {
	            connection = DBUtil.provideConnection();
	            String query;
	            if (whereClause != null && !whereClause.isEmpty()) {
	                query = "SELECT  appointmentID, customerID, VIN, appointmentdate, A11, A12, A13, A14, A15, A16, A17, A18, start_time, end_time, end_datetime, status, total_price, total_timetakes FROM appointment WHERE " + whereClause + " LIMIT ? , ?;";
	               
	            } else {
	                query = "SELECT  appointmentID, customerID, VIN, appointmentdate, A11, A12, A13, A14, A15, A16, A17, A18, start_time, end_time, end_datetime, status, total_price, total_timetakes FROM appointment LIMIT ? , ?;";
	            }

	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, start);
	            preparedStatement.setInt(2, limit );
	     
	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	            	AppointmentBean aaa = new AppointmentBean();
	            	aaa.setAppointmentID(resultSet.getString("appointmentID"));
	            	aaa.setCustomerID(resultSet.getString("customerID"));
	            	aaa.setVIN(resultSet.getString("VIN"));
	            	aaa.setAppointmentdate(resultSet.getString("appointmentdate"));
	            	aaa.setStart_time(resultSet.getString("start_time"));
	            	aaa.setEnd_time(resultSet.getString("end_time"));
	            	aaa.setEnd_datetime(resultSet.getString("end_datetime"));
	            	aaa.setStatus(resultSet.getString("status"));
	            	aaa.setTotal_price(resultSet.getString("total_price"));
		            aaa.setTotal_timetakes(resultSet.getString("total_timetakes"));
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
	  public static int completedCount() {
		    int count = 0;
		    Connection connection = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;
		    try {
		        connection = DBUtil.provideConnection();
		        String query = "SELECT COUNT(*) AS count FROM appointment WHERE status = 'completed'";
		        ps = connection.prepareStatement(query);
		        rs = ps.executeQuery();
		        while (rs.next()) {
		            count = rs.getInt("count");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (connection != null) {
		                connection.close();
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		    return count;
		}
		public static int currentCount() {
		    int count = 0;
		    Connection connection = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;
		    try {
		        connection = DBUtil.provideConnection();
		        String query = "SELECT COUNT(*) AS count FROM appointment WHERE status = 'current'";
		        ps = connection.prepareStatement(query);
		        rs = ps.executeQuery();
		        while (rs.next()) {
		            count = rs.getInt("count");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (connection != null) {
		                connection.close();
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		    return count;
		}
		public static int cancelledCount() {
		    int count = 0;
		    Connection connection = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;
		    try {
		        connection = DBUtil.provideConnection();
		        String query = "SELECT COUNT(*) AS count FROM appointment WHERE status = 'cancelled'";
		        ps = connection.prepareStatement(query);
		        rs = ps.executeQuery();
		        while (rs.next()) {
		            count = rs.getInt("count");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (connection != null) {
		                connection.close();
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		    return count;
		}
	// Aravindh retrieve data of appointment for each vehicle (ID)
	  public static List<AppointmentBean> getAppointmentByVehicleID(String VIN) {
	      List<AppointmentBean> vehicleAppointments = new ArrayList<>();
	      Connection connection = null;
	      PreparedStatement preparedStatement = null;
	      ResultSet resultSet = null;

	      try {
	          connection = DBUtil.provideConnection();
	          String query = "SELECT appointmentID, customerID, VIN, appointmentdate, A11, A12, A13, A14, A15, A16, A17, A18, start_time, end_time, end_datetime, status, total_price, total_timetakes FROM appointment WHERE VIN = ?;";
	          
	          preparedStatement = connection.prepareStatement(query);
	          preparedStatement.setString(1, VIN);
	          resultSet = preparedStatement.executeQuery();

	          while (resultSet.next()) {
	              AppointmentBean aaa = new AppointmentBean();
	              aaa.setAppointmentID(resultSet.getString("appointmentID"));
	              aaa.setCustomerID(resultSet.getString("customerID"));
	              aaa.setVIN(resultSet.getString("VIN"));
	              aaa.setAppointmentdate(resultSet.getString("appointmentdate"));
	              aaa.setA11(resultSet.getString("A11"));
	              aaa.setA12(resultSet.getString("A12"));        
	              aaa.setA13(resultSet.getString("A13"));
	              aaa.setA14(resultSet.getString("A14"));
	              aaa.setA15(resultSet.getString("A15"));        
	              aaa.setA16(resultSet.getString("A16"));
	              aaa.setA17(resultSet.getString("A17"));
	              aaa.setA18(resultSet.getString("A18"));        
	              aaa.setStart_time(resultSet.getString("start_time"));
	              aaa.setEnd_time(resultSet.getString("end_time"));
	              aaa.setEnd_datetime(resultSet.getString("end_datetime"));
	              aaa.setStatus(resultSet.getString("status"));
	              aaa.setTotal_price(resultSet.getString("total_price"));
	              aaa.setTotal_timetakes(resultSet.getString("total_timetakes"));
	             
	              vehicleAppointments.add(aaa);
	          }
	      } catch (SQLException e) {
	          e.printStackTrace(); 
	      } catch (Exception e) {
	        
	          e.printStackTrace();
	      } finally {
	          
	          try {
	              if (resultSet != null) resultSet.close();
	              if (preparedStatement != null) preparedStatement.close();
	              if (connection != null) connection.close();
	          } catch (Exception e) {
	             
	              e.printStackTrace();
	          }
	      }

	      return vehicleAppointments;
	  }

	  
	  //aravindh retrive data of all appointment of each appointment(ID)
	  public static List<AppointmentBean> getAppointmentByappointmentID(String appointmentID) {
		    List<AppointmentBean> appointmentappointments = new ArrayList<>();
		    Connection connection = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;

		    try {
		        connection = DBUtil.provideConnection();
		        String query = "SELECT  appointmentID, customerID, VIN, appointmentdate, A11, A12, A13, A14, A15, A16, A17, A18, start_time, end_time, end_datetime, status, total_price, total_timetakes  FROM appointment WHERE appointmentID = ?;";
		        
		        preparedStatement = connection.prepareStatement(query);
		        preparedStatement.setString(1, appointmentID);
		        resultSet = preparedStatement.executeQuery();

		        while (resultSet.next()) {
		        	
		        	AppointmentBean aaa = new AppointmentBean();
	            	aaa.setAppointmentID(resultSet.getString("appointmentID"));
	            	aaa.setCustomerID(resultSet.getString("customerID"));
	            	aaa.setVIN(resultSet.getString("VIN"));
	            	aaa.setAppointmentdate(resultSet.getString("appointmentdate"));
	            	aaa.setA11(resultSet.getString("A11"));
	            	aaa.setA12(resultSet.getString("A12"));		
	            	aaa.setA13(resultSet.getString("A13"));
	            	aaa.setA14(resultSet.getString("A14"));
	            	aaa.setA15(resultSet.getString("A15"));		
	            	aaa.setA16(resultSet.getString("A16"));
	            	aaa.setA17(resultSet.getString("A17"));
	            	aaa.setA18(resultSet.getString("A18"));	
	            	aaa.setStart_time(resultSet.getString("start_time"));
		            aaa.setEnd_time(resultSet.getString("end_time"));
		            aaa.setEnd_datetime(resultSet.getString("end_datetime"));
		            aaa.setStatus(resultSet.getString("status"));
		            aaa.setTotal_price(resultSet.getString("total_price"));
		            aaa.setTotal_timetakes(resultSet.getString("total_timetakes"));
	            	appointmentappointments.add(aaa);
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

		    return appointmentappointments;
		}

		

		  
//Admin 
		  public static List<AppointmentBean> AppointmentCancelled() {
			    List<AppointmentBean> filteredAppointments = new ArrayList<>();
			    Connection connection = null;
			    PreparedStatement preparedStatement = null;
			    ResultSet resultSet = null;

			    try {
			        connection = DBUtil.provideConnection();
			        String query = "SELECT appointmentID, customerID, VIN, appointmentdate, A11, A12, A13, A14, A15, A16, A17, A18, start_time, end_time, end_datetime, status, total_price, total_timetakes FROM appointment WHERE status = 'cancelled'";

			        preparedStatement = connection.prepareStatement(query);
			        resultSet = preparedStatement.executeQuery();

			        while (resultSet.next()) {
			            AppointmentBean aaa = new AppointmentBean();
			            aaa.setAppointmentID(resultSet.getString("appointmentID"));
			            aaa.setCustomerID(resultSet.getString("customerID"));
			            aaa.setVIN(resultSet.getString("VIN"));
			            aaa.setAppointmentdate(resultSet.getString("appointmentdate"));
			            aaa.setStart_time(resultSet.getString("start_time"));
			            aaa.setEnd_time(resultSet.getString("end_time"));
			            aaa.setEnd_datetime(resultSet.getString("end_datetime"));
			          	aaa.setStart_time(resultSet.getString("start_time"));
			            aaa.setEnd_time(resultSet.getString("end_time"));
			            aaa.setEnd_datetime(resultSet.getString("end_datetime"));
			            aaa.setStatus(resultSet.getString("status"));
			            aaa.setTotal_price(resultSet.getString("total_price"));
			            aaa.setTotal_timetakes(resultSet.getString("total_timetakes"));

			            filteredAppointments.add(aaa);
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

			    return filteredAppointments;
			}

//Admin Completed Bookings
		  public static List<AppointmentBean> getFilteredAppointmentCompleted(String whereClause, int start, int limit) {
			    List<AppointmentBean> filteredAppointments = new ArrayList<>();
			    Connection connection = null;
			    PreparedStatement preparedStatement = null;
			    ResultSet resultSet = null;

			    try {
			        connection = DBUtil.provideConnection();
			        String query;
			        if (whereClause != null && !whereClause.isEmpty()) {
			            query = "SELECT  appointmentID, customerID, VIN, appointmentdate, A11, A12, A13, A14, A15, A16, A17, A18, start_time, end_time, end_datetime, status, total_price, total_timetakes FROM appointment WHERE status='completed' " + whereClause + " LIMIT ?, ?;";
			        } else {
			            query = "SELECT  appointmentID, customerID, VIN, appointmentdate, A11, A12, A13, A14, A15, A16, A17, A18, start_time, end_time, end_datetime, status, total_price, total_timetakes FROM appointment WHERE status='completed' LIMIT ?, ?;";
			        }

			        preparedStatement = connection.prepareStatement(query);
			        preparedStatement.setInt(1, start);
			        preparedStatement.setInt(2, limit);

			        resultSet = preparedStatement.executeQuery();

			        while (resultSet.next()) {
			            AppointmentBean aaa = new AppointmentBean();
			            aaa.setAppointmentID(resultSet.getString("appointmentID"));
			            aaa.setCustomerID(resultSet.getString("customerID"));
			            aaa.setVIN(resultSet.getString("VIN"));
			            aaa.setAppointmentdate(resultSet.getString("appointmentdate"));
			            aaa.setStart_time(resultSet.getString("start_time"));
			            aaa.setEnd_time(resultSet.getString("end_time"));
			            aaa.setEnd_datetime(resultSet.getString("end_datetime"));
			            aaa.setStatus(resultSet.getString("status"));

			            filteredAppointments.add(aaa);
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

			    return filteredAppointments;
			}
		//Admin Cancelled Bookings
		  public static  List<AppointmentBean> getFilteredAppointmentCancelled() {
			    List<AppointmentBean> filteredAppointments = new ArrayList<>();
			    Connection connection = null;
			    PreparedStatement preparedStatement = null;
			    ResultSet resultSet = null;

			    try {
			        connection = DBUtil.provideConnection();
			        String query = "appointmentID, customerID, VIN, appointmentdate, A11, A12, A13, A14, A15, A16, A17, A18, start_time, end_time, end_datetime, status, total_price, total_timetakes FROM appointment WHERE status = 'cancelled'";

			        preparedStatement = connection.prepareStatement(query);
			        resultSet = preparedStatement.executeQuery();

			        while (resultSet.next()) {
			            AppointmentBean aaa = new AppointmentBean();
			            aaa.setAppointmentID(resultSet.getString("appointmentID"));
			            aaa.setCustomerID(resultSet.getString("customerID"));
			            aaa.setVIN(resultSet.getString("VIN"));
			            aaa.setAppointmentdate(resultSet.getString("appointmentdate"));
			            aaa.setStart_time(resultSet.getString("start_time"));
			            aaa.setEnd_time(resultSet.getString("end_time"));
			            aaa.setEnd_datetime(resultSet.getString("end_datetime"));
			            aaa.setStatus(resultSet.getString("status"));

			            filteredAppointments.add(aaa);
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
			            e.printStackTrace();
			        }
			    }

			    return filteredAppointments;
			}


		//Admin Current Bookings	  
		  public static List<AppointmentBean> getFilteredAppointmentCurrent(String whereClause, int start, int limit) {
			    List<AppointmentBean> filteredAppointments = new ArrayList<>();
			    Connection connection = null;
			    PreparedStatement preparedStatement = null;
			    ResultSet resultSet = null;

			    try {
			        connection = DBUtil.provideConnection();
			        String query;
			        if (whereClause != null && !whereClause.isEmpty()) {
			            query = "SELECT  appointmentID, customerID, VIN, appointmentdate, start_time, end_time, end_datetime, status FROM appointment WHERE status='current' " + whereClause + " LIMIT ?, ?;";
			        } else {
			            query = "SELECT  appointmentID, customerID, VIN, appointmentdate, start_time, end_time, end_datetime, status FROM appointment WHERE status='current' LIMIT ?, ?;";
			        }

			        preparedStatement = connection.prepareStatement(query);
			        preparedStatement.setInt(1, start);
			        preparedStatement.setInt(2, limit);

			        resultSet = preparedStatement.executeQuery();

			        while (resultSet.next()) {
			            AppointmentBean aaa = new AppointmentBean();
			            aaa.setAppointmentID(resultSet.getString("appointmentID"));
			            aaa.setCustomerID(resultSet.getString("customerID"));
			            aaa.setVIN(resultSet.getString("VIN"));
			            aaa.setAppointmentdate(resultSet.getString("appointmentdate"));
			            aaa.setStart_time(resultSet.getString("start_time"));
			            aaa.setEnd_time(resultSet.getString("end_time"));
			            aaa.setEnd_datetime(resultSet.getString("end_datetime"));
			            aaa.setStatus(resultSet.getString("status"));

			            filteredAppointments.add(aaa);
			        }
			    } catch (Exception e) {
			        e.printStackTrace();
			    } finally {
			        // Close database resources (connection, statement, result set)
			        try {
			            if (resultSet != null) resultSet.close();
			            if (preparedStatement != null) preparedStatement.close();
			            if (connection != null) connection.close();
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			    }

			    return filteredAppointments;
			}

		  
		 
		//ARAVINDH NEW CID current (imp)
		  public static List<AppointmentBean> getAppointmentBycustomerIDcurrent(String customerID) {
			    List<AppointmentBean> Appointments = new ArrayList<>();
			    Connection connection = null;
			    PreparedStatement preparedStatement = null;
			    ResultSet resultSet = null;

			    try {
			        connection = DBUtil.provideConnection();
			        String query = "SELECT appointmentID, customerID, VIN, appointmentdate, A11, A12, A13, A14, A15, A16, A17, A18, start_time, end_time, end_datetime, status, total_price, total_timetakes FROM appointment WHERE customerID = ? and status='current';";

			        preparedStatement = connection.prepareStatement(query);
			        preparedStatement.setString(1, customerID);
			        resultSet = preparedStatement.executeQuery();

			        while (resultSet.next()) {
			            AppointmentBean aaa = new AppointmentBean();
			            aaa.setAppointmentID(resultSet.getString("appointmentID"));
			            aaa.setCustomerID(resultSet.getString("customerID"));
			            aaa.setVIN(resultSet.getString("VIN"));
			            aaa.setAppointmentdate(resultSet.getString("appointmentdate"));
			            aaa.setA11(resultSet.getString("A11"));
			            aaa.setA12(resultSet.getString("A12"));
			            aaa.setA13(resultSet.getString("A13"));
			            aaa.setA14(resultSet.getString("A14"));
			            aaa.setA15(resultSet.getString("A15"));
			            aaa.setA16(resultSet.getString("A16"));
			            aaa.setA17(resultSet.getString("A17"));
			            aaa.setA18(resultSet.getString("A18"));
			            aaa.setStart_time(resultSet.getString("start_time"));
			            aaa.setEnd_time(resultSet.getString("end_time"));
			            aaa.setEnd_datetime(resultSet.getString("end_datetime"));
			            aaa.setStatus(resultSet.getString("status"));
			            aaa.setTotal_price(resultSet.getString("total_price"));
			            aaa.setTotal_timetakes(resultSet.getString("total_timetakes"));
			            List<AppointmentServicesBean> serviceDetailsList = new ArrayList<>();
			            
			            String appointmentID = resultSet.getString("appointmentID");
			            String serviceQuery = "SELECT ID, serviceID, servicename, price, timetakes FROM appointment_services WHERE appointmentID = ?";
			            
			            try (PreparedStatement serviceStatement = connection.prepareStatement(serviceQuery)) {
			                serviceStatement.setString(1, appointmentID);
			                ResultSet serviceResultSet = serviceStatement.executeQuery();

			                while (serviceResultSet.next()) {
			                    AppointmentServicesBean serviceDetails = new AppointmentServicesBean();
			                    serviceDetails.setServiceID(serviceResultSet.getString("serviceID"));
			                    serviceDetails.setServicename(serviceResultSet.getString("servicename"));
			                    serviceDetails.setPrice(serviceResultSet.getString("price"));
			                    serviceDetails.setTimetakes(serviceResultSet.getString("timetakes"));
			                    serviceDetailsList.add(serviceDetails);
			                }
			            } catch (SQLException e) {
			                e.printStackTrace(); // Handle the exception as needed
			            }

			            aaa.setServiceDetailsList(serviceDetailsList);
			            Appointments.add(aaa); 
			        }
			    } catch (Exception e) {
			        // Handle exceptions
			        e.printStackTrace();
			    } finally {
			        // Close database resources (statement, result set)
			        try {
			            if (resultSet != null) resultSet.close();
			            if (preparedStatement != null) preparedStatement.close();
			        } catch (Exception e) {
			            // Handle exceptions
			            e.printStackTrace();
			        }
			        // Connection should not be closed here
			    }

			    return Appointments;
			}	  
}
		  
		 



