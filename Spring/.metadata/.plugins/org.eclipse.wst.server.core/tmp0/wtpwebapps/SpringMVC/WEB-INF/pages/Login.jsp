<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sf:form action="Login" method="post" modelAttribute="form">
		<font size="10px" color="navy">Login</font>
		<table>
			<tr>
				<th>Login :</th>
				<td><sf:input path="login" /></td>
			</tr>
			<tr>
				<th>Password :</th>
				<td><sf:input path="password" /></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit"></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>