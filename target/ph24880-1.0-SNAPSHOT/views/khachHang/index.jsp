<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>

<header class="container">
    <h1 style="text-align: center;margin-top:15px;">Khách Hàng</h1>
</header>
<div class="col-11 offset-1 mt-5 table-responsive">
    <div class="row">
        <div class="col-6">
            <section>
                <a href="/khach-hang/view-create" class="btn btn-success " tabindex="-1" role="button"
                   aria-disabled="true">Create</a>
            </section>
        </div>
    </div>
    <c:if test="${ f:length(listKH) == 0 }">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(listKH) != 0 }">

        <table class="table">
            <thead>
            <tr>
                <th>Id</th>
                <th>Mã</th>
                <th>Tên</th>
                <th>Tên Đệm</th>
                <th>Họ</th>
                <th>Ngày Sinh</th>
                <th>SDT</th>
                <th>Địa Chỉ</th>
                <th>Quốc Gia</th>
                <th>Thành Phố</th>
                <th>Mật Khẩu</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ listKH }" var="khachHang">
                <tr>
                    <td>${ khachHang.id }</td>
                    <td>${ khachHang.ma }</td>
                    <td>${ khachHang.ten }</td>
                    <td>${ khachHang.tenDem }</td>
                    <td>${ khachHang.ho }</td>
                    <td>${ khachHang.ngaySinh }</td>
                    <td>${ khachHang.sdt }</td>
                    <td>${ khachHang.diaChi }</td>
                    <td>${ khachHang.thanhPho }</td>
                    <td>${ khachHang.quocGia }</td>
                    <td>${ khachHang.matKhau }</td>
                    <td>
                        <a href="/khach-hang/detail?id=${khachHang.id}" class="btn btn-primary " tabindex="-1" role="button"
                           aria-disabled="true">Detail</a>
                        <a href="/khach-hang/view-update?id=${khachHang.id}" class="btn btn-success " tabindex="-1"
                           role="button"
                           aria-disabled="true">Update</a>
                        <a href="/khach-hang/remove?id=${khachHang.id}" class="btn btn-danger " tabindex="-1" role="button"
                           aria-disabled="true">Remove</a>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>