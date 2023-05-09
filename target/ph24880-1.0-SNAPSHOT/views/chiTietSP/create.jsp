<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<%--<c:forEach items="${ listNV }" var="nhanVien">--%>
<div class="col-8 offset-2">
    <form method="POST" action="/chi-tiet-san-pham/create">
        <div class="row mt-4">
            <div class="col-6">
                <label>Id</label>
                <input type="text" name="id" class="form-control" disabled/>
            </div>
            <div class="col-6">
                <label>Sản Phẩm</label>
                <%--                <input type="text" name="idSP" class="form-control"/>--%>
                <select name="idSP" class="form-control">
                    <c:forEach items="${ listSP }" var="sanPham">
                        <option value="${sanPham.id}">${sanPham.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Nhà Sản Xuất</label>
                <%--                <input type="text" name="idNSX" class="form-control"/>--%>
                <select name="idNSX" class="form-control">
                    <c:forEach items="${ listNSX }" var="nhaSanXuat">
                        <option value="${nhaSanXuat.id}">${nhaSanXuat.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Màu Sắc</label>
                <%--                <input type="text" name="idMauSac" class="form-control"/>--%>
                <select name="idMauSac" class="form-control">
                    <c:forEach items="${ listMS }" var="mauSac">
                        <option value="${mauSac.id}">${mauSac.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Dòng Sản Phẩm</label>
                <%--                <input type="text" name="idDongSP" class="form-control"/>--%>
                <select name="idDongSP" class="form-control">
                    <c:forEach items="${ listDSP }" var="dongSanPham">
                        <option value="${dongSanPham.id}">${dongSanPham.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Năm Bảo Hành</label>
                <input type="number" name="namBH" class="form-control" min="0" value="0" required/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Mô Tả</label>
                <input type="text" name="moTa" class="form-control" />
            </div>
            <div class="col-6">
                <label>Số Lượng Tồn</label>
                <input type="number" name="soLuongTon" class="form-control" min="0" value="0" required/>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6">
                <label>Gia Nhập</label>
                <input type="text" name="giaNhap" class="form-control" required/>
            </div>
            <div class="col-6">
                <label>Gia Bán</label>
                <input type="text" name="giaBan" class="form-control" required/>
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