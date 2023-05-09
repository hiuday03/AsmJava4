<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<style>
    table, th, td {
        border: 1px solid black;
    }
</style>
<body>
<h1>Hello, Welcome to the post of PH24880!</h1>
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
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/home">IT17315</a>
    </div>
</nav>

<div class="row mt-10" style="min-height: 800px;">
    <div class="col-1 bg-info">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/khach-hang/view-all">Khách Hàng</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" aria-current="page" href="/cua-hang/view-all">Cửa Hàng</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" aria-current="page" href="/chuc-vu/view-all">Chức Vụ</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" aria-current="page" href="/nhan-vien/view-all">Nhân Viên</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" aria-current="page" href="/san-pham/view-all">Sản Phẩm</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" aria-current="page" href="/mau-sac/view-all">Màu sắc</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" aria-current="page" href="/dong-san-pham/view-all">Dòng Sản Phẩm</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" aria-current="page" href="/nha-san-xuat/view-all">Nhà Sản Xuất</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" aria-current="page" href="/chi-tiet-san-pham/view-all">Chi Tiết Sản Phẩm</a>
            </li>
        </ul>
    </div>
    <div class="col-11">
        <jsp:include page="${ view }"/>
    </div>
</div>

<div class="bg-light">
    <footer><h5 style="text-align: center;">PH24880</h5></footer>
</div>
<script>
    var date = new Date();

    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();

    if (month < 10) month = "0" + month;
    if (day < 10) day = "0" + day;

    var today = year + "-" + month + "-" + day;
    document.getElementById("theDate").value = today;
</script>
</html>