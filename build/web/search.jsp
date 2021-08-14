<%-- 
    Document   : search
    Created on : Mar 15, 2021, 7:19:45 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <div class="container">
            <div class="menu">
                <div class="up">
                    <ul>
                        <li class="logo">

                            <img src="hình ảnh/logo1.jpg" style="width: 200px; height: 50px;">


                        </li>
                        <li class="search">

                            <form action="MainController" method="POST" style="color: black;">
                                <input type="hidden" name="action" value="SearchProduct"/>
                                Tìm sản phẩm: <input type="text" name="search" value="${param.search}"/> 
                                <input type="submit" value="Tìm Kiếm"/>
                            </form>
                        </li>

                        <li>
                            <a href="MainController?action=ViewCart" style="color: black;" class="giohang">
                                <img src="hình ảnh/giohang.jpg" style="width: 50px; height: 50px;">
                                Giỏ hàng
                            </a>
                        </li>
                        <li>
                            <a href="MainController?result=${sessionScope.result}&action=${sessionScope.result}" style="color: blue; font-size: 20px;">${sessionScope.result}
                                <img src="${sessionScope.avatar}" style="width: 50px; height: 50px;">
                            </a> 
                        </li>
                    </ul>
                </div>
            </div>

            <div class="content">
                <c:if test="${not empty requestScope.LIST_PRODUCT}">

                    <h1>Here is your Search</h1>
                    <div class="item">
                        <c:forEach var="pline" items="${requestScope.LIST_PRODUCT}">
                            <div class="info">
                                <a href="MainController?action=Add&pID=${pline.productID}" style="width: 10px; color: black; height: 10px; ">
                                    <img src="hình ảnh/${pline.image}" style="width: 180px; height: 180px;"/>
                                    <p>${pline.name}</p><br/>
                                    <p>${pline.description}</p>
                                    <p>${pline.price}</p>
                                </a>
                            </div>

                        </c:forEach>
                    </div>

                </c:if>
                <c:if test="${empty requestScope.LIST_PRODUCT}">
                    <h1>Not Found Product name: ${param.search}</h1>
                </c:if> 
            </div>
        </div>
    </body>
</html>
