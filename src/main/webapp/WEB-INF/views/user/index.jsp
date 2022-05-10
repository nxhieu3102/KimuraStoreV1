<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<body>


<div class="app-container">
    <div class="grid wide">
        <!-- intro bar -->
        <div class="row intro-bar">
            <div class="col l-3 m-3 c-3">
                <div class="intro-bar__item">
                    <img src="<c:url value = "/assets/user/img/headerbar/japan.png" />" alt="" class="intro-bar__img" />
                    <span class="intro-bar__title">Hàng Nhật Nội Địa Chuẩn 100%</span>
                </div>
            </div>
            <div class="col l-3 m-3 c-3">
                <div class="intro-bar__item">
                    <img src="<c:url value = "/assets/user/img/headerbar/100.png" />"alt="" class="intro-bar__img" />
                    <span class="intro-bar__title">Uy Tín Hàng Đầu</span>
                </div>
            </div>
            <div class="col l-3 m-3 c-3">
                <div class="intro-bar__item">
                    <img src="<c:url value = "/assets/user/img/headerbar/quality.png"/>" alt="" class="intro-bar__img" />
                    <span class="intro-bar__title">Chất Lượng Đảm Bảo</span>
                </div>
            </div>
            <div class="col l-3 m-3 c-3">
                <div class="intro-bar__item">
                    <img src="<c:url value = "/assets/user/img/headerbar/delivery.png"/>" alt="" class="intro-bar__img" />
                    <span class="intro-bar__title">Giao Hàng Nhanh Toàn Quốc</span>
                </div>
            </div>
        </div>

        <div class="intro-part">
            <ul class="category-bar hide-on-mobile hide-on-tablet">
                <li class = "category__header">
                    <a href="/the-loai-san-pham/0" class="category__header-link">Danh mục sản phẩm</a>
                </li>
                <c:forEach var="item" items="${category}">
                    <li class="category-bar__item">
                        <a href="/the-loai-san-pham/${item.id}" class="category-bar__item-link">${item.name}</a>
                    </li>
                </c:forEach>

            </ul>
            <div class="intro-image">
                <c:forEach var = "item" items="${slides}">
                    <img src="<c:url value = "/assets/user/img/intro/${item.image}" />" alt="" class="intro-image__item" loading="eager"/>
                </c:forEach>
            </div>
        </div>
        <!-- best seller -->
        <div class="best-seller">
            <h1 class="product-event__title">Bán Chạy</h1>
            <div class="row product-event__list">
                <c:forEach var="item" items="${bestSellerProduct}">
                    <div class="col l-2-4 m-4 c-6 best-seller__item">
                        <a href="/chi-tiet-san-pham/${item.id}" class="product-event__item">
                            <div class="product-event__item-img"
                                 style="background-image: url(<c:url value = "/assets/user/img/product/${item.image}"/>)"></div>
                            <h4 class="product-event__item-name">
                                ${item.name}
                            </h4>
                            <div class="product-event__item-price">
                                <c:choose>
                                    <c:when test="${item.price_min != item.price_max}">
                                        <fmt:formatNumber type="number"
                                                          groupingUsed="true"
                                                          value="${item.price_min}"/>đ -
                                        <fmt:formatNumber type="number"
                                                          groupingUsed="true"
                                                          value="${item.price_max}"/>
                                    </c:when>
                                    <c:otherwise>
                                        <fmt:formatNumber type="number"
                                                          groupingUsed="true"
                                                          value="${item.price}"/>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="product-event__item-add">
                                <button class="product-event__item-btn btn">
                                    Thêm vào giỏ hàng
                                </button>
                            </div>
                            <div class="best-seller__label">
                                <i class="fas fa-check"></i>
                                <span>Best Seller</span>
                            </div>
                        </a>
                    </div>
                </c:forEach>

            </div>
        </div>
        <!-- discount -->
        <div class="discount">
            <h1 class="product-event__title">Giảm Giá</h1>
            <div class="row product-event__list">
                <c:forEach var="item" items="${discountProduct}">
                    <div class="col l-2-4 m-4 c-6">
                        <a href="/chi-tiet-san-pham/${item.id}" class="product-event__item">
                            <div class="product-event__item-img"
                                 style="background-image: url(<c:url value = "/assets/user/img/product/${item.image}"/>)"></div>
                            <h4 class="product-event__item-name">
                                ${item.name}
                            </h4>
                            <div class="product-event__item-price">
                                <span class="product-event__item-price--old"><fmt:formatNumber type="number"
                                                                                               groupingUsed="true"
                                                                                               value="${item.price}"/>đ</span>
                                <span class="product-event__item-price--new"><fmt:formatNumber type="number"
                                                                                               groupingUsed="true"
                                                                                               value="${item.price - item.discount_money}"/>đ</span>
                            </div>
                            <div class="product-event__item-add">
                                <button class="product-event__item-btn btn">
                                    Thêm vào giỏ hàng
                                </button>
                            </div>
                            <div class="discount__label">
                                <span class="discount__label-percent">${item.discount_rate}%</span>
                                <span class="discount__label-text"> GIẢM </span>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>


</body>