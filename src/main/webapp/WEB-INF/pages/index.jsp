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
<jsp:include page="common/user_header.jsp" />
<div class="container main-block">
    <jsp:include page="common/user_search.jsp" />
<div class="row">
    <h2>专职教员推荐</h2>
    <c:forEach items="${topList}" var="teacher">
        <div class="col-md-3">
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
    </c:forEach>
</div>

<div class="row">
    <div class="rank col-lg-4">
        <h2>英语教员推荐</h2>
        <c:forEach items="${row2List}" var="teacher">
            <div class="col-md-12">
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
        </c:forEach>
        <div class="col-lg-12">
            <a href="#" class="btn btn-link btn-block">查看更多</a>
        </div>
    </div>
    <div class="rank col-lg-4">
        <h2>英语教员推荐</h2>
        <c:forEach items="${row2List}" var="teacher">
            <div class="col-md-12">
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
        </c:forEach>
        <div class="col-lg-12">
            <a href="#" class="btn btn-link btn-block">查看更多</a>
        </div>
    </div>
    <div class="rank col-md-4">
        <h2>英语教员推荐</h2>
        <c:forEach items="${row2List}" var="teacher">
            <div class="col-md-12">
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
        </c:forEach>
        <div class="col-lg-12">
            <a href="#" class="btn btn-link btn-block">查看更多</a>
        </div>
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
</body>
</html>