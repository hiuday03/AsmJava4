<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 3/13/2023
  Time: 12:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Chi Tiết Sản Phẩm</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<center><h1>Chi Tiết Sản Phẩm</h1></center>
<div class="col-8 offset-2">
    <form method="POST"
          action="/Assingment_war_exploded/chitiet-sanpham/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>idSP</label>
                <input type="text" name="idsp" class="form-control" value="${ctsp.idsp}" disabled />
            </div>
            <div class="col-6">
                <label>IdNsx</label>
                <input type="text" name="idnsx" class="form-control" value="${ctsp.idnsx}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>IdDongSp</label>
                <input type="text" name="iddongsp" class="form-control"  value="${ctsp.iddongsp}"/>
            </div>
            <div class="col-6">
                <label>IdMauSac</label>
                <input type="text" name="idmausac" class="form-control"  value="${ctsp.idmausac}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Năm Bảo Hành</label>
                <input type="date" name="nambaohanh" class="form-control" value="${ctsp.nambaohanh}" />
            </div>
            <div class="col-6">
                <label>Mô Tả</label>
                <input type="tel" name="mota" class="form-control" value="${ctsp.mota}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Số Lượng Tồn</label>
                <input type="text" name="soluongton" class="form-control" value="${ctsp.soluongton}" />
            </div>
            <div class="col-6">
                <label>Gia Nhập</label>
                <input type="password" name="gianhap" class="form-control" value="${ctsp.gianhap}" />
            </div>
            <div class="col-6">
                <label>Gia Bán</label>
                <input type="password" name="giaban" class="form-control" value="${ctsp.giaban}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Thêm</button>
            </div>
            <div class="col-6"></div>
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