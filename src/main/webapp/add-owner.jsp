<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Owner</title>
</head>
<body>
<h1>Add a new owner:</h1>
<form action = "addOwnerServlet" method = "post">
First Name: <input type="text" name="firstName"><br/>
Last Name: <input type="text" name="lastName"><br/>
<input type = "submit" value="Add Owner">
</form>
</body>
</html>