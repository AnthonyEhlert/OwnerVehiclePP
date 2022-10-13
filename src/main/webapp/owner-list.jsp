<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owners List</title>
<link rel="stylesheet" href="stylesheet.css">
</head>
<body>

<h1>List of Owners</h1>
<form method="post" action="ownerNavigationServlet">
<table>
	<tr>
		<th></th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>List of Vehicles</th>
	</tr>
	<c:forEach items="${requestScope.allOwners}" var="owner">
	<tr>
		<td><input type = "radio" name = "id" value = "${owner.id}"></td>
		<td>${owner.firstName}</td>
		<td>${owner.lastName}</td>
		<td align = "center"><c:forEach items="${owner.listOfVehicles}" var="vehicle">
			<table>
		          <tr>${vehicle.type}, ${vehicle.color}, ${vehicle.dateOfPurchase}</tr>
			</table>
		      </c:forEach> 
		</td>
	</tr>
	</c:forEach>
</table><br/>
<input type = "submit" value = "edit" name = "doThisToOwner">
<input type = "submit" value = "delete" name = "doThisToOwner">
<input type = "submit" value = "add" name = "doThisToOwner">
</form>
<br><br>
<a href = "index.html">Main Menu</a><br>
<a href = "viewAllVehiclesServlet">View the complete list of vehicles</a><br>
</body>
</html>