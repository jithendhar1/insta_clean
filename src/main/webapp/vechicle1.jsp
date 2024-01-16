<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.weblabs.service.impl.VechicleServiceImpl" %>
<%@ page import="com.weblabs.beans.VechicleBean" %>
<%@ page import="java.util.List" %>
<%@page import="com.weblabs.DAO.VechicleDAO"%>
<%@page import="com.weblabs.DAO.CustomerDAO"%>
<%@ page import="com.weblabs.beans.CustomerBean" %>
<%
    // Getting the username from the session
   
     String username = (String) session.getAttribute("customerID");
  //  String username = "customerID";
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <meta name="description" content="Smarthr - Bootstrap Admin Template">
		<meta name="keywords" content="admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects">
        <meta name="author" content="Dreamguys - Bootstrap Admin Template">
        <meta name="robots" content="noindex, nofollow">
        <title>vechicle -  template</title>
		
		<!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.png">
		
		<!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
		
		<!-- Fontawesome CSS -->
        <link rel="stylesheet" href="css/font-awesome.min.css">
		
		<!-- Lineawesome CSS -->
        <link rel="stylesheet" href="css/line-awesome.min.css">
		
		<!-- Select2 CSS -->
		<link rel="stylesheet" href="css/select2.min.css">
		
		<!-- Main CSS -->
        <link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/tstyles.css">
		
    </head>
    <body>

		<!-- Main Wrapper -->
        <div class="main-wrapper">
		
		<jsp:include page="sidebar.jsp" />
            <div class="page-wrapper">
			
				<!-- Page Content -->
                <div class="content container-fluid">
				
					<!-- Page Header -->
					<div class="page-header">
						<div class="row align-items-center">
							<div class="col">
							<div id="welcomeMessage" style="text-align: center; margin-top: 20px; font-size: 24px;">
                                Welcome  <%= username%>!
                              </div>
								<h3 class="page-title">Vechicless</h3>
								<!-- <ul class="breadcrumb">
									<li class="breadcrumb-item"><a href="index.jsp">Dashboard</a></li>
									<li class="breadcrumb-item active">Tasks</li>
								</ul> -->
							</div>
							<div class="col-auto float-right ml-auto">
							<a href="#" class="btn add-btn" data-toggle="modal" data-target="#addvechicle"><i class="fa fa-plus"></i> Add Vechicle</a>
							</div>
						</div>
					</div>
					<!-- /Page Header -->
					<!-- Search Filter -->
					<form action="./SearchVechicleSrv" method="post">
    <div class="row filter-row">
        <div class="col-sm-6 col-md-3">
            <div class="form-group form-focus select-focus">
                <label for="id">vehicleID:</label>
                <input type="text" name="vehicleID" id="vehicleID">
            </div>
        </div>
        <div class="col-sm-6 col-md-3">
            <input style="margin-top: 29px;" type="submit" value="Search">
        </div>
    </div>
   
   
</form>
								<table>
									<thead>
										<tr>
							
											<th>vehicleID</th>
											<th>customerName </th>
									        <th>vehicleType</th>
									        <th>vehicleModel</th>
									        <th>VIN</th>
									        <th>brand</th>
									        
										</tr>
									</thead>
<%

  List<VechicleBean>  tax = VechicleDAO.getVehiclesByCustomerID(username);

for (VechicleBean tasks : tax) {
	CustomerBean pro = CustomerDAO.getCustomerById(tasks.getCustomerID()); 
%>
<tr>
    <td><%=tasks.getVehicleID() %></td>
   <td><%=tasks.getCustomerID() %></td>
    <td><%=tasks.getVehicleType() %></td>
    <td><%=tasks.getVehicleModel() %></td>
    <td>
    <a href="service.jsp?VIN=<%= tasks.getVIN() %>"><%= tasks.getVIN() %></a>
    </td>
   <%--  <td><%=tasks.getVIN() %></td> --%>
    <td><%=tasks.getBrand() %></td>
   
</tr>
<%
}
%>

								</table>

</div>
							</div>
						</div>
					</div>
               
				<!-- /Page Content -->
				
				<!-- Add Tax Modal -->
				 <jsp:include page="vechicle_add.jsp" />
				<!-- /Add Tax Modal -->
				
				<%-- <!-- Edit Tax Modal -->
				 <jsp:include page="edit_tasks.jsp" />
				<!-- /Edit Tax Modal -->
				
				<!-- Delete Tax Modal -->
				 <jsp:include page="delete_task.jsp" />
				<!-- /Delete Tax Modal --> --%>
				
          
	

		
        <script src="js/jquery-3.2.1.min.js"></script>

		
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

		
		<script src="js/jquery.slimscroll.min.js"></script>
		
		
		<script src="js/select2.min.js"></script>

		
		<script src="js/app.js"></script>


    </body>
</html>