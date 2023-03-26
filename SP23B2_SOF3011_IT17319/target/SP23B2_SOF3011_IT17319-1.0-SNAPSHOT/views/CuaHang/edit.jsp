<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/03/2023
  Time: 11:08 PM
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
            var ma = document.myForm.ma.value;
            var ten = document.myForm.ten.value;
            var diachi = document.myForm.dia_chi.value;

            if(ma==""){
                document.getElementById("error_ma").innerHTML="Không để trống trường mã";
            }if(ten==""){
                document.getElementById("error_ten").innerHTML="Không để trống trường tên";
            } if(diachi==""){
                document.getElementById("error_diachi").innerHTML="Không để trống trường địa chỉ";
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
    <h1 class="text-center">QUẢN LÝ CỬA HÀNG</h1>
    <form name="myForm" method="POST" action="/SP23B2_SOF3011_IT17319_war_exploded/cua-hang/update?ma=${qlch.ma}">
        <div class="form-group">
            <label>Mã</label>
            <input type="text" name="ma" class="form-control" value="${qlch.ma}" disabled/>
            <p id="error_ma"></p>
        </div>
        <div class="form-group">
            <label>Tên</label>
            <input type="text" name="ten" class="form-control" value="${qlch.ten}" required/>
            <p id="error_ten"></p>
        </div>
        <div class="form-group">
            <label>Địa chỉ</label>
            <input type="text" name="dia_chi" class="form-control" value="${qlch.dia_chi}" required/>
            <p id="error_diachi"></p>
        </div>
        <div class="form-group">
            <label>Thành phố</label>
            <select name="thanh_pho" class="form-select"/>
                <option value="Hà Nội" ${ qlch.thanh_pho == "Hà Nội" ? "selected" : "" } >Hà Nội</option>
                <option value="Đà Nẵng" ${ qlch.thanh_pho == "Đà Nẵng" ? "selected" : "" }>Đà Nẵng</option>
                <option value="Hồ Chí Minh" ${ qlch.thanh_pho == "Hồ Chí Minh" ? "selected" : "" }>Hồ Chí Minh</option>
            </select>
        </div>
        <div class="form-group">
            <label>Quốc gia</label>
            <select name="quoc_gia" class="form-select"/>
                <option value="Việt Nam" ${ qlch.quoc_gia == "Việt Nam" ? "selected" : "" } >Việt Nam</option>
                <option value="Thái Lan" ${ qlch.quoc_gia == "Thái Lan" ? "selected" : "" }>Thái Lan</option>
                <option value="Campuchia" ${ qlch.quoc_gia == "Campuchia" ? "selected" : "" }>Campuchia</option>
            </select>
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
