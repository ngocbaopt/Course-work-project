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
	<link href="<c:url value="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="">
 	<c:if test="${not empty currentUsername}"> 
			<a href="login"><span class="glyphicon glyphicon-off"></span></a>
 	</c:if> 
	<a
		href="register"><span class="glyphicon glyphicon-plus"></span></a>
	<c:if test="${not empty currentUsername}"> 
			<span>Welcome ${currentUsername}</span>
 	</c:if> 
	</div>
