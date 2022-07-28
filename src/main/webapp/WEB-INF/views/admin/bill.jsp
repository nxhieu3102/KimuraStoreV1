<%--
  Created by IntelliJ IDEA.
  User: xuan hieu
  Date: 7/25/2022
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<body>
<c:if test="${bill == null}">
    <div class="container-xl" style="display: flex; max-width: none;">
        <div class="col-12 col-lg-auto mb-3" style="width: 200px; margin-top: 30px">
            <div class="card p-3">
                <div class="e-navlist e-navlist--active-bg">
                    <ul class="nav">
                        <li class="nav-item"><a class="nav-link px-2" href="/admin/product"><span>Sản phẩm</span></a></li>
                        <li class="nav-item"><a class="nav-link px-2" href="/admin/user" ><span>Người dùng</span></a></li>
                        <li class="nav-item"><a class="nav-link px-2" href="/admin/bill" ><span>Hóa đơn</span></a></li>
                        <li class="nav-item"><a class="nav-link px-2" href="/admin/category" ><span>Danh mục</span></a></li>
                        <li class="nav-item"><a class="nav-link px-2" href="/admin/logout" ><span>Đăng xuất</span></a></li>

                    </ul>
                </div>
            </div>
        </div>
        <div class="table-responsive" style="width: calc(100% - 200px);">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Quản lí <b>Hóa đơn</b></h2>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>Điện thoại</th>
                        <th>Địa chỉ</th>
                        <th>Tổng tiền</th>
                        <th>Ngày thanh toán</th>
                        <th>Tên</th>
                        <th>Xem chi tiết</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${bills != null and bills.size() > 0}">
                        <c:forEach var="item" items="${bills}" begin="0" end="${bills.size() - 1}"
                                   varStatus="loop">
                            <tr>

                                <td>${item.getPhone()}</td>
                                <td>${item.getAddress()}</td>
                                <td><fmt:formatNumber type="number"
                                                      groupingUsed="true"
                                                      value="${item.getTotalPrice()}"/>đ
                                </td>
                                <td><fmt:formatDate value="${item.getCheckoutDate()}" pattern="dd-MM-yyyy"/></td>
                                <td>${item.getName()}</td>
                                <td><a href="/admin/bill/view/${item.getId()}">xem</a></td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</c:if>

<c:if test="${bill != null}">
<div class="container-xl">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                        <h2>Xem <b>Hóa đơn</b></h2>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">

                <tbody>
                <tr>
                    <td>Điện thoại:</td>
                    <td style="width: 50%;" >${bill.getPhone()}</td>
                </tr>
                <tr>
                    <td>Địa chỉ:</td>
                    <td>${bill.getAddress()}</td>
                </tr>
                <tr>
                    <td>Tổng tiền: </td>
                    <td><fmt:formatNumber type="number"
                                          groupingUsed="true"
                                          value="${bill.getTotalPrice()}"/>đ
                </tr>
                <tr>
                    <td>Ngày thanh toán: </td>
                    <td><fmt:formatDate value="${bill.getCheckoutDate()}" pattern="dd-MM-yyyy"/></td>
                </tr>
                <tr>
                    <td>Tên: </td>
                    <td>${bill.getName()}</td>
                </tr>
                </tbody>
            </table>

        </div>
    </div>


</c:if>

</body>
