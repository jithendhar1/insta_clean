 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.weblabs.beans.ServiceBean" %>
<%@ page import="com.weblabs.DAO.VechicleDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.weblabs.beans.CustomerBean" %>
<%@ page import="com.weblabs.DAO.ServiceDAO" %>
    
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

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]-->
   <!--  <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>  -->
 </head>
<body>  
    <%
    int start = 0;
    int limit = 25;

    String idFilter = request.getParameter("serviceID");
    List<ServiceBean> tasksList = null;
    String whereClause = "";

    if (idFilter != null && !idFilter.isEmpty()) {
        whereClause += "serviceID = '" + idFilter + "'";
    }

    if (!whereClause.isEmpty()) {
        tasksList = ServiceDAO.getFilteredServices(whereClause, start, limit);
    }

    if (tasksList != null && !tasksList.isEmpty()) {
    	ServiceBean task = tasksList.get(0);

        if (task != null) {
%>
    
    
    
<form action="./EditServiceSrv" method="post">


  
     <div class="col-md-6">
        <div class="form-group">
            <label for="serviceID">service ID <span class="text-danger">*</span></label>
            <input id="serviceID" name="serviceID" class="form-control" type="text" readonly value="<%= task.getServiceID() %>">
        </div>
    </div> 

    <div class="col-sm-6">
        <div class="form-group">
            <label for="servicename">service name  <span class="text-danger">*</span></label>
            <input id="servicename" name="servicename" class="form-control" type="text" value="<%= task.getServicename() %>">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">description  <span class="text-danger">*</span></label>
            <input name="description" required class="form-control" type="text" value="<%= task.getDescription() %>">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">price <span class="text-danger">*</span></label>
            <input name="price" required class="form-control" type="text" value="<%= task.getPrice() %>">
        </div>
    </div>
      <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">discount <span class="text-danger">*</span></label>
            <input name="discount" required class="form-control" type="text" value="<%= task.getDiscount() %>">
        </div>
    </div>
      <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">coupons <span class="text-danger">*</span></label>
            <input name="coupons" required class="form-control" type="text" value="<%= task.getCoupons() %>">
        </div>
    </div>
<div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">type <span class="text-danger">*</span></label>
            <input name="type" required class="form-control" type="text" value="<%= task.getType() %>">
        </div>
    </div>
    <div class="submit-section">
        <button type="submit"  class="btn btn-primary submit-btn">Submit</button>
    </div>
</form>
<%
    HttpSession sessionstatus = request.getSession(true);
    if (sessionstatus.getAttribute("status") != null && sessionstatus.getAttribute("status").equals("provident found Position Updated Successfully!")) {
        response.sendRedirect("service.jsp");
    } else {
%>
   <!-- <div class="col-sm-6">
        <p>Task not found with the provided ID.</p>
   </div> -->
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

		

