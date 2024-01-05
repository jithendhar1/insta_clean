 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.weblabs.beans.VechicleBean" %>
<%@ page import="com.weblabs.DAO.VechicleDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.weblabs.beans.CustomerBean" %>
<%@ page import="com.weblabs.DAO.CustomerDAO" %>
    
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

    String idFilter = request.getParameter("vehicleID");
    List<VechicleBean> tasksList = null;
    String whereClause = "";

    if (idFilter != null && !idFilter.isEmpty()) {
        whereClause += "vehicleID = '" + idFilter + "'";
    }

    if (!whereClause.isEmpty()) {
        tasksList = VechicleDAO.getFilteredVechicles(whereClause, start, limit);
    }

    if (tasksList != null && !tasksList.isEmpty()) {
    	VechicleBean task = tasksList.get(0);

        if (task != null) {
%>
    
    
    
<form action="./EditVechicleSrv" method="post">
    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">Vehicle ID</label>
            <input name="vehicleID" required class="form-control" type="text"readonly value="<%= task.getVehicleID() %>">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
             <label for="customerID">Customer ID <span class="text-danger">*</span></label>
            <input id="customerID" name="customerID" class="form-control" type="text" value="<%= task.getCustomerID() %>"> 
        <%--     <label style="margin-top: 40px;" class="col-form-label">customer Name <span class="text-danger">*</span></label>
              <select class="abc2" style=" width:270px;" name="customerID" required class="form-control" required>
                                    <%
                                            String selectedClientId = task.getCustomerID();
                                            List<CustomerBean> projects = CustomerDAO.getAllCustomer();
                                            
                                            for (CustomerBean project : projects) {
                                    %>
                                    <option value="<%= project.getProjectname() %>" <%= (project.getProject_id().equals(task.getProject_id())) ? "selected" : "" %>><%= project.getProjectname() %></option>
                                    <option value="<%= project.getCustomerID()%>" <%= (selectedClientId != null && selectedClientId.equals(task.getCustomerID())) ? "selected" : "" %>><%= project.getCustomerID() %></option>
                                    
                                    <%
                                            }
                                      
                                    %>
                                </select> --%>
        </div>
    </div>
 <script>
    $(document).ready(function() {
        $('.abc2').select2();
    });
</script>  
    <div class="col-sm-6">
        <div class="form-group">
            <label for="vehicleType">Vehicle Type <span class="text-danger">*</span></label>
            <input id="vehicleType" name="vehicleType" class="form-control" type="text" value="<%= task.getVehicleType() %>">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">Vehicle Model <span class="text-danger">*</span></label>
            <input name="vehicleModel" required class="form-control" type="text" value="<%= task.getVehicleModel() %>">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">VIN <span class="text-danger">*</span></label>
            <input name="VIN" required class="form-control" type="text" value="<%= task.getVIN() %>">
        </div>
    </div>

    <div class="submit-section">
        <button type="submit"  class="btn btn-primary submit-btn">Submit</button>
    </div>
</form>
<%
    HttpSession sessionstatus = request.getSession(true);
    if (sessionstatus.getAttribute("status") != null && sessionstatus.getAttribute("status").equals("provident found Position Updated Successfully!")) {
        response.sendRedirect("vechicle.jsp");
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

		

