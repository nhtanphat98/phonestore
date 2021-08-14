<%-- 
    Document   : success
    Created on : Jan 19, 2021, 12:32:47 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phát - Thế giới di động</title>
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
                                Tìm sản phẩm: <input type="text" name="search"/> 
                                <input type="submit" value="Tìm Kiếm"/>
                            </form>
                        </li>

                        <li>
                            <a href="MainController?action=ViewCart" style="color: black;" class="giohang">
                                <img src="hình ảnh/giohang.jpg" style="width: 50px; height: 50px;"/>
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
                <c:if test="${not empty sessionScope.LIST_CATEGORY}">
                    <c:forEach var="cateDTO" items="${sessionScope.LIST_CATEGORY}">
                        <h2 style="margin-left: 20%; margin-top: 10px;">${cateDTO.name} - ${cateDTO.description}</h2>
                        <div class="item">
                            <c:forEach var="pline" items="${cateDTO.listProduct}">
                                <c:if test="${pline.quantity > 0}">
                                    <div class="info">

                                        <a href="MainController?action=Add&pID=${pline.productID}" style="width: 10px; color: black; height: 10px; ">
                                            <img src="hình ảnh/${pline.image}" style="width: 180px; height: 180px;"/>
                                            <p>-Tên sản phẩm: ${pline.name}</p>
                                            <p>-Mô tả: ${pline.description}</p>
                                            <p>-Giá: ${pline.price}</p>
                                            <img src="hình ảnh/giohang.jpg" style="width: 40px; height: 40px; text-align: center;"/>
                                        </a>

                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </c:forEach>
                </c:if>

            </div>
        </div>

    </body>
</html>

