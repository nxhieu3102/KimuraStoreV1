<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="javax.servlet.http.HttpSession" %>

<body>
<div class="base-container">
    <div class="grid wide">
        <c:if test="${cartItem == null or cartItem.size() == 0}">
            <div class="non-product">
                <c:if test="${messageCheckout == null}">
                    <p>(Chưa có sản phẩm nào) nhấn vào <a href="/the-loai-san-pham/0">cửa hàng</a> để mua hàng</p>
                </c:if>
                <c:if test="${messageCheckout != null}">
                    <p style="font-size: 16px;">${messageCheckout}</p>
                    <% session.removeAttribute("messageCheckout"); %>
                </c:if>
            </div>
        </c:if>
        <c:if test="${cartItem != null and cartItem.size() != 0}">
            <div class="payment">
                <div class="row">
                    <div class="cart-list l-8 m-12 c-12">
                        <h1>Giỏ Hàng</h1>
                        <c:forEach items="${cartItem}" var="item">
                            <div class="cart-list__item">
                                <div class="img_wrap">
                                    <img src="<c:url value = "/assets/user/img/product/${item.image}" />"
                                         alt="" class="item_img">
                                </div>
                                <div class="item-img-des-wrap">
                                    <p>${item.name}</p>
                                    <div class="quantity-wrap">
                                        <button class="change-quantity quantity-list-btn--decrease"
                                                data-id="${item.productId}">-
                                        </button>
                                        <input type="number" min="0" value="${item.quantity}" class="quantity-number"
                                               id="quantity-cart-${item.productId}">
                                        <button class="change-quantity quantity-list-btn--increase"
                                                data-id="${item.productId}">+
                                        </button>
                                    </div>
                                    <p><fmt:formatNumber type="number"
                                                         groupingUsed="true"
                                                         value="${item.totalPrice}"/>đ</p>
                                </div>
                                <a href="<c:url value = "/DeleteCart/${item.productId}" />"
                                   class="remove-product">
                                    Xóa
                                </a>
                            </div>
                        </c:forEach>

                    </div>
                    <div class="checkout-infor l-4 m-12 c-12">
                        <h1>Thông tin thanh toán</h1>
                        <form:form action="/xem-gio-hang" modelAttribute="BillInfo" method="post" id="form-checkout">
                            <p class="input-header">Họ và tên <span style="color:red">*</span></p>
                            <form:input path="name" class="checkout-infor__input" type="text"
                                        placeholder="Nhập họ và tên"
                                        required="true"
                                        oninvalid="this.setCustomValidity('Bạn chưa nhập họ và tên')"></form:input>
                            <p class="input-header">Số điện thoại <span style="color:red">*</span></p>
                            <form:input path="phone" class="checkout-infor__input" type="tel"
                                        placeholder="Nhập số điện thoại"
                                        required="true"
                                        oninvalid="this.setCustomValidity('Bạn chưa nhập số điện thoại')"></form:input>
                            <div class="select-address">
                                <p class="input-header">Tỉnh/Thành phố <span style="color:red">*</span></p>
                                <select id="province" class="select-address-form" name="province" required>
                                    <option disabled selected>Chọn tỉnh/thành phố</option>
                                    <c:forEach var="item" items="${province}">
                                        <option value="${item.getId()}">${item.getName()}</option>
                                    </c:forEach>
                                </select>

                                <p class="input-header">Quận/Huyện <span style="color:red">*</span></p>
                                <select id="district" class="select-address-form" name="district" required>
                                </select>

                                <p class="input-header">Xã/Phường/Thị trấn <span style="color:red">*</span></p>
                                <select id="ward" class="select-address-form" name="ward" required>
                                </select>
                            </div>
                            <p class="input-header">Địa chỉ <span style="color:red">*</span></p>
                            <form:input path="address" class="checkout-infor__input" type="text"
                                        placeholder="Nhập địa chỉ"
                                        required="true"
                                        oninvalid="this.setCustomValidity('Bạn chưa nhập địa chỉ')"></form:input>
                        </form:form>
                        <div class="total-money__price">
                            <p>Tổng: </p>
                            <h3><fmt:formatNumber type="number"
                                                  groupingUsed="true"
                                                  value="${TotalPrice}"/>đ</h3>
                        </div>
                        <button form="form-checkout" type="submit">Thanh Toán</button>
                    </div>
                </div>
            </div>
        </c:if>
    </div>
</div>
</body>

<content tag="local_script">
    <script type="text/javascript" src="<c:url value = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js" />"  ></script>
    <script type="text/javascript">
        $(document).ready(function() {
            <%--$.ajax({--%>
            <%--    type: 'GET',--%>
            <%--    url: '${pageContext.servletContext.contextPath}/load-district/' + 1,--%>
            <%--})--%>
            $("#province").change(function (){
                const districtId = $(this).val();
                console.log(districtId);
                $('#ward > option').remove()
                $.ajax({
                    type: 'GET',
                    url: '${pageContext.servletContext.contextPath}/load-district/' + districtId,
                    success: function (res) {
                        console.log(res)
                        const result = JSON.parse(res)
                        console.log(result)
                        let s = ""
                        for(let i = 0 ; i < result.length ; i++) {
                            s += '<option value = ' + result[i].id + '>' + result[i].name + '</option>'
                        }
                        $('#district').html(s)
                    }
                })
            })
            $("#district").change(function () {
                const wardId = $(this).val();
                $.ajax({
                    type: 'GET',
                    url: '${pageContext.servletContext.contextPath}/load-ward/' + wardId,
                    success: function (res) {
                        console.log(res)
                        const result = JSON.parse(res)
                        console.log(result)
                        let s = ""
                        for(let i = 0 ; i < result.length ; i++) {
                            s += '<option value = ' + result[i].id + '>' + result[i].name + '</option>'
                        }
                        $('#ward').html(s)
                    }
                })
            })
        })
    </script>
</content>



