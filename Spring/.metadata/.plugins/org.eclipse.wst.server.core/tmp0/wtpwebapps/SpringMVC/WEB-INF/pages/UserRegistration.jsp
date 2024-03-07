<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sf:form action="UserRegistration" method="post" modelAttribute="form">
		<table>
			<tr>
				<th>First Name :</th>
				<td><sf:input path="firstName" />
			</tr>
			<tr>
				<th>Last Name :</th>
				<td><sf:input path="lastName" />
			</tr>
			<tr>
				<th>Login :</th>
				<td><sf:input path="login" />
			</tr>
			<tr>
				<th>Password :</th>
				<td><sf:input path="password" />
			</tr>
			<tr>
				<th>DOB :</th>
				<td><sf:input path="dob" />
			</tr>
			<tr>
				<th>Address :</th>
				<td><sf:input path="address" />
			</tr>
			<tr>
				<th></th>
				<td><input type="submit"></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>