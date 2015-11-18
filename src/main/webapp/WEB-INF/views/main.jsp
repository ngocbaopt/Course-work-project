<%@ include file="header.jsp"%>
<div class="container">
	<div class="page-content">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<form:form commandName="trip" action="addTrip" method="post"
					class="form-inline">
					<form:errors path="*" cssClass="errorBlock" element="div"></form:errors>
					<table>
						<tr>
							<td><textarea rows="4" cols="80" name="tripText"
									class="form-control"></textarea></td>
							<td><input type="submit" class="btn btn-default" value="Add"></td>
							<td><form:errors path="tripText" cssClass="error" /></td>
						</tr>
					</table>
				</form:form>
				<c:forEach var="trip" items="${trips}">
					<hr>
					<div class="form-group">
						<p>
							<span class="glyphicon glyphicon-user"></span>
							${trip.user.username}
							<fmt:formatDate value="${trip.createDate}" pattern="yyyy-MMM-dd" />
						</p>
						<c:choose>
							<c:when test="${trip.editable eq true }">
								<form:form commandName="trip" action="updateTrip/${trip.id}"
									method="post">
									<table>
										<tr>
											<td><textarea name="tripText" class="form-control"
													rows="4" cols="80">${trip.tripText }</textarea></td>
											<td><button type="submit" class="btn btn-default">Update</button></td>
										</tr>
									</table>
								</form:form>
							</c:when>
							<c:otherwise>
								<p>${trip.tripText }</p>
								<c:choose>
									<c:when test="${trip.isFavorite()}">
										<c:choose>
											<c:when test="${trip.favorites.size() > 1}">
												<p class="label label-info">${trip.favorites.size()}
													people like this</p>
											</c:when>
											<c:otherwise>
												<p class="label label-info">1 like</p>
											</c:otherwise>
										</c:choose>

										<c:choose>
											<c:when test="${trip.isLikedByUser(currentUsername)}">
												<a href="addFavorite/${trip.id}/${currentUsername}"> <span
													class="glyphicon glyphicon-heart"></span>
												</a>
											</c:when>
											<c:otherwise>
												<a href="addFavorite/${trip.id}/${currentUsername}"> <span
													class="glyphicon glyphicon-heart-empty"></span>
												</a>
											</c:otherwise>
										</c:choose>

									</c:when>
									<c:otherwise>
										<a href="addFavorite/${trip.id}/${currentUsername}"> <span
											class="glyphicon glyphicon-heart-empty"></span>
										</a>
									</c:otherwise>
								</c:choose>
								<c:if test="${trip.user.username eq currentUsername }">
									<a href="trip/${trip.id }"> <span
										class="glyphicon glyphicon-pencil"></span>
									</a>
									<a href="deleteTrip/${trip.id}"> <span
										class="glyphicon glyphicon-remove"></span>
									</a>
								</c:if>
							</c:otherwise>
						</c:choose>
						<div class="tripComment">
							<c:forEach var="currentComment" items="${trip.comments}">
								<p>
									<span class="glyphicon glyphicon-user"></span>

									<c:choose>
										<c:when test="${currentComment.editable eq true }">
											<form:form commandName="comment"
												action="updateComment/${currentComment.id}" method="post">
												<table>
													<tr>
														<td><textarea name="commentText" class="form-control">${currentComment.commentText}</textarea></td>
														<td><button type="submit" class="btn btn-default">Update</button></td>
													</tr>
												</table>
											</form:form>
										</c:when>
										<c:otherwise>
											<td>${currentComment.commentText}</td>
											<c:if
												test="${currentComment.user.username eq currentUsername }">
												<td><a href="editComment/${currentComment.id}"> <span
														class="glyphicon glyphicon-pencil"></span>
												</a></td>
												<td><a href="deleteComment/${currentComment.id}"> <span
														class="glyphicon glyphicon-remove"></span>
												</a></td>
											</c:if>
										</c:otherwise>
									</c:choose>
								</p>
							</c:forEach>
							<form:form commandName="comment" action="addComment/${trip.id}"
								method="post">
								<form:errors path="*" cssClass="errorBlock" element="div"></form:errors>
								<table>
									<tr>
										<td><span class="glyphicon glyphicon-user"></span></td>
										<td><textarea rows="1" cols="40" name="commentText"
												class="form-control"></textarea></td>
										<td><input type="submit" value="Add"
											class="btn btn-default" /></td>
										<td><form:errors path="commentText" cssClass="error" /></td>
									</tr>
								</table>
							</form:form>
						</div>

					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>