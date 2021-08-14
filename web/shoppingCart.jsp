<%-- 
    Document   : shoppingCart
    Created on : Mar 9, 2021, 3:47:59 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
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
        <br/><a href="success.jsp">Back to shopping page</a>
        <div style="text-align: center;" class="shopping">
            <div style="display: inline-block;" class="productCart">
                <h1>Your Cart</h1>
                <c:if test="${requestScope.mess != null}">
                    <h2>${mess}</h2>
                </c:if>
                    
                <c:if test="${empty sessionScope.CART.cart}">
                    <h1>Cart is empty</h1>
                    <h2>Total: 0</h2>

                </c:if>
                <c:if test="${requestScope.message != null}">
                    <h2>${message}</h2>
                </c:if>
                <c:if test="${not empty sessionScope.CART.cart}">
                    <table>
                        <thead>
                            <tr>
                                <th style="width: 200px; text-align: center;">Image</th>
                                <th style="width: 200px; text-align: center;">ID</th>
                                <th style="width: 200px; text-align: center;">Name</th>
                                <th style="width: 200px; text-align: center;">Price</th>
                                <th style="width: 200px; text-align: center;">Quantity</th>
                                <th style="width: 200px; text-align: center;">Delete</th>
                                <th style="width: 200px; text-align: center;">Update</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="dto" items="${sessionScope.CART.cart.values()}">
                            <form action="MainController">
                                <tr>
                                    <td><img src="hình ảnh/${dto.image}" style="width: 210px; height: 180px;"></td>
                                    <td>
                                        <input style="border: none; width: 50px; text-align: center;" type="text" name="productID" value="${dto.productID}" readonly="true"/>
                                    </td>
                                    <td style="text-align: center;">${dto.name}</td>

                                    <td style="text-align: center;">${dto.price}</td>

                                    <td style="text-align: center;">
                                        <input style=" text-align: center; width: 50px;" type="number" name="quantity" value="${dto.quantity}"/>
                                    </td>

                                    <td style="text-align: center;"><input type="submit" name="action" value="Delete_Cart"/></td>
                                    <td style="text-align: center;"><input type="submit" name="action" value="Update_Cart"/></td>
                                </tr>
                            </form>                    
                        </c:forEach>

                        </tbody>
                    </table>
                    <br/>Total   : $${sessionScope.CART.getTotal()}
                </c:if>
            </div>
            <br/> <br/>
            <form action="MainController" method="POST">                            
                <input style="font-size: 20px; width: 100px" type="submit" name="action" value="Order"/>
            </form>

        </div>

    </body>
</html>
