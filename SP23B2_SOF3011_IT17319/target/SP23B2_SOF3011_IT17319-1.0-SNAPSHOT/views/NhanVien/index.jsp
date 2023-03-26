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
    <h1 class="text-center"><b>DANH SÁCH NHÂN VIÊN</b></h1>
    <div class="row">
        <div class="col-6">
            <a href="/SP23B2_SOF3011_IT17319_war_exploded/nhan-vien/create" class="btn btn-success">Thêm mới</a>
        </div>
    </div>
    <table class="table mt-3 table-responsive">
        <thead class="table-primary text-center m-5">
        <tr>
            <th scope="col">Ma</th>
            <th scope="col">Họ</th>
            <th scope="col">Tên</th>
            <th scope="col">Tên đệm</th>
            <th scope="col">Giới tính</th>
            <th scope="col">Ngày sinh</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Sđt</th>
            <th scope="col">Mật khẩu</th>
            <th scope="col">Cửa hàng</th>
            <th scope="col">Chức vụ</th>
            <th scope="col">Trạng thái</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody class="text-center">
        <c:if test="${f:length(ds) == 0}">
            <span>Không có dữ liệu</span>
        </c:if>
        <c:if test="${f:length(ds) != 0}">
            <c:forEach items="${ ds }" var="nv">
                <tr>
                    <td>${ nv.ma }</td>
                    <td>${ nv.ho }</td>
                    <td>${ nv.ten_dem}</td>
                    <td>${ nv.ten }</td>
                    <td>${ nv.gioi_tinh}</td>
                    <td>${ nv.ngay_sinh}</td>
                    <td>${ nv.dia_chi}</td>
                    <td>${ nv.sdt}</td>
                    <td>${ nv.mat_khau}</td>
                    <td>${ nv.id_ch}</td>
                    <td>${ nv.id_cv}</td>
                    <td>
                        <c:if test="${nv.trang_thai == 0}">Đang hoạt động</c:if>
                        <c:if test="${nv.trang_thai == 1}">Không hoạt động</c:if>
                    </td>
                    <td>
                        <a href="/SP23B2_SOF3011_IT17319_war_exploded/nhan-vien/delete?ma=${nv.ma}"
                           class="btn btn-danger">Delete</a>
                    </td>
                    <td>
                        <a href="/SP23B2_SOF3011_IT17319_war_exploded/nhan-vien/edit?ma=${nv.ma}"
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
