<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>AdminLTE | Dashboard</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- bootstrap 3.0.2 -->
    <link href="/public/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <!-- font Awesome -->
    <link href="/public/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <!-- Ionicons -->
    <link href="/public/css/ionicons.min.css" rel="stylesheet" type="text/css"/>
    <!-- Theme style -->
    <link href="/public/css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css" />
    <link href="/public/css/AdminLTE.css" rel="stylesheet" type="text/css"/>
    <link href="/public/css/styles.css" rel="stylesheet" type="text/css"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body class="skin-blue">
<jsp:include page="common/user_header.jsp"/>
<div class="container main-block">
    <jsp:include page="common/user_search.jsp"/>
    <form role="form" action="/user/ticket" method="post">

    <div class="box box-warning">
        <div class="box-header">
            <h3 class="box-title">免费预约教员</h3>
        </div>
        <!-- /.box-header -->
        <div class="box-body">
            <c:if test="${not empty teacher}">
                <div class="row">
                    <div class="col-md-4">
                        <div class="teacher-block bg-color-white">
                            <div class="avatar-block">
                                <img src="${teacher.avatar}">
                            </div>
                            <div class="teacher-content text-center">
                                <p>
                                        ${teacher.name}
                                    <c:if test="${empty teacher.info.sex or not teacher.info.sex}">
                                        男
                                    </c:if>
                                    <c:if test="${not empty teacher.info.sex and teacher.info.sex}">
                                        女
                                    </c:if>
                                </p>
                                <p>
                                    <c:if test="${teacher.info.identity == 1}">
                                <p class="teacher-info">
                                    在职教员
                                </p>
                                </c:if>
                                <c:if test="${teacher.info.identity == 2}">
                                    <p class="teacher-info">
                                        专职教员
                                    </p>
                                </c:if>
                                <c:if test="${teacher.info.identity == 3}">
                                    <p class="teacher-info">
                                        大学生教员
                                    </p>
                                </c:if>
                                </p>
                                <p>
                                    <c:forEach items="${teacher.info.courses}" var="course">
                                        <span class="label label-info">${course.name}</span>
                                    </c:forEach>
                                </p>
                                <a href="/teachers/${teacher.id}" class="btn btn-success">查看</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
                <hr class="clearfix">
                <div>
                    <c:if test="${empty teacher}">
                        <c:forEach items="${stages}" var="stage">
                            <div class="box-info">
                                <h4 class="page-header">${stage.name}</h4>

                                <div class="radio-inline">
                                    <c:forEach var="course" items="${stage.courses}">
                                        <input name="course" type="radio" value="${course.id}"
                                               <c:if test="${form.course == course.id}">checked </c:if>>
                                        ${course.name}
                                    </c:forEach>
                                </div>

                            </div>
                        </c:forEach>
                    </c:if>
                    <c:if test="${not empty teacher}">
                        <div class="form-control">
                            <label>请选择一门课程：</label>

                            <c:forEach items="${teacher.info.courses}" var="course">
                                <div class="radio-inline">
                                    <input name="course" type="radio" value="${course.id}"
                                           <c:if test="${form.course == course.id}">checked </c:if>>
                                        ${course.name}
                                </div>
                            </c:forEach>
                        </div>
                    </c:if>
                </div>
                <!-- text input -->
                <div class="form-group">
                    <label>您的地址</label>
                    <textarea class="form-control" rows="3" name="address" placeholder="您的地址 ...">${form.address}</textarea>
                </div>
                <div class="form-group">
                    <label>上门试讲时间:</label>
                    <input type="text" class="form-control" id="datetimepicker" name="teachingAt" value="${form.teachingAt}">
                </div>
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
            <input type="hidden" name="teacherId" value="${teacher.id}">
            <button type="submit" class="btn btn-primary">免费预约</button>
        </div>
    </div>
    </form>
</div>

<jsp:include page="common/footer.jsp"/>


<!-- jQuery 2.0.2 -->
<script src="/public/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="/public/js/bootstrap.min.js" type="text/javascript"></script>
<!-- AdminLTE App -->
<script src="/public/js/AdminLTE/app.js" type="text/javascript"></script>
<!-- AdminLTE for demo purposes -->
<script src="/public/js/AdminLTE/demo.js" type="text/javascript"></script>
<script src="/public/js/plugins/datetimepicker/bootstrap-datetimepicker.js" type="text/javascript"></script>
<script>
    $(function () {
        $('#datetimepicker').datetimepicker({
            useMinutes: false,
            useSeconds: false
        });
    });
</script>
</body>
</html>