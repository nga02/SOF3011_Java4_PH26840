<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/03/2023
  Time: 5:27 PM
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
    <h1 class="text-center"><b>DANH SÁCH KHÁCH HÀNG</b></h1>
    <div class="row">
        <div class="col-6">
            <a href="/SP23B2_SOF3011_IT17319_war_exploded/khach-hang/create" class="btn btn-success">Thêm mới</a>
        </div>
    </div>
    <table class="table mt-3 table-responsive">
        <thead class="table-primary text-center">
        <tr>
            <th>Mã</th>
            <th>Họ</th>
            <th>Tên đệm</th>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>SDT</th>
            <th>Địa chỉ</th>
            <th>Thành phố</th>
            <th>Quốc gia</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody class="text-center">
            <c:if test="${f:length(ds) == 0}">
                <span>Không có dữ liệu</span>
            </c:if>
            <c:if test="${f:length(ds) != 0}">
                <c:forEach items="${ ds }" var="kh">
                    <tr>
                        <td>${ kh.ma }</td>
                        <td>${ kh.ho }</td>
                        <td>${ kh.tenDem}</td>
                        <td>${ kh.ten }</td>
                        <td>${ kh.ngaySinh }</td>
                        <td>${ kh.sdt }</td>
                        <td>${ kh.diaChi }</td>
                        <td>${ kh.thanhPho }</td>
                        <td>${ kh.quocGia }</td>
                        <td>
                            <a href="/SP23B2_SOF3011_IT17319_war_exploded/khach-hang/edit?id=${ kh.id }" class="btn btn-primary">Update</a>
                        </td>
                        <td>
                            <a href="/SP23B2_SOF3011_IT17319_war_exploded/khach-hang/delete?id=${ kh.id }" class="btn btn-danger">Delete</a>
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
