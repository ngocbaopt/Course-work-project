<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Blog for fun</title>
<link
	href="<c:url value="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet"
	type="text/css" />
</head>
<body>

	<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="row top-row">
			<div class="col-md-5"></div>
			<div class="pull-right">
				<c:if test="${not empty currentUsername}">
					<a href="login" class="navi-icon"><span
						class="glyphicon glyphicon-off"></span></a>
				</c:if>
			</div>
			<div class="pull-right">
				<a href="register" class="navi-icon">Register</a>
			</div>
			<div class="col-md-6">
				<c:if test="${not empty currentUsername}">
					<span class="welcome-text">Welcome ${currentUsername}</span>
				</c:if>
			</div>
		</div>
	</div>
	</nav>