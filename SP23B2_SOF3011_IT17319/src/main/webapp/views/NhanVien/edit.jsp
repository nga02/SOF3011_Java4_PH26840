<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/03/2023
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nhân viên</title>
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
                document.getElementById("error_mk").innerHTML="Không để trống trường mật khẩu";
            }
            // else if(mk.length<7 || mk.length>15){
            //     document.getElementById("error_pass").innerHTML="Mật khẩu phải ";
            // }
        }
    </script>
    <style>
        .col-6 p{
            color: red;
        }
    </style>
</head>
<body>
<h1 class="text-center">QUẢN LÝ NHÂN VIÊN</h1>
<div class="col-9 offset-1 mt-3">
    <form name="myForm" method="POST"
          action="/SP23B2_SOF3011_IT17319_war_exploded/nhan-vien/update?ma=${qlnv.ma}">
        <div class="row">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${qlnv.ma}" disabled/>
                <p id="error_ma"></p>
            </div>
            <div class="col-6">
                <label>Sđt</label>
                <input type="text" name="sdt" class="form-control" value="${qlnv.sdt}" required/>
                <p id="error_sdt"></p>
            </div>
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control" value="${qlnv.ho}" required/>
                <p id="error_ho"></p>
            </div>
            <div class="col-6">
                <label>Ngày sinh</label>
                <input type="date" name="ngay_sinh" class="form-control" value="${qlnv.ngay_sinh}" required/>
                <p id="error_ngaysinh"></p>
            </div>
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="ten_dem" class="form-control" value="${qlnv.ten_dem}" required/>
                <p id="error_tendem"></p>
            </div>
            <div class="col-6">
                <label>Mật khẩu</label>
                <input type="text" name="mat_khau" class="form-control" value="${qlnv.mat_khau}" required/>
                <p id="error_mk"></p>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${qlnv.ten}" required/>
                <p id="error_ten"></p>
            </div>
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="dia_chi" class="form-control" value="${qlnv.dia_chi}" required/>
                <p id="error_diachi"></p>
            </div>
            <div class="col-6 mt-2">
                <label>Cửa hàng</label>
                <select name="id_ch" class="form-select"/>
                <option value="Cửa hàng 1" ${ qlnv.id_ch == "Cửa hàng 1" ? "selected" : "" } >Cửa hàng 1</option>
                <option value="Cửa hàng 2" ${ qlnv.id_ch == "Cửa hàng 2" ? "selected" : "" } >Cửa hàng 2</option>
                <option value="Cửa hàng 3" ${ qlnv.id_ch == "Cửa hàng 3" ? "selected" : "" } >Cửa hàng 3</option>
                </select>
            </div>
            <div class="col-6 mt-2">
                <label>Chức vụ</label>
                <select name="id_cv" class="form-select">
                    <option value="Nhân viên" ${ qlnv.id_ch == "Nhân viên" ? "selected" : "" } >Nhân viên</option>
                    <option value="Quản lý" ${ qlnv.id_ch == "Quản lý" ? "selected" : "" } >Quản lý</option>
                    <option value="Trưởng phòng" ${ qlnv.id_ch == "Trưởng phòng" ? "selected" : "" } >Trưởng phòng
                    </option>
                </select>
            </div>
            <div class="col-6">
                <label>Giới tính:</label>
                <div>
                    <input type="radio" id="nam" name="gioi_tinh" value="Nam" ${qlnv.gioi_tinh == "Nam" ?"checked":""}/>
                    <label>Nam</label>
                    <input type="radio" id="nu" name="gioi_tinh" value="Nữ" ${qlnv.gioi_tinh == "Nữ" ?"checked":""}>
                    <label>Nữ</label>
                </div>
            </div>
            <div class="col-6">
                <label>Trạng thái</label>
                <input type="radio" name="trang_thai" value="0" ${qlnv.trang_thai == "0" ?"checked":""} checked/>Đang
                hoạt động
                <input type="radio" name="trang_thai" value="1" ${qlnv.trang_thai == "1" ?"checked":""} />Không hoạt
                động
            </div>
        </div>
        <div class="row">
            <div class="col-6 text-center">
                <button class="btn btn-primary" onclick="Validate()">Cập nhật</button>
            </div>
        </div>
    </form>
</div>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>