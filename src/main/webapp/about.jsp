<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List" %>
<%@ page import="com.weblabs.beans.AboutUsBean" %>
<%@ page import="com.weblabs.DAO.AboutUsDAO" %> 


<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <meta name="description" content="Smarthr- Bootstrap Admin Template">
    <meta name="keywords" content="admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects">
    <meta name="author" content="Dreamguys - Bootstrap Admin Template">
    <meta name="robots" content="noindex, nofollow">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="assets/favicon.png">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

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
     <link rel="stylesheet" href="css/tstyles.css">
</head>
<body>
	<!-- Main Wrapper -->
        <div class="main-wrapper">
		
			<!-- Header -->
          
			<!-- /Header -->
			
			<!-- Sidebar -->
            <jsp:include page="sidebar.jsp" />
			<!-- /Sidebar -->
			
			<!-- Page Wrapper -->
            <div class="page-wrapper">
            
			<!--   <div class="header-topleft text-left" style="margin-left: 1cm;">
        <img src="assets/logo.png" width="150" height="100" alt="">
    </div>
			 -->
			
				<!-- Page Content -->
                <div class="content container-fluid">
				
					<!-- Page Header -->
					<div class="page-header">
					
					
						<div class="row">
							<div class="col-sm-12">
								<h3 class="page-title">About Us</h3>
								
							</div>
						</div>
					</div>
		
	<%
	AboutUsDAO aa = new AboutUsDAO();
    List<AboutUsBean> companySettingsList = aa.getAllAboutUs();

    // Initialize the company object outside the if block
    AboutUsBean company = null;

    if (companySettingsList != null && !companySettingsList.isEmpty()) {
        company = companySettingsList.get(0); // Assuming only one record is fetched
    }
%>	
<form id="myForm" action="" method="post">
				 <input type="hidden" id="action" name="action" value="">	
      

								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<label>Title<span class="text-danger">*</span></label>
								
									<%-- 		        <input type="text" id="companyName" name="companyName" value="<%= company.getCompanyName() %>"> value="<%= companyName %>">  --%>
									<input class="form-control" type="hidden" name="aboutID" value="<%= (company != null) ? company.getAboutID() : "" %>">   
											<input class="form-control" type="text" name="title" value="<%= (company != null) ? company.getTitle() : "" %>" oninput="checkInput()">   
										</div>
									</div>
									</div>
									<div class="col-sm-6">
										<div class="form-group">
											<label>Content </label>
											<input class="form-control "  type="text" name="content" value="<%= (company != null) ? company.getContent() : "" %>">
										</div>
									</div>
								
								

<div class="text-center">
    <button class="btn btn-primary submit-btn" type="submit" name="action" value="save" onclick="setAction('save')" id="saveBtn" disabled>Save</button>
    <button class="btn btn-primary submit-btn" type="submit" name="action" value="edit" onclick="setAction('edit')">Edit</button>
</div>
<!-- ... Rest of your HTML ... -->

							</form>
 
</div></div>

  <script>
    function setAction(action) {
        var form = document.getElementById('myForm');
        document.getElementById('action').value = action;
        form.action = (action === 'save') ? './AddAboutUsSrv' : './EditAboutUsSrv';
        form.submit();
    }
</script>
      
  

<script>
    function checkInput() {
        // Get the Company Name input by name
        var CompanyName = document.getElementsByName('title')[0].value;

        // Get the button by id
        var saveBtn = document.getElementById('saveBtn');

        // Check if the Company Name field has data
        if (CompanyName.trim() !== '') {
            // Enable the button
            saveBtn.disabled = false;
        } else {
            // Disable the button
            saveBtn.disabled = true;
        }
    }
</script>
  
  
  
  
         
         <!-- jQuery -->
        <script src="js/jquery-3.2.1.min.js"></script>

		<!-- Bootstrap Core JS -->
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

		<!-- Slimscroll JS -->
		<script src="js/jquery.slimscroll.min.js"></script>
		
		<!-- Datatable JS -->
		<script src="js/jquery.dataTables.min.js"></script>
		<script src="js/dataTables.bootstrap4.min.js"></script>

		<!-- Custom JS -->
		<script src="js/app.js"></script>

         
</body>
</html>