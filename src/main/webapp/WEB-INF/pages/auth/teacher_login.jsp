<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="bg-light-blue">
<head>
    <meta charset="UTF-8">
    <title>AdminLTE | Log in</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- bootstrap 3.0.2 -->
    <link href="/public/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- font Awesome -->
    <link href="/public/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="/public/css/AdminLTE.css" rel="stylesheet" type="text/css" />
    <style>
        .header-link {
            color: #ffffff;
            font-size: 18px;
        }
        .header-link :hover, .header-link :visited, .header-link :focus {
            text-decoration: none;
        }
    </style>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

</head>
<body class="bg-light-blue">

<div class="form-box" id="login-box">
    <div class="header">用户登录 | <a class="header-link" href="#">教员点我登录</a></div>
    <form action="/teachers/j_spring_security_check" method="post">
        <div class="body bg-gray">
            <div class="form-group">
                <input type="text" name="username" class="form-control" placeholder="用户名" value="bohan" />
            </div>
            <div class="form-group">
                <input type="password" name="password" class="form-control" placeholder="密码" value="123456"/>
            </div>
            <div class="form-group">
                <input type="checkbox" name="remember_me"/> 记住我
            </div>
        </div>
        <div class="footer">
            <button type="submit" class="btn bg-olive btn-block">登录</button>

            <p><a href="#">忘记密码</a></p>

            <a href="register.html" class="text-center">注册</a>
        </div>
    </form>
</div>


<!-- jQuery 2.0.2 -->
<script src="/public/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="/public/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>