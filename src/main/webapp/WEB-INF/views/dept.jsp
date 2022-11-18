<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department page</title>
</head>
<body>

	<h1>Department Page</h1>

	<form:form action="department.html" method="post">
		<form:input path="deptId" />
		<br />
		<form:input path="deptName" />
		<br />
		<input type="submit" value="Create" />

	</form:form>

	<h1>Department List</h1>

	<table border="1">

		<thead>
			<tr>
				<td>Department Id</td>
				<td>Department Name</td>
				<td></td>
			</tr>
		</thead>

		<tbody>

			<c:forEach items="${DEPTLIST}" var="d">

				<tr>
					<td><c:out value="${d.deptId}"></c:out></td>
					<td><c:out value="${d.deptName}"></c:out></td>
					<td><a href="<c:url value='/dept-del-${d.deptId}'/>">Delete</a></td>
					<td><a href="<c:url value='/dept-edit-${d.deptId}'/>">edit</a></td>
				</tr>
				
			</c:forEach>

		</tbody>
	</table>
</body>
</html>