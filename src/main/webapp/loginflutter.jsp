<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.sql.*, javax.servlet.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <meta name="description" content="Smarthr - Bootstrap Admin Template">
    <meta name="keywords" content="admin, estimates, bootstrap, business, corporate, creative, management, minimal, modern, accounts, invoice, html5, responsive, CRM, Projects">
    <meta name="author" content="Dreamguys- Boot			strap Admin Template">
    <meta name="robots" content="noindśex, nofollow">
    <title>Login -  admin</title>
    <!-- Favicon -->
    <link rel	="shortcut icon" type="image/x-icon" href="assets/logo.png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Fontawesome CSS -->
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <!-- Main CSS -->
    <link rel="stylesheet" href="css/style.css">
    
    
</head>
<body class="account-page">
    <!-- Main Wrapper -->
    <div class="main-wrapper">
        <div class="account-content">
            <div class="container">
                <!-- Account Logo -->
                <div class="account-logo">
                   <!--  <a href="admin_dashboard.jsp"><img src="assets/logo2.png" alt="Company Logo"></a> -->
                   
                </div>
                <!-- /Account Logo -->
                <div class="account-box">
                    <div class="account-wrapper">
                        <h3 class="account-title"> Login</h3>
                        <!-- Account Form -->
                        <!-- <form method="post" action="./CustomerLoginSrv"> -->
                         <form method="post" action="./AddOtpSrv"> 
                         
                         
                            <div class="form-group">
                                <label>Phone no</label>
                                <input class="form-control" id="phno"  name="phno" required type="text">
                            </div>
                            
                            
                            
              <!--               <div class="submit-section">
        <button type="submit"  class="btn btn-primary submit-btn">Verify otp</button>
    </div> -->
    
    <div class="submit-section">
    <button type="submit" class="btn btn-primary submit-btn" onclick="redirectToLogin()">Verify OTP</button>
</div>
    <script>
    function redirectToLogin() {
        // Use window.location.href to redirect to login.jsp
        window.location.href = 'login.jsp';
    }
</script>
    
                            </form>
                        <!-- /Account Form -->
                    </div>
                </div>
            </div>
        </div>
    </div>