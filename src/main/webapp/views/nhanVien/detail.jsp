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
<header class="container"><h3 style="text-align: center;margin-top:15px;"> Thông tin Nhân Viên</h3>
</header>
<main class="container">
    <section>
        <div class="row mt-4">
            <div class="col-12">
                <label>ID:</label>
                <input type="text" disabled value="${nhanVien.id}">
            </div>
            <div class="col-12">
                <label>Mã:</label>
                <input type="text" disabled value="${nhanVien.ma}">
            </div>
            <div class="col-12">
                <label>Tên:</label>
                <input type="text" disabled value="${nhanVien.ten}">
            </div>
            <div class="col-12">
                <label>Tên Đệm:</label>
                <input type="text" disabled value="${nhanVien.tenDem}">
            </div>
            <div class="col-12">
                <label>Họ:</label>
                <input type="text" disabled value="${nhanVien.ho}">
            </div>
            <div class="col-12">
                <label>Giới Tính:</label>
                <input type="text" disabled value="${nhanVien.gioiTinh}">
            </div>
            <div class="col-12">
                <label>Ngày Sinh:</label>
                <input type="text" disabled value="${nhanVien.ngaySinh}">
            </div>
            <div class="col-12">
                <label>Địa Chỉ:</label>
                <input type="text" disabled value="${nhanVien.diaChi}">
            </div>
            <div class="col-12">
                <label>SDT:</label>
                <input type="text" disabled value="${nhanVien.sdt}">
            </div>
            <div class="col-12">
                <label>Mật Khẩu:</label>
                <input type="text" disabled value="${nhanVien.matKhau}">
            </div>
            <div class="col-12">
                <label>Cửa Hàng:</label>
<%--                <input type="text" disabled--%>
                <c:forEach items="${ listCH }" var="cuaHang">
<%--                       value="--%>
                       ${ nhanVien.idCH.id == cuaHang.id ? cuaHang.ten : ""}
<%--                        "--%>
                </c:forEach>
<%--                >--%>

            </div>
            <div class="col-12">
                <label>Chúc Vụ:</label>
<%--                <input disabled--%>
                <c:forEach items="${ listCV }" var="chucVu">
<%--                       value="--%>
                    ${ nhanVien.idCV.id == chucVu.id ? chucVu.ten : ""}
<%--                    "--%>
                </c:forEach>
<%--                >--%>
            </div>
            <div class="col-12">
                <label>Trạng Thái:</label>
                <input type="text" disabled value="${nhanVien.trangThai == 1 ? "Đang Làm" : "Nghỉ Làm"}">
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
