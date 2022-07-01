<%--
  Created by IntelliJ IDEA.
  User: xuan hieu
  Date: 5/25/2022
  Time: 10:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<body>

<div class="signin-container">
    <div class="grid wide">
        <div class="singin-form">
            <h1>Đăng Nhập Tài Khoản</h1>
            <p class="no-account">Bạn chưa có tài khoản? Đăng kí <a href="/dang-ky">Tại đây</a></p>
            <form:form method="post" action="/login-account" modelAttribute="user">
                <div class="singin-form-wrap">
                    <div class="singin-form__infor">
                        <div class="form-infor-wrap">
                            <p>Email <span class="required">*</span></p>
                            <form:input type="email" placeholder="Email" path="email"/>
                        </div>
                        <div class="form-infor-wrap">
                            <p>Mật Khẩu <span class="required">*</span></p>
                            <form:input type="password" placeholder="Mật khẩu" path="password"/>
                        </div>
                    </div>
                    <p class="forget-password">Quên mật khẩu? Nhấn vào <a href="/forgot-password">đây</a></p>
                    <h1 style="font-size: 14px; color: var(--red-color); margin-top: 10px;">${messsage_login_account}</h1>
                    <button class="btn" type="submit">Đăng Nhập</button>
                </div>
            </form:form>

        </div>
    </div>
</div>

</body>
