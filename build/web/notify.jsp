<%-- 
    Document   : notify
    Created on : Mar 15, 2021, 3:03:33 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Page</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
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
                    <c:if test="${msg != null}">
                        <br/>${msg}
                    </c:if>
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
        <h1>Đặt Mua Thành Công</h1>
        <a href="success.jsp">Continue to shopping</a>
    </body>
</html>
