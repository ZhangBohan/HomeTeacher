<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<a href="/public/index.html" class="logo">
    <!-- Add the class icon to your logo image or logo icon to add the margining -->
    AdminLTE
</a>
<!-- Header Navbar: style can be found in header.less -->
<nav class="navbar navbar-static-top" role="navigation">
<!-- Sidebar toggle button-->
<a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
    <span class="sr-only">Toggle navigation</span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
</a>
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
<!-- Left side column. contains the logo and sidebar -->
<aside class="left-side sidebar-offcanvas">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/public/img/avatar3.png" class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
                <p>Hello, Jane</p>

                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- search form -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search..."/>
                            <span class="input-group-btn">
                                <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                            </span>
            </div>
        </form>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
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
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-bar-chart-o"></i>
                    <span>Charts</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="../charts/morris.html"><i class="fa fa-angle-double-right"></i> Morris</a></li>
                    <li><a href="../charts/flot.html"><i class="fa fa-angle-double-right"></i> Flot</a></li>
                    <li><a href="../charts/inline.html"><i class="fa fa-angle-double-right"></i> Inline charts</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-laptop"></i>
                    <span>UI Elements</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="../UI/general.html"><i class="fa fa-angle-double-right"></i> General</a></li>
                    <li><a href="../UI/icons.html"><i class="fa fa-angle-double-right"></i> Icons</a></li>
                    <li><a href="../UI/buttons.html"><i class="fa fa-angle-double-right"></i> Buttons</a></li>
                    <li><a href="../UI/sliders.html"><i class="fa fa-angle-double-right"></i> Sliders</a></li>
                    <li><a href="../UI/timeline.html"><i class="fa fa-angle-double-right"></i> Timeline</a></li>
                </ul>
            </li>
            <li class="treeview active">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>Forms</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li class="active"><a href="general.html"><i class="fa fa-angle-double-right"></i> General Elements</a></li>
                    <li><a href="advanced.html"><i class="fa fa-angle-double-right"></i> Advanced Elements</a></li>
                    <li><a href="editors.html"><i class="fa fa-angle-double-right"></i> Editors</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-table"></i> <span>Tables</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="../tables/simple.html"><i class="fa fa-angle-double-right"></i> Simple tables</a></li>
                    <li><a href="../tables/data.html"><i class="fa fa-angle-double-right"></i> Data tables</a></li>
                </ul>
            </li>
            <li>
                <a href="../calendar.html">
                    <i class="fa fa-calendar"></i> <span>Calendar</span>
                    <small class="badge pull-right bg-red">3</small>
                </a>
            </li>
            <li>
                <a href="../mailbox.html">
                    <i class="fa fa-envelope"></i> <span>Mailbox</span>
                    <small class="badge pull-right bg-yellow">12</small>
                </a>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-folder"></i> <span>Examples</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="../examples/invoice.html"><i class="fa fa-angle-double-right"></i> Invoice</a></li>
                    <li><a href="../examples/login.html"><i class="fa fa-angle-double-right"></i> Login</a></li>
                    <li><a href="../examples/register.html"><i class="fa fa-angle-double-right"></i> Register</a></li>
                    <li><a href="../examples/lockscreen.html"><i class="fa fa-angle-double-right"></i> Lockscreen</a></li>
                    <li><a href="../examples/404.html"><i class="fa fa-angle-double-right"></i> 404 Error</a></li>
                    <li><a href="../examples/500.html"><i class="fa fa-angle-double-right"></i> 500 Error</a></li>
                    <li><a href="../examples/blank.html"><i class="fa fa-angle-double-right"></i> Blank Page</a></li>
                </ul>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>

<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        General Form Elements
        <small>Preview</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Forms</a></li>
        <li class="active">General Elements</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">
<div class="row">
<!-- right column -->
<div>
    <!-- general form elements disabled -->
    <div class="box">
        <div class="box-body">
            <form role="form">
                <!-- text input -->
                <div class="form-group">
                    <label>Text</label>
                    <input type="text" class="form-control" placeholder="Enter ..."/>
                </div>
                <div class="form-group">
                    <label>Text Disabled</label>
                    <input type="text" class="form-control" placeholder="Enter ..." disabled/>
                </div>

                <!-- textarea -->
                <div class="form-group">
                    <label>Textarea</label>
                    <textarea class="form-control" rows="3" placeholder="Enter ..."></textarea>
                </div>
                <div class="form-group">
                    <label>Textarea Disabled</label>
                    <textarea class="form-control" rows="3" placeholder="Enter ..." disabled></textarea>
                </div>

                <!-- input states -->
                <div class="form-group has-success">
                    <label class="control-label" for="inputSuccess"><i class="fa fa-check"></i> Input with success</label>
                    <input type="text" class="form-control" id="inputSuccess" placeholder="Enter ..."/>
                </div>
                <div class="form-group has-warning">
                    <label class="control-label" for="inputWarning"><i class="fa fa-warning"></i> Input with warning</label>
                    <input type="text" class="form-control" id="inputWarning" placeholder="Enter ..."/>
                </div>
                <div class="form-group has-error">
                    <label class="control-label" for="inputError"><i class="fa fa-times-circle-o"></i> Input with error</label>
                    <input type="text" class="form-control" id="inputError" placeholder="Enter ..."/>
                </div>

                <!-- checkbox -->
                <div class="form-group">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"/>
                            Checkbox 1
                        </label>
                    </div>

                    <div class="checkbox">
                        <label>
                            <input type="checkbox"/>
                            Checkbox 2
                        </label>
                    </div>

                    <div class="checkbox">
                        <label>
                            <input type="checkbox" disabled/>
                            Checkbox disabled
                        </label>
                    </div>
                </div>

                <!-- radio -->
                <div class="form-group">
                    <div class="radio">
                        <label>
                            <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                            Option one is this and that&mdash;be sure to include why it's great
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                            Option two can be something else and selecting it will deselect option one
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="optionsRadios" id="optionsRadios3" value="option3" disabled/>
                            Option three is disabled
                        </label>
                    </div>
                </div>

                <!-- select -->
                <div class="form-group">
                    <label>Select</label>
                    <select class="form-control">
                        <option>option 1</option>
                        <option>option 2</option>
                        <option>option 3</option>
                        <option>option 4</option>
                        <option>option 5</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Select Disabled</label>
                    <select class="form-control" disabled>
                        <option>option 1</option>
                        <option>option 2</option>
                        <option>option 3</option>
                        <option>option 4</option>
                        <option>option 5</option>
                    </select>
                </div>

                <!-- Select multiple-->
                <div class="form-group">
                    <label>Select Multiple</label>
                    <select multiple class="form-control">
                        <option>option 1</option>
                        <option>option 2</option>
                        <option>option 3</option>
                        <option>option 4</option>
                        <option>option 5</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Select Multiple Disabled</label>
                    <select multiple class="form-control" disabled>
                        <option>option 1</option>
                        <option>option 2</option>
                        <option>option 3</option>
                        <option>option 4</option>
                        <option>option 5</option>
                    </select>
                </div>

            </form>
        </div><!-- /.box-body -->
    </div><!-- /.box -->
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