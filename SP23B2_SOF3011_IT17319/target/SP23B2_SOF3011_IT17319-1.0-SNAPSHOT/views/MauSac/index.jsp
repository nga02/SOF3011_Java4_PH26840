<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/03/2023
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Title</title>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
</head>
<body>
<div class="col-8 offset-2 mt-5">
    <h1 class="text-center"><b>DANH SÁCH MÀU SẮC</b></h1>
    <div class="row">
        <div class="col-6">
            <a href="/SP23B2_SOF3011_IT17319_war_exploded/mau-sac/create" class="btn btn-success">Thêm mới</a>
        </div>
    </div>
    <table class="table mt-3">
        <thead class="table-primary text-center">
        <tr>
            <th scope="col">Ma</th>
            <th scope="col">Tên</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody class="text-center">
        <c:if test="${f:length(ds) == 0}">
            <span>Không có dữ liệu</span>
        </c:if>
        <c:if test="${f:length(ds) != 0}">
            <c:forEach items="${ ds }" var="ms">
                <tr>
                    <td>${ms.ma}</td>
                    <td>${ms.ten}</td>
                    <td>
                        <a href="/SP23B2_SOF3011_IT17319_war_exploded/mau-sac/delete?id=${ms.id}" class="btn btn-danger">Delete</a>
                    </td>
                    <td>
                        <a href="/SP23B2_SOF3011_IT17319_war_exploded/mau-sac/edit?id=${ms.id}" class="btn btn-primary">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</div>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
