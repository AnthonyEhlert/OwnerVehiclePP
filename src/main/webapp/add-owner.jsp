<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Owner</title>
<link rel="stylesheet" href="stylesheet.css">
</head>
<body>
<h1>Add a new owner:</h1>
<form action = "addOwnerServlet" method = "post">
First Name: <input type="text" name="firstName"><br>
Last Name: <input type="text" name="lastName"><br><br>
<input type = "submit" value="Add Owner">
</form>
<br>
<a href = "viewAllOwnersServlet">View the complete list of owners </a><br><br>
<a href = "viewAllVehiclesServlet">View the complete list of vehicles</a><br><br><br><br>
<a href = "index.html">Main Menu</a><br>
</body>
</html>