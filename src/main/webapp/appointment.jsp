<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.weblabs.service.impl.AppointmentServiceImp" %>
<%@ page import="com.weblabs.beans.AppointmentBean" %>
<%@ page import="java.util.List" %>
<%@page import="com.weblabs.DAO.AppointmentDAO"%>
<%@page import="com.weblabs.DAO.CustomerDAO"%>
<%@ page import="com.weblabs.beans.CustomerBean" %>
<%@ page import="java.net.URLEncoder" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <meta name="description" content="Smarthr - Bootstrap Admin Template">
		<meta name="keywords" content="admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects">
        <meta name="author" content="Dreamguys - Bootstrap Admin Template">
        <meta name="robots" content="noindex, nofollow">
        <title>appointment -  template</title>
		
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

<%
HttpSession sessionRec = request.getSession(true);

// Initialize recordsPerPage and currentPage as Java variables
String recordsPerPageStr = (String) sessionRec.getAttribute("recordsPerPage");
String currentPageStr = (String) sessionRec.getAttribute("currentPage");

if (recordsPerPageStr == null || "0".equals(recordsPerPageStr)) {
    recordsPerPageStr = "10"; // Set a default value, e.g., 1
    sessionRec.setAttribute("recordsPerPage", recordsPerPageStr);
}
int recordsPerPage = Integer.parseInt(recordsPerPageStr);

if (currentPageStr == null || "0".equals(currentPageStr)) {
    currentPageStr = "1"; // Set a default value, e.g., 1
    sessionRec.setAttribute("currentPage", currentPageStr);
}
int currentPage = Integer.parseInt(currentPageStr);

// Handle the change in recordsPerPage here
int newRecordsPerPage = 10; // Default value
String newRecordsPerPageParam = request.getParameter("newRecordsPerPage");
if (newRecordsPerPageParam != null) {
    newRecordsPerPage = Integer.parseInt(newRecordsPerPageParam);
    sessionRec.setAttribute("recordsPerPage", String.valueOf(newRecordsPerPage));
    //currentPage = 1; // Reset to the first page when changing recordsPerPage
    //sessionRec.setAttribute("currentPage", "1");
}

%>
<script>
    var recordsPerPage = <%= recordsPerPage %>; // Use Java variable in JavaScript
    var currentPage = <%= currentPage %>; 
 
    function changeRecordsPerPage() {
        var recordsPerPageSelect = document.getElementById("recordsPerPage");
        var selectedValue = recordsPerPageSelect.value;
        
        // Update the URL with the selected "recordsPerPage" value and navigate to it
        var baseUrl = window.location.href.split('?')[0];
        var newUrl = baseUrl + '?newRecordsPerPage=' + selectedValue;
        window.location.href = newUrl;
    }
</script>





		<!-- Main Wrapper -->
        <div class="main-wrapper">
			 <jsp:include page="header.jsp" />
		 <jsp:include page="sidebar.jsp" />
     
        <!-- Include your sidebar HTML here -->			
			<!-- Page Wrapper -->
            <div class="page-wrapper">
			
				<!-- Page Content -->
                <div class="content container-fluid">
				
					<!-- Page Header -->
					<div class="page-header">
						<div class="row align-items-center">
							<div class="col">
							<div id="welcomeMessage" style="text-align: center; margin-top: 20px; font-size: 24px;">
                                Welcome !
                              </div>
								<h3 class="page-title">appointment</h3>
							</div>
							<div class="col-auto float-right ml-auto">
							<!-- <a href="#" class="btn add-btn" data-toggle="modal" data-target="#addappointment"><i class="fa fa-plus"></i> Add appointment</a> -->
							</div>
						</div>
					</div>
					
								<table>
									<thead>
										<tr>
							
											<th>appointmentID</th>
											<th>customerID </th>
									        <th>vehicleID</th>
									        <th>appointment date</th>
									        <th>appointment startTime</th>
									        <th>appointment sendTime</th>
									         <th>End_datetime</th>
									         <th>Status</th>
										</tr>
									</thead>

<%
int start = currentPage;
int limit = newRecordsPerPage;
// pagenation code start
int pageno = 1;
int noOfPages = 0;

String pageNoStr = request.getParameter("page");

if (pageNoStr != null) {
    pageno = Integer.parseInt(pageNoStr);
}

start = (pageno - 1) * limit;
// pagenation code ended
String usernameFilter = request.getParameter("description");
String idFilter = request.getParameter("vehicleID");
List<AppointmentBean> tax;

String whereClause = ""; // Initialize an empty whereClause

if (usernameFilter != null && !usernameFilter.isEmpty()) {
    whereClause = "description like '%" + usernameFilter + "%'";
}

if (idFilter != null && !idFilter.isEmpty()) {
    if (!whereClause.isEmpty()) {
        whereClause += " or ";
    }
    whereClause += "vehicleID = '" + idFilter + "'";
}
// page
int recordcount = AppointmentDAO.totalCount();

noOfPages = (int) Math.ceil((double) recordcount / limit);
// pagee
if (!whereClause.isEmpty()) {
    // Apply the whereClause condition
    tax = AppointmentDAO.getFilteredAppointment(whereClause, start, limit);
} else {
    // Retrieve all data based on the limit
    tax = AppointmentDAO.getFilteredAppointment("", start, limit);
}
for (AppointmentBean tasks : tax) {
	CustomerBean pro = CustomerDAO.getCustomerById(tasks.getCustomerID()); 
%>
	
<tr>
    <!-- ... Your table row content ... -->
    <td><%=tasks.getAppointmentID() %></td>
    <td><%=tasks.getCustomerID() %></td> 
    <td><%=tasks.getVIN() %></td>
    <td><%=tasks.getAppointmentdate() %></td>
   <td><%=tasks.getStart_time()%></td>
    <td><%=tasks.getEnd_time()%></td>
    <td><%=tasks.getEnd_datetime() %></td>
     <td><%=tasks.getStatus()%></td>
</tr>
<%
} 
%>
	</table>
<div class="row justify-content-center align-items-center" id = "flag1">
   
   <!-- Pagination links -->

    <% if (pageno > 1) { %>
        <a href="appointment.jsp?page=<%=pageno - 1%>">Previous</a>
    <% } %>

    <% for (int i = 1; i <= noOfPages; i++) { %>
        <% if (i == pageno) { %>
            <%=i%>
        <% } else { %>
            <a href="appointment.jsp?page=<%=i%>"><%=i%></a>
        <% } %>
    <% } %>

    <% if (pageno < noOfPages) { %>
        <a href="appointment.jsp?page=<%=pageno + 1%>">Next</a>
    <% } %>

</div>
							</div>
						</div>
					</div>
               
				<%--  <jsp:include page="appointment_add.jsp" /> --%>
			
				
           
	

		
        <script src="js/jquery-3.2.1.min.js"></script>

		
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

		
		<script src="js/jquery.slimscroll.min.js"></script>
		
		
		<script src="js/select2.min.js"></script>

		
		


    </body>
</html>

