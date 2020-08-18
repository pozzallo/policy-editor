<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
    <style>
        a{
            font-size: 20px;
            display:block;
            margin-top: 20px;
            text-decoration:none;
            color:gray;
        }
        a i{color:#3fb3a4;}
        p{
        font-size: 20px;
        }
    </style>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link href="${pageContext.request.contextPath}/resources/libs/awesome/css/all.css" rel="stylesheet">
    <title>Document</title>
</head>
<body>
	<p>
		User: <i> <security:authentication property="principal.username" /></i>
		<br><br>
		Role(s): <i><security:authentication property="principal.authorities" /></i>
		<br><br>
		First name: <i>${user.firstName}, </i> Last name: <i>${user.lastName},</i> Email: <i>${user.email}</i>
	</p>
	<hr>
    <a href="/changePassword.jsp"><i class="fas fa-unlock-alt"></i> change password</a>
    <security:authorize access="hasRole('ADMIN')">
    <a href="${pageContext.request.contextPath}/admin/showFormForAdd"><i class="fas fa-user-plus"></i> create user</a>
    <a href="${pageContext.request.contextPath}/admin/users"><i class="fas fa-users"></i> show all users</a>
    <a href="${pageContext.request.contextPath}/admin/users"><i class="fas fa-user-minus"></i> delete user</a>
    </security:authorize>	
    <hr>
    <a href="${pageContext.request.contextPath}/"><i class="fas fa-sign-out-alt"></i> Back to Home page</a>
</body>
</html>