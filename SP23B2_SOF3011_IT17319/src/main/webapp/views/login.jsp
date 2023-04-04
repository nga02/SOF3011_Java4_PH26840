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
</head>
<body>
<div class="alert alert-danger">
    ${ error_message }
</div>
<form action="/SP23B2_SOF3011_IT17319_war_exploded/login" method="post">
    <div>
        <label>Mã KH</label>
        <input type="text" name="ma" />
    </div>
    <div>
        <label>Mật khẩu</label>
        <input type="password" name="matKhau" />
    </div>
    <div>
        <button>Đăng nhập</button>
    </div>
</form>
</body>
</html>
