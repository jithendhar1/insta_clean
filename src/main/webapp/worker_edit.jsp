 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.weblabs.beans.WorkerBean" %>
<%@ page import="com.weblabs.DAO.CustomerDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.weblabs.beans.CustomerBean" %>
<%@ page import="com.weblabs.DAO.WorkerDAO" %>
    
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

 </head>
<body>  
    <%
    int start = 0;
    int limit = 25;

    String idFilter = request.getParameter("workerID");
    List<WorkerBean> tasksList = null;
    String whereClause = "";

    if (idFilter != null && !idFilter.isEmpty()) {
        whereClause += "workerID = '" + idFilter + "'";
    }

    if (!whereClause.isEmpty()) {
        tasksList = WorkerDAO.getFilteredWorkers(whereClause, start, limit);
    }

    if (tasksList != null && !tasksList.isEmpty()) {
    	WorkerBean task = tasksList.get(0);

        if (task != null) {
%>
    
    
    
<form action="./EditWorkerSrv" method="post">
    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">worker ID</label>
            <input name="workerID" required class="form-control" type="text"readonly value="<%= task.getWorkerID() %>">
        </div>
    </div>

   <div class="col-sm-6">
        <div class="form-group">
            <label for="worker_name">worker_name  <span class="text-danger">*</span></label>
            <input id="worker_name" name="worker_name" class="form-control" type="text" value="<%= task.getWorker_name() %>"> 
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">phno  <span class="text-danger">*</span></label>
            <input name="phno" required class="form-control" type="text" value="<%= task.getPhno() %>"> 
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">address <span class="text-danger">*</span></label>
            <input name="address" required class="form-control" type="text" value="<%= task.getAddress() %>"> 
        </div>
    </div>
<div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">salary <span class="text-danger">*</span></label>
            <input name="salary" required class="form-control" type="text" value="<%= task.getSalary() %>"> 
        </div>
    </div>
    <div class="submit-section">
        <button type="submit"  class="btn btn-primary submit-btn">Submit</button>
    </div>
</form>
<%
    HttpSession sessionstatus = request.getSession(true);
    if (sessionstatus.getAttribute("status") != null && sessionstatus.getAttribute("status").equals("provident found Position Updated Successfully!")) {
        response.sendRedirect("worker.jsp");
    } else {
%>
   <div class="col-sm-6">
        <p>Task not found with the provided ID.</p>
   </div>
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

		

