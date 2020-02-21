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
<form method = "post" action = "navigationServlet">
	<table>
	<c:forEach items="${requestScope.allEmps}" var="currentEmp">
		<tr>
			<td><input type="radio" name="id" value="${currentEmp.id}"></td>
			<td>${currentEmp.firstName}</td>
			<td>${currentEmp.lastName}</td>
			<td>${currentEmp.age}</td>
			<td>${currentEmp.position}</td>
		</tr>
	</c:forEach>
	</table>
	<input type="submit" value="edit" name="doThisToEmp">
	<input type="submit" value="delete" name="doThisToEmp">
	<input type="submit" value="add" name="doThisToEmp">
</form>

</body>
</html>