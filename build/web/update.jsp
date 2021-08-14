<%-- 
    Document   : update
    Created on : Mar 15, 2021, 2:19:23 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>

    <c:if test="${sessionScope.LOGIN_USER != null}">
        <h1>Wellcome: ${sessionScope.LOGIN_USER.fullName}</h1>     
        <form action="MainController">
            <table>
                
                    <tr>
                        <td>UserID</td>
                        <td><input type="text" name="userID" value="${param.userID}" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td>FullName</td>
                        <td><input type="text" name="fullName" value="${param.fullName}"/></td>
                    </tr>
                    <tr>
                        <td>Role</td>
                        <td>
                            <select name="roleID">
                                <option value="user">user</option>
                                <option value="AD">AD</option>
                            </select>
                        </td>
                    </tr>
            </table>
            <input type="hidden" name="search" value="${param.search}"/>
            <input type="submit" name="action" value="Confirm Update"/>
        </form>
    </c:if>
</body>
</html>
