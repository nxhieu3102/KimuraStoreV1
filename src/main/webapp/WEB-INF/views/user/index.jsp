<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
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
                    <a href="./allProduct.html" class="category__header-link">Danh mục sản phẩm</a>
                </li>
                <li class="category-bar__item">
                    <a href="./allProduct.html" class="category-bar__item-link">Trang điểm</a>
                </li>
                <li class="category-bar__item">
                    <a href="./allProduct.html" class="category-bar__item-link">Nước cân bằng da</a>
                </li>
                <li class="category-bar__item">
                    <a href="./allProduct.html" class="category-bar__item-link">Giảm cân và chăm sóc sức khỏe</a>
                </li>
                <li class="category-bar__item">
                    <a href="./allProduct.html" class="category-bar__item-link">Mặt nạ</a>
                </li>
                <li class="category-bar__item">
                    <a href="./allProduct.html" class="category-bar__item-link">Tắm & chăm sóc cơ thể</a>
                </li>
                <li class="category-bar__item">
                    <a href="./allProduct.html" class="category-bar__item-link">Dụng cụ làm đẹp</a>
                </li>
                <li class="category-bar__item">
                    <a href="./allProduct.html" class="category-bar__item-link">Tinh chất dưỡng</a>
                </li>
                <li class="category-bar__item">
                    <a href="./allProduct.html" class="category-bar__item-link">Kem dưỡng ẩm</a>
                </li>
                <li class="category-bar__item">
                    <a href="./allProduct.html" class="category-bar__item-link">Sản phẩm dưỡng mắt</a>
                </li>
                <li class="category-bar__item">
                    <a href="./allProduct.html" class="category-bar__item-link">Sửa rửa mặt</a>
                </li>
                <li class="category-bar__item">
                    <a href="./allProduct.html" class="category-bar__item-link">Nhà cửa và đời sống: đồ dùng cá nhân & gia đình
                    </a>
                </li>
                <li class="category-bar__item">
                    <a href="./allProduct.html" class="category-bar__item-link">Kem chống nắng</a>
                </li>
                <li class="category-bar__item">
                    <a href="./allProduct.html" class="category-bar__item-link">Đồ ăn</a>
                </li>
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
                <div class="col l-2-4 m-4 c-6 best-seller__item">
                    <a href="./product.html" class="product-event__item">
                        <div class="product-event__item-img"
                             style="background-image: url(<c:url value = "/assets/user/img/product/item11.jfif"/>)"></div>
                        <h4 class="product-event__item-name">
                            SON CEZANNE LASTING GLOSS LIP nội địa Nhật Bản
                        </h4>
                        <div class="product-event__item-price">190.000đ - 230.000đ</div>
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
                <div class="col l-2-4 m-4 c-6 best-seller__item">
                    <a href="./product.html" class="product-event__item">
                        <div class="product-event__item-img"
                             style="background-image: url(<c:url value = "/assets/user/img/product/item1.jpg"/>)"></div>
                        <h4 class="product-event__item-name">
                            [Restock bao bì mới 2021] [thêm vị Trà sữa hoàng gia] BỘT GIẢM
                            CÂN ASAHI SLIM UP SLIM SUPERFOOD SHAKE NỘI ĐỊA NHẬT BẢN
                        </h4>
                        <div class="product-event__item-price">560.000đ</div>
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
                <div class="col l-2-4 m-4 c-6 best-seller__item">
                    <a href="./product.html" class="product-event__item">
                        <div class="product-event__item-img"
                             style="background-image: url(<c:url value = "/assets/user/img/product/item2.jpg" />)"></div>
                        <h4 class="product-event__item-name">
                            Xịt khoáng dưỡng da, kháng khuẩn, bụi mịn PM 2. 5 Earth Kafun
                            Guard Spray nội địa Nhật Bản Top 1 Cosme
                        </h4>
                        <div class="product-event__item-price">350.000đ</div>
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
                <div class="col l-2-4 m-4 c-6 best-seller__item">
                    <a href="./product.html" class="product-event__item">
                        <div class="product-event__item-img"
                             style="background-image: url(<c:url value = "/assets/user/img/product/item3.jpg"/>)"></div>
                        <h4 class="product-event__item-name">
                            Xịt khoáng dưỡng da, kháng khuẩn, bụi mịn PM 2. 5 Earth Kafun
                            Guard Spray nội địa Nhật Bản Top 1 Cosme
                        </h4>
                        <div class="product-event__item-price">280.000đ - 495.000đ</div>
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
                <div class="col l-2-4 m-4 c-6 best-seller__item">
                    <a href="./product.html" class="product-event__item">
                        <div class="product-event__item-img"
                             style="background-image: url(<c:url value = "/assets/user/img/product/item4.jpg"/>)"></div>
                        <h4 class="product-event__item-name">
                            DẦU GỘI/XẢ KRACIE ICHIKAMI NỘI ĐỊA NHẬT BẢN DẠNG TÚI REFILL
                            340ML
                        </h4>
                        <div class="product-event__item-price">205.000đ - 410.000đ</div>
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
                <div class="col l-2-4 m-4 c-6 best-seller__item">
                    <a href="./product.html" class="product-event__item">
                        <div class="product-event__item-img"
                             style="background-image: url(<c:url value = "/assets/user/img/product/item5.jpg"/>)"></div>
                        <h4 class="product-event__item-name">
                            KEO DÁN MI GIẢ D-UP 552 CLEAR TYPE NỘI ĐỊA NHẬT
                        </h4>
                        <div class="product-event__item-price">325.000đ</div>
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
            </div>
        </div>
        <!-- discount -->
        <div class="discount">
            <h1 class="product-event__title">Giảm Giá</h1>
            <div class="row product-event__list">
                <div class="col l-2-4 m-4 c-6">
                    <a href="./product.html" class="product-event__item">
                        <div class="product-event__item-img"
                             style="background-image: url(<c:url value = "/assets/user/img/product/item6.jpg"/>)"></div>
                        <h4 class="product-event__item-name">
                            (Săn Sale-Giá Tốt-Chuẩn bill nội địa) Mặt nạ Mitomo cô gái
                            Geisha nội địa Nhật Bản
                        </h4>
                        <div class="product-event__item-price">
                            <span class="product-event__item-price--old">35.000đ</span>
                            <span class="product-event__item-price--new">25.000đ</span>
                        </div>
                        <div class="product-event__item-add">
                            <button class="product-event__item-btn btn">
                                Thêm vào giỏ hàng
                            </button>
                        </div>
                        <div class="discount__label">
                            <span class="discount__label-percent">29%</span>
                            <span class="discount__label-text"> GIẢM </span>
                        </div>
                    </a>
                </div>
                <div class="col l-2-4 m-4 c-6">
                    <a href="./product.html" class="product-event__item">
                        <div class="product-event__item-img"
                             style="background-image: url(<c:url value = "/assets/user/img/product/item7.jpg"/>)"></div>
                        <h4 class="product-event__item-name">
                            (Loại 24 gói-chuẩn bill nội địa-date xa) TRÀ GIẢM CÂN BAN ĐÊM
                            ORIHIRO NIGHT DIET TEA NHẬT BẢN
                        </h4>
                        <div class="product-event__item-price">
                            <span class="product-event__item-price--old">245.000đ</span>
                            <span class="product-event__item-price--new">195.000đ</span>
                        </div>
                        <div class="product-event__item-add">
                            <button class="product-event__item-btn btn">
                                Thêm vào giỏ hàng
                            </button>
                        </div>
                        <div class="discount__label">
                            <span class="discount__label-percent">20%</span>
                            <span class="discount__label-text"> GIẢM </span>
                        </div>
                    </a>
                </div>
                <div class="col l-2-4 m-4 c-6">
                    <a href="./product.html" class="product-event__item">
                        <div class="product-event__item-img"
                             style="background-image: url(<c:url value = "/assets/user/img/product/item8.jpg"/>)"></div>
                        <h4 class="product-event__item-name">
                            Phấn má dạng thỏi Cezanne Cheek Stick nội địa Nhật Bản(nhắn
                            shop để chọn màu 01, 02 hoặc 03)
                        </h4>
                        <div class="product-event__item-price">
                            <span class="product-event__item-price--old">255.000đ</span>
                            <span class="product-event__item-price--new">155.000đ</span>
                        </div>
                        <div class="product-event__item-add">
                            <button class="product-event__item-btn btn">
                                Thêm vào giỏ hàng
                            </button>
                        </div>
                        <div class="discount__label">
                            <span class="discount__label-percent">39%</span>
                            <span class="discount__label-text"> GIẢM </span>
                        </div>
                    </a>
                </div>
                <div class="col l-2-4 m-4 c-6">
                    <a href="./product.html" class="product-event__item">
                        <div class="product-event__item-img"
                             style="background-image: url(<c:url value = "/assets/user/img/product/item9.jpg"/>)"></div>
                        <h4 class="product-event__item-name">
                            Mặt nạ Botanical Esthe 7 in 1 nội địa Nhật Bản
                        </h4>
                        <div class="product-event__item-price">
                            <span class="product-event__item-price--old">250.000đ</span>
                            <span class="product-event__item-price--new">190.000đ</span>
                        </div>
                        <div class="product-event__item-add">
                            <button class="product-event__item-btn btn">
                                Thêm vào giỏ hàng
                            </button>
                        </div>
                        <div class="discount__label">
                            <span class="discount__label-percent">24%</span>
                            <span class="discount__label-text"> GIẢM </span>
                        </div>
                    </a>
                </div>
                <div class="col l-2-4 m-4 c-6">
                    <a href="./product.html" class="product-event__item">
                        <div class="product-event__item-img" style="
                    background-image: url(<c:url value = "/assets/user/img/product/item10.jpg"/>);
                  "></div>
                        <h4 class="product-event__item-name">
                            Mặt nạ Botanical Esthe 7 in 1 nội địa Nhật Bản
                        </h4>
                        <div class="product-event__item-price">
                            <span class="product-event__item-price--old">200.000đ</span>
                            <span class="product-event__item-price--new">195.000đ</span>
                        </div>
                        <div class="product-event__item-add">
                            <button class="product-event__item-btn btn">
                                Thêm vào giỏ hàng
                            </button>
                        </div>
                        <div class="discount__label">
                            <span class="discount__label-percent">3%</span>
                            <span class="discount__label-text"> GIẢM </span>
                        </div>
                    </a>
                </div>
                <div class="col l-2-4 m-4 c-6">
                    <a href="./product.html" class="product-event__item">
                        <div class="product-event__item-img" style="
                    background-image: url(<c:url value = "/assets/user/img/product/item10.jpg"/>);
                  "></div>
                        <h4 class="product-event__item-name">
                            Mặt nạ Botanical Esthe 7 in 1 nội địa Nhật Bản
                        </h4>
                        <div class="product-event__item-price">
                            <span class="product-event__item-price--old">200.000đ</span>
                            <span class="product-event__item-price--new">195.000đ</span>
                        </div>
                        <div class="product-event__item-add">
                            <button class="product-event__item-btn btn">
                                Thêm vào giỏ hàng
                            </button>
                        </div>
                        <div class="discount__label">
                            <span class="discount__label-percent">3%</span>
                            <span class="discount__label-text"> GIẢM </span>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>


</body>