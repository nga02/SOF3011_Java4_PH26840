<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/03/2023
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nhà sản xuất</title>
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
</head>
<body>
<div class="col-8 offset-2 mt-3">
    <h1 class="text-center">QUẢN LÝ NSX</h1>
    <form name="myForm" method="POST"
          action="/SP23B2_SOF3011_IT17319_war_exploded/nsx/store">
        <div class="row">
            <div class="form-group">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" required/>
                <p id="error_ma"></p>
            </div>
            <div class="form-group">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" required/>
                <p id="error_ten"></p>
            </div>
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