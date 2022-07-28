<%--
  Created by IntelliJ IDEA.
  User: xuan hieu
  Date: 7/17/2022
  Time: 8:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script>
    $(document).ready(function () {
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();

        // Select/Deselect checkboxes
        var checkbox = $('table tbody input[type="checkbox"]');
        $("#selectAll").click(function () {
            if (this.checked) {
                checkbox.each(function () {
                    this.checked = true;
                });
            } else {
                checkbox.each(function () {
                    this.checked = false;
                });
            }
        });
        checkbox.click(function () {
            if (!this.checked) {
                $("#selectAll").prop("checked", false);
            }
        });
    });
</script>
</head>
<body>
<c:if test="${message == null and edit == null}">
    <div class="container-xl" style="display: flex; max-width: none;">
        <div class="col-12 col-lg-auto mb-3" style="width: 200px; margin-top: 30px">
            <div class="card p-3">
                <div class="e-navlist e-navlist--active-bg">
                    <ul class="nav">
                        <li class="nav-item"><a class="nav-link px-2" href="/admin/product"><span>Sản phẩm</span></a>
                        </li>
                        <li class="nav-item"><a class="nav-link px-2" href="/admin/user"><span>Người dùng</span></a>
                        </li>
                        <li class="nav-item"><a class="nav-link px-2" href="/admin/bill"><span>Hóa đơn</span></a></li>
                        <li class="nav-item"><a class="nav-link px-2" href="/admin/category"><span>Danh mục</span></a>
                        </li>
                        <li class="nav-item"><a class="nav-link px-2" href="/admin/logout"><span>Đăng xuất</span></a>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
        <div class="table-responsive" style="width: calc(100% - 200px);">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Quản lí <b>Sản phẩm</b></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i
                                    class="material-icons">&#xE147;</i> <span>Thêm sản phẩm</span></a>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>Tên sản phẩm</th>
                        <th>Giá</th>
                        <th>Danh mục</th>
                        <th>Mô tả</th>
                        <th>Giảm giá</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="item" items="${products}" varStatus="loop">
                        <tr>

                            <td>${item.getName()}</td>
                            <td><fmt:formatNumber type="number"
                                                  groupingUsed="true"
                                                  value="${item.getPrice()}"/>đ
                            </td>
                            <td>${categoryProduct.get(loop.index).getName()}</td>
                            <td class="detail-table">${item.getDetail()}</td>

                            <td>
                                <fmt:formatNumber type="number"
                                                  groupingUsed="true"
                                                  value="${item.getDiscount_money()}"/>đ/
                                    ${item.getDiscount_rate()}%
                            </td>
                            <td>
                                <a href="/admin/product/edit/${item.getId()}" class="edit"><i class="material-icons"
                                                                                              data-toggle="tooltip"
                                                                                              title="Edit">&#xE254;</i></a>
                                <a href="/admin/product/delete/${item.getId()}" class="delete"><i class="material-icons"
                                                                                                  data-toggle="tooltip"
                                                                                                  title="Delete">&#xE872;</i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- Edit Modal HTML -->
    <div id="addEmployeeModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="/uploadFile" method="post" enctype="multipart/form-data">
                    <div class="modal-header">
                        <h4 class="modal-title">Thêm sản phẩm</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Tên</label>
                            <input type="text" class="form-control" name="name" required>
                        </div>
                        <div class="form-group">
                            <label>Giá</label>
                            <input type="text" class="form-control" name="price" required>
                        </div>
                        <div class="form-group">
                            <label>Danh mục</label>
                            <select class="form-control" name="category" required>
                                <c:forEach items="${categories}" var="item">
                                    <option value="${item.getId()}">${item.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Mô tả</label>
                            <textarea type="text" class="form-control" name="detail" required></textarea>
                        </div>
                        <div class="form-group">
                            <label> <b>Giảm giá</b></label>
                            <br>
                            <label>Giảm theo tiền</label>
                            <input type="text" class="form-control" name="discount-money">
                            <label>Giảm theo %</label>
                            <input type="text" class="form-control" name="discount-rate">
                        </div>
                        <div class="form-group">
                            <label>Hình ảnh</label>
                            <input type="file" class="form-control" name="image" accept="image/*" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                        <input type="submit" class="btn btn-success" value="Add">
                    </div>
                </form>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${message != null}">
    <p>${message}</p>
    <p>Quay lại <a href="/admin/product">trang</a></p>
</c:if>
<c:if test="${edit != null}">
    <div class="container-xl">
        <div class="table-wrapper">
            <form action="/edit/product/${edit}" , method="post" enctype="multipart/form-data">
                <div class="modal-header">
                    <h4 class="modal-title">Chỉnh sửa sản phẩm</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Tên</label>
                        <input type="text" class="form-control" name="name" value="${product.getName()}" required>
                    </div>
                    <div class="form-group">
                        <label>Giá</label>
                        <input type="text" class="form-control" name="price" value="${product.getPrice()}" required>
                    </div>
                    <div class="form-group">
                        <label>Danh mục</label>
                        <select class="form-control" name="category" required>
                            <c:forEach items="${categories}" var="item">
                                <option value="${item.getId()}">${item.getName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Mô tả</label>
                        <textarea type="text" class="form-control" name="detail"
                                  required>${product.getDetail()}</textarea>
                    </div>
                    <div class="form-group">
                        <label> <b>Giảm giá</b></label>
                        <br>
                        <label>Giảm theo tiền</label>
                        <input type="text" class="form-control" value="${product.getDiscount_money()}" name="discount-money">
                        <label>Giảm theo %</label>
                        <input type="text" class="form-control" value ="${product.getDiscount_rate()}" name="discount-rate">
                    </div>
                    <div class="form-group">
                        <label>Hình ảnh</label>
                        <input type="file" class="form-control" name="image" accept="image/*">
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-success" value="Sửa">
                </div>
            </form>
        </div>
    </div>
</c:if>
</body>