
package com.weblabs.srv;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weblabs.utility.DBUtil;

@WebServlet("/AddAppointmentSrv1")
public class AddAppointmentSrv1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        commonLogic(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        commonLogic(request, response);

        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            ObjectMapper mapper = new ObjectMapper();
            JsonNode requestData = mapper.readTree(sb.toString());

            // Extract data from JSON
            String customerID = requestData.get("customerID").asText();
            String VIN = requestData.get("VIN").asText();
            String appointmentDate = requestData.get("appointmentdate").asText();
            String startTime = requestData.get("start_time").asText();
            double totalPrice = requestData.get("totalPrice").asDouble();
            int endTime = requestData.get("end_time").asInt();
            int totalTimeTakes = requestData.get("totalTimeTakes").asInt();
            String A11 = null;
            String A12 = null;
            String A13 = null;
            String A14 = null;
            String A15 = null;
            String A16 = null;
            String A17 = null;
            String A18 = null;

            int startHour = Integer.parseInt(startTime.split(" ")[0]);
            int endHour = endTime;

            // Iterate through time slots between start_time and end_time (inclusive)
            for (int i = startHour; i <= endHour; i++) {
                String currentSlot = i + " " + (i == 12 ? "PM" : (i < 12 ? "AM" : "PM"));

                switch (currentSlot) {
                    case "11 AM":
                        A11 = "11";
                        break;
                    case "12 PM":
                        A12 = "12";
                        break;
                    case "13 PM":
                        A13 = "13";
                        break;
                    case "14 PM":
                        A14 = "14";
                        break;
                    case "15 PM":
                        A15 = "15";
                        break;
                    case "16 PM":
                        A16 = "16";
                        break;
                    case "17 PM":
                        A17 = "17";
                        break;
                    case "18 PM":
                        A18 = "18";
                        break;
                   
                }}
            // Database operations
            Connection conn = DBUtil.provideConnection();
          
          // You need to implement this method  appointmentID, customerID, VIN, appointmentdate, A11, A12, A13, A14, A15, A16, A17, A18, start_time, end_time, end_datetime, status, serviceIDlist
            String insertAppointmentQuery = "INSERT INTO appointment (customerID, VIN, appointmentdate,A11, A12, A13, A14, A15, A16, A17, A18,status, start_time, end_time, end_datetime,total_price,total_timetakes) VALUES (?,?,?,?,?,?,?,?,?,?,?,'current',?,?,DATE_ADD(appointmentdate, INTERVAL end_time MINUTE),?,?)";
            
            PreparedStatement ps = conn.prepareStatement(insertAppointmentQuery,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, customerID);
            ps.setString(2, VIN);
            ps.setString(3, appointmentDate);
            ps.setString(4, A11);
            ps.setString(5, A12);
            ps.setString(6, A13);
            ps.setString(7, A14);
            ps.setString(8, A15);
            ps.setString(9, A16);
            ps.setString(10, A17);
            ps.setString(11, A18);
            ps.setString(12, startTime);
            ps.setInt(13, endTime);
            ps.setDouble(14, totalPrice);
            ps.setInt(15, totalTimeTakes);
            
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int appointmentID = generatedKeys.getInt(1);
                    
                    JsonNode selectedServicesNode = requestData.get("selectedServices");
                    if (selectedServicesNode.isArray()) {
                        for (JsonNode serviceNode : selectedServicesNode) {
                            String serviceID = serviceNode.get("serviceID").asText();
                            String serviceName = serviceNode.get("serviceName").asText();
                            double price = serviceNode.get("price").asDouble();
                            int timeTakes = serviceNode.get("timeTakes").asInt();
                            
                            // Insert service details
                            String insertServiceQuery = "INSERT INTO appointment_services (serviceID, serviceName, price, timeTakes, appointmentID) VALUES (?, ?, ?, ?, ?)";
                            PreparedStatement addressStatement = conn.prepareStatement(insertServiceQuery);
                            addressStatement.setString(1, serviceID);
                            addressStatement.setString(2, serviceName);
                            addressStatement.setDouble(3, price);
                            addressStatement.setInt(4, timeTakes);
                            addressStatement.setInt(5, appointmentID);
                            
                            addressStatement.execute();
                            addressStatement.close();
                        }
                    }
                }
            }
            conn.close();
            ps.close();
            
            // response.sendRedirect("addcustomerprofile.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            // response.sendRedirect("loginflutter.jsp");
        }
    }

    private void commonLogic(HttpServletRequest request, HttpServletResponse response) {
        // Common logic goes here
    }
}