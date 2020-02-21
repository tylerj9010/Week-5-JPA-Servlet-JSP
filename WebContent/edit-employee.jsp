<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ 

taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action = "editEmpServlet" method="post">
		First Name: <input type="text" name="firstName" value="${empToEdit.firstName}">
		Last Name: <input type="text" name="lastName" value="${empToEdit.lastName}">
		Age: <input type="text" name="age" value="${empToEdit.age}">
		Position: <input type="text" name="position" value="${empToEdit.position}">
	
<input type="hidden" name="id" value="${empToEdit.id}">
<input type="submit" value="Save Edited Employee">
</form>
</body>
</html>