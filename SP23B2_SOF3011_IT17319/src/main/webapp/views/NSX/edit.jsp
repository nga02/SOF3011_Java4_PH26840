<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/03/2023
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
    <script>
        function Validate() {

            var ten = document.myForm.ten.value;

            if (ten == "") {
                document.getElementById("error_ten").innerHTML = "Không để trống trường tên";
            }
        }
    </script>
    <style>
        .form-group p{
            color: red;
        }
    </style>
</head>
<body>
<div class="col-8 offset-2 mt-3">
    <h1 class="text-center">QUẢN LÝ NHÀ SẢN XUẤT</h1>
    <form name="myForm" method="POST"
          action="/SP23B2_SOF3011_IT17319_war_exploded/nsx/update?id_nsx=${qlnsx.id}">
        <div class="form-group">
            <label>Mã</label>
            <input type="text" name="ma" class="form-control" value="${qlnsx.ma}" disabled/>

        </div>
        <div class="form-group">
            <label>Tên</label>
            <input type="text" name="ten" class="form-control" value="${qlnsx.ten}" required/>
            <p id="error_ten"></p>
        </div>
        <div class="mt-2">
            <div class="col-6">
                <button class="btn btn-primary" onclick="Validate()">Cập nhật</button>
            </div>

        </div>
    </form>
</div>

<script src="/js/bootstrap.min.js"></script>
</body>
</html>
