<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>AdminLTE | Dashboard</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- bootstrap 3.0.2 -->
    <link href="/public/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- font Awesome -->
    <link href="/public/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="/public/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="/public/css/AdminLTE.css" rel="stylesheet" type="text/css" />
    <link href="/public/css/styles.css" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body class="skin-blue">
<!-- header logo: style can be found in header.less -->
<header class="header">
<nav class="navbar navbar-static-top" role="navigation">
<div class="navbar-left">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <div class="navbar-brand">
            家教你好
        </div>
    </div>
    <ul class="nav navbar-nav">
        <li class="active"><a href="#">用户版</a></li>
        <li><a href="#">教员版</a></li>
    </ul>
</div>
<div class="navbar-right">
<ul class="nav navbar-nav">
<!-- Messages: style can be found in dropdown.less-->
<li class="dropdown messages-menu">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
        <i class="fa fa-envelope"></i>
        <span class="label label-success hidden">4</span>
    </a>
    <ul class="dropdown-menu">
        <li class="header">You have 4 messages</li>
        <li>
            <!-- inner menu: contains the actual data -->
            <ul class="menu">

            </ul>
        </li>
        <li class="footer"><a href="#">See All Messages</a></li>
    </ul>
</li>
<!-- User Account -->
<jsp:include page="../common/account_teacher.jsp" />
</ul>
</div>
</nav>
</header>
<div class="wrapper row-offcanvas row-offcanvas-left">
    <jsp:include page="../common/sidebar_teacher.jsp" />

<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        更新资料
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Forms</a></li>
        <li class="active">General Elements</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">
    <c:if test="${not empty message}">
        <div class="alert alert-${message.type}">
                ${message.message}
        </div>
    </c:if>
<div class="row">
<!-- right column -->
<div>
    <!-- general form elements disabled -->
    <form role="form" action="" method="post" enctype="multipart/form-data">
        <div class="box">
            <div class="box-body">
                    <div class="form-group">
                        <img src="${teacherAccount.avatar}" class="avatar">
                        <input type="file" name="avatarFile" class="btn">
                    </div>
                    <!-- text input -->
                    <div class="form-group">
                        <label>名称</label>
                        <span class="text-light-blue">在网站中显示的名称</span>
                        <input type="text" name="name" class="form-control" placeholder="请输入名称" value="${teacherAccount.name}"/>
                    </div>
                    <div class="form-group">
                        <label>描述</label>
                        <span class="text-light-blue">写一段自我介绍吧，一个好的介绍可以直接打动别人。</span>
                        <textarea name="description" class="form-control" rows="3" placeholder="自我介绍">${teacherAccount.info.description}</textarea>
                    </div>
                    <div class="form-group">
                        <label>您是一名：</label> <br>
                        <input type="radio" name="identity" value="1"
                               <c:if test="${teacherAccount.info.identity == 1}">checked</c:if>>在职教师&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="identity" value="2"
                               <c:if test="${teacherAccount.info.identity == 2}">checked</c:if>>退休教师&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="identity" value="3"
                               <c:if test="${teacherAccount.info.identity == 3}">checked</c:if>>大学生&nbsp;&nbsp;&nbsp;&nbsp;
                    </div>
                    <div class="form-group">
                        <label>教育信息</label>
                        <span class="text-light-blue">如果是在校大学生请写所上的学校，如果是老师请写任教学校。</span>
                        <input type="text" name="school" class="form-control" placeholder="请输入教育信息" value="${teacherAccount.info.school}"/>
                    </div>
                    <div class="form-group">
                        <label>授课时间</label>
                        <span class="text-light-blue">什么时间方便授课（例如：周六周日全天等）。</span>
                        <textarea name="freeTime" class="form-control" rows="3" placeholder="授课时间">${teacherAccount.info.freeTime}</textarea>
                    </div>
            </div><!-- /.box-body -->
            <div class="box-footer">
                <input type="hidden" name="username" value="${teacherAccount.username}">
                <button class="btn btn-primary">提交</button>
            </div>
        </div><!-- /.box -->
    </form>
</div><!--/.col (right) -->
</div>   <!-- /.row -->
</section><!-- /.content -->
</aside><!-- /.right-side -->
</div><!-- ./wrapper -->
<!-- jQuery 2.0.2 -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="/public/js/bootstrap.min.js" type="text/javascript"></script>
<!-- AdminLTE App -->
<script src="/public/js/AdminLTE/app.js" type="text/javascript"></script>
<!-- AdminLTE for demo purposes -->
<script src="/public/js/AdminLTE/demo.js" type="text/javascript"></script>
</body>
</html>