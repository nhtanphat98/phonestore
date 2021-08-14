<%-- 
    Document   : index
    Created on : Jan 19, 2021, 12:29:01 PM
    Author     : Admin
--%>

<%@page import="phat.dtos.UserDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    <link rel="stylesheet" type="text/css" href="frontend.css">
    <body>
        <div class="loginbox">
            
            <img src="avatar.png" class="avatar">
            <h1>Login Here</h1>
            <font style="color: red">${msg}</font>
            <form action="MainController" method="POST">
                <p>Username</p>
                <input type="text" name="username" placeholder="Enter Username"> <font style="color: red">${err.userIDErr}</font>
                <p>Password</p>
                <input type="password" name="password" placeholder="Enter Password"> <font style="color: red">${err.passwordErr}</font>
                <input type="submit" name="action" value="Login"/>
                <input type="reset" value="Reset"/>     
            </form>
            <a href="https://www.facebook.com/dialog/oauth?client_id=3741017742626595&redirect_uri=http://localhost:8080/Assignment_PRJ321_SE140227/LoginFacebook"><img src="hình ảnh/fblogin.png" style="height: 40px; width:260px; border-radius: 20px;"></a>
            <a href="https://accounts.google.com/o/oauth2/auth?scope=profile&redirect_uri=http://localhost:8080/Assignment_PRJ321_SE140227/LoginGmail&response_type=code
               &client_id=1096737237119-2tapsofovb2olka5sfhkqg1sshe99e1v.apps.googleusercontent.com&approval_prompt=force"><img src="hình ảnh/gmailLogin.png" style="height: 40px; width:260px; border-radius: 20px;"></a>
            <a href="createUser.jsp">Create Account</a>
        </div>
    </body>

</html>
