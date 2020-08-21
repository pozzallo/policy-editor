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
   html, body {
  height: 100%;
}    
    .save {
	font-weight: bold;
	width: 130px; 
	padding: 5px 10px; 
	margin-top: 30px;
	background: #cccccc;
}

a{text-decoration: none;}
.addrule{
font-size: 18px;
	display: block;
	margin-top: 10px;
	text-decoration: none;
	border:2px solid #e1e6e3;
	width:150px;
	padding:5px;
	background-color: #edf2ef;
	color: black;
}
.addrule:hover{background-color: #e1e6e3;}
.wrapper{padding:10px;}
h3{margin-top:15px}
.back a{
            font-size: 20px;
            display:block;
            margin-top: 20px;
            text-decoration:none;
            color:gray;
        }
.sidebar{
 overflow: scroll;
 height:800px;
}
.sidebar a{
font-size: 16px;
color: black;
display: inline-block;
}
.sidebar a:hover{
background-color: #e1e6e3;
}
</style>
</head>

<body>
    <div class="wrapper">
        <header>
            <div class="logo"><img src="${pageContext.request.contextPath}/resources/img/ssl.svg" alt="logo" width="110px" align="left"></div>
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
        <a href="${pageContext.request.contextPath}/policy/addRule?policyId=${policyId}" class="addrule">Add New Rule</a><br>
        <hr>
       
        <div class="content">
        
            <div class="sidebar">
             <h4>Rules:</h4> <br>
                	<c:forEach var="tempRule" items="${rules}">

						<c:url var="showRule" value="/policy/showRule">
							<c:param name="ruleId" value="${tempRule.id}" />
							<c:param name="policyId" value="${policyId}" />
						</c:url>
                		<a href="${showRule}">${tempRule.title}</a><br>
           			</c:forEach>
            	<a href="${pageContext.request.contextPath}/policy/addRule?policyId=${policyId}">Add New Rule</a><br>
            </div>
          
            <div class="main_view" style="padding:8px">
            <form:form action="savePolicy" modelAttribute="policyDTO" method="POST"> 

                <div class="">
                	<form:hidden path="id"/>
                	Policy version:<form:textarea path="version" style="width:100%; height:30px;padding:8px"/> <br>
                	Policy description:<form:textarea path="description" style="width:100%; height:200px;padding:8px"/>
                </div>
                
                <div class="">
                Policy profiles: <br>
                	<c:forEach var="tempProfile" items="${profiles}">
                		${tempProfile.title}<br>
           			</c:forEach>
                </div>
                
                 <div class="">
					<input type="submit" value="Save" class="save" />
                </div>
                <div class="back" style="margin-top:10px">
					 <a href="${pageContext.request.contextPath}/"><i class="fas fa-sign-out-alt"></i>Back to list of Policies</a>
                </div>
              </form:form> 
            </div>
     </div>
    </div>
</body>
</html> 
