<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/03/2023
  Time: 5:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Khách hàng</title>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
    <script>
        function Validate(){
            var ma = document.myForm.ma.value;
            var ho = document.myForm.ho.value;
            var tendem = document.myForm.ten_dem.value;
            var ten = document.myForm.ten.value;
            var diachi = document.myForm.dia_chi.value;
            var ngaysinh = document.myForm.ngay_sinh.value;
            var sdt = document.myForm.sdt.value;
            var mk = document.myForm.mat_khau.value;
            var vnf_regex = /((09|03|07|08|05)+([0-9]{8})\b)/g;
            if(ma==""){
                document.getElementById("error_ma").innerHTML="Không để trống trường mã";
            }
            if(ho==""){
                document.getElementById("error_ho").innerHTML="Không để trống trường họ";
            }
            if(tendem==""){
                document.getElementById("error_tendem").innerHTML="Không để trống trường tên đệm";
            } if(ten==""){
                document.getElementById("error_ten").innerHTML="Không để trống trường tên";
            } if(diachi==""){
                document.getElementById("error_diachi").innerHTML="Không để trống trường địa chỉ";
            } if(ngaysinh==""){
                document.getElementById("error_ngaysinh").innerHTML="Không để trống trường ngày sinh";
            }if(sdt==""){
                document.getElementById("error_sdt").innerHTML="Không để trống trường số điện thoại";
            }else if(!vnf_regex.test(sdt)){
                document.getElementById("error_sdt").innerHTML="Sdt không đúng định dạng";
                return;
            }
            if(mk==""){
                document.getElementById("error_pass").innerHTML="Không để trống trường mật khẩu";
            }
            // else if(mk.length<7 || mk.length>15){
            //     document.getElementById("error_pass").innerHTML="Mật khẩu phải ";
            // }



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
    <form name="myForm" method="POST"
          action="/SP23B2_SOF3011_IT17319_war_exploded/khach-hang/store">
        <div class="row">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" required/>
                <p id="error_ma"></p>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" required/>
                <p id="error_ten"></p>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="tenDem" class="form-control" required/>
                <p id="error_tendem"></p>
            </div>
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control" required/>
                <p id="error_ho"></p>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label>Ngày sinh</label>
                <input type="date" name="ngaySinh" class="form-control" required/>
                <p id="error_date"></p>
            </div>
            <div class="col-6">
                <label>SDT</label>
                <input type="text" name="sdt" class="form-control" required/>
                <p id="error_sdt"></p>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" required/>
                <p id="error_diachi"></p>
            </div>
            <div class="col-6">
                <label>Mật khẩu</label>
                <input type="password" name="matKhau" class="form-control" required/>
                <p id="error_pass"></p>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label>Quốc gia</label>
                <select name="quocGia" class="form-select">
                    <option>Việt Nam</option>
                    <option>Lào</option>
                    <option>Campuchia</option>
                </select>
            </div>
            <div class="col-6">
                <label>Thành phố</label>
                <select name="thanhPho" class="form-select">
                    <option>Hà Nội</option>
                    <option>Đà Nẵng</option>
                </select>
            </div>
        </div>

        <div class="row">
            <div class="col-6">
                <button class="btn btn-primary" onclick="Validate()">Thêm mới</button>
            </div>

        </div>
    </form>
</div>

<script src="/js/bootstrap.min.js"></script>
</body>
</html>
