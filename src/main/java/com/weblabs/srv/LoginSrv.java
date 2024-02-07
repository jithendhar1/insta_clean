package com.weblabs.srv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weblabs.utility.DBUtil;

@WebServlet("/LoginSrv")
public class LoginSrv extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String phno = request.getParameter("phno");
        String otp = request.getParameter("otp");

        if (validate(request, phno, otp)) {
            response.sendRedirect("admin_dashboard.jsp");
        } else {
            String errorMessage = "Invalid username or password";
            request.setAttribute("error", errorMessage);
            request.setAttribute("wrongusername", "true"); // Set wrongusername attribute
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }

    private boolean validate(HttpServletRequest request, String phno, String otp) {
        Connection con = DBUtil.provideConnection();

        try {
            String sql = "SELECT customer.phno,otp.otp,customer.customerID,customer.customername,customer.RoleID "
                    + "FROM customer INNER JOIN otp ON otp.customerID=customer.customerID "
                    + "WHERE phno = ? AND otp = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, phno);
            statement.setString(2, otp);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                // If authentication is successful, set session attributes
                HttpSession session = request.getSession();
                session.setAttribute("otp", result.getString("otp"));
                session.setAttribute("customerID", result.getString("customerID"));
                session.setAttribute("phno", result.getString("phno"));
                session.setAttribute("customername", result.getString("customername"));
                session.setAttribute("RoleID", result.getString("RoleID"));
                con.close();

                // Redirect to TwilloSrv servlet using RequestDispatcher (uncomment if needed)
                // request.getRequestDispatcher("/TwilloSrv").forward(request, response);

                return true;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("wrongpassword", "true");
        } finally {
            // Close resources in the finally block
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return false;
    }
}
