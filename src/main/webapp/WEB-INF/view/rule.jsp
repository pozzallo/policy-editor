<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ page isELIgnored="false" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style2.css" >
    <link href="${pageContext.request.contextPath}/resources/libs/awesome/css/all.css" rel="stylesheet">
    <title>Document</title>
        <style type="text/css">
    
    .save {
	font-weight: bold;
	width: 130px; 
	padding: 5px 10px; 
	margin-top: 30px;
	background: #cccccc;
}
    </style>
</head>

<body>
    <div class="wrapper">
        <header>
            <div class="logo"><img src="${pageContext.request.contextPath}/resources/img/ssl.svg" alt="logo" width="140px" align="left"></div>
            <div class="header_content">
                <div class="user"><a href="${pageContext.request.contextPath}/user/info"><i class="fas fa-users-cog"></i> 
                    <security:authentication property="principal.username" /></a></div>
                <div class="about"><a href=""><i class="fas fa-info-circle"></i> About</a></div>
                <div class="sign_out">
                		<form:form action="${pageContext.request.contextPath}/logout" 
			   															method="POST">
			   			<i class="fas fa-sign-out-alt"></i> 
						<input class="logout" type="submit" value="Logout" />
						</form:form>
                </div>
            </div>
        </header>
        <h3>Rule: ${ruleTitle} ${rule.id}</h3>
        			<c:url var="deleteLink" value="/policy/deleteRule">
						<c:param name="ruleId" value="${rule.id}" />
						<c:param name="policyId" value="${policyId}" />
					</c:url>
        <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this policy?'))) return false">Delete this rule</a>
        <br> <br>
        <hr>
       
        <div class="content">
        
            <div class="sidebar">
             <h4>Profiles:</h4> <br>
            	 <ul>
                	<c:forEach var="tempProfile" items="${ruleProfiles}">
						<li>${tempProfile.title}</li>
           			</c:forEach>
           		 </ul>
            </div>
          
            <div class="main_view" style="padding:8px;padding-right:25px">
            <form:form action="saveRule?policyId=${policyId}" modelAttribute="rule" method="POST"> 

                <div class="">
                	<form:hidden path="id"/>
                	Title:<form:textarea path="title" style="width:100%; height:50px; padding:8px"/> <br> 
                	Rule description:<form:textarea path="description" style="width:100%; height:80px; padding:8px"/> <br>
                	Checked Text:<form:textarea path="checkedText" style="width:100%; height:200px;padding:8px"/> <br>
                	Fix Text:<form:textarea path="fixText" style="width:100%; height:200px;padding:8px"/> <br>
                </div>
                
                <div class="">
               		 <input type="submit" value="Save" class="save" />
                </div>
                
                 <div class="" style="margin-top:10px">
					 <a href="${pageContext.request.contextPath}/policy/showPolicy?policyId=${policyId}">Back to list of Rules</a>
                </div>
              </form:form> 
              </div>
         </div>
         </div>

</body>
</html> 
