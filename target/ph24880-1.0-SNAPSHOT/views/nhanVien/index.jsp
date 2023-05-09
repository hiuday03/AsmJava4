<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>

<header class="container">
    <h1 style="text-align: center;margin-top:15px;">Nhân Viên</h1>
</header>
<div class="col-10 offset-1 mt-5 table-responsive">
    <div class="row">
        <div class="col-6">
            <section>
                <a href="/nhan-vien/view-create" class="btn btn-success " tabindex="-1" role="button"
                   aria-disabled="true">Create</a>
            </section>
        </div>
    </div>
    <c:if test="${ f:length(listNV) == 0 }">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(listNV) != 0 }">

        <table class="table">
            <thead>
            <tr>
                    <%--            <th>Id</th>--%>
                <th>Mã</th>
                <th>Tên</th>
                <th>Tên Đệm</th>
                <th>Họ</th>
                <th>giới Tính</th>
                <th>Ngày Sinh</th>
                <th>Địa Chỉ</th>
                <th>SDT</th>
                <th>Mật Khẩu</th>
                <th>Cửa Hàng</th>
                <th>Chúc Vụ</th>
                <th>Trạng Thái</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ listNV }" var="nhanVien">
                <tr>
                        <%--                <td>${ nhanVien.id }</td>--%>
                    <td>${ nhanVien.ma }</td>
                    <td>${ nhanVien.ho }</td>
                    <td>${ nhanVien.tenDem }</td>
                    <td>${ nhanVien.ten }</td>
                    <td>${ nhanVien.gioiTinh }</td>
                    <td>${ nhanVien.ngaySinh }</td>
                    <td>${ nhanVien.diaChi }</td>
                    <td>${ nhanVien.sdt }</td>
                    <td>${ nhanVien.matKhau }</td>
                    <td>
                        <c:forEach items="${ listCH }" var="cuaHang">
                            ${ nhanVien.idCH.id == cuaHang.id ? cuaHang.ten : ""}
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${ listCV }" var="chucVu">
                            ${ nhanVien.idCV.id == chucVu.id ? chucVu.ten : ""}
                        </c:forEach>
                    </td>
                    <td>${ nhanVien.trangThai == 1 ? "Đang Làm" : "Nghỉ Làm"}</td>
                    <td>
                        <a href="/nhan-vien/detail?id=${nhanVien.id}" class="btn btn-primary " tabindex="-1"
                           role="button"
                           aria-disabled="true">Detail</a>
                        <a href="/nhan-vien/view-update?id=${nhanVien.id}" class="btn btn-success " tabindex="-1"
                           role="button"
                           aria-disabled="true">Update</a>
                        <a href="/nhan-vien/remove?id=${nhanVien.id}" class="btn btn-danger " tabindex="-1"
                           role="button"
                           aria-disabled="true">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
