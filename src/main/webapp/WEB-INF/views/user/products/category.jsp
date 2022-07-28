<%--
  Created by IntelliJ IDEA.
  User: xuan hieu
  Date: 5/5/2022
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>

<div class="allproduct-container">
    <%
        String price = request.getParameter("price");
        String name = request.getParameter("name");

        String param = "?";

        if (price != null)
            param += "price=" + price;

        if (name != null) {
            if (price != null) param += "&name=" + name;
            else param += "name=" + name;
        }

        pageContext.setAttribute("parameter", param);

    %>
    <div class="grid wide">
        <div class="filter">
            <div class="row filter-item">
                <div class="col l-4 c-12 m-4">
                    <select name="category" class="filter-option" onchange="window.location.href=this.value">
                        <option>Danh sách sản phẩm</option>
                        <c:forEach var="item" items="${categoryData}">
                            <option value="/the-loai-san-pham/${item.id}">
                                    ${item.name}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col l-4 c-12 m-4">
                    <select name="price" class="filter-option" onchange="window.location.href=this.value">
                        <option value="">Giá</option>
                        <%
                            String p = "?";
                            if(name!=null)
                                p += "name="+name+"&";
                            pageContext.setAttribute("p", p);
                        %>
                        <option value="${p}price=asc">Tăng dần</option>
                        <option value="${p}price=desc">Giảm dần</option>
                    </select>
                </div>
                <div class="col l-4 c-12 m-4">
                    <select name="name" class="filter-option" onchange="window.location.href=this.value">
                        <option value="">Sắp xếp theo</option>
                        <%
                            p = "?";
                            if(price!=null)
                                p += "price="+price+"&";
                            pageContext.setAttribute("p", p);
                        %>
                        <option value="${p}name=asc">Theo ký tự A-Z</option>
                        <option value="${p}name=desc">Theo ký tự Z-A</option>
                    </select>
                </div>
            </div>
        </div>
        <h1>${test.size()}</h1>
        <c:if test="${idCategory == 0}">
            <h1>Tất cả sản phẩm</h1>
        </c:if>
        <c:if test="${idCategory != 0}">
            <h1>Tất cả sản phẩm trong: ${category.name} </h1>
        </c:if>
        <div class="product-grid">
            <div class="row">
                <c:forEach var="item" items="${ProductPaginate}">
                    <div class="col l-3 m-4 c-6 product-grid__item">
                        <a href="/chi-tiet-san-pham/${item.id}" class="product-event__item">
                            <div class="product-event__item-img"
                                 style="background-image: url(<c:url
                                         value="/assets/user/img/product/${item.image}"/>)"></div>
                            <h4 class="product-event__item-name">
                                    ${item.name}
                            </h4>
                            <div class="product-event__item-price"><fmt:formatNumber type="number"
                                                                                     groupingUsed="true"
                                                                                     value="${item.price}"/>đ
                            </div>
                            <div class="product-event__item-add">
                                <form method="get" action="<c:url value="/AddCart/${item.id}" />">
                                    <button class="product-event__item-btn btn" type="submit">
                                        Thêm vào giỏ hàng
                                    </button>
                                </form>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div class="pagination">
            <%--            <c:set var="link_before" value="" />--%>
            <%--            <c:set var="link_after" value="" />--%>

            <%--            <a href="${link_before}" class="fas fa-chevron-left pagination-icon pagination-btn"></a>--%>

            <c:forEach var="item" begin="1" end="${paginateInfo.totalPage}" varStatus="loop">

                <%--                <c:choose>--%>
                <%--                    <c:when test="${loop.index == 1}">--%>
                <%--                        <c:set var="link_before" value="/the-loai-san-pham/${idCategory}" />--%>
                <%--                    </c:when>--%>
                <%--                    <c:otherwise>--%>
                <%--                        <c:set var="link_before" value="/the-loai-san-pham/${idCategory}/${loop.index-1}" />--%>
                <%--                    </c:otherwise>--%>
                <%--                </c:choose>--%>

                <%--                <c:choose>--%>
                <%--                    <c:when test="${loop.index == paginateInfo.totalPage}">--%>
                <%--                        <c:set var="link_after" value="/the-loai-san-pham/${idCategory}/${loop.index}" />--%>
                <%--                    </c:when>--%>
                <%--                    <c:otherwise>--%>
                <%--                        <c:set var="link_after" value="/the-loai-san-pham/${idCategory}/${loop.index+1} " />--%>
                <%--                    </c:otherwise>--%>
                <%--                </c:choose>--%>

                <c:if test="${loop.index == paginateInfo.currentPage}">
                    <a href="<c:url value="/the-loai-san-pham/${idCategory}/${loop.index}${parameter}}"/>"
                       class="pagination-number pagination-btn pagination-number--active">${loop.index}</a>
                </c:if>
                <c:if test="${loop.index != paginateInfo.currentPage}">
                    <a href="<c:url value="/the-loai-san-pham/${idCategory}/${loop.index}${parameter}"/>"
                       class="pagination-number pagination-btn">${loop.index}</a>
                </c:if>

            </c:forEach>


        </div>
    </div>
</div>

</body>
