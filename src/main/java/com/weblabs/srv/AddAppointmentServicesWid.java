package com.weblabs.srv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;  // Import SQLException for proper exception handling

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weblabs.utility.DBUtil;

@WebServlet("/AddAppointmentServicesWid")
public class AddAppointmentServicesWid extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String status1 = "Add Failed!";
        try {
            String workerID = request.getParameter("workerID");

            Connection conn = null;
            PreparedStatement customerStatement = null;

            try {
                conn = DBUtil.provideConnection();
                if (conn != null) {
                    customerStatement = conn.prepareStatement(
                            "INSERT INTO appointment_services (workerID) " + // Specify column names
                                    "VALUES (?)"
                    );

                    // Set parameters for customerStatement
                    customerStatement.setString(1, workerID);
                    customerStatement.executeUpdate();  // Execute the SQL statement

                    response.sendRedirect(".jsp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle SQL exception or log the error
                response.sendRedirect("error.jsp");
            } finally {
                // Close resources in a finally block to ensure they are always closed
                try {
                    if (customerStatement != null) {
                        customerStatement.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            //response.sendRedirect("loginflutter.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
