package com.weblabs.srv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weblabs.utility.DBUtil;

@WebServlet("/DAOWorkplaceServlet")
public class DAOWorkplaceServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetch workplace value from the database based on the request parameters
        // You need to implement this part based on your database logic

        // For demonstration purposes, let's assume workplace value is fetched using
        // getWorkplaceByAppointmentDate method
        String appointmentDate = request.getParameter("appointmentdate");
        String start_time = request.getParameter("start_time");
        List<String> workplaceValue = getWorkplacesByAppointmentDate(appointmentDate,start_time);

        // Return the workplace value as a response
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.print(workplaceValue);
        out.flush();
    }

    public static List<String> getWorkplacesByAppointmentDate(String appointmentdate,String start_time) {
        List<String> workplaces = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.provideConnection();
            String query = "SELECT workplace FROM appointment WHERE appointmentdate = ? AND start_time=?;";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, appointmentdate);
            preparedStatement.setString(2, start_time);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String workplace = resultSet.getString("workplace");
                workplaces.add(workplace);
            }
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        } finally {
            // Close database resources (connection, statement, result set)
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

        return workplaces;
    }

}
