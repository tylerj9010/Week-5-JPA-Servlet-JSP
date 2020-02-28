<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Departments</title>
</head>
<body>
<body>
<form method = "post" action = "departmentNavigationServlet">
<table>
<c:forEach items="${requestScope.allDepartments}" var="currentDepartment">
<tr>
   <td><input type="radio" name="id" value="${currentDepartment.id}"></td>
   <td><h2>${currentDepartment.name}</h2></td></tr>
   <c:forEach var = "emp" items = "${currentDepartment.listOfEmployees}">
            <tr><td></td><td colspan="3">
                ${emp.firstName}, ${emp.lastName}
                </td>
            </tr>
  </c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "delete" name="doThisToEmp">
<input type="submit" value = "add" name = "doThisToEmp">
</form>
<a href="">Create a new List</a>
<a href="index.html">Insert a new item</a>
</body>

</body>
</html>