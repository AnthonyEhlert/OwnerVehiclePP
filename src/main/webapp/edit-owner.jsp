<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Owner</title>
</head>
<body>
<h1>Editing owner ${ownerToEdit.firstName} ${ownerToEdit.lastName}</h1>

<form action = "editOwnerServlet" method = "post">
First Name: <input type = "text" name = "firstName" value = "${ownerToEdit.firstName}"><br/><br/>
Last Name: <input type = "text" name = "lastName" value = "${ownerToEdit.lastName}"><br/><br/>
<input type = "hidden" name = "id" value="${ownerToEdit.id}">
<input type = "submit" value="Save Owner">
</form>

</body>
</html>