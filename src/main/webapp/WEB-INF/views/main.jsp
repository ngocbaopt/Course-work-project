<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Blog Post</title>
</head>
<body>
	<div>
		<a href="login""><img alt="Logout"
			src="<c:url value="/resources/images/logout.png"/>" /></a> <a
			href="register""><img alt="Register"
			src="<c:url value="/resources/images/register.png"/>" /></a>
	</div>
	<h1>Welcome to Blog Post Site</h1>
	<form:form commandName="trip" action="addTrip" method="post">
		<form:errors path="*" cssClass="errorBlock" element="div"></form:errors>
		<table>
			<tr>
				<td><textarea rows="10" cols="80" name="tripText"></textarea></td>
				<td><input type="submit" value="Add" /></td>
				<td><form:errors path="tripText" cssClass="error" /></td>
			</tr>
		</table>
	</form:form>
	<hr>
	<c:forEach var="trip" items="${trips}">
		<div>

			<p>
				<img alt="Like" src="<c:url value="/resources/images/user.png"/>" />
				${trip.user.username}
				<fmt:formatDate value="${trip.createDate}" pattern="yyyy-MMM-dd" />
			</p>
			<c:choose>
				<c:when test="${trip.editable eq true }">
					<form:form commandName="trip" action="updateTrip/${trip.id}"
						method="post">
						<textarea name="tripText">${trip.tripText }</textarea>
						<button type="submit">Update</button>
					</form:form>
				</c:when>
				<c:otherwise>
					<label>${trip.tripText }</label>
					<img alt="Like" src="<c:url value="/resources/images/like.png"/>" />
					<a href="trip/${trip.id }"><img alt="Edit"
						src="<c:url value="/resources/images/edit.png"/>" /></a>
					<a href="deleteTrip/${trip.id}"><img alt="Delete"
						src="<c:url value="/resources/images/delete.png"/>" /></a>
				</c:otherwise>
			</c:choose>
			<table>
				<c:forEach var="currentComment" items="${trip.comments}">
					<tr>
						<td><img alt="Like"
							src="<c:url value="/resources/images/user.png"/>" /></td>
						<td>${currentComment.user.username}</td>
						<td>${currentComment.commentText}</td>
						<td><img alt="Edit"
							src="<c:url value="/resources/images/edit.png"/>" /></td>
						<td><img alt="Delete"
							src="<c:url value="/resources/images/delete.png"/>" /></td>
					</tr>
				</c:forEach>
			</table>
			<form:form commandName="comment" action="addComment/${trip.id}"
				method="post">
				<form:errors path="*" cssClass="errorBlock" element="div"></form:errors>
				<table>
					<tr>
						<td><textarea rows="2" cols="40" name="commentText"></textarea></td>
						<td><input type="submit" value="Add" /></td>
						<td><form:errors path="commentText" cssClass="error" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</c:forEach>
</body>
</html>