<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <li class="active"><a href="/">首页</a></li>
        <li><a href="teacher.html">教员版</a></li>
      </ul>
    </div>
    <div class="navbar-right">
      <ul class="nav navbar-nav">
        <!-- Messages: style can be found in dropdown.less-->
        <sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_TEACHER,ROLE_USER">
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
        </sec:authorize>
        <!-- User Account: style can be found in dropdown.less -->
        <sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_USER,ROLE_TEACHER">

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
                  <a href="/teacher/edit" class="btn btn-default btn-flat">修改资料</a>
                </div>
                <div class="pull-right">
                  <a href="/teacher/j_spring_security_logout" class="btn btn-default btn-flat">退出</a>
                </div>
              </li>
            </ul>
          </li>
        </sec:authorize>
        <sec:authorize ifNotGranted="ROLE_USER,ROLE_ADMIN,ROLE_TEACHER">
          <li>
            <a class="navbar-link" href="/auth/login/user">点我登录</a>
          </li>
        </sec:authorize>

      </ul>
    </div>
  </nav>
</header>