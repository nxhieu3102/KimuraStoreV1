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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<body>
<div class="product-container">
    <div class="grid wide">
        <div class="single-product">
            <div class="row">
                <div class="col l-5 m-12 c-12">
                    <div class="image-container">
                        <img src="<c:url value ="/assets/user/img/product/${product.image}" />" width="auto" height="100%" style="padding: 5px 0;">
                    </div>


                </div>
                <div class="col l-7 m-12 c-12">
                    <h1>${product.name}</h1>
                    <h4>190.000đ - 230.000đ</h4>
                    <div class="field-list">
                        <div class="field-list__item">
                            <p>Lựa chọn:</p>
                            <div class="field-item__options">
                                <c:forEach var="item" items="${productOptions}">
                                    <button> ${item.name}</button>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <p>Số lượng: </p>
                    <div class="quantity-wrap">
                        <button class="change-quantity quantity-btn--decrease">-</button>
                        <input type="number" min="0" value="1" class="quantity-number">
                        <button class="change-quantity quantity-btn--increase">+</button>
                    </div>

                    <button class="btn product-btn">Thêm vào giỏ hàng</button>
                </div>
            </div>
        </div>

        <div class="row">

            <div class="col l-9 m-12 c-12">
                <div class="product-description">
                    <h1>Mô tả sản phẩm</h1>
                    <p>
                        🇯🇵Keo dán mi giả D-UP 552 Clear Type🇯🇵<br>
                        .<br>
                        🥇Keo dán mi giả D.UP chất lượng vượt trội, vươn lên hẳn vị trí số 1 tạp chí Cosme luôn nhé,
                        được rất nhiều Makeup Artist chuyên nghiệp nổi tiếng thế giới tin dùng ✌<br>
                        .<br>
                        ✔️Chất keo được làm bằng chất kết dính y tế an toàn với da mắt, cho cảm giác nhẹ nhàng trên
                        mi mắt 🌼<br>
                        .<br>
                        ✔️Cường độ bám dính của keo siêu chặt, giữ vững trên mi mắt. Hãng đảm bảo dùng tay kéo cũng
                        không ra được đâu ạ. .<br>
                        ✔️ Màu keo trong suốt, cho hiệu ứng tự nhiên.<br>
                        .<br>
                        ✔️ Có khả năng chống nước, chống mồ hôi, chống bã nhờn, dễ dàng dính mí trong lần dán đầu
                        tiên.<br>
                        .<br>
                        📌Chai 5ml.<br>
                        . ➖➖➖➖➖<br>
                        .<br>
                        📞Call/viber/zalo: 0914 837 823.<br>
                        .<br>
                        💯Cam kết hàng chính hãng 100%, luôn luôn có bills mua tại các store uy tín ở Tokyo 🇯🇵<br>
                        .<br>
                        ➖➖➖➖➖<br>
                    </p>
                </div>
            </div>
            <div class="col l-3 m-12 c-12">
                <div class="hot-product-wrap">
                    <h1>Có thể bạn quan tâm</h1>
                    <ul class="hot-product-list">
                        <c:forEach var="item" items="${productRelated}" varStatus="loop">
                            <li>
                                <a href="" class="hot-product-item">
                                    <img src="<c:url value="/assets/user/img/product/${productRelated.get(loop.index).image}" />" alt="">
                                    <div class="hot-product-item-body">
                                        <h3>${productRelated.get(loop.index).name}</h3>
                                        <p><fmt:formatNumber type="number"
                                                             groupingUsed="true"
                                                             value="${productRelated.get(loop.index).price}"/>đ</p>
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
