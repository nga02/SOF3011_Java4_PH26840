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
    <title>Chi tiết sản phẩm</title>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
    <style>
        .form-group p {
            color: red;
        }
    </style>
    <script>
        function Validate() {

            var namBH = document.myForm.idNamBH.value.trim();
            var moTa = document.myForm.mota.value.trim();
            var sl_ton = document.myForm.soLuongTon.value.trim();
            var gia_nhap = document.myForm.giaNhap.value.trim();
            var gia_ban = document.myForm.giaBan.value.trim();


            if (namBH == "") {
                document.getElementById("error_namBH").innerHTML = "Không để trống trường năm bảo hành";
            }
            if (moTa == "") {
                document.getElementById("error_mota").innerHTML = "Không để trống trường mô tả";
            }
            if (sl_ton == "") {
                document.getElementById("error_slTon").innerHTML = "Không để trống trường số lượng tồn";
            }
            if (gia_nhap == "") {
                document.getElementById("error_giaNhap").innerHTML = "Không để trống trường giá nhập";
            }
            if (gia_ban == "") {
                document.getElementById("error_giaBan").innerHTML = "Không để trống trường giá bán";
            }

        }
    </script>
</head>
<body>
<h1 class="text-center">QUẢN LÝ CHI TIẾT SẢN PHẨM</h1>
<div class="col-8 offset-1 mt-3">
    <form name="myForm" method="POST" action="/SP23B2_SOF3011_IT17319_war_exploded/chitiet-sp/store">
        <%--        <div class="form-group">--%>
        <%--            <label>Sản phẩm</label>--%>
        <%--            <input type="text" name="idsp" class="form-control" onkeyup="Validate()" required/>--%>
        <%--            <p id="error_id"></p>--%>
        <%--        </div>--%>
        <div class="form-group">
            <label>Sản phẩm</label>
            <select name="id_SP" class="form-select">
                <c:forEach items="${ lstSP }" var="sp">
                    <option value="${sp.id}">${sp.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>NSX</label>
                <select name="id_Nsx" class="form-select">
                    <c:forEach items="${ lstNSX }" var="nsx">
                        <option value="${nsx.id}">${nsx.ten}</option>
                    </c:forEach>
                </select>
        </div>

        <div class="form-group">
            <label>Màu sắc</label>
            <select name="id_MauSac" class="form-select">
                <c:forEach items="${ lstMauSac }" var="ms">
                    <option value="${ms.id}">${ms.ten}</option>
                </c:forEach>

            </select>
        </div>
        <div class="form-group">
            <label>Dòng sản phẩm</label>
            <select name="id_DongSP" class="form-select">
                <c:forEach items="${ lstDongSP }" var="dsp">
                    <option value="${dsp.id}">${dsp.ten}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Năm bảo hành</label>
            <input type="number" min="0" max="100" name="namBH" class="form-control" placeholder="" required/>
            <p id="error_namBH"></p>
        </div>

        <div class="form-group">
            <label>Mô tả</label>
            <input type="text" name="mota" class="form-control" onkeyup="Validate()" required/>
            <p id="error_mota"></p>
        </div>
        <div class="form-group">
            <label>Số lượng tồn</label>
            <input type="number" min="0" name="soLuongTon" class="form-control" onkeyup="Validate()" required/>
            <p id="error_slTon"></p>
        </div>

        <div class="form-group">
            <label>Giá nhập</label>
            <input type="number" min="0" name="giaNhap" class="form-control" onkeyup="Validate()" required/>
            <p id="error_giaNhap"></p>
        </div>
        <div class="form-group">
            <label>Giá bán</label>
            <input type="number" min="0" name="giaBan" class="form-control" onkeyup="Validate()" required/>
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
