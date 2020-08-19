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
        <h3>Policy: ${policyTitle}</h3>
        <br> <br>
        <hr>
       
        <div class="content">
        
            <div class="sidebar">
             <h4>Rules:</h4> <br>
                	<c:forEach var="tempRule" items="${rules}">

						<c:url var="showRule" value="/policy/showRule">
							<c:param name="ruleId" value="${tempRule.id}" />
						</c:url>
                		<a href="${showRule}">${tempRule.title}</a><br>
           			</c:forEach>
            
            </div>
          
            <div class="main_view">
            <form:form action="savePolicy" modelAttribute="policyDTO" method="POST"> 

                <div class="">
                	<form:hidden path="id"/>
                	Policy version:<form:textarea path="version" style="width:100%; height:30px"/> <br>
                	Policy description:<form:textarea path="description" style="width:100%; height:200px"/>
                </div>
                
                <div class="">
                Policy profiles: <br>
                	<c:forEach var="tempProfile" items="${profiles}">
                		${tempProfile.title}<br>
           			</c:forEach>
                </div>
                
                 <div class="">

                </div>
              </form:form> 
            </div>
     </div>
     <footer>this is some information in footer</footer>
    </div>
</body>
</html> 
