<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Nhân Viên</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<center><h1> Nhân Viên</h1></center>

<%--<c:forEach items="${ listNV }" var="nhanVien">--%>

<div class="col-8 offset-2">
    <form method="POST" action="/nhan-vien/create">
        <div class="row mt-4">
            <div class="col-6">
                <label>Id</label>
                <input type="text" name="id" disabled class="form-control"/>
            </div>
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" required/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" />
            </div>
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="tenDem" class="form-control" />
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control" />
            </div>
            <div class="col-6">
                <label>giới Tính</label><br>
                <input type="radio" name="gioiTinh" value="Nam" checked/>Nam
                <input type="radio" name="gioiTinh" value="Nữ"/>Nữ
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Ngày sinh</label>
                <input type="date" name="ngaySinh" class="form-control" id="theDate"  max="theDate" required />
            </div>
            <div class="col-6">
                <label>Địa Chỉ</label>
                <input type="text" name="diaChi" class="form-control" />
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>SDT</label>
                <input type="text" name="sdt" class="form-control" />
            </div>
            <div class="col-6">
                <label>Mật khẩu</label>
                <input type="password" name="matKhau" class="form-control" />
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Cửa Hàng</label>
                <%--                <input type="text" name="idCH" class="form-control"/>--%>
                <select name="idCH" class="form-control">
                    <c:forEach items="${ listCH }" var="cuaHang">
                        <option value="${cuaHang.id}">${cuaHang.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Chức Vụ</label>
                <%--                <input type="text" name="idCV" class="form-control"/>--%>
                <select name="idCV" class="form-control">
                    <c:forEach items="${ listCV }" var="chucVu">
                        <option value="${chucVu.id}">${chucVu.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Báo Cáo</label>
                <input type="text" name="idBaoCao"  class="form-control" required/>
            </div>
            <div class="col-6">
                <label>Trạng Thái</label><br>
                <input type="radio" name="trangThai" value="1" checked/>Đang Làm
                <input type="radio" name="trangThai" value="0"/>Nghỉ Làm
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <button class="btn btn-primary">Create</button>
            </div>
            <span class="fw-bold">${result}</span>
        </div>
    </form>
</div>
<%--</c:forEach>--%>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>