<%--
  Created by IntelliJ IDEA.
  User: xuan hieu
  Date: 6/29/2022
  Time: 7:39 PM
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

<div class="base-container">
    <div style="text-align:center">
        <h2 style="font-size: 22px;">
            Quên mật khẩu
        </h2>
    </div>

    <form action="/forgot-password" method="post" class="forgot-password-form">
        <div class="forgot-password-form__container">
            <div>
                <p style="text-align: center;">
                    <c:if test="${message == null}">
                        Mã khôi phục sẽ được gửi qua email này.
                    </c:if>
                    <c:if test="${message != null}">
                        ${message}
                    </c:if>
                </p>
            </div>
            <div>
                <p>
                    <input type="email" name="email" id="email" placeholder="Nhập email của bạn"
                           class="forgot-password-form__input" required></input>
                </p>
                <p style="text-align: center;">
                    <input type="submit" value="Send" style="background-color: #007bff;
                        border: none; padding: 10px; border-radius: 3px; color: white; cursor: pointer;"/>
                </p>
            </div>
        </div>
    </form>


</div>
</body>

