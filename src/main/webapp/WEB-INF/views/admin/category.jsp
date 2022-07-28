<%--
  Created by IntelliJ IDEA.
  User: xuan hieu
  Date: 7/25/2022
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<body>
<c:if test="${message == null and edit == null}">
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
                            <h2>Quản lí <b>Danh mục</b></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i
                                    class="material-icons">&#xE147;</i> <span>Thêm danh mục</span></a>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>Tên danh mục</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${categories != null and categories.size() > 0}">
                        <c:forEach var="item" items="${categories}" begin="0" end="${categories.size() - 1}"
                                   varStatus="loop">
                            <tr>

                                <td>${item.getName()}</td>
                                <td>
                                    <a href="/admin/category/edit/${item.getId()}" class="edit"><i class="material-icons"
                                                                                                   data-toggle="tooltip"
                                                                                                   title="Edit">&#xE254;</i></a>
                                    <a href="/admin/category/delete/${item.getId()}" class="delete"><i
                                            class="material-icons"
                                            data-toggle="tooltip"
                                            title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- Edit Modal HTML -->
    <div id="addEmployeeModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="/admin/category/add" method="post">
                    <div class="modal-header">
                        <h4 class="modal-title">Thêm danh mục</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Tên danh mục</label>
                            <input type="text" class="form-control" name="name" required>
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
<c:if test="${message != null}" >
    <p>${message}</p>
    <p>Quay lại <a href="/admin/category">trang</a></p>
</c:if>
<c:if test="${edit != null}">
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
            <form action="/admin/category/edit/${edit}", method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Chỉnh sửa Danh mục</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Tên danh mục</label>
                        <input type="text" class="form-control" name="name" required>
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

