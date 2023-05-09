
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>

<header class="container">
    <h1 style="text-align: center;margin-top:15px;">Cửa Hàng</h1>
</header>
<div class="col-10 offset-1 mt-5 table-responsive">
<div class="row">
    <div class="col-6">
        <section>
            <a href="/cua-hang/view-create" class="btn btn-success " tabindex="-1" role="button"
               aria-disabled="true">Create</a>
        </section>
    </div>
</div>
<c:if test="${ f:length(listCH) == 0 }">
    <h3 class="alert alert-warning">Không có dữ liệu</h3>
</c:if>
<c:if test="${ f:length(listCH) != 0 }">

    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Địa Chỉ</th>
            <th>Thành Phố</th>
            <th>Quốc Gia</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ listCH }" var="cuaHang">
            <tr>
                <td>${ cuaHang.id }</td>
                <td>${ cuaHang.ma }</td>
                <td>${ cuaHang.ten }</td>
                <td>${ cuaHang.diaChi }</td>
                <td>${ cuaHang.thanhPho}</td>
                <td>${ cuaHang.quocGia}</td>
                <td>
                    <a href="/cua-hang/detail?id=${cuaHang.id}" class="btn btn-primary " tabindex="-1" role="button"
                       aria-disabled="true">Detail</a>
                    <a href="/cua-hang/view-update?id=${cuaHang.id}" class="btn btn-success " tabindex="-1"
                       role="button"
                       aria-disabled="true">Update</a>
                    <a href="/cua-hang/remove?id=${cuaHang.id}" class="btn btn-danger " tabindex="-1" role="button"
                       aria-disabled="true">Remove</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</div>
