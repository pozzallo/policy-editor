<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>

<html>

<head>
<title>Home page</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style3.css" />
<link
	href="${pageContext.request.contextPath}/resources/libs/awesome/css/all.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style2.css">
<link
	href="${pageContext.request.contextPath}/resources/libs/awesome/css/all.css"
	rel="stylesheet">
<style>
.back a {
	font-size: 20px;
	display: block;
	margin-top: 20px;
	text-decoration: none;
	color: gray;
}

a i {
	color: #3fb3a4;
}
</style>
</head>

<body>

		<header>
			<div class="logo">
				<img src="${pageContext.request.contextPath}/resources/img/ssl.svg"
					alt="logo" width="140px" align="left">
			</div>
			<div class="header_content">
				<div class="user">
					<a href="${pageContext.request.contextPath}/user/info"><i
						class="fas fa-users-cog"></i> <security:authentication
							property="principal.username" /></a>
				</div>
				<div class="about">
					<a href=""><i class="fas fa-info-circle"></i> About</a>
				</div>
				<div class="sign_out">
					<form:form action="${pageContext.request.contextPath}/logout"
						method="POST">
						<i class="fas fa-sign-out-alt"></i>
						<input class="logout" type="submit" value="Logout" />
					</form:form>
				</div>
			</div>
		</header>

		<div id="header" style="margin-top:30px">
			<h2>Policies:</h2>
		</div>
	

	<div id="container">

		<div id="content">

			<input type="button" value="Upload Policy"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<!--  add our html table here -->

			<table>
				<tr>
					<th>Policy</th>
					<th>Version</th>
					<th>Action</th>
				</tr>

				<c:forEach var="tempPolicy" items="${policies}">

					<c:url var="showPolicy" value="/policy/showPolicy">
						<c:param name="policyId" value="${tempPolicy.id}" />
					</c:url>

					<c:url var="deleteLink" value="/policy/deletePolicy">
						<c:param name="policyId" value="${tempPolicy.id}" />
					</c:url>

					<tr>
						<td>${tempPolicy.title}</td>
						<td>${tempPolicy.version}</td>
						<td>
							<!-- display the update link --> <a href="${showPolicy}">Show
								Policy</a> | <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this policy?'))) return false">Delete policy</a>
						</td>
					</tr>
				</c:forEach>

			</table>

		</div>

	</div>

	<hr>

</body>

</html>









