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
              
                
                <div class="account-box">
                    <div class="account-wrapper">
                        <h3 class="account-title"> Login</h3>
                                
                        
                        
                         <form method="post" action="./LoginSrv"> 
                            <div class="form-group">
                                <label>phno</label>
                                <input class="form-control" id="phno"  name="phno" required type="text">
                            </div>
                            <% if (request.getAttribute("wrongusername") != null) { %>
                                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                    <strong>Oh Snapp!🙃</strong> Alert <b class="alert-link">UserName:</b> You entered a wrong UserName.
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                            <% } %>
                            
                            <div class="form-group">
                                <div class="row">
                                    <div class="col">
                                        <label>otp</label>
                                    </div>
                                </div>
                                <input class="form-control" id="otp" name="otp" required type="text">
                               
                            </div>
                            <% if (request.getAttribute("wrongpassword") != null) { %>
                                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                    <strong>Oh Snapp!😕</strong> Alert <b class="alert-link">Password:</b> You entered wrong password.
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                            <% } %>
                            <div class="form-group text-center">
                                <button href="employee.jsp" class="btn btn-primary account-btn" name="login" type="submit">Login</button>
                                <div class="col-auto pt-2">
                                    <a class="text-muted float-right" href="forgot-password.jsp">Forgot password?</a>
                                </div>
                            </div>
                           <!--  <div class="account-footer">
                                <p>Having Trouble? report an issue on GitHub <a target="_blank" href="https://github.com/MusheAbdulHakim/Smarthr---hr-payroll-project-employee-management-System/issues">GitHub issues</a></p>
                            </div> -->
                        </form>
                       
                    </div>
                </div>
            </div>
        </div>
    </div>
   
    
    <script>
    function validateLogin() {
        // Get the input values
        var username = document.getElementById('phno').value;
        console.log("Username: " + username);

        var password = document.getElementById('otp').value;

        // Check if username and password match certain criteria (you can replace this with your validation logic)
        if (username === 'correctUsername' && password === 'correctPassword') {
            // Redirect to a successful login page or perform further actions
            alert('Login successful!');
        } else {
            // Display an alert for invalid username or password
            alert('Invalid username or password. Please try again.');
        }
    }
</script>

    <!-- jQuery -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap Core JS -->
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- Custom JS -->

</body>
</html>
