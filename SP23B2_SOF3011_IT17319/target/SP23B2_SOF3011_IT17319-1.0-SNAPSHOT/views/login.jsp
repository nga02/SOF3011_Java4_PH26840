<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/03/2023
  Time: 5:12 PM
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

<form action="/SP23B2_SOF3011_IT17319_war_exploded/login" method="post">
    <div class="container">
        <div class="row">
            <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                <div class="card border-0 shadow rounded-3 my-5">
                    <div class="card-body p-4 p-sm-5">
                        <h5 class="card-title text-center mb-5 fw-light fs-5">SIGN IN</h5>
                        <form>
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="floatingInput"
                                       placeholder="ma" name = "ma">
                                <label for="floatingInput">Mã người dùng:</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="password" class="form-control" id="floatingPassword" name = "matKhau"
                                       placeholder="Password">
                                <label for="floatingPassword">Password</label>
                            </div>

                            <div class="d-grid">
                                <button class="btn btn-primary btn-login text-uppercase fw-bold text-center" type="submit">Sign
                                    in
                                </button>
                            </div>
                            <div class="alert text-dark">${ error_message }</div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</form>
</body>
</html>
