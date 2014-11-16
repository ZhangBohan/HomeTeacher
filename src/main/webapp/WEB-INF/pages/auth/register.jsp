<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:if test="${not empty message}">
        <div class="alert alert-${message.type}">
                ${message.message}
        </div>
    </c:if>
    <div class="header">注册</div>
    <form action="" method="post">
        <div class="body bg-gray">
            <div class="form-group">
                <input type="radio" name="account" value="0" <c:if test="${form.account == 0}">checked="" </c:if>>&nbsp;我是用户&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="radio"  name="account" value="1" <c:if test="${form.account == 1}">checked="" </c:if>>&nbsp;我是教员
            </div>
            <div class="form-group">
                <input type="text" name="phone" id="username" class="form-control" placeholder="手机号" value="${form.phone}" />
            </div>
            <div class="form-group">
                <input type="text" name="verifyCode" class="form-control span1" placeholder="验证码" />
                <button type="button" class="btn btn-default" id="verify-send">发送验证码</button>
            </div>
            <div class="form-group">
                <input type="text" name="name" id="name" class="form-control" placeholder="姓名" value="${form.name}" />
            </div>
            <div class="form-group">
                <input type="password" name="password" class="form-control" placeholder="密码" />
            </div>
            <div class="form-group">
                <input type="password" name="repeatPassword" class="form-control" placeholder="确认密码" />
            </div>
        </div>
        <div class="footer">
            <button type="submit" class="btn bg-olive btn-block">注册</button>

            <p>
                已有账号？<a href="/auth/login/teacher" class="text-center">登录</a>
            </p>
        </div>
    </form>
</div>


<!-- jQuery 2.0.2 -->
<script src="/public/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="/public/js/bootstrap.min.js" type="text/javascript"></script>
<script>
    $(function () {
        $("#verify-send").click(function () {
            var phone = $("#username").val();

            $.ajax({
                url: '/auth/verify/' + phone,
                success: function () {
                    console.debug('send message success!');
                    // 禁用发送并倒数60秒
                    $("#verify-send").attr('disabled','disabled');

                    var seconds = 60;
                    function tick() {
                        seconds--;
                        $("#verify-send").text("已发送（" + seconds + "秒）");
                        if( seconds > 0 ) {
                            setTimeout(tick, 1000);
                        } else {
                            $("#verify-send").removeAttr('disabled');
                            $("#verify-send").text("重新发送");
                        }
                    }
                    tick();
                },
                error: function (XMLHttpRequest) {
                    console.log(XMLHttpRequest.responseText);
                    alert(XMLHttpRequest.responseText);
                }
            });
        });

        $("#username").blur(function () {
            var phone = $("#username").val();
            console.log('phone', phone);
            if(!/1[3458]\d{9}/g.test(phone)) {
                alert("手机号非法");
            } else {
                $.ajax({
                    url: '/auth/phones/' + phone,
                    success: function () {
                        console.debug('send message success!');
                        // 验证成功
                    },
                    error: function (XMLHttpRequest) {
                        console.log(XMLHttpRequest.responseText);
                        alert(XMLHttpRequest.responseText);
                    }
                });
            }
        });
    });
</script>
</body>
</html>