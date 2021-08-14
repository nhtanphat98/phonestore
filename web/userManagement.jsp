<%-- 
    Document   : userManagement
    Created on : Mar 14, 2021, 8:44:36 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UserManagement Page</title>
    </head>
    <a href="userManagement.jsp"></a>
    <body>
        <c:if test="${sessionScope.LOGIN_USER != null}">
            <h1> Wellcome: ${LOGIN_USER.fullName}</h1>
            <form action="MainController">
                <input type="submit" name="action" value="SignOut">
            </form>
            <form action="MainController">
                Search <input type="text" name="search" value="${param.search}"/>
                <input type="submit" name="action" value="Search"/>
            </form>
            <c:if test="${requestScope.LIST_USER != null}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>UserID</th>
                            <th>FullName</th>
                            <th>RoleID</th>
                            <th>Password</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="uline" items="${requestScope.LIST_USER}" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${uline.userID}</td>
                                <td>${uline.fullName}</td>
                                <td>${uline.roleID}</td>
                                <td>${uline.password}</td>
                                <td>
                                    <a href="MainController?search=${param.search}&action=Delete&userID=${uline.userID}">Delete</a>
                                </td>
                                <td>
                                    <c:url var="Update" value="MainController">
                                        <c:param name="userID" value="${uline.userID}"></c:param>
                                        <c:param name="fullName" value="${uline.fullName}"></c:param>
                                        <c:param name="roleID" value="${uline.roleID}"></c:param>
                                        <c:param name="search" value="${param.search}"></c:param>
                                        <c:param name="action" value="Update"></c:param>
                                    </c:url>
                                    <a href="${Update}">Update</a>                                   
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>

            </c:if>
        </c:if>
    </body>
</html>
