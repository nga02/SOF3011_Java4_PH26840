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
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
    <script>
        function Validate(){
            var ma = document.myForm.idsp.value;
            var namBH = document.myForm.nam_bh.value;
            var moTa = document.myForm.mo_ta.value;
            var sl_ton = document.myForm.sl_ton.value;
            var gia_nhap = document.myForm.gia_nhap.value;
            var gia_ban = document.myForm.gia_ban.value;

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
    <style>
        .form-group p{
            color: red;
        }
    </style>
</head>
<body>
<h1 class="text-center">QUẢN LÝ CHI TIẾT SẢN PHẨM</h1>
<div class="col-8 offset-1 mt-3">
    <form name="myForm" method="POST"
          action="/SP23B2_SOF3011_IT17319_war_exploded//chitiet-sp/update?idsp=${ ctsp.idsp }">

        <div class="form-group">
            <label>Id</label>
            <input type="text" name="idsp" class="form-control" value="${ctsp.idsp}" disabled/>
            <p id="error_id"></p>
        </div>
        <div class="form-group">
            <label>Sản phẩm</label>
            <select name="san_pham" class="form-select">
                <option value="Sữa rửa mặt" ${ctsp.san_pham=="Sữa rửa mặt"?"selected":""}>Sữa rửa mặt</option>
                <option value="Kem chống nắng" ${ctsp.san_pham=="Kem chống nắng"?"selected":""}>Kem chống nắng</option>
                <option value="Nước tẩy trang" ${ctsp.san_pham=="Nước tẩy trang"?"selected":""}>Nước tẩy trang</option>
            </select>
        </div>
        <div class="form-group">
            <label>NSX</label>
            <select name="nsx" class="form-select">
                <option value="Maybelline" ${ctsp.nsx=="Maybelline"?"selected":""}>Maybelline</option>
                <option value="Shu Uemura" ${ctsp.nsx=="Shu Uemura"?"selected":""}>Shu Uemura</option>
                <option value="Estee Lauder" ${ctsp.nsx=="Estee Lauder"?"selected":""}>Estee Lauder</option>
            </select>
        </div>
        <div class="form-group">
            <label>Màu sắc</label>
            <select name="mau_sac" class="form-select">
                <option value="Orange" ${ctsp.san_pham=="Orange"?"selected":""}>Orange</option>
                <option value="Blue" ${ctsp.san_pham=="Blue"?"selected":""}>Blue</option>
                <option value="White" ${ctsp.san_pham=="White"?"selected":""}>White</option>

            </select>
        </div>
        <div class="form-group">
            <label>Dòng sản phẩm</label>
            <select name="dong_sp" class="form-select">
                <option value="Biore" ${ctsp.dong_sp=="Biore"?"selected":""}>Biore</option>
                <option value="Bobbi Brown" ${ctsp.dong_sp=="Bobbi Brown"?"selected":""}>Bobbi Brown</option>
                <option value="Obagi Medical" ${ctsp.dong_sp=="Obagi Medical"?"selected":""}>Obagi Medical</option>

            </select>
        </div>

        <div class="form-group">
            <label>Năm bảo hành</label>
            <input type="number" name="nam_bh" class="form-control" value="${ctsp.nam_bh}" onkeyup="Validate()" required/>
            <p id="error_namBH"></p>
        </div>

        <div class="form-group">
            <label>Mô tả</label>
            <input type="text" name="mo_ta" class="form-control" value="${ctsp.mo_ta}" onkeyup="Validate()" required/>
            <p id="error_mota"></p>
        </div>
        <div class="form-group">
            <label>Số lượng tồn</label>
            <input type="number" name="sl_ton" class="form-control" value="${ctsp.sl_ton}" onkeyup="Validate()" required/>
            <p id="error_slTon"></p>
        </div>

        <div class="form-group">
            <label>Giá nhập</label>
            <input type="text" name="gia_nhap" class="form-control" value="${ctsp.gia_nhap}" onkeyup="Validate()" required/>
            <p id="error_giaNhap"></p>
        </div>
        <div class="form-group">
            <label>Giá bán</label>
            <input type="text" name="gia_ban" class="form-control" value="${ctsp.gia_ban}"  onkeyup="Validate()" required/>
            <p id="error_giaBan"></p>
        </div>
        <div class="row">
            <div class="col-6 text-center">
                <button class="btn btn-primary" onclick="Validate()">Update</button>

            </div>
        </div>
    </form>
</div>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
