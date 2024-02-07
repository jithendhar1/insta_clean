 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.weblabs.beans.CustomerBean" %>
<%@ page import="com.weblabs.DAO.CustomerDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.weblabs.beans.AppointmentServicesBean" %>
<%@ page import="com.weblabs.DAO.AppointmentServicesDAO" %>
    
  <!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
    <!-- Add your CSS and JavaScript includes here -->
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/logo.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- Fontawesome CSS -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- Lineawesome CSS -->
    <link rel="stylesheet" href="css/line-awesome.min.css">

    <!-- Select2 CSS -->
    <link rel="stylesheet" href="css/select2.min.css">

    <!-- Datetimepicker CSS -->
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">

    <!-- Main CSS -->
    <link rel="stylesheet" href="css/style.css">
    <!-- table styles CSS -->
    <link rel="stylesheet" href="css/styles.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/select2.min.js"></script>
   
 </head>
<body>  
    <%
    int start = 0;
    int limit = 25;

    String idFilter = request.getParameter("ID");
    List<AppointmentServicesBean> tasksList = null;
    String whereClause = "";

    if (idFilter != null && !idFilter.isEmpty()) {
        whereClause += "ID = '" + idFilter + "'";
    }

    if (!whereClause.isEmpty()) {
        tasksList = AppointmentServicesDAO.getAppointmentServicesBean(whereClause, start, limit);
    }

    if (tasksList != null && !tasksList.isEmpty()) {
    	AppointmentServicesBean task = tasksList.get(0);

        if (task != null) {
%>
    
    
    
<form action="./EditAppointmentServicesWid" method="post">
    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">ID </label>
            <input name="ID" required class="form-control" type="text"readonly value="<%= task.getID() %>">
        </div>
    </div>


<div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">serviceID <span class="text-danger">*</span></label>
            <input name="serviceID" required class="form-control" type="text" readonly value="<%= task.getServiceID() %>">
        </div>
    </div>
    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">servicename <span class="text-danger">*</span></label>
            <input name="servicename" required class="form-control" type="text" readonly  value="<%= task.getServicename() %>">
        </div>
    </div> 
      <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label"> price <span class="text-danger">*</span></label>
            <input name="price" required class="form-control" type="text" readonly   value="<%= task.getPrice() %>">
        </div>
    </div>

    
<div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">timetakes <span class="text-danger">*</span></label>
            <input name="timetakes" required class="form-control" readonly   type="text" value="<%= task.getTimetakes() %>">
        </div>
    </div>
    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">appointmentID <span class="text-danger">*</span></label>
            <input name="appointmentID" required class="form-control" readonly   type="text" value="<%= task.getAppointmentID() %>">
        </div>
    </div> 
      <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label"> workerID <span class="text-danger">*</span></label>
            <input name="workerID" required class="form-control" type="text" value="<%= task.getWorkerID() %>">
        </div>
    </div>
    <div class="submit-section">
        <button type="submit"  class="btn btn-primary submit-btn">Submit</button>
    </div>
</form>
<%
    HttpSession sessionstatus = request.getSession(true);
    if (sessionstatus.getAttribute("status") != null && sessionstatus.getAttribute("status").equals("provident found Position Updated Successfully!")) {
        response.sendRedirect("appointment_services.jsp");
    } else {
%>
   
<%
    }}}
%>

<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.slimscroll.min.js"></script>
<script src="js/select2.min.js"></script>
<script src="js/moment.min.js"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>
<script src="js/app.js"></script>
</body>
</html>

		

