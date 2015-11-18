<%@ include file="header.jsp"%>
<div class="container">
	<div class="page-content">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<h3>Please log in!</h3>
				<c:if test="${error eq true}">
					<p>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
				</c:if>
				<form method="post"
					action="<c:url value='j_spring_security_check' />"
					class="form-signin">
					<label for="j_username">Username</label> <input
						class="form-control" name="j_username"
						value='<c:if test="${not empty param.login_error}">
										<c:out value="${SPRING_SECURITY_LAST_USERNAME}"/>
									</c:if>' />
					<label for="j_password">Password</label> <input type="password"
						name='j_password' class="form-control" /> <input type="hidden"
						name="<c:out value="${_csrf.parameterName}"/>"
						value="<c:out value="${_csrf.token}"/>" />
						 <div class="checkbox">
      						<label for="_spring_security_remember_me"><input type="checkbox" name="_spring_security_remember_me">Remember me</label>
    					</div>
					<input type="submit" class="button" />
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>