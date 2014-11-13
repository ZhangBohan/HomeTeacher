<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<li class="dropdown user user-menu">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
        <i class="glyphicon glyphicon-user"></i>
        <span><sec:authentication property="principal.name" /> <i class="caret"></i></span>
    </a>
    <ul class="dropdown-menu">
        <!-- User image -->
        <li class="user-header bg-light-blue">
            <img src="<sec:authentication property="principal.avatar" />" class="img-circle" alt="User Image" />
            <p>
                <sec:authentication property="principal.name" />
                <small>上次登录时间：<sec:authentication property="principal.updatedAt" /></small>
            </p>
        </li>
        <!-- Menu Footer-->
        <li class="user-footer">
            <div class="pull-left">
                <a href="/admin/edit" class="btn btn-default btn-flat">修改资料</a>
            </div>
            <div class="pull-right">
                <a href="/admin/j_spring_security_logout" class="btn btn-default btn-flat">退出</a>
            </div>
        </li>
    </ul>
</li>
