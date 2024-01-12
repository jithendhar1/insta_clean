<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.weblabs.service.impl.VechicleServiceImpl" %>
<%@ page import="com.weblabs.beans.VechicleBean" %>
<%@ page import="java.util.List" %>
<%@page import="com.weblabs.DAO.VechicleDAO"%>
<%@page import="com.weblabs.DAO.CustomerDAO"%>
<%@ page import="com.weblabs.beans.CustomerBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<%
List<VechicleBean> allVehicles = VechicleDAO.getAllVehicles();
for (VechicleBean vehicle : allVehicles) {
   

%>
<%=vehicle.getVehicleType() %>
<%
}
%>


<br>
<br>

<%
String customerID = "2";
List<VechicleBean> customerVehicles = VechicleDAO.getVehiclesByCustomerID(customerID);

// Process the list of customer's vehicles as needed
for (VechicleBean vehicle : customerVehicles) {
%>
   <%=vehicle.getVehicleType() %>
<%
}
%>
</body>
</html>

