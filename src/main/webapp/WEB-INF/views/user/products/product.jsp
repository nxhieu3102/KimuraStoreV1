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
                        <img src="<c:url value ="/assets/user/img/product/${product.image}" />" height="100%" width="auto">
                    </div>

                    <div class="small-img-row">
                        <div class="small-img-col">
                            <img src="./assests/img/product detail/item1.jfif">
                        </div>
                        <div class="small-img-col">
                            <img src="./assests/img/product detail/item2.jfif">
                        </div>
                        <div class="small-img-col">
                            <img src="./assests/img/product detail/item3.jfif">
                        </div>
                        <div class="small-img-col">
                            <img src="./assests/img/product detail/item4.jfif">
                        </div>
                        <div class="small-img-col">
                            <img src="./assests/img/product detail/item5.jfif">
                        </div>
                        <div class="small-img-col">
                            <img src="./assests/img/product detail/item6.jfif">
                        </div>
                    </div>
                </div>
                <div class="col l-7 m-12 c-12">
                    <h1>SON CEZANNE LASTING GLOSS LIP nội địa Nhật Bản</h1>
                    <p>Tình trạng: <span>Còn hàng</span></p>
                    <h4>190.000đ - 230.000đ</h4>
                    <div class="field-list">
                        <div class="field-list__item">
                            <p>Màu:</p>
                            <div class="field-item__options">
                                <button>101- </button>
                                <button>101-Đỏ cam nâu đất</button>
                                <button>101-Đỏ cam nâu đất</button>
                                <button>101-Đỏ cam nâu đất</button>
                                <button>101-Đỏ cam nâu đất</button>
                                <button>101-Đỏ cam nâu đất</button>
                                <button>101-Đỏ cam nâu đất</button>
                                <button>101-Đỏ cam nâu đất</button>
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
                        <li>
                            <a href="" class="hot-product-item">
                                <img src="./assests/img/product/item1.jpg" alt="">
                                <div class="hot-product-item-body">
                                    <h3>KEO DÁN MI GIẢ D-UP 552 CLEAR TYPE NỘI ĐỊA NHẬT</h3>
                                    <p>325.000đ</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="" class="hot-product-item">
                                <img src="./assests/img/product/item1.jpg" alt="">
                                <div class="hot-product-item-body">
                                    <h3>KEO DÁN MI GIẢ D-UP 552 CLEAR TYPE NỘI ĐỊA NHẬT</h3>
                                    <p>325.000đ</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="" class="hot-product-item">
                                <img src="./assests/img/product/item1.jpg" alt="">
                                <div class="hot-product-item-body">
                                    <h3>KEO DÁN MI GIẢ D-UP 552 CLEAR TYPE NỘI ĐỊA NHẬT</h3>
                                    <p>325.000đ</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="" class="hot-product-item">
                                <img src="./assests/img/product/item1.jpg" alt="">
                                <div class="hot-product-item-body">
                                    <h3>KEO DÁN MI GIẢ D-UP 552 CLEAR TYPE NỘI ĐỊA NHẬT</h3>
                                    <p>325.000đ</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="" class="hot-product-item">
                                <img src="./assests/img/product/item1.jpg" alt="">
                                <div class="hot-product-item-body">
                                    <h3>KEO DÁN MI GIẢ D-UP 552 CLEAR TYPE NỘI ĐỊA NHẬT</h3>
                                    <p>325.000đ</p>
                                </div>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
