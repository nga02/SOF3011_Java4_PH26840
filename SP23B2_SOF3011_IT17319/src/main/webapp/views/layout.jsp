<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/03/2023
  Time: 11:09 AM
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
    <link rel="stylesheet" href="/views/ass.css">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <a class="navbar-brand" href="javascript:void(0)"><img
                    src="https://img.watsonsvn.com/ecommerce/ecom/Watsons/WatsonsVietnam.jpg" alt="" width="150"
                    height="50"/></a>
            <div class="collapse navbar-collapse" id="mynavbar" style="margin-left: 30px">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link text-black" aria-current="page" href="/SP23B2_SOF3011_IT17319_war_exploded/admin"><span
                                class="glyphicon  glyphicon-list "></span>Trang chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-black" href="/SP23B2_SOF3011_IT17319_war_exploded/admin"><span
                                class="glyphicon glyphicon-earphone"></span>Giới thiệu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-black" href="/SP23B2_SOF3011_IT17319_war_exploded/admin"><span
                                class="glyphicon glyphicon-envelope "></span>Liên hệ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-black" href="/SP23B2_SOF3011_IT17319_war_exploded/admin"><span
                                class="glyphicon glyphicon-envelope"></span>Blog</a>
                    </li>

<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link text-black" href="/SP23B2_SOF3011_IT17319_war_exploded/nhan-vien/index"><span--%>
<%--                                class="glyphicon glyphicon-envelope "></span>NHÀ SẢN XUẤT</a>--%>
<%--                    </li>--%>
                </ul>
            </div>


            <form class="d-flex justify-content-center" role="search">
                <input class="form-control me-2 col-6 mt-1" type="search" style=" width: 400px;
                    margin-right:10px;
                    border-color: rebeccapurple;" placeholder="Search" aria-label="Search">
                <button class="btn btn- btn-primary" style="width: 100px; margin-right: 20px"
                        type="submit">Search
                </button>
            </form>

            <button class="btn btn-black" style="border: none; border-radius: 5px">
                <a class="nav-link text-black" href="#giohang">
                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="25" fill="currentColor"
                         class="bi bi-cart-check-fill" viewBox="0 0 16 16">
                        <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm-1.646-7.646-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L8 8.293l2.646-2.647a.5.5 0 0 1 .708.708z"/>
                    </svg>
                    <!-- <img src="https://img.icons8.com/emoji/256/shopping-cart-emoji.png" id="dagger" width="30px" /> -->
                </a>
            </button>

        </div>
    </div>
</nav>


<div class="row">
    <div class="col-3">
        <div class="card mt-2" style="width: 23rem;">
            <div class="card-header" style="background-color: #43bdbf;">
                <h4>QUẢN LÝ DANH MỤC</h4>
            </div>
            <div class="list-group">
                <a href="/SP23B2_SOF3011_IT17319_war_exploded/chuc-vu/index" class="list-group-item list-group-item-action">CHỨC VỤ</a>
                <a href="/SP23B2_SOF3011_IT17319_war_exploded/nhan-vien/index" class="list-group-item list-group-item-action">NHÂN VIÊN</a>
                <a href="/SP23B2_SOF3011_IT17319_war_exploded/khach-hang/index" class="list-group-item list-group-item-action">KHÁCH HÀNG</a>
                <a href="/SP23B2_SOF3011_IT17319_war_exploded/cua-hang/index" class="list-group-item list-group-item-action">CỬA HÀNG</a>
                <a href="/SP23B2_SOF3011_IT17319_war_exploded/san-pham/index" class="list-group-item list-group-item-action">SẢN PHẨM</a>
                <a href="/SP23B2_SOF3011_IT17319_war_exploded/dong-sp/index" class="list-group-item list-group-item-action">DÒNG SẢN PHẨM</a>
                <a href="/SP23B2_SOF3011_IT17319_war_exploded/mau-sac/index" class="list-group-item list-group-item-action">MÀU SẮC</a>
                <a href="/SP23B2_SOF3011_IT17319_war_exploded/nsx/index" class="list-group-item list-group-item-action">NHÀ SẢN XUẤT</a>
                <a href="/SP23B2_SOF3011_IT17319_war_exploded/chitiet-sp/index" class="list-group-item list-group-item-action">CHI TIẾT SẢN PHẨM</a>
            </div>
        </div>
    </div>
    <div class="col-9" style="min-height: 600px">
        <jsp:include page="${ view }"></jsp:include>
    </div>
