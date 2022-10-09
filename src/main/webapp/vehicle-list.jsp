<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
    th, tr{
    padding-left: 20px;
    padding-right: 20px;
    text-align: center;
    }
</style>
<meta charset="UTF-8">
<title>Vehicles List</title>
</head>
<body>
    <h1>List of Vehicles</h1>
    <form method="post" action = "vehicleNavigationServlet">
    <table>
        <tr>
            <th></th>
            <th>Date Purchased</th>
            <th>Vehicle Type</th>
            <th>Vehicle Color</th>
            <th>Owner</th>
        <c:forEach items="${requestScope.allVehicles}" var="vehicle">
        <tr>
            <td><input type = "radio" name = "id" value = "${vehicle.id}"></td>
            <td>${vehicle.dateOfPurchase}</td>
            <td>${vehicle.type}</td>
            <td>${vehicle.color}</td>
            <td>${vehicle.owner.firstName} ${vehicle.owner.lastName}</td>
        </tr>
        </c:forEach>
    </table><br />
    <input type = "submit" value = "edit" name = "doThisToVehicle">
    <input type = "submit" value = "delete" name = "doThisToVehicle">
    <input type = "submit" value = "add" name = "doThisToVehicle"><br /><br /><br />
    </form>
    <a href = "index.html">Main Menu</a><br />
    <a href = "viewAllOwnersServlet">View the complete list of owners </a><br />
</body>
</html>