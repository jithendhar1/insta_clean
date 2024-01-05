 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.weblabs.beans.CustomerBean" %>
<%@ page import="com.weblabs.DAO.CustomerDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.weblabs.beans.AppointmentBean" %>
<%@ page import="com.weblabs.DAO.AppointmentDAO" %>
    
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

    String idFilter = request.getParameter("appointmentID");
    List<AppointmentBean> tasksList = null;
    String whereClause = "";

    if (idFilter != null && !idFilter.isEmpty()) {
        whereClause += "appointmentID = '" + idFilter + "'";
    }

    if (!whereClause.isEmpty()) {
        tasksList = AppointmentDAO.getFilteredAppointment(whereClause, start, limit);
    }

    if (tasksList != null && !tasksList.isEmpty()) {
    	AppointmentBean task = tasksList.get(0);

        if (task != null) {
%>
    
    
    
<form action="./EditAppointmentSrv" method="post">
    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">appointmentID </label>
            <input name="appointmentID" required class="form-control" type="text"readonly value="<%= task.getAppointmentID() %>">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <%--  <label for="customerID">Customer ID <span class="text-danger">*</span></label>
            <input id="customerID" name="customerID" class="form-control" type="text" value="<%= task.getCustomerID() %>">  --%>
            <label style="margin-top: 40px;" class="col-form-label">Customer ID  <span class="text-danger">*</span></label>
                                <select class="xcx234" style=" width:270px;" name="customerID"  required>
                                    <%
                                            String selectedClientId = task.getCustomerID();
                                            List<CustomerBean> projects =  CustomerDAO.getAllCustomer();
                                            
                                            for (CustomerBean project : projects) {
                                    %>
                                   <option value="<%= project.getCustomerID()%>" <%= (selectedClientId != null && selectedClientId.equals(project.getCustomername())) ? "selected" : "" %>><%= project.getCustomername() %></option>
                                    <%-- <option value="<%= project.getCustomername()%>" <%= (selectedClientId != null && selectedClientId.equals(task.getCustomerID())) ? "selected" : "" %>><%= project.getCustomername() %></option>   --%>
                                    <%
                                            }
                                      
                                    %>
                                </select>
                            </div>
                        </div> 
                       <script>
    $(document).ready(function() {
        $('.xcx234').select2();
    });
</script>  
            
            

          <%--  <label style="margin-top: 40px;" class="col-form-label">customer Name <span class="text-danger">*</span></label>
              <select class="abc2" style=" width:270px;" name="customerID" required class="form-control" required>
                                    <%
                                            String selectedClientId = task.getCustomerID();
                                            List<CustomerBean> projects = CustomerDAO.getAllCustomer();
                                            
                                            for (CustomerBean project : projects) {
                                    %>
                                    <option value="<%= project.getCustomerID()%>" <%= (selectedClientId != null && selectedClientId.equals(task.getCustomerID())) ? "selected" : "" %>><%= project.getCustomerID() %></option>
                                    
                                    <%
                                            }
                                      
                                    %>
                                </select> 
        </div>
    </div>
 <script>
    $(document).ready(function() {
        $('.abc2').select2();
    });
</script>   --%>


 <!--    <div class="col-sm-6">
        <div class="form-group">
            <label for="customerID">customerID <span class="text-danger">*</span></label>
            <input id="customerID" name="customerID" class="form-control" type="text">
        </div>
    </div>
 -->
    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label"> vehicleID <span class="text-danger">*</span></label>
            <input name="vehicleID" required class="form-control" type="text" value="<%= task.getVehicleID() %>">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">serviceID <span class="text-danger">*</span></label>
            <input name="serviceID" required class="form-control" type="text" value="<%= task.getServiceID() %>">
        </div>
    </div>
<div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">appointmentdate <span class="text-danger">*</span></label>
            <input name="appointmentdate" required class="form-control" type="text" value="<%= task.getAppointmentdate() %>">
        </div>
    </div>
    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">status <span class="text-danger">*</span></label>
            <input name="status" required class="form-control" type="text" value="<%= task.getStatus() %>">
        </div>
    </div>
  
    <div class="submit-section">
        <button type="submit"  class="btn btn-primary submit-btn">Submit</button>
    </div>
</form>
<%
    HttpSession sessionstatus = request.getSession(true);
    if (sessionstatus.getAttribute("status") != null && sessionstatus.getAttribute("status").equals("provident found Position Updated Successfully!")) {
        response.sendRedirect("appointment.jsp");
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

		

