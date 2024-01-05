<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
				
				<!DOCTYPE html>
<html>
<head>
    <title>Delete Form</title>
</head>
<body>

<!-- Script to automatically trigger deletion when the page loads -->
<script>
    window.addEventListener('load', function() {
        // Extract the 'id' parameter from the URL
        var urlParams = new URLSearchParams(window.location.search);
        var serviceID = urlParams.get('serviceID');
console.log("you have entered deleteEmployee");
        // Make an AJAX request to delete the employee
        var xhr = new XMLHttpRequest();
        xhr.open('POST', './DeleteServiceSrv', true);
        console.log("DeleteServiceSrv called");
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.send('serviceID=' + serviceID);

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                // Handle the response if needed
                var response = xhr.responseText;
                console.log(response); // You can log the response to the console
            }
        };
    });
</script>
console.log("you are about to leaves.jsp");
<%   response.sendRedirect("service.jsp"); %>
</body>
</html>