
package com.weblabs.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weblabs.service.impl.PaymentTransactionsServiceImpl;

@WebServlet("/AddPaymentTransactionsSrv")
public class AddPaymentTransactionsSrv extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       

        String status = "Add Failed!";
        String transactionID = request.getParameter("transactionID");
        String customerID = request.getParameter("customerID");
        String paymentamount = request.getParameter("paymentamount");
        String paymentmethod = request.getParameter("paymentmethod");
        String transactionstatus = request.getParameter("transactionstatus");
        String datetimestamp = request.getParameter("datetimestamp");
        String cardholdername = request.getParameter("cardholdername");
        String maskedcardnumber = request.getParameter("maskedcardnumber");
        
        PaymentTransactionsServiceImpl add = new PaymentTransactionsServiceImpl();
        status = add.addP( transactionID, customerID, paymentamount, paymentmethod, transactionstatus, datetimestamp, cardholdername, maskedcardnumber);

        RequestDispatcher rd = request.getRequestDispatcher("vechicle_add.jsp?message=" + status);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}








