<%--
  Created by IntelliJ IDEA.
  User: xuan hieu
  Date: 7/25/2022
  Time: 11:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<body>
<c:if test="${id == null and isSuccess == null}">
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
                            <h2>Quản lí <b>Người dùng</b></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i
                                    class="material-icons">&#xE147;</i> <span>Thêm người dùng</span></a>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>Email</th>
                        <th>Tên người dùng</th>
                        <th>Vai trò</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${users != null and users.size() > 0}">
                        <c:forEach var="item" items="${users}" begin="0" end="${users.size() - 1}"
                                   varStatus="loop">
                            <tr>

                                <td>${item.getEmail()}</td>
                                <td>${item.getDisplay_name()}</td>
                                <td>${item.getRole()}</td>
                                <td>
                                    <a href="/admin/user/edit/${item.getId()}" class="edit"><i class="material-icons"
                                                                                                   data-toggle="tooltip"
                                                                                                   title="Edit">&#xE254;</i></a>
                                    <a href="/admin/user/delete/${item.getId()}" class="delete"><i
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
                <form action="/admin/user/add" method="post">
                    <div class="modal-header">
                        <h4 class="modal-title">Thêm danh mục</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" name="email" required>
                        </div>
                        <div class="form-group">
                            <label>Tên người dùng</label>
                            <input type="text" class="form-control" name="name" required>
                        </div>
                        <div class="form-group">
                            <label>Mật khẩu</label>
                            <input type="password" class="form-control" name="password" required>
                        </div>
                        <div class="form-group">
                            <label>Vai trò</label>
                            <select class="form-control" name="role" required>
                                <option value="customer">Khách hàng</option>
                                <option value="admin">Quản trị viên</option>
                            </select>
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
<c:if test="${id != null and isSuccess == null}">
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
            <form action="/admin/user/edit/${id}", method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Chỉnh sửa Người dùng</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Email</label>
                        <input type="Email" class="form-control" name="email">
                    </div>
                    <div class="form-group">
                        <label>Tên người dùng</label>
                        <input type="text" class="form-control" name="name">
                    </div>
                    <div class="form-group">
                        <label>Vai trò</label>
                        <select class="form-control" name="role" required>
                            <option value="customer">Khách hàng</option>
                            <option value="admin">Quản trị viên</option>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-success" value="Sửa">
                </div>
            </form>
        </div>
    </div>

</c:if>
<c:if test="${isSuccess != null}">
    <c:if test="${isSuccess == false}">
        <p>Email này đã tồn tại</p>
        <c:if test="${add == null}">
            <a href="/admin/user/edit/${id}">Chỉnh sửa</a>
        </c:if>
        <c:if test="${add != null}">
            <a href="/admin/user">Quay về</a>
        </c:if>
    </c:if>
    <c:if test="${isSuccess == true}">
        <p>Thao tác thành công</p>
        <p>Quay lại <a href="/admin/user">trang</a></p>
    </c:if>
</c:if>

</body>