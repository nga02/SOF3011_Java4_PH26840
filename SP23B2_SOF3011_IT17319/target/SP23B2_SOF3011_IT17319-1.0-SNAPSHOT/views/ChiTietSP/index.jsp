<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21/03/2023
  Time: 8:37 PM
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
    <h1 class="text-center"><b>DANH SÁCH CHI TIẾT SẢN PHẨM</b></h1>
    <div class="row">
        <div class="col-6">
            <a href="/SP23B2_SOF3011_IT17319_war_exploded/chitiet-sp/create" class="btn btn-success">Thêm mới</a>
        </div>
    </div>
    <table class="table mt-3 table-responsive">
        <thead class="table-primary text-center m-5">
        <tr>
            <th scope="col">Sản phẩm</th>
            <th scope="col">Nhà SX</th>
            <th scope="col">Màu sắc</th>
            <th scope="col">Dòng SP</th>
            <th scope="col">Năm BH</th>
            <th scope="col">Mô tả</th>
            <th scope="col">SL tồn</th>
            <th scope="col">Giá nhập</th>
            <th scope="col">Giá bán</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody class="text-center">
        <c:if test="${f:length(ds) == 0}">
            <span>Không có dữ liệu</span>
        </c:if>
        <c:if test="${f:length(ds) != 0}">
            <c:forEach items="${ ds }" var="ctsp">
                <tr>
                    <td>${ ctsp.san_pham }</td>
                    <td>${ ctsp.nsx }</td>
                    <td>${ ctsp.mau_sac }</td>
                    <td>${ ctsp.dong_sp }</td>
                    <td>${ ctsp.nam_bh }</td>
                    <td>${ ctsp.mo_ta }</td>
                    <td>${ ctsp.sl_ton }</td>
                    <td>${ ctsp.gia_nhap }</td>
                    <td>${ ctsp.gia_ban }</td>

                    <td>
                        <a href="/SP23B2_SOF3011_IT17319_war_exploded/chitiet-sp/delete?idsp=${ctsp.idsp}"
                           class="btn btn-danger">Delete</a>
                    </td>
                    <td>
                        <a href="/SP23B2_SOF3011_IT17319_war_exploded/chitiet-sp/edit?idsp=${ctsp.idsp}"
                           class="btn btn-primary">Update</a>
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
