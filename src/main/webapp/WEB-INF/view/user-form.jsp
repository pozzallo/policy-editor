<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
<title>Save Customer</title>
 	<style>
 	.error{color:red}
 	</style>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>

		<form:form action="${pageContext.request.contextPath}/admin/updateUser" modelAttribute="userDTO" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
			<form:hidden path="password" />

			<table>
				<tbody>
					<tr>
						<td><label>User name:</label></td>
						<td><form:input path="userName" />
						<form:errors path="userName" cssClass="error"></form:errors>
						</td>
					</tr>

					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" />
						<form:errors path="firstName" cssClass="error"></form:errors>
						</td>
					</tr>
					
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" />
						<form:errors path="lastName" cssClass="error"></form:errors>
						</td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><label>Description:</label></td>
						<td><form:input path="description" /></td>
					</tr>
					<tr>
						<td><label>Department:</label></td>
						<td>
						<form:select path="department">
							<form:options items="${departments}"/>
						</form:select>
						</td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}/admin/users">Back to
				List</a>
		</p>

	</div>

</body>

</html>










