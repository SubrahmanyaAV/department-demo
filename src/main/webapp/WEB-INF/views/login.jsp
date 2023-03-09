<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>

	<h1>Login Page</h1>
	
	<c:if test="${param.ERROR_MSG != null}" >   <%-- ${param} shortcut for req param --%>
		<c:out value="${param.ERROR_MSG }"  />
	</c:if>
	
	
	
	<form action="login.html" method="post">
		<label>User Id</label>
		<input type="text" name="userId"><br/>
		<label>Password</label>
		<input type="password" name="pwd"><br/>
		<input type="submit" value="login">
	</form>

</body>
</html>