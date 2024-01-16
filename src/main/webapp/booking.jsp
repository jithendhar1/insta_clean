<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.weblabs.DAO.ServiceDAO"%>
<%@ page import="com.weblabs.beans.ServiceBean" %>
<%@ page import="java.util.List" %>
<%
String username = (String) session.getAttribute("customerID");
String[] selectedServices = request.getParameterValues("selectedServices");
String currentVIN = (String) session.getAttribute("currentVIN");
double totalPrice = 0.0;
int totalTime = 0;
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Selected Services</title>
</head>
<body>

customerID --- <%= username %>!<br>vehicleID --- <%= currentVIN %>!<br><br>

<% 
if (selectedServices != null) {
    for (String serviceId : selectedServices) {
        List<ServiceBean> serviceList = ServiceDAO.getAllServices(serviceId);
        for (ServiceBean service : serviceList) {
            // Assuming getPrice() returns a String that represents a numeric value
            String priceStr = service.getPrice();
            double price = Double.parseDouble(priceStr);
            
            // Assuming getTimetakes() returns a String that represents an integer value
            String timeTakenStr = service.getTimetakes();
            int timeTaken = Integer.parseInt(timeTakenStr);
%>
            <%= service.getServiceID() %>, <%= service.getServicename() %>, $<%= service.getPrice() %>, <%= service.getTimetakes() %> min<br><br>
<%
            totalPrice += price;
            totalTime += timeTaken;
        }
    }
} else {
%>
    No services selected.
<%
}
%>
<br><br><span>totalPrice $<%=totalPrice%></span>
<br><br><span>totalTime<%=totalTime%>min</span>


</body>
</html>
