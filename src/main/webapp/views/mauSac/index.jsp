
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>

<header class="container">
    <h1 style="text-align: center;margin-top:15px;">Màu Sắc</h1>
</header>
<div class="col-10 offset-1 mt-5 table-responsive">
<div class="row">
    <div class="col-6">
        <section>
            <a href="/mau-sac/view-create" class="btn btn-success " tabindex="-1" role="button"
               aria-disabled="true">Create</a>
        </section>
    </div>
</div>
<c:if test="${ f:length(listMS) == 0 }">
    <h3 class="alert alert-warning">Không có dữ liệu</h3>
</c:if>
<c:if test="${ f:length(listMS) != 0 }">

    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Mã</th>
            <th>Tên</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ listMS }" var="mauSac">
            <tr>
                <td>${ mauSac.id }</td>
                <td>${ mauSac.ma }</td>
                <td>${ mauSac.ten }</td>
                <td>
                    <a href="/mau-sac/detail?id=${mauSac.id}" class="btn btn-primary " tabindex="-1" role="button"
                       aria-disabled="true">Detail</a>
                    <a href="/mau-sac/view-update?id=${mauSac.id}" class="btn btn-success " tabindex="-1"
                       role="button"
                       aria-disabled="true">Update</a>
                    <a href="/mau-sac/remove?id=${mauSac.id}" class="btn btn-danger " tabindex="-1" role="button"
                       aria-disabled="true">Remove</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</div>
