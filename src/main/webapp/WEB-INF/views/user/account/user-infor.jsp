<%--
  Created by IntelliJ IDEA.
  User: xuan hieu
  Date: 7/3/2022
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.Date" %>

<body>
<div class="base-container">
    <div class="grid wide">
        <div class="user-info-wrap">
            <p>Thông tin cá nhân</p>
            <div class="user-infor-form">
                <div class="user-infor-form-wrap">
                    <p>Tên: <span style="display:inline;">${user.display_name}</span> </p>
                </div>
                <div class="user-infor-form-wrap">
                    <p>Email: <span style="display: inline;"> ${user.email} </span> </p>
                </div>
                <div class="user-infor-form-wrap">
                    <a href="/thong-tin/change">Thay đổi</a>
                </div>
            </div>
        </div>

        <div class="user-bill-wrap">
            <p>Danh sách đơn hàng đã mua</p>
            <c:forEach items="${cartItems}" var="cartItem" begin="0" end="${cartItems.size() - 1}" varStatus="loop">
                <div class="user-bill">
                    <p style="text-align: left; margin-top: 20px;">Ngày mua:
                        <span>${dateCheckOut.get(loop.index)}</span>
                    </p>
                    <c:forEach items="${cartItem}" var="item">
                        <div class="cart-list__item">
                            <div class="img_wrap">
                                <img src="<c:url value = "/assets/user/img/product/${item.image}" />"
                                     alt="" class="item_img">
                            </div>
                            <div class="item-img-des-wrap">
                                <p>${item.name}</p>
                                <p> x${item.quantity} </p>
                                <p><fmt:formatNumber type="number"
                                                     groupingUsed="true"
                                                     value="${item.totalPrice}"/>đ</p>
                            </div>

                        </div>
                    </c:forEach>
                    <p>Tổng: <span style="font-weight: bold"><fmt:formatNumber type="number"
                                                                               groupingUsed="true"
                                                                               value="${totalPrices.get(loop.index)}"/>đ</span></p>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>