</div>

<div class="container-flex mt-2">
    <footer class="text-white text-center text-lg-start bg-secondary">
        <!-- Grid container -->
        <div class="container p-1">
            <!--Grid row-->
            <div class="row mt-4">
                <div class="col-lg-3 col-md-12 mb-4 mb-md-0">
                    <h5 class="text-uppercase mb-4">ADDRESS</h5>
                    <div id="map-container-google-1" class="z-depth-1-half map-container" style="height: 200px">
                        <iframe src="https://www.google.com/maps/embed/v1/place?key=AIzaSyA0s1a7phLN0iaD6-UE7m4qP-z21pH0eSc&q=47+Ngõ+99+Cầu+Diễn,+Phúc+Diễn,+Bắc+Từ+Liêm,+Hà+Nội,+Vietnam"
                                frameborder="0"
                                style="border:0" allowfullscreen></iframe>
                    </div>
                </div>
                <!--Grid column-->
                <div class="col-lg-3 col-md-12 mb-4 mb-md-0">
                    <h5 class="text-uppercase mb-4">About company</h5>

                    <p>Ở đây tôi bán mỹ phẩm!</p>

                    <p>Mua thì liên hệ tui</p>

                    <div class="mt-4">
                        <!-- Facebook -->
                        <a class="btn btn-floating btn-warning btn-lg"
                           href="https://www.facebook.com/profile.php?id=100028194530646"><i
                                class="fab fa-facebook-f"></i></a>
                        <!-- Dribbble -->
                        <a class="btn btn-floating btn-warning btn-lg"><i class="fab fa-dribbble"></i></a>
                        <!-- Twitter -->
                        <a class="btn btn-floating btn-warning btn-lg"><i class="fab fa-twitter"></i></a>
                        <!-- Google + -->
                        <a class="btn btn-floating btn-warning btn-lg"><i class="fab fa-google-plus-g"></i></a>
                        <!-- Linkedin -->
                    </div>
                </div>
                <!--Grid column-->

                <!--Grid column-->
                <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                    <h5 class="text-uppercase mb-4 pb-1">Email</h5>

                    <div class="form-outline form-white mb-4">
                        <input type="email" id="formControlLg" class="form-control form-control-lg"
                               placeholder="@example.com.vn"/>
                        <br/>
                        <button class="btn btn-primary">Submit</button>
                        <div class="form-notch">
                            <div class="form-notch-leading" style="width: 9px"></div>
                            <div class="form-notch-middle" style="width: 48.8px"></div>
                            <div class="form-notch-trailing"></div>
                        </div>
                    </div>

                    <ul class="fa-ul" style="margin-left: 1.65em">
                        <li class="mb-3">
                            <span class="fa-li"><i class="fas fa-home"></i></span><span class="ms-2">New York, NY 10012,
                                US</span>
                        </li>
                        <li class="mb-3">
                            <span class="fa-li"><i class="fas fa-envelope"></i></span><span class="ms-2"><a href="#"
                                                                                                            style="color: azure;">ngaltph26840@fpt.edu.vn</a></span>
                        </li>
                        <li class="mb-3">
                            <span class="fa-li"><i class="fas fa-phone"></i></span><span class="ms-2">+ 01 234 567
                                88</span>
                        </li>
                        <li class="mb-3">
                            <span class="fa-li"><i class="fas fa-print"></i></span><span class="ms-2">+ 01 234 567
                                89</span>
                        </li>
                    </ul>
                </div>
                <!--Grid column-->

                <!--Grid column-->
                <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                    <h5 class="text-uppercase mb-4">Opening hours</h5>

                    <table class="table text-center text-white">
                        <tbody class="font-weight-normal">
                        <tr>
                            <td>Mon - Thu:</td>
                            <td>8am - 9pm</td>
                        </tr>
                        <tr>
                            <td>Fri - Sat:</td>
                            <td>8am - 1am</td>
                        </tr>
                        <tr>
                            <td>Sunday:</td>
                            <td>9am - 10pm</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!--Grid column-->
            </div>
            <!--Grid row-->
        </div>
        <!-- Grid container -->

        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2)">

            <a class="text-white" href="https://github.com/nga02">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-github"
                     viewBox="0 0 16 16">
                    <path d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.012 8.012 0 0 0 16 8c0-4.42-3.58-8-8-8z"/>
                </svg>
                ngaltph26840</a>
        </div>
        <!-- Copyright -->
    </footer>
</div>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
