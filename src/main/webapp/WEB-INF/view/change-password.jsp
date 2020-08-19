<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ page isELIgnored="false" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
.change_password{
    width: 50%;
    padding: 25px;
    background-color: #c5ece78f;
}
label{
        font-size:18px;
        color: rgb(108, 111, 114);
    }
    input[type=submit]{
        display: block;
        padding: 5px 25px;
        font-size: 15px;
        cursor: pointer;
        font-style: italic;
        margin-top: 25px;
    }
    input[type=password]{
        display: inline-block;
        padding: 5px 15px;
        font-size: 15px;
        margin-top: 10px;
    }
.error{color:red;}
</style>
<body>
    <center>
        <div class="change_password">
            <form:form action="${pageContext.request.contextPath}/user/changePassword" modelAttribute="passwordDTO" method="post">
                <div>
                  <form:errors path="password" cssClass="error" /> <br>
                    <label for="password_id">Enter new password: </label> 
                    <form:input type="password" name="password" id="password_id" path="password"/>
                </div>
                <div>
                    <label for="repassword_id"> Confirm password: </label> 
                    <form:input type="password" name="repassword" id="repassword_id" path="matchingPassword"/> 
                </div>
                <input type="submit" value="change">
            </form:form>
           
        </div>
    </center>
</body>
</html>