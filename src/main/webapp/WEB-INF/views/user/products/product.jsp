<%--
  Created by IntelliJ IDEA.
  User: xuan hieu
  Date: 5/2/2022
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>
<div class="product-container">
    <div class="grid wide">
        <div class="single-product">
            <div class="row">
                <div class="col l-5 m-12 c-12">
                    <div class="image-container">
                        <img src="<c:url value ="/assets/user/img/product/${product.image}" />" width="auto"
                             height="100%" style="padding: 5px 0;">
                    </div>


                </div>
                <div class="col l-7 m-12 c-12">
                    <h1>${product.name}</h1>
                    <h4>
                        <c:if test="${product.getPrice() != product.getPrice_max()}">
                            <span class="product-event__item-price--old"> <fmt:formatNumber type="number"
                                                                                            groupingUsed="true"
                                                                                            value="${product.getPrice_max()}"/>đ </span>
                            <fmt:formatNumber type="number"
                                              groupingUsed="true"
                                              value="${product.getPrice()}"/>đ
                        </c:if>
                        <c:if test="${product.getPrice() == product.getPrice_max()}">
                            <fmt:formatNumber type="number"
                                              groupingUsed="true"
                                              value="${product.getPrice()}"/>đ
                        </c:if>
                    </h4>

                    <p>Số lượng: </p>
                    <div class="quantity-wrap">
                        <button class="change-quantity quantity-btn--decrease">-</button>
                        <input type="number" min="0" value="1" class="quantity-number">
                        <button class="change-quantity quantity-btn--increase">+</button>
                    </div>
                    <button class="btn product-btn add-to-cart-btn" type="submit" data-id="${product.id}">Thêm vào giỏ
                        hàng
                    </button>
                </div>
            </div>
        </div>

        <div class="row">

            <div class="col l-9 m-12 c-12">
                <div class="product-description">
                    <h1>Mô tả sản phẩm</h1>
                    <pre>
                        ${product.detail}
                    </pre>
                </div>
            </div>
            <div class="col l-3 m-12 c-12">
                <div class="hot-product-wrap">
                    <h1>Có thể bạn quan tâm</h1>
                    <ul class="hot-product-list">
                        <c:forEach var="item" items="${productRelated}" varStatus="loop">
                            <li>
                                <a href="/chi-tiet-san-pham/${productRelated.get(loop.index).id }"
                                   class="hot-product-item">
                                    <img src="<c:url value="/assets/user/img/product/${productRelated.get(loop.index).image}" />"
                                         alt="">
                                    <div class="hot-product-item-body">
                                        <h3>${productRelated.get(loop.index).name}</h3>

                                        <p>
                                            <fmt:formatNumber type="number"
                                                              groupingUsed="true"
                                                              value="${item.getPrice()}"/>đ
                                        </p>
                                    </div>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>


