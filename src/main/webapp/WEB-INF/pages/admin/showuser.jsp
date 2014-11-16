<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminLTE | Dashboard</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- bootstrap 3.0.2 -->
<link href="/public/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- font Awesome -->
<link href="/public/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />
<!-- Ionicons -->
<link href="/public/css/ionicons.min.css" rel="stylesheet"
	type="text/css" />
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
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<div class="navbar-brand">家教你好</div>
				</div>
			</div>
			<div class="navbar-right">
				<ul class="nav navbar-nav">
					<!-- Messages: style can be found in dropdown.less-->
					<li class="dropdown messages-menu"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="fa fa-envelope"></i> <span
							class="label label-success hidden">4</span>
					</a>
						<ul class="dropdown-menu">
							<li class="header">You have 4 messages</li>
							<li>
								<!-- inner menu: contains the actual data -->
								<ul class="menu">

								</ul>
							</li>
							<li class="footer"><a href="#">See All Messages</a></li>
						</ul></li>
					<!-- User Account -->
					<jsp:include page="../common/account_admin.jsp" />
				</ul>
			</div>
		</nav>
	</header>
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<jsp:include page="../common/sidebar_admin.jsp" flush="true">
			<jsp:param name="activeMenu" value="showuser" />
		</jsp:include>

		<!-- Right side column. Contains the navbar and content of the page -->
		<aside class="right-side">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>查看用户资料</h1>
				<ol class="breadcrumb">
					<li><i class="fa fa-dashboard"></i>首页</li>
					<li class="active"><i class="fa fa-th"></i>查看用户资料</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<c:if test="${not empty message}">
					<div class="alert alert-${message.type}">${message.message}</div>
				</c:if>
				<div class="row">
					<!-- right column -->
					<div>
						<!-- general form elements disabled -->
						<form id="main-form" action="/admin/showuser" method="get">
							<input type="hidden" id="page" name="page" value="${ page.page }">
							<input type="hidden" id="size" name="size" value="${ page.size }">
							<input type="hidden" id="total" name="total"
								value="${ page.total }">

							<div class="box">
								<table class="table table-bordered">
									<tbody>
										<tr>
											<th>用户名</th>
											<th>姓名</th>
										</tr>
										<c:forEach var="userAccount" items="${userAccountList}">
											<tr>
												<td>${userAccount.username}</td>
												<td>${userAccount.name}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div class="box-footer clearfix">

									<span class="badge">共${ page.total}条</span>
									<ul class="pagination pagination-sm no-margin pull-right">

										<li><a class="previous_page">上一页</a></li>
										<li><a class="next_page">下一页</a></li>

									</ul>
								</div>
								<!-- /.box -->
						</form>
					</div>
					<!--/.col (right) -->
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->
		</aside>
		<!-- /.right-side -->
	</div>

	<!-- ./wrapper -->

	<!-- jQuery 2.0.2 -->
	<script src="/public/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="/public/js/bootstrap.min.js" type="text/javascript"></script>
	<!-- AdminLTE App -->
	<script src="/public/js/AdminLTE/app.js" type="text/javascript"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="/public/js/AdminLTE/demo.js" type="text/javascript"></script>
	<script type="text/javascript">
		(function($) {
			$(".next_page").click(function() {
				var page = $('#page').val();
				total = $('#total').val();
				size = $('#size').val();
				page=page+1;
				var maxpage=1;
				if (total % size == 0) {
					maxpage = total / size;
				} else {
					maxpage =parseInt(total / size) + 1;
				}
				if (page > maxpage) {
					page = maxpage;
				}
				$("#page").val(page);
				$("#main-form").submit();
			});
			$(".previous_page").click(function() {
				var page = $('#page').val();
				page=page-1;
				if (page <= 0) {
					page = 1;
				}
				$("#page").val(page);
				$("#main-form").submit();
			});
		})(window.jQuery);
	</script>
	<script src="/public/js/app.js" type="text/javascript"></script>
</body>
</html>