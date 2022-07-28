<%--
  Created by IntelliJ IDEA.
  User: xuan hieu
  Date: 5/25/2022
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<body>

<div class="base-container">
    <div class="grid wide">
        <div class="singin-form">
            <h1>Đăng Ký Tài Khoản</h1>
            <p class="no-account">Bạn đã có tài khoản? Đăng nhập <a href="/dang-nhap">Tại đây</a></p>
            <div class="singin-form-wrap">
                <h1>Thông Tin Cá Nhân</h1>
                <h1 style="font-size: 15px; color: var(--red-color); margin-top: 13px">${message_create_account}</h1>
                <form:form method="post" action="/create-account" modelAttribute="user" style="width: 600px">
                    <div class="singin-form__infor">
                        <div class="form-infor-wrap">
                            <p>Họ Và Tên <span class="required">*</span></p>
                            <form:input type="text" placeholder="Họ và tên" path="display_name"/>
                        </div>
                        <div class="form-infor-wrap">
                            <p>Email <span class="required">*</span></p>
                            <form:input type="email" placeholder="Email" path="email"/>
                        </div>
                        <div class="form-infor-wrap">
                            <p>Mật Khẩu <span class="required">*</span></p>
                            <form:input type="password" placeholder="Mật khẩu" path="password"/>
                        </div>
                    </div>
                    <button type="submit" class = "btn" style="margin-top: 10px">Đăng Ký</button>
                </form:form>

            </div>
        </div>
    </div>
</div>

</body>
