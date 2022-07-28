
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<body>
<div class="base-container">
    <div style="text-align:center">
        <h2 style="font-size: 22px;">
            Thay đổi thông tin
        </h2>
    </div>
    <form action="/thong-tin/change" method="post" class="forgot-password-form">
        <div class="forgot-password-form__container">
            <div>
                <c:if test="${message != null}">
                    <p style="text-align: center; color: var(--red-color)">
                            ${message}
                    </p>
                </c:if>
            </div>
            <div>
                <p>
                    <input type="email" name="email" placeholder="Nhập email mới của bạn"
                           class="forgot-password-form__input">
                </p>
                <p>
                    <input type="text" name="name" placeholder="Nhập tên mới của bạn"
                           class="forgot-password-form__input">
                </p>
                <p style="text-align: center;">
                    <input type="submit" value="Xong" style="background-color: #007bff;
                        border: none; padding: 10px; border-radius: 3px; color: white; cursor: pointer;"/>
                </p>
            </div>
        </div>
    </form>
</div>
</body>

