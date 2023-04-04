<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/03/2023
  Time: 9:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dòng sản phẩm</title>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
    <script>
        function Validate() {
            var ma = document.myForm.ma.value;
            var ten = document.myForm.ten.value;
            if (ma == "") {
                document.getElementById("error_ma").innerHTML = "Không để trống trường mã";
            }
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
    <h1 class="text-center">QUẢN LÝ DÒNG SẢN PHẨM</h1>
    <form name="myForm" method="POST"
          action="/SP23B2_SOF3011_IT17319_war_exploded/dong-sp/store">

        <div class="form-group">
            <label>Mã</label>
            <input type="text" name="ma" class="form-control" required/>
            <p id="error_ma"></p>
        </div>
        <div class="form-group">
            <label>Dòng sản phẩm</label>
            <input type="text" name="ten" class="form-control" required/>
            <p id="error_ten"></p>
        </div>

        <div class="mt-2">
            <div class="col-6">
                <button class="btn btn-primary" onclick="Validate()">Thêm mới</button>

            </div>

        </div>
    </form>
</div>

<script src="/js/bootstrap.min.js"></script>
</body>
</html>