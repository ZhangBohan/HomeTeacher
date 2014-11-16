<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a href="/admin" <c:if test="${param.activeMenu == 'index'}">class="menu-active" </c:if>>
                    <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                </a>
            </li>
            <li>
                <a href="/admin/edit" <c:if test="${param.activeMenu == 'edit'}">class="menu-active" </c:if>>
                    <i class="fa fa-th"></i> <span>个人资料</span>
                </a>
                <a href="/admin/showteacher" <c:if test="${param.activeMenu == 'showteacher'}">class="menu-active" </c:if>>
                    <i class="fa fa-th"></i> <span>查看教员资料</span>
                </a>
                <a href="/admin/showuser" <c:if test="${param.activeMenu == 'showuser'}">class="menu-active" </c:if>>
                    <i class="fa fa-th"></i> <span>查看用户资料</span>
                </a>
                <a href="/admin/verifyteacher" <c:if test="${param.activeMenu =='verifyteacher'}">class="menu-active" </c:if>>
                    <i class="fa fa-th"></i> <span>审核教员资料</span>
                </a>
                
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>