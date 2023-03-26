<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21/03/2023
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết sản phẩm</title>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
    <style>
        .form-group p{
            color: red;
        }
    </style>
    <script>
        function Validate(){
            var ma = document.myForm.idsp.value.trim();
            var namBH = document.myForm.nam_bh.value.trim();
            var moTa = document.myForm.mo_ta.value.trim();
            var sl_ton = document.myForm.sl_ton.value.trim();
            var gia_nhap = document.myForm.gia_nhap.value.trim();
            var gia_ban = document.myForm.gia_ban.value.trim();

            if(ma==""){
                document.getElementById("error_id").innerHTML="Không để trống trường mã";
            }
            if(namBH==""){
                document.getElementById("error_namBH").innerHTML="Không để trống trường năm bảo hành";
            }
            if(moTa==""){
                document.getElementById("error_mota").innerHTML="Không để trống trường mô tả";
            } if(sl_ton==""){
                document.getElementById("error_slTon").innerHTML="Không để trống trường số lượng tồn";
            } if(gia_nhap==""){
                document.getElementById("error_giaNhap").innerHTML="Không để trống trường giá nhập";
            } if(gia_ban==""){
                document.getElementById("error_giaBan").innerHTML="Không để trống trường giá bán";
            }

        }
    </script>
</head>
<body>
<h1 class="text-center">QUẢN LÝ CHI TIẾT SẢN PHẨM</h1>
<div class="col-8 offset-1 mt-3">
    <form name="myForm" method="POST" action="/SP23B2_SOF3011_IT17319_war_exploded/chitiet-sp/store">
        <div class="form-group">
            <label>Id</label>
            <input type="text" name="idsp" class="form-control" onkeyup="Validate()" required/>
            <p id="error_id"></p>
        </div>
        <div class="form-group">
            <label>Sản phẩm</label>
            <select name="san_pham" class="form-select">
                <option>Sữa rửa mặt</option>
                <option>Kem chống nắng</option>
                <option>Nước tẩy trang</option>
            </select>
        </div>
        <div class="form-group">
            <label>NSX</label>
            <select name="nsx" class="form-select">
                <option>Maybelline</option>
                <option>Shu Uemura</option>
                <option>Estee Lauder</option>
            </select>
        </div>

        <div class="form-group">
            <label>Màu sắc</label>
            <select name="mau_sac" class="form-select">
                <option>Orange</option>
                <option>Blue</option>
                <option>White</option>

            </select>
        </div>
        <div class="form-group">
            <label>Dòng sản phẩm</label>
            <select name="dong_sp" class="form-select">
                <option>Biore</option>
                <option>Bobbi Brown</option>
                <option>Obagi Medical</option>

            </select>
        </div>

        <div class="form-group">
            <label>Năm bảo hành</label>
            <input type="number" min="0" max="100" name="nam_bh" class="form-control" placeholder="" required/>
            <p id="error_namBH"></p>
        </div>

        <div class="form-group">
            <label>Mô tả</label>
            <input type="text" name="mo_ta" class="form-control" onkeyup="Validate()" required/>
            <p id="error_mota"></p>
        </div>
        <div class="form-group">
            <label>Số lượng tồn</label>
            <input type="number" min="0" name="sl_ton" class="form-control" onkeyup="Validate()" required/>
            <p id="error_slTon"></p>
        </div>

        <div class="form-group">
            <label>Giá nhập</label>
            <input type="number" min="0" name="gia_nhap" class="form-control" onkeyup="Validate()" required/>
            <p id="error_giaNhap"></p>
        </div>
        <div class="form-group">
            <label>Giá bán</label>
            <input type="number" min="0" name="gia_ban" class="form-control" onkeyup="Validate()" required/>
            <p id="error_giaBan"></p>
        </div>
        <div class="row">
            <div class="col-6 text-center">
                <button class="btn btn-primary" onclick="Validate()">Thêm mới</button>

            </div>
        </div>
    </form>
</div>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
