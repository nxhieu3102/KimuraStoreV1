<%--
  Created by IntelliJ IDEA.
  User: xuan hieu
  Date: 4/24/2022
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<header id="header">
    <div class="grid wide header-wrap">
        <div class="header__mobile-icon">
            <label for="category__mobile-input" class="category-icon--mobile">
                <i class="fas fa-bars category__bar-icon--mobile"></i>
            </label>
            <label for="mobile-search-checkbox" class="header__mobile-search">
                <i class="header__mobile-search-icon fas fa-search"></i>
            </label>
        </div>

        <input type="checkbox" hidden id="mobile-search-checkbox" class="header__search-checkbox" />
        <input type="checkbox" hidden name="" class="category__input" id="category__mobile-input" />

        <div class="category__mobile">
            <div class="category__mobile-wrap">
                <div class="category__mobile-header">
                    <a href="./signin.html" class="category__mobile-title">Đăng Nhập</a>
                    <label for="category__mobile-input" class="category__mobile-close">
                        <i class="fas fa-times"></i>
                    </label>
                </div>
                <div class="category__mobile-header">
                    <a href="./singup.html" class="category__mobile-title">Đăng Kí</a>
                </div>
                <div class="category__mobile-header">
                    <a href="/" class="category__mobile-title">Trang chủ</a>
                </div>
                <div class="category__mobile-header">
                    <a href="./allProduct.html" class="category__mobile-title">Tất cả sản phẩm</a>
                </div>
                <div class="category__mobile-header category__mobile-click">
                    <span class="category__mobile-title">Danh mục</span>
                    <span class="category__mobile-icon-down"><i class="fas fa-chevron-down"></i></span>
                    <ul class="category__bar--mobile">
                        <li class="category__bar-item--mobile">
                            <a href="" class="category__bar-item--mobile-link">Trang điểm</a>
                        </li>
                        <li class="category__bar-item--mobile">
                            <a href="" class="category__bar-item--mobile-link">Nước cân bằng da</a>
                        </li>
                        <li class="category__bar-item--mobile">
                            <a href="" class="category__bar-item--mobile-link">Giảm cân và chăm sóc sức khỏe</a>
                        </li>
                        <li class="category__bar-item--mobile">
                            <a href="" class="category__bar-item--mobile-link">Mặt nạ</a>
                        </li>
                        <li class="category__bar-item--mobile">
                            <a href="" class="category__bar-item--mobile-link">Tắm & chăm sóc cơ thể</a>
                        </li>
                        <li class="category__bar-item--mobile">
                            <a href="" class="category__bar-item--mobile-link">Dụng cụ làm đẹp</a>
                        </li>
                        <li class="category__bar-item--mobile">
                            <a href="" class="category__bar-item--mobile-link">Tinh chất dưỡng</a>
                        </li>
                        <li class="category__bar-item--mobile">
                            <a href="" class="category__bar-item--mobile-link">Kem dưỡng ẩm</a>
                        </li>
                        <li class="category__bar-item--mobile">
                            <a href="" class="category__bar-item--mobile-link">Sản phẩm dưỡng mắt</a>
                        </li>
                        <li class="category__bar-item--mobile">
                            <a href="" class="category__bar-item--mobile-link">Sửa rửa mặt</a>
                        </li>
                        <li class="category__bar-item--mobile">
                            <a href="" class="category__bar-item--mobile-link">Nhà cửa và đời sống: đồ dùng cá nhân
                                & gia đình
                            </a>
                        </li>
                        <li class="category__bar-item--mobile">
                            <a href="" class="category__bar-item--mobile-link">Kem chống nắng</a>
                        </li>
                        <li class="category__bar-item--mobile">
                            <a href="" class="category__bar-item--mobile-link">Đồ ăn</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="category__overlay">
            <label for="category__mobile-input"> </label>
        </div>

        <div class="header__logo">
            <div class="header__logo-icon">
                <a href="/">
                    <img src="<c:url value = "/assets/user/img/LOGO.png" />" alt="" class="header__logo-img" />
                </a>
            </div>
        </div>

        <div class="header__search">
            <div class="header__search-input">
                <input type="text" class="header__search-input-box" placeholder="Tìm kiếm sản phẩm" />
            </div>
            <div class="header__search-button">
                <button class="header__search-button-item">
                    <i class="fas fa-search header__search-button-icon"></i>
                </button>
            </div>
        </div>

        <div class="header__icon">
            <div class="header__icon-item hide-on-mobile hide-on-tablet">
                <i class="far fa-user"></i>
                <div class="header__icon-text">
                    <a href="./singup.html" class="header__icon-text-item">Đăng Kí</a>
                    <a href="./signin.html" class="header__icon-text-item">Đăng Nhập</a>
                </div>
            </div>
            <div class="header__icon-item hide-on-mobile hide-on-tablet">
                <i class="fas fa-headphones-alt"></i>
                <div class="header__icon-text">
                    <p class="header__icon-text-item" style="font-weight: 600">
                        Hỗ trợ khách hàng
                    </p>
                    <p class="header__icon-text-item">0983796289</p>
                </div>
            </div>
            <div class="header__icon-item header__cart">
                <i class="las la-shopping-cart"></i>
                <span class="header__icon-cart-quantity">3</span>
                <div class="header__cart-list">
                    <div class="header__cart-list--empty">
                        <img src="<c:url value = "/assets/user/img/no__cart.jpg" />" alt="" class="header__cart-no-cart-img" />
                        <span class="header__cart-list-no-cart-msg">
                                Chưa có sản phẩm
                            </span>
                    </div>
                    <div class="header__cart-list--not-empty">
                        <h4 class="header__cart-heading">Sản phẩm đã thêm</h4>
                        <ul class="header__cart-list-item">
                            <!-- cart item -->
                            <li class="header__cart-item">
                                <img src="<c:url value = "/assets/user/img/item.jpg" />" alt="" class="header__cart-img" />
                                <div class="header__cart-item-info">
                                    <div class="header__cart-item-head">
                                        <h5 class="header__cart-item-name">
                                            Bộ kem đặc trị vùng mắt
                                        </h5>
                                        <div class="header__cart-item-price-wrap">
                                            <span class="header__cart-item-price">2.000.000đ</span>
                                            <span class="header__cart-item-multiply">x</span>
                                            <span class="header__cart-item-qnt">2</span>
                                        </div>
                                    </div>
                                    <div class="header__cart-item-body">
                                            <span class="header__cart-item-description">
                                                Phân loại: Bạc
                                            </span>
                                        <span class="header__cart-item-remove">Xóa</span>
                                    </div>
                                </div>
                            </li>
                            <li class="header__cart-item">
                                <img src="<c:url value = "/assets/user/img/item.jpg" />"alt="" class="header__cart-img" />
                                <div class="header__cart-item-info">
                                    <div class="header__cart-item-head">
                                        <h5 class="header__cart-item-name">
                                            Bộ kem đặc trị vùng mắt
                                        </h5>
                                        <div class="header__cart-item-price-wrap">
                                            <span class="header__cart-item-price">2.000.000đ</span>
                                            <span class="header__cart-item-multiply">x</span>
                                            <span class="header__cart-item-qnt">2</span>
                                        </div>
                                    </div>
                                    <div class="header__cart-item-body">
                                            <span class="header__cart-item-description">
                                                Phân loại: Bạc
                                            </span>
                                        <span class="header__cart-item-remove">Xóa</span>
                                    </div>
                                </div>
                            </li>
                            <li class="header__cart-item">
                                <img src="<c:url value = "/assets/user/img/item.jpg" />" alt="" class="header__cart-img" />
                                <div class="header__cart-item-info">
                                    <div class="header__cart-item-head">
                                        <h5 class="header__cart-item-name">
                                            Bộ kem đặc trị vùng mắt
                                        </h5>
                                        <div class="header__cart-item-price-wrap">
                                            <span class="header__cart-item-price">2.000.000đ</span>
                                            <span class="header__cart-item-multiply">x</span>
                                            <span class="header__cart-item-qnt">2</span>
                                        </div>
                                    </div>
                                    <div class="header__cart-item-body">
                                            <span class="header__cart-item-description">
                                                Phân loại: Bạc
                                            </span>
                                        <span class="header__cart-item-remove">Xóa</span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                        <a href="./cart.html" class="header__cart-view-cart btn"> Xem Giỏ Hàng </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

<div class="contact">
    <div class="contact__icon">
        <i class="fas fa-plus"></i>
    </div>
    <div class="contact__list">
        <a target="_blank" href="https://zalo.me/0914837823" class="contact__list-item">
            <img src="<c:url value = "/assets/user/img/contact/zalo.png" />" alt="" class="contact__item-img" title="zalo" />
        </a>
        <a target="_blank" href="https://www.facebook.com/Kimura.saigon.tokyo/" class="contact__list-item">
            <img src="<c:url value = "/assets/user/img/contact/faacebook.png" />" alt="" class="contact__item-img" title="facebook" />
        </a>
        <a target="_blank" href="https://shopee.vn/kimura1404" class="contact__list-item" title="shopee">
            <img src="<c:url value = "/assets/user/img/contact/shopee.png" />" alt="" class="contact__item-img" />
        </a>
        <a target="_blank" href="https://www.instagram.com/kimura.store/" class="contact__list-item"
           title="instagram">
            <img src="<c:url value = "/assets/user/img/contact/instagram.png" />" alt="" class="contact__item-img" />
        </a>
    </div>
</div>
