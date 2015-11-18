<%@ include file="header.jsp"%>
<div class="container">
	<div class="page-content">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<h3>Please register new account!</h3>
				<form:form commandName="users" action="register" method="post">
					<form:errors path="*" cssClass="errorBlock" element="div"></form:errors>
					<label>User name</label>
					<input type="text" name="username" class="form-control" />
					<form:errors path="username" cssClass="error" />

					<label>Password</label>
					<input type="text" name="password" class="form-control" />
					<form:errors path="password" cssClass="error" />


					<label for="email">Email</label>
					<input type="text" name="email" class="form-control" />
					<form:errors path="email" cssClass="error" />
					<br>
					<input type="submit" class="button"/>
				</form:form>
				<%@ include file="footer.jsp"%>
			</div>
		</div>
	</div>
</div>