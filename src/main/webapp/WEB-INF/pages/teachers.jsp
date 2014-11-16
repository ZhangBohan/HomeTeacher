<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>AdminLTE | Dashboard</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- bootstrap 3.0.2 -->
    <link href="/public/css/bootstrap.css" rel="stylesheet" type="text/css" />
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
    <!-- Header Navbar: style can be found in header.less -->
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
                <li class="active"><a href="user.html">用户版</a></li>
                <li><a href="teacher.html">教员版</a></li>
            </ul>
        </div>
        <div class="navbar-right">
            <ul class="nav navbar-nav">
                <!-- Messages: style can be found in dropdown.less-->
                <li class="dropdown messages-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-envelope"></i>
                        <span class="label label-success">4</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="header">You have 4 messages</li>
                        <li>
                            <!-- inner menu: contains the actual data -->
                            <ul class="menu">
                                <li><!-- start message -->
                                    <a href="#">
                                        <div class="pull-left">
                                            <img src="../img/avatar3.png" class="img-circle" alt="User Image"/>
                                        </div>
                                        <h4>
                                            Support Team
                                            <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                        </h4>
                                        <p>Why not buy a new awesome theme?</p>
                                    </a>
                                </li><!-- end message -->
                                <li>
                                    <a href="#">
                                        <div class="pull-left">
                                            <img src="../img/avatar2.png" class="img-circle" alt="user image"/>
                                        </div>
                                        <h4>
                                            AdminLTE Design Team
                                            <small><i class="fa fa-clock-o"></i> 2 hours</small>
                                        </h4>
                                        <p>Why not buy a new awesome theme?</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <div class="pull-left">
                                            <img src="../img/avatar.png" class="img-circle" alt="user image"/>
                                        </div>
                                        <h4>
                                            Developers
                                            <small><i class="fa fa-clock-o"></i> Today</small>
                                        </h4>
                                        <p>Why not buy a new awesome theme?</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <div class="pull-left">
                                            <img src="../img/avatar2.png" class="img-circle" alt="user image"/>
                                        </div>
                                        <h4>
                                            Sales Department
                                            <small><i class="fa fa-clock-o"></i> Yesterday</small>
                                        </h4>
                                        <p>Why not buy a new awesome theme?</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <div class="pull-left">
                                            <img src="../img/avatar.png" class="img-circle" alt="user image"/>
                                        </div>
                                        <h4>
                                            Reviewers
                                            <small><i class="fa fa-clock-o"></i> 2 days</small>
                                        </h4>
                                        <p>Why not buy a new awesome theme?</p>
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li class="footer"><a href="#">See All Messages</a></li>
                    </ul>
                </li>
                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="glyphicon glyphicon-user"></i>
                        <span>Jane Doe <i class="caret"></i></span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header bg-light-blue">
                            <img src="../img/avatar3.png" class="img-circle" alt="User Image" />
                            <p>
                                Jane Doe - Web Developer
                                <small>Member since Nov. 2012</small>
                            </p>
                        </li>
                        <!-- Menu Body -->
                        <li class="user-body">
                            <div class="col-xs-4 text-center">
                                <a href="#">Followers</a>
                            </div>
                            <div class="col-xs-4 text-center">
                                <a href="#">Sales</a>
                            </div>
                            <div class="col-xs-4 text-center">
                                <a href="#">Friends</a>
                            </div>
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">Profile</a>
                            </div>
                            <div class="pull-right">
                                <a href="#" class="btn btn-default btn-flat">Sign out</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>
<div class="container main-block">
<div class="row top-content">
    <div class="col-md-3">
        <img src="../img/logo.png">
        <!-- Single button -->
        <div class="btn-group">
            <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
                Action <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" role="menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
            </ul>
        </div>
    </div>
    <div class="col-md-6">
        <div class="input-group input-group-lg">
            <input type="text" class="form-control" autofocus="">
                        <span class="input-group-btn">
                            <button class="btn btn-default btn-flat" type="button">搜索</button>
                        </span>
        </div>
        <div>
            <a href="#" class="btn btn-link">英语</a>
            <a href="#" class="btn btn-link">数学</a>
            <a href="#" class="btn btn-link">语文</a>
            <a href="#" class="btn btn-link">物理</a>
            <a href="#" class="btn btn-link">化学</a>
            <a href="#" class="btn btn-link">地理</a>
            <a href="#" class="btn btn-link">生物</a>
            <a href="#" class="btn btn-link">艺术</a>
        </div>
    </div>
    <div class="col-md-3 text-center publish-message">
        <div>
            <button type="button" class="btn btn-success btn-lg">免费发布信息</button>
        </div>
        <div>
            <p class="text-bold text-blue">也可直接拨打家教热线：18511870281</p>
        </div>
    </div>
</div>
<div class="box box-primary">
    <div class="box-header">
        <h2>
            教员资料：${teacher.name}
            <small>
                <span class="label label-success">认证教员</span>
                <span class="label label-success">教学认可</span>
            </small>
        </h2>

    </div>
    <div class="box-body">
        <div class="row">
            <div class="col-md-2">
                <img src="${teacher.avatar}" class="avatar-big">
            </div>
            <div>
                <p class="teacher-info">
                    <c:if test="${empty teacher.info.sex or not teacher.info.sex}">
                        男
                    </c:if>
                    <c:if test="${not empty teacher.info.sex and teacher.info.sex}">
                        女
                    </c:if>
                </p>
                <c:if test="${teacher.info.identity == 1}">
                    <p class="teacher-info text-bold">
                        在职教员
                    </p>
                </c:if>
                <c:if test="${teacher.info.identity == 2}">
                    <p class="teacher-info text-bold">
                        专职教员
                    </p>
                </c:if>
                <c:if test="${teacher.info.identity == 3}">
                    <p class="teacher-info  text-bold">
                        大学生教员
                    </p>
                </c:if>
                <p class="teacher-info">
                    ${teacher.info.school}
                </p>
            </div>
        </div>
        <div class="box box-info">
            <div class="box-header">
                <h3>个人资料</h3>
            </div>
            <div class="box-body">
                ${teacher.info.description}
            </div>
        </div>
        <div class="box box-info">
            <div class="box-header">
                <h3>授课时间</h3>
            </div>
            <div class="box-body">
                ${teacher.info.freeTime}
            </div>
        </div>
        <c:if test="${not empty teacher.info.videoUrl}">
            <div class="box box-info">
                <div class="box-header">
                    <h3>授课视频</h3>
                </div>
                <div class="box-body">
                        ${teacher.info.videoUrl}
                </div>
            </div>
        </c:if>
    </div>
    <div class="box-footer">
        <button class="btn btn-success btn-lg">免费预约</button>
    </div>
</div>
</div>

<jsp:include page="common/footer.jsp" />


<!-- jQuery 2.0.2 -->
<script src="../js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../js/bootstrap.min.js" type="text/javascript"></script>
<!-- AdminLTE App -->
<script src="../js/AdminLTE/app.js" type="text/javascript"></script>
<!-- AdminLTE for demo purposes -->
<script src="../js/AdminLTE/demo.js" type="text/javascript"></script>
<script>
    $(function () {

    });
</script>
</body>
</html>