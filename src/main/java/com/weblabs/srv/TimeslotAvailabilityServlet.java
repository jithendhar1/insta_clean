package com.weblabs.srv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weblabs.utility.DBUtil;

@WebServlet("/YourAvailabilityEndpoint")
public class TimeslotAvailabilityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        // Get the appointment date from the request
        String appointmentDate = request.getParameter("appointmentDate");

        // Perform database query to get availability
        try (Connection connection = DBUtil.provideConnection()) {
        	
            String query = "SELECT COUNT(CASE WHEN A11 IS NOT NULL THEN 1 END) AS cnt_11, " +
                           "COUNT(CASE WHEN A12 IS NOT NULL THEN 1 END) AS cnt_12, " +
                           "COUNT(CASE WHEN A13 IS NOT NULL THEN 1 END) AS cnt_13, " +
                           "COUNT(CASE WHEN A14 IS NOT NULL THEN 1 END) AS cnt_14, " +
                           "COUNT(CASE WHEN A15 IS NOT NULL THEN 1 END) AS cnt_15, " +
                           "COUNT(CASE WHEN A16 IS NOT NULL THEN 1 END) AS cnt_16, " +
                           "COUNT(CASE WHEN A17 IS NOT NULL THEN 1 END) AS cnt_17, " +
                           "COUNT(CASE WHEN A18 IS NOT NULL THEN 1 END) AS cnt_18 " +
                           "FROM appointment WHERE appointmentdate = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, appointmentDate);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Convert availability to JSON format and send it to the client
                        out.println("{"
                                + "\"availability11\": " + resultSet.getInt("cnt_11") + ","
                                + "\"availability12\": " + resultSet.getInt("cnt_12") + ","
                                + "\"availability13\": " + resultSet.getInt("cnt_13") + ","
                                + "\"availability14\": " + resultSet.getInt("cnt_14") + ","
                                + "\"availability15\": " + resultSet.getInt("cnt_15") + ","
                                + "\"availability16\": " + resultSet.getInt("cnt_16") + ","
                                + "\"availability17\": " + resultSet.getInt("cnt_17") + ","
                                + "\"availability18\": " + resultSet.getInt("cnt_18")
                                + "}");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("{ \"error\": \"Internal Server Error\" }");
        }
    }
}
