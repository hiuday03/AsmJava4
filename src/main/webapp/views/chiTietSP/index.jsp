<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>

<header class="container">
    <h1 style="text-align: center;margin-top:15px;">Chi Tiết Sản Phẩm</h1>
</header>
<div class="col-10 offset-1 mt-5 table-responsive">
    <div class="row">
        <div class="col-6">
            <section>
                <a href="/chi-tiet-san-pham/view-create" class="btn btn-success " tabindex="-1" role="button"
                   aria-disabled="true">Create</a>
            </section>
        </div>
    </div>
    <c:if test="${ f:length(listCTSP) == 0 }">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(listCTSP) != 0 }">

        <table class="table">
            <thead>
            <tr>
                    <%--            <th>Id</th>--%>
                <th>Sản Phẩm</th>
                <th>Nhà Sản Xuất</th>
                <th>Màu Sắc</th>
                <th>Dòng Sản Phẩm</th>
                <th>Năm Bảo Hành</th>
                <th>Mô Tả</th>
                <th>Số Lượng Tồn</th>
                <th>Gía Nhập</th>
                <th>Gía Bán</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ listCTSP }" var="chiTietSP">
                <tr>
                        <%--                <td>${ chiTietSP.id }</td>--%>
<%--                    <td>--%>
<%--                        <c:forEach items="${ listSP }" var="sanPham">--%>
<%--                            ${ chiTietSP.idSP.id == sanPham.id ? sanPham.ten : ""}--%>
<%--                        </c:forEach>--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <c:forEach items="${ listNSX }" var="nhaSanXuat">--%>
<%--                            ${ chiTietSP.idNSX.id == nhaSanXuat.id ? nhaSanXuat.ten : ""}--%>
<%--                        </c:forEach>--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <c:forEach items="${ listMS }" var="mauSac">--%>
<%--                            ${ chiTietSP.idMauSac.id == mauSac.id ? mauSac.ten : ""}--%>
<%--                        </c:forEach>--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <c:forEach items="${ listDSP }" var="dongSanPham">--%>
<%--                            ${ chiTietSP.idDongSP.id == dongSanPham.id ? dongSanPham.ten : ""}--%>
<%--                        </c:forEach>--%>
<%--                    </td>--%>
                    <td>${ chiTietSP.idSP.ten }</td>
                    <td>${ chiTietSP.idNSX.ten }</td>
                    <td>${ chiTietSP.idMauSac.ten }</td>
                    <td>${ chiTietSP.idDongSP.ten }</td>
                    <td>${ chiTietSP.namBH }</td>
                    <td>${ chiTietSP.moTa }</td>
                    <td>${ chiTietSP.soLuongTon }</td>
                    <td>${ chiTietSP.giaNhap }</td>
                    <td>${ chiTietSP.giaBan }</td>
                    <td>
                        <a href="/chi-tiet-san-pham/detail?id=${chiTietSP.id}" class="btn btn-primary " tabindex="-1"
                           role="button"
                           aria-disabled="true">Detail</a>
                        <a href="/chi-tiet-san-pham/view-update?id=${chiTietSP.id}" class="btn btn-success "
                           tabindex="-1"
                           role="button"
                           aria-disabled="true">Update</a>
                        <a href="/chi-tiet-san-pham/remove?id=${chiTietSP.id}" class="btn btn-danger " tabindex="-1"
                           role="button"
                           aria-disabled="true">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>