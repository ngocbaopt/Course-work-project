<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Blog Post</title>
</head>
<body>
	<h1>Welcome to Blog Post Site</h1>
	<form:form commandName="trip" action="trip" method="post">
		<form:errors path="*" cssClass="errorBlock" element="div"></form:errors>
		<table>
			<tr>
				<td><textarea rows="15" cols="80" name="tripText"></textarea></td>
				<td><input type="submit" value="Add" /></td>
				<td><form:errors path="tripText" cssClass="error" /></td>
			</tr>
		</table>
	</form:form>
	<hr>
	<c:forEach var="trip" items="${trips}">
		<div>
			<p>${trip.username}$" " $ ${trip.createDate}</p>
			<p>${trip.tripText }</p>
			<img alt="Like" src="like.png" /> 
			<img alt="Edit" src="edit.png" /> 
			<img alt="Delete" src="delete.png" />
			<table>
				<c:forEach var="comment" items="${comments}">
					<tr>
						<td>${comment.username}</td>
						<td><img alt="Edit" src="edit.png" /></td>
						<td><img alt="Delete" src="delete.png" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:forEach>
</body>
</html>