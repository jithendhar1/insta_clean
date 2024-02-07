<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <meta name="description" content="Smarthr- Bootstrap Admin Template">
    <meta name="keywords" content="admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects">
    <meta name="author" content="Dreamguys - Bootstrap Admin Template">
    <meta name="robots" content="noindex, nofollow">
    <title>Leaves - HRMS admin template</title>

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/favicon.png">

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
    
    <!-- Table styles CSS -->
    <link rel="stylesheet" href="css/styles.css">
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
   
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
   
    <title>add List</title>
</head>
<body>


<form action="./AddServiceSrv" method="post">
<div id="addservice" class="modal custom-modal fade" role="dialog">
<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Add Department</h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								
 <!--    <div class="col-md-6">
        <div class="form-group">
            <label for="serviceID">service ID <span class="text-danger">*</span></label>
            <input id="serviceID" name="serviceID" class="form-control" type="text">
        </div>
    </div> -->

    <div class="col-md-12">
        <div class="form-group">
            <label for="servicename">servicename  <span class="text-danger">*</span></label>
            <input id="servicename" name="servicename" class="form-control" type="text">
        </div>
    </div>

 <div class="col-md-12">
        <div class="form-group">
            <label class="col-form-label">description  <span class="text-danger">*</span></label>
            <input name="description" required class="form-control" type="text">
        </div>
    </div>

   <div class="col-md-12">
        <div class="form-group">
            <label class="col-form-label">price <span class="text-danger">*</span></label>
            <input name="price" required class="form-control" type="text">
        </div>
    </div>
      <div class="col-md-12">
        <div class="form-group">
            <label class="col-form-label">discount <span class="text-danger">*</span></label>
            <input name="discount" required class="form-control" type="text">
        </div>
    </div>
     <div class="col-md-12">
        <div class="form-group">
            <label class="col-form-label">coupons <span class="text-danger">*</span></label>
            <input name="coupons" required class="form-control" type="text">
        </div>
    </div>
 <div class="col-md-12">
        <div class="form-group">
            <label class="col-form-label">type <span class="text-danger">*</span></label>
            <input name="type" required class="form-control" type="text">
        </div>
    </div>
    <div class="submit-section">
        <button type="submit"  class="btn btn-primary submit-btn">Submit</button>
    </div>
</div>
</div>
</div>
</div>
</form>
