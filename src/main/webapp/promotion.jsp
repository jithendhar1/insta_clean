
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
		 <jsp:include page="header.jsp" />
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
								<h3 class="page-title">Promotion</h3>
								
							</div>
						</div>
					</div>

<form action="./TwilioSrv1" method="post">
    <div style="margin: 20px;">
        <div class="form-group">
            <label for="otp">SMS Bulk <span style="color: red;">*</span></label>
            <input id="otp" name="otp" class="form-control" type="text" required>
        </div>

        <div class="submit-section">
            <button type="submit" class="btn btn-primary submit-btn">Submit</button>
        </div>
    </div>
</form>

<form action="./TwilioSrv2" method="post">
    <div style="margin: 20px;">
    
    <div class="form-group">
            <label for="phno">Phno  <span style="color: red;">*</span></label>
            <input id="phno" name="phno" class="form-control" type="text" required>
        </div>
    
        <div class="form-group">
            <label for="otp">SMS  <span style="color: red;">*</span></label>
            <input id="otp" name="otp" class="form-control" type="text" required>
        </div>

        <div class="submit-section">
            <button type="submit" class="btn btn-primary submit-btn">Submit</button>
        </div>
    </div>
</form>



 </div> 
 </div> 
  </div> 
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

		

         
</body>
</html>