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
		<a href="login"><img alt="Logout"
			src="<c:url value="/resources/images/logout.png"/>" /></a> <a
			href="register"><img alt="Register"
			src="<c:url value="/resources/images/register.png"/>" /></a>
	</div>
	<h1>Welcome ${currentUsername}</h1>
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
				<img alt="User" src="<c:url value="/resources/images/user.png"/>" />
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
					<p>${trip.tripText }</p>			
						<c:choose>
							<c:when test="${trip.isFavorite()}">
								<p>${trip.favorites.size()} people like this</p>
								<c:choose>
									<c:when test="${trip.isLikedByUser(currentUsername)}">
										<a href="addFavorite/${trip.id}/${currentUsername}">
											<img alt="Like" src="<c:url value="/resources/images/like filled.png"/>" />
										</a>
									</c:when>
									<c:otherwise>
										<a href="addFavorite/${trip.id}/${currentUsername}">
											<img alt="Like" src="<c:url value="/resources/images/like.png"/>" />
										</a>
									</c:otherwise>
								</c:choose>

							</c:when>
							<c:otherwise>
								<img alt="Like" src="<c:url value="/resources/images/like.png"/>" />
							</c:otherwise>
						</c:choose>
					<c:if test="${trip.user.username eq currentUsername }">
						<a href="trip/${trip.id }"><img alt="Edit"
							src="<c:url value="/resources/images/edit.png"/>" /></a>
						<a href="deleteTrip/${trip.id}"><img alt="Delete"
							src="<c:url value="/resources/images/delete.png"/>" /></a>
					</c:if>
				</c:otherwise>
			</c:choose>
			<table>
				<c:forEach var="currentComment" items="${trip.comments}">
					<tr>
						<td><img alt="User"
							src="<c:url value="/resources/images/user.png"/>" /></td>
						<td>${currentComment.user.username}</td>
						<c:choose>
							<c:when test="${currentComment.editable eq true }">
								<td>
									<form:form commandName="comment" action="updateComment/${currentComment.id}" method="post">
										<textarea name="commentText">${currentComment.commentText}</textarea>
										<button type="submit">Update</button>
									</form:form>
								</td>
							</c:when>
							<c:otherwise>
								<td>${currentComment.commentText}</td>
								<c:if test="${currentComment.user.username eq currentUsername }">
									<td>
										<a href="editComment/${currentComment.id}">
											<img alt="Edit"src="<c:url value="/resources/images/edit.png"/>" />
									</a>
									</td>
									<td>
										<a href="deleteComment/${currentComment.id}">
											<img alt="Delete" src="<c:url value="/resources/images/delete.png"/>" />
										</a>
									</td>
								</c:if>
							</c:otherwise>
						</c:choose>
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