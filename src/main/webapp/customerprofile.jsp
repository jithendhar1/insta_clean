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
    HttpSession sessionRec = request.getSession(true);

    String recordsPerPageStr = (String) sessionRec.getAttribute("recordsPerPage");
    String currentPageStr = (String) sessionRec.getAttribute("currentPage");

    if (recordsPerPageStr == null || "0".equals(recordsPerPageStr)) {
        recordsPerPageStr = "5";
        sessionRec.setAttribute("recordsPerPage", recordsPerPageStr);
    }
    int recordsPerPage = Integer.parseInt(recordsPerPageStr);

    if (currentPageStr == null || "0".equals(currentPageStr)) {
        currentPageStr = "0";
        sessionRec.setAttribute("currentPage", currentPageStr);
    }
    int currentPage = Integer.parseInt(currentPageStr);

    int newRecordsPerPage = 5;
    String newRecordsPerPageParam = request.getParameter("newRecordsPerPage");
    if (newRecordsPerPageParam != null) {
        newRecordsPerPage = Integer.parseInt(newRecordsPerPageParam);
        sessionRec.setAttribute("recordsPerPage", String.valueOf(newRecordsPerPage));
    }
    %>

    <!-- Main Wrapper -->
    <div class="main-wrapper">

       

        <!-- Page Wrapper -->
        <div class="page-wrapper">

            <!-- Page Content -->
            <div class="content container-fluid">

                <!-- Page Header -->
                <div class="page-header">
                    <div class="row align-items-center">
                        <div class="col">
                            <h3 class="page-title">Customer profiles</h3>
                            
                        </div>
                        <div class="col-auto float-right ml-auto">
                            <a href="addcustomerprofile.jsp" class="btn add-btn"><i class="fa fa-plus"></i> Create profile</a>
                        </div>
                    </div>
                </div>
                
 <%--  <form action="./SearchCustomerSrv" method="post">
             
            <div class="row filter-row">
                <div class="col-sm-6 col-md-3">
                    <div class="form-group form-focus">
                        <label for="customername">customername:</label>
                        <input type="text" name="customername" id="customername">
                    </div>
                </div>
                <div class="col-sm-6 col-md-3">
                    <div class="form-group form-focus select-focus">
                        <label for="customerID">customerID:</label>
                        <input type="text" name="customerID" id="customerID">
                    </div>
                </div>
               
                <div class="col-sm-6 col-md-3">
                    <input type="submit" value="Search">
                </div>
            </div>
<input type="hidden" name="start" value="<%= currentPage %>">
    <input type="hidden" name="limit" value="<%= newRecordsPerPage %>">

    <div class="col-sm-6 col-md-3" id = "flag">
        <label>Records per page:</label>
        <select id="recordsPerPage" onchange="changeRecordsPerPage()">
            
            <option value="10">10</option>
           
          
        </select>
        
    </div>
</form>           --%>  
            
            
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <!-- Parent Table -->
                            <table  class="table table-striped custom-table" id="parentTable">
                                <thead>
                                    <tr>
                                      
                                        <th>customerID </th>
                                        <th>customername </th>
                                        <th>email</th>
                                        <th>phno</th>
                                        <th>firstname</th>
                                        <th>lastname </th>
                                        <th style="text-align: center;" colspan="2">Actions</th>
                                       </tr>
                                </thead>
                                <tbody>
                                    <%
                                    int start = 0;
                                    int limit = 25;
                                    String usernameFilter = request.getParameter("customername");
                                    String idFilter = request.getParameter("customerID");
                                    List<CustomerBean> resultSet;

                                    String whereClause = ""; // Initialize an empty whereClause

                                    if (usernameFilter != null && !usernameFilter.isEmpty()) {
                                        whereClause = "customername = '" + usernameFilter + "'";
                                    }

                                    if (idFilter != null && !idFilter.isEmpty()) {
                                        if (!whereClause.isEmpty()) {
                                            whereClause += " AND ";
                                        }
                                        whereClause += "customerID = '" + idFilter + "'";
                                    }

                                    if (!whereClause.isEmpty()) {
                                        // Apply the whereClause condition
                                        resultSet = CustomerDAO.getFilteredCustomers(whereClause, start, limit);
                                    } else {
                                        // Retrieve all data based on the limit
                                        resultSet = CustomerDAO.getFilteredCustomers("", start, limit);
                                    }
                           
                                        
                                  for (int i = 0; i < resultSet.size(); i++) {
                                	  CustomerBean invoice = resultSet.get(i);
                                    %>
                                    <tr  class="parentRow">
                                      
                                        <!-- Parent table data -->
                                        <td class="toggle"><%= invoice.getCustomerID()%></td>
                                        <td class="toggle"><%= invoice.getCustomername() %></td>
                                        <td class="toggle"><%= invoice.getEmail() %></td>
                                        <td class="toggle"><%= invoice.getPhno() %></td>
                                        <td class="toggle"><%= invoice.getFirstname() %></td>
                                        <td class="toggle"><%= invoice.getLastname() %></td>
                                        
                                        <td>
                                      <a href="edit_invoice.jsp?id=<%= invoice.getCustomerID() %>">Edit</a>
                                       </td>
                                        
                                    </tr>
										<!-- Child Table for Invoice Items -->
								 	<tr class="child">
										    <td></td> <!-- Empty column for consistency with the header -->
										    <td colspan="12">
										        <table class="childTable">
										            <thead>
										                <tr>
										                    <!-- Child table headers -->
										                 
										                    <th>addressID</th>
										                    <th>customerID</th>
										                    <th>street</th>
										                    <th>city</th>
										                    <th>postal_code</th>
										                    <th>state</th>
										                    <th>hno</th>
										                </tr>
										            </thead>
										            <tbody>
										                <% 
										                    List<AddressBean> invoiceItems = CustomerDAO.getInvoiceItemsByInvoiceId(invoice.getCustomerID());
										                    for (AddressBean invoiceItem : invoiceItems) {
										                %>
										                <tr>
										                    <!-- Child table data -->
										                    
										                    <td><%= invoiceItem.getAddressID() %></td>
										                    <td><%= invoiceItem.getCustomerID() %></td>
										                    <td><%= invoiceItem.getStreet() %></td>
										                    <td><%= invoiceItem.getCity() %></td>
										                    <td><%= invoiceItem.getPostal_code() %></td>
										                    <td><%= invoiceItem.getState() %></td>
										                    <td><%= invoiceItem.getHno() %></td>
										                </tr>
										                <%
										                    } 
										                %>
										            </tbody>
										        </table>
										    </td>
										</tr>

                                    <% } %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
  // Toggle child rows on clicking parent rows
 
  document.addEventListener('DOMContentLoaded', function () {
    // Toggle child rows on clicking parent rows
    const parentRows = document.querySelectorAll('.parentRow');

    parentRows.forEach(row => {
      row.addEventListener('click', () => {
        const childRow = row.nextElementSibling;
        childRow.classList.toggle('child');
      });
    });
  });
</script>


   
    
</body>
</html>
