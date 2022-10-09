<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
    th, tr{
    padding-left: 10px;
    padding-right: 10px;
    text-align: center;
    }
</style>
<meta charset="UTF-8">
<title>Add New Vehicle</title>
</head>
<body>
    <h1>List of Owners</h1>
    <form method="post" action = "addVehicleServlet">
    <table>
        <tr>
            <th></th>
            <th>First Name</th>
            <th>Last Name</th>
        <c:forEach items="${requestScope.allOwners}" var="currentowner">
        <tr>
            <td><input type = "radio" name = "ownerId" value = "${currentowner.id}"></td>
            <td>${currentowner.firstName}</td>
            <td>${currentowner.lastName}</td>
        </tr>
        </c:forEach>
    </table>
    <br />
    Date of Purchase: <input type = "date" id = "dateOfPurchase" name = "dateOfPurchase"><br /><br />
    Type: <input type = "text" name = "type"><br><br><br>
    Color: <input type = "text" name = "color"><br><br><br>
    <input type = "submit" value = "add" name = "insertVehicle"><br/><br/>
    </form>
    <a href = "viewAllOwnersServlet">View the complete list of owners </a><br /><br />
    <a href = "viewAllVehiclesServlet">View the complete list of vehicles</a><br /><br /><br /><br />
    <a href = "index.html">Main Menu</a><br />
</body>
</html>