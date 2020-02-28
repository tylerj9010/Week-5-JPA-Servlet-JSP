<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new list</title>
</head>
<body>
<form action = "createNewDepartmentServlet" method="post">
Department Name: <input type ="text" name = "departmentName"><br />

Employees to add:<br />

<select name="allEmpsToAdd" multiple size="6">
<c:forEach items="${requestScope.allEmps}" var="currentemp">
   <option value = "${currentemp.id}">${currentemp.firstName} ${currentemp.lastName} | ${currentemp.position}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create New Department and Add Employees">
</form>
<a href = "index.html">Go Home</a>
</body>

</html>