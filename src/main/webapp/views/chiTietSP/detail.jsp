<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header class="container"><h3 style="text-align: center;margin-top:15px;"> Thông tin Chi Tiết Sản Phẩm</h3>
</header>
<main class="container">
    <section>
        <div class="row mt-4">
            <div class="col-12">
                <label>ID:</label>
                <input type="text" disabled value="${chiTietSP.id}">
            </div>
            <div class="col-12">
                <label>Sản Phẩm:</label>
                <c:forEach items="${ listSP }" var="sanPham">
                    ${chiTietSP.idSP.id == sanPham.id ? sanPham.ten : ""}
                </c:forEach>
            </div>
            <div class="col-12">
                <label>Nhà Sản Xuất:</label>
                <c:forEach items="${ listNSX }" var="nhaSanXuat">
                    ${chiTietSP.idNSX.id == nhaSanXuat.id ? nhaSanXuat.ten : ""}
                </c:forEach>
            </div>
            <div class="col-12">
                <label>Màu Sắc:</label>
                <c:forEach items="${ listMS }" var="mauSac">
                    ${chiTietSP.idMauSac.id == mauSac.id ? mauSac.ten : ""}
                </c:forEach>
            </div>
            <div class="col-12">
                <label>Dòng Sản Phẩm:</label>
                <c:forEach items="${ listDSP }" var="dongSanPham">
                    ${chiTietSP.idDongSP.id == dongSanPham.id ? dongSanPham.ten : ""}
                </c:forEach>
            </div>
            <div class="col-12">
                <label>Năm Bảo Hành:</label>
                <input type="text" disabled value="${chiTietSP.namBH}">
            </div>
            <div class="col-12">
                <label>Mô Tả:</label>
                <input type="text" disabled value="${chiTietSP.moTa}">
            </div>
            <div class="col-12">
                <label>Số Lượng Tồn:</label>
                <input type="text" disabled value="${chiTietSP.soLuongTon}">
            </div>
            <div class="col-12">
                <label>Giá Nhập:</label>
                <input type="text" disabled value="${chiTietSP.giaNhap}">
            </div>
            <div class="col-12">
                <label>Giá Bán:</label>
                <input type="text" disabled value="${chiTietSP.giaBan}">
            </div>
        </div>
    </section>

</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>
