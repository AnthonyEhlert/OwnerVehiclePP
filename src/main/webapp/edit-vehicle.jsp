<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vehicle Edit</title>
<link rel="stylesheet" href="stylesheet.css">
</head>
<body>
    <h1>Please Edit Any Necessary Info, then Click "Save Vehicle</h1>
    <h2> Owner Name: ${vehicleToEdit.owner.firstName} ${vehicleToEdit.owner.lastName}</h2>
    <form action = "editVehicleServlet" method = "post">
        Date: <input type = "date" name = "dateOfPurchase" value = "${vehicleToEdit.dateOfPurchase}"><br><br>
        Type: <input type = "text" name = "type" value = "${vehicleToEdit.type}"><br><br>
        Color: <input type = "text" name = "color" value = "${vehicleToEdit.color}"><br><br>
        <input type = "hidden" name = "id" value="${vehicleToEdit.id}">
        <input type = "submit" value="Save Vehicle">
    </form>
</body>
</html>