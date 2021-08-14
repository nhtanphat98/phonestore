<%-- 
    Document   : createUser
    Created on : Mar 15, 2021, 2:26:42 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            User ID <input type="text" name="userID"></br>
            ${err.userIDErr}</br>
            Full Name <input type="text" name="fullName"></br>
            ${err.fullNameErr}</br>
            Password <input type="password" name="password"></br>
            ${err.passwordErr}</br>
            Confirm <input type="password" name="confirm"></br>
            ${err.confirmErr}</br>
            <input type="submit" name="action" value="Create"></br>
        </form>
    </body>
</html>

