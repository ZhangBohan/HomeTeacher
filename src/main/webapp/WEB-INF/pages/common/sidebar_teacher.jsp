<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- Left side column. contains the logo and sidebar -->
<aside class="left-side sidebar-offcanvas">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="<sec:authentication property="principal.avatar" />" class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
                <p>你好, <sec:authentication property="principal.name" /></p>

                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- sidebar menu -->
        <ul class="sidebar-menu">
            <li>
                <a href="/public/index.html">
                    <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                </a>
            </li>
            <li>
                <a href="../widgets.html">
                    <i class="fa fa-th"></i> <span>Widgets</span> <small class="badge pull-right bg-green">new</small>
                </a>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>