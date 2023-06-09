<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21/03/2023
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
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
        function Validate() {

            var namBH = document.myForm.namBH.value.trim();
            var moTa = document.myForm.mota.value.trim();
            var sl_ton = document.myForm.soLuongTon.value.trim();
            var gia_nhap = document.myForm.giaNhap.value.trim();
            var gia_ban = document.myForm.giaBan.value.trim();


            if (namBH == "") {
                document.getElementById("error_namBH").innerHTML = "Không để trống trường năm bảo hành";
            }else if(namBH < 0){
                document.getElementById("error_namBH").innerHTML = "Năm bảo hành phải lớn hơn hoặc bằng 0";
            }
            else if (moTa == "") {
                document.getElementById("error_mota").innerHTML = "Không để trống trường mô tả";
            }
            else  if (sl_ton == "") {
                document.getElementById("error_slTon").innerHTML = "Không để trống trường số lượng tồn";
            }
            else if (gia_nhap == "") {
                document.getElementById("error_giaNhap").innerHTML = "Không để trống trường giá nhập";
            }else if(gia_nhap < 0){
                document.getElementById("error_giaNhap").innerHTML = "Giá nhập phải lớn hơn 0";
            }
            else if (gia_ban == "") {
                document.getElementById("error_giaBan").innerHTML = "Không để trống trường giá bán";
            }else if(gia_ban < 0){
                document.getElementById("gia_ban").innerHTML = "Giá bán phải lớn hơn 0";
            }else if(gia_nhap < gia_ban){
                document.getElementById("gia_ban").innerHTML = "Giá bán phải lớn hơn hoặc bằng giá nhập";
            }

        }
    </script>
</head>
<body>
<h1 class="text-center">QUẢN LÝ CHI TIẾT SẢN PHẨM</h1>
<div class="col-8 offset-1 mt-3">
    <form method="POST"
          action="/SP23B2_SOF3011_IT17319_war_exploded//chitiet-sp/update?id_ctsp=${ctsp.id}">

        <div class="form-group">
            <label>Id</label>
            <input type="text" name="id" class="form-control" value="${ctsp.id}" disabled/>
            <p id="error_id"></p>
        </div>
        <div class="form-group">
            <label>Sản phẩm</label>
            <select name="id_SP" class="form-select">
                <c:forEach items="${ lstSP }" var="sp">
                    <option value="${sp.id}" ${sp.id == ctsp.idSP.id?"selected":""}>${sp.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>NSX</label>
            <select name="id_Nsx" class="form-select">
                <c:forEach items="${ lstNSX }" var="nsx">
                    <option value="${nsx.id}" ${nsx.id == ctsp.idNsx.id?"selected":""}>${nsx.ten}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Màu sắc</label>
            <select name="id_MauSac" class="form-select">
                <c:forEach items="${ lstMauSac }" var="ms">
                    <option value="${ms.id}" ${ms.id == ctsp.idMauSac.id?"selected":""}>${ms.ten}</option>
                </c:forEach>

            </select>
        </div>
        <div class="form-group">
            <label>Dòng sản phẩm</label>
            <select name="id_DongSP" class="form-select">
                <c:forEach items="${ lstDongSP }" var="dsp">
                    <option value="${dsp.id}" ${dsp.id == ctsp.idDongSP.id?"selected":""}>${dsp.ten}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Năm bảo hành</label>
            <input type="number" name="namBH" class="form-control" value="${ctsp.namBH}" required/>
            <p id="error_namBH"></p>
        </div>

        <div class="form-group">
            <label>Mô tả</label>
            <input type="text" name="mota" class="form-control" value="${ctsp.mota}" required/>
            <p id="error_mota"></p>
        </div>
        <div class="form-group">
            <label>Số lượng tồn</label>
            <input type="number" name="soLuongTon" class="form-control" value="${ctsp.soLuongTon}" required/>
            <p id="error_slTon"></p>
        </div>

        <div class="form-group">
            <label>Giá nhập</label>
            <input type="text" name="giaNhap" class="form-control" value="${ctsp.giaNhap}" required/>
            <p id="error_giaNhap"></p>
        </div>
        <div class="form-group">
            <label>Giá bán</label>
            <input type="text" name="giaBan" class="form-control" value="${ctsp.giaBan}"  required/>
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
