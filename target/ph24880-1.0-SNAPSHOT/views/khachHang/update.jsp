
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Khách Hàng</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<center><h1> Khách Hàng</h1></center>
<div class="col-8 offset-2">
    <form method="POST"
          action="/khach-hang/update?id=${khachHang.id}">
        <div class="row mt-4">
            <div class="col-12">
                <label>Id</label>
                <input type="text" name="id" class="form-control"  readonly value="${khachHang.id}"/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${khachHang.ma}" required/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${khachHang.ten}" required/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="tenDem" class="form-control" value="${khachHang.tenDem}" required/>
            </div>
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control" value="${khachHang.ho}" required/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Ngày Sinh</label>
                <input type="date" name="ngaySinh" class="form-control" value="${khachHang.ngaySinh}" required/>
            </div>
            <div class="col-6">
                <label>SDT</label>
                <input type="text" name="sdt" class="form-control" value="${khachHang.sdt}"required/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" value="${khachHang.diaChi}" required/>
            </div>
            <div class="col-6">
                <label>Thành phố</label>
                <input type="text" name="thanhPho" class="form-control" value="${khachHang.thanhPho}"/>
                <%--                <select name="thanhPho" class="form-control">--%>
                <%--                    <option value="Hà Nội">Hà Nội</option>--%>
                <%--                    <option value="Vĩnh Phúc">Vĩnh Phúc</option>--%>
                <%--                    <option value="Hải Dương">Hải Dương</option>--%>
                <%--                    <option value="New York">New York</option>--%>
                <%--                </select>--%>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Quốc gia</label>
                <input type="text" name="quocGia" class="form-control" value="${khachHang.quocGia}"/>
                <%--                <select name="quocGia" class="form-control">&ndash;%&gt;--%>
                <%--                    <option value="Việt Nam">Việt Nam</option>--%>
                <%--                    <option value="Hàn Quốc">Hàn Quốc</option>--%>
                <%--                    <option value="Du Bai">Du Bai</option>--%>
                <%--                    <option value="Mỹ">Mỹ</option>--%>
                <%--                </select>--%>
            </div>
            <div class="col-6">
                <label>Mật khẩu</label>
                <input type="password" name="matKhau" class="form-control" value="${khachHang.matKhau}" required/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <button class="btn btn-primary">Update</button>
            </div>
        </div>
    </form>
</div>
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