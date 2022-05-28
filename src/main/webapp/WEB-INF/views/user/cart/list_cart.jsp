<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>
<div class="cart-container">
    <div class="grid wide">
        <div class="non-product">
            <h1>Giỏ hàng</h1>
            <p>(Chưa có sản phẩm nào) nhấn vào <a href="./allProduct.html">cửa hàng</a> để mua hàng</p>
        </div>
        <div class="payment">
            <div class="row">
                <div class="cart-list l-8 m-12 c-12">
                    <h1>Giỏ Hàng</h1>
                    <c:forEach items="${Cart}" var="item">
                        <div class="cart-list__item">
                            <div class="img_wrap">
                                <img src="<c:url value = "/assets/user/img/product/${item.value.product.getImage()}" />"
                                     alt="" class="item_img">
                            </div>
                            <div class="item-img-des-wrap">
                                <p>${item.value.product.getName()}</p>
                                <div class="quantity-wrap">
                                    <button class="change-quantity quantity-list-btn--decrease" data-id="${item.value.product.getId()}">-</button>
                                    <input type="number" min="0" value="${item.value.quantity}" class="quantity-number"
                                           id="quantity-cart-${item.value.product.getId()}">
                                    <button class="change-quantity quantity-list-btn--increase" data-id="${item.value.product.getId()}">+</button>
                                </div>
                                <p><fmt:formatNumber type="number"
                                                     groupingUsed="true"
                                                     value="${item.value.totalPrice}"/>đ</p>
                            </div>
                            <a href="<c:url value = "/DeleteCart/${item.value.product.getId()}" />"
                               class="remove-product">
                                Xóa
                            </a>
                        </div>
                    </c:forEach>

                </div>
                <div class="total-money l-4 m-12 c-12">
                    <h1>Thanh Toán</h1>
                    <div class="total-money__price">
                        <p>Tổng: </p>
                        <h3><fmt:formatNumber type="number"
                                              groupingUsed="true"
                                              value="${TotalPrice}"/>đ</h3>
                    </div>
                    <button>Tiến Hành Thanh Toán</button>
                </div>
            </div>
        </div>
    </div>
</div>

</body>