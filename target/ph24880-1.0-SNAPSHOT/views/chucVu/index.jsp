<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>

<header class="container">
    <h1 style="text-align: center;margin-top:15px;">Chúc Vụ</h1>
</header>
<div class="col-10 offset-1 mt-5 table-responsive">
    <div class="row">
        <div class="col-6">
            <section>
                <a href="/chuc-vu/view-create" class="btn btn-success " tabindex="-1" role="button"
                   aria-disabled="true">Create</a>
            </section>
        </div>
    </div>
    <c:if test="${ f:length(listCV) == 0 }">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(listCV) != 0 }">

        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Mã</th>
                <th>Tên</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ listCV }" var="chucVu">
                <tr>
                    <td>${ chucVu.id }</td>
                    <td>${ chucVu.ma }</td>
                    <td>${ chucVu.ten }</td>
                    <td>
                        <a href="/chuc-vu/detail?id=${chucVu.id}" class="btn btn-primary " tabindex="-1" role="button"
                           aria-disabled="true">Detail</a>
                        <a href="/chuc-vu/view-update?id=${chucVu.id}" class="btn btn-success " tabindex="-1"
                           role="button"
                           aria-disabled="true">Update</a>
                        <a href="/chuc-vu/remove?id=${chucVu.id}" class="btn btn-danger " tabindex="-1" role="button"
                           aria-disabled="true">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
