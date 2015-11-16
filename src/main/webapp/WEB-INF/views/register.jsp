<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register new user</title>
</head>
<body>
	<h1>Please register new account!</h1>
	<form:form commandName="user" action="register" method="post">
		<form:errors path="*" cssClass="errorBlock" element="div"></form:errors>
		<table>
			<tr>
				<td>User name:</td>
				<td><input type="text" name="username" /></td>
				<td><form:errors path="username" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password" /></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>
 			<tr>
				<td>Email: </td>
				<td><input type="text" name="email" /></td>
				<td><form:errors path="email" cssClass="error"/></td>
			</tr>
		</table>
		<input type="submit" />
	</form:form>
</body>
</html>