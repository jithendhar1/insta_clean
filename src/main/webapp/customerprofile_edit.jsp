<%@ page import="com.weblabs.DAO.CustomerDAO" %>
<%@ page import="com.weblabs.beans.AddressBean" %>
<%@ page import="com.weblabs.beans.CustomerBean" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <meta name="description" content="Smarthr - Bootstrap Admin Template">
    <meta name="keywords" content="admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects">
    <meta name="author" content="Dreamguys - Bootstrap Admin Template">
    <meta name="robots" content="noindex, nofollow">
    <title>Invoices - HRMS admin template</title>

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

    <!-- Datetimepicker CSS -->
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">

 <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <!-- Main CSS -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/tstyles.css">
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
     <style>
    /* Some basic styling for the table */
    table {
      border-collapse: collapse;
      width: 100%;
    }
    th, td {
      border: 1px solid #ddd;
      padding: 8px;
      text-align: left;
    }
    th {
      background-color: #f2f2f2;
    }
    .child {
      display: none; /* Hide child rows initially */
    }
    .childTable {
      margin-left: 20px; /* Indent child table */
    }
  </style>
    
  
</head>

<body>
<!-- Other scripts for jQuery, Bootstrap, etc. -->
  

    <!-- filtering records -->
   <%

int start = 0;
int limit = 25;

String idFilter = request.getParameter("customerID"); // Make sure the parameter name matches your form
List<CustomerBean> invoices = null; // Initialize the list as empty

String whereClause = ""; // Initialize an empty whereClause

if (idFilter != null && !idFilter.isEmpty()) {
    whereClause += "customerID = '" + idFilter + "'";
}

if (!whereClause.isEmpty()) {
    // Apply the whereClause condition
    invoices = CustomerDAO.getFilteredCustomers(whereClause, start, limit);
}

if (invoices != null && !invoices.isEmpty()) {
	CustomerBean invoice = invoices.get(0); // Access the first element
    if (invoice != null) {
%>
   
   <% 
										                    List<AddressBean> invoiceItems = CustomerDAO.getAddressItemsByCustomerId(invoice.getCustomerID());
										                    for (AddressBean invoiceItem : invoiceItems) {
										                %>
     
     <form action="./EditCustomerSrv" method="post">
      <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">customer ID</label>
            <input name="customerID" value="<%= invoice.getCustomerID() %>" required class="form-control" type="text" readonly>
        </div>
    </div> 
     <div class="col-md-6">
        <div class="form-group">
            <label>customername  <span class="text-danger">*</span></label>
            <input  name="customername"  value="<%= invoice.getCustomername() %>" class="form-control" type="text">
        </div>
    </div>

    <div class="col-sm-6">
        <div class="form-group">
            <label >email  <span class="text-danger">*</span></label>
            <input  name="email" class="form-control"   value="<%= invoice.getEmail() %>" type="text">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">phno <span class="text-danger">*</span></label>
            <input   value="<%= invoice.getPhno() %>" name="phno" required class="form-control" type="text">
        </div>
    </div>

    <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">firstname <span class="text-danger">*</span></label>
            <input name="firstname"   value="<%= invoice.getFirstname() %>" required class="form-control" type="text">
        </div>
    </div>
 <div class="col-md-6">
        <div class="form-group">
            <label class="col-form-label">lastname <span class="text-danger">*</span></label>
            <input name="lastname"   value="<%= invoice.getLastname() %>" required class="form-control" type="text">
        </div>
    </div>
    
    
    <table class="table table-hover table-white" id="itemTable" >
												<thead>
													<tr>
														<th style="width: 20px">ID</th>
														<th class="col-sm-2">street</th>
														<th class="col-md-6">city</th>
														<th style="width:100px;">postal_code </th>
														<th style="width:80px;">state</th>
														<th>hno</th>
														<th> </th>
													</tr>
												</thead>
    <tbody>
												<tr>
													<td>
<input name="id" class="form-control" type="text" style="min-width:150px" value="<%= invoiceItem.getAddressID()%>" >

</td>
													<td>
													<!-- 	<input name="items" class="form-control" type="text" style="min-width:150px"> -->
														 <input name="street"  value="<%= invoiceItem.getStreet() %>" id="street" required class="form-control" type="text"  >
                                                        <span id="itemsError" style="display: none; color: red;"></span>
                              
													</td>
													<td>
														<input name="city" value="<%= invoiceItem.getCity() %>" class="form-control" type="text" style="min-width:150px">
													</td>
													<td>
														<input name="postal_code"  value="<%= invoiceItem.getPostal_code() %>" class="form-control" style="width:100px" type="text">
													</td>
													<td>
														<input name="state" class="form-control"  value="<%= invoiceItem.getState() %>" style="width:80px" type="text"  >
													</td>
													<td>
														<input name="hno"  value="<%= invoiceItem.getHno() %>" class="form-control" style="width:100px" type="text" >
													</td>
													 <td>
										                <a href="javascript:void(0)" class="text-success font-18" title="Add" onclick="addItem(this)"><i class="fa fa-plus"></i> </a>
										            </td>
										            <td>
										                <a href="javascript:void(0)" class="text-danger font-18 disabled-link"  title="Remove" ><i class="fa fa-trash-o"></i> </a>
										            </td>
										
												</tr>

</tbody>
 </table>   

    
    
    <div class="submit-section">
        <button type="submit" name="addcustomerprofile" class="btn btn-primary submit-btn">Submit</button>
    </div>

</form>
		<!-- jQuery -->
        <script src="js/jquery-3.2.1.min.js"></script>
		
		<!-- Bootstrap Core JS -->
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
		
		<!-- Slimscroll JS -->
		<script src="js/jquery.slimscroll.min.js"></script>
		
		<!-- Select2 JS -->
		<script src="js/select2.min.js"></script>
		
		<!-- Datetimepicker JS -->	
		<script src="js/moment.min.js"></script>
		<script src="js/bootstrap-datetimepicker.min.js"></script>
		
		<!-- Custom JS -->
		<script src="js/app.js"></script>
		
		<%
        } } }
    
%>
    </body>
</html>