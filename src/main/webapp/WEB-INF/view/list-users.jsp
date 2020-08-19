<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
	<link href="${pageContext.request.contextPath}/resources/libs/awesome/css/all.css" rel="stylesheet">

    <style>
           .back a{
            font-size: 20px;
            display:block;
            margin-top: 20px;
            text-decoration:none;
            color:gray;
        }

        a i{color:#3fb3a4;}
    </style>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>User Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add User"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>User Name</th>
					<th>Full Name</th>
					<th>Email</th>
					<th>Department</th>
					<th>Description</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempUser" items="${users}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/admin/showFormForUpdate">
						<c:param name="userId" value="${tempUser.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/admin/delete">
						<c:param name="userId" value="${tempUser.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempUser.userName} </td>
						<td> ${tempUser.firstName}  ${tempUser.lastName}</td>
						<td> ${tempUser.email} </td>
						<td> ${tempUser.department} </td>
						<td> ${tempUser.description} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	
<hr>
<div class="back">
	<a href="${pageContext.request.contextPath}/user/info"><i class="fas fa-sign-out-alt"></i> Back to User page</a>
</div>
    
</body>

</html>









