<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<center><h1> Cửa Hàng</h1></center>

<form method="POST"
      action="/cua-hang/update?id=${cuaHang.id}">
    <div class="container">
        <div class="col-12">
            <label>Id</label>
            <input type="text" name="id" class="form-control" value="${cuaHang.id}"  readonly/>
        </div>
        <div class="col-12">
            <label>Mã</label>
            <input type="text" name="ma" class="form-control" value="${cuaHang.ma}" required/>
        </div>
        <div class="col-12">
            <label>Tên</label>
            <input type="text" name="ten" class="form-control" value="${cuaHang.ten}" required/>
        </div>
        <div class="col-12">
            <label>Địa chỉ</label>
            <input type="text" name="diaChi" class="form-control" value="${cuaHang.diaChi}"required/>
        </div>
        <div class="col-12">
            <label>Thành phố</label>
            <input type="text" name="thanhPho" class="form-control" value="${cuaHang.thanhPho}" required/>
<%--            <select name="thanhPho" class="form-control">--%>
<%--                <option value="Hà Nội" ${ cuaHang.thanhPho == "Hà Nội" ? "selected" : ""}>Hà Nội</option>--%>
<%--                <option value="Vĩnh Phúc" ${ cuaHang.thanhPho == "Vĩnh Phúc" ? "selected" : ""}>Vĩnh Phúc</option>--%>
<%--                <option value="Hải Dương" ${ cuaHang.thanhPho == "Hải Dương" ? "selected" : ""}>Hải Dương</option>--%>
<%--                <option value="New York" ${ cuaHang.thanhPho == "New York" ? "selected" : ""}>New York</option>--%>
<%--            </select>--%>
        </div>
        <br>
        <div>
            <div class="col-12">
                <label>Quốc gia</label>
                <input type="text" name="quocGia" class="form-control" value="${cuaHang.quocGia}" required/>
<%--                <select name="quocGia" class="form-control">--%>
<%--                    <option value="Việt Nam" ${ cuaHang.quocGia == "Việt nam" ? "selected" : ""}>Việt Nam</option>--%>
<%--                    <option value="Hàn Quốc" ${ cuaHang.quocGia == "Hàn Quốc" ? "selected" : ""}>Hàn Quốc</option>--%>
<%--                    <option value="Du Bai" ${ cuaHang.quocGia == "Du Bai" ? "selected" : ""}>Du Bai</option>--%>
<%--                    <option value="Mỹ" ${ cuaHang.quocGia == "Mỹ" ? "selected" : ""}>Mỹ</option>--%>
<%--                </select>--%>
                <br>
            </div>
            <div class="col-md-12">
                <button class="btn btn-primary">Update</button>
            </div>
        </div>
    </div>
</form>

>
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
