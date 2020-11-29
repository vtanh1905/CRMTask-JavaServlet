<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" sizes="16x16"
	href="../plugins/images/favicon.png">
<title>Pixel Admin</title>
<!-- Bootstrap Core CSS -->

<link
	href="<c:url value="/assets/bootstrap/dist/css/bootstrap.min.css" />"
	rel="stylesheet">
<!-- Menu CSS -->
<link
	href="<c:url value="/assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" />"
	rel="stylesheet">
<!-- toast CSS -->
<link
	href="<c:url value="/assets/plugins/bower_components/toast-master/css/jquery.toast.css" />"
	rel="stylesheet">
<!-- morris CSS -->
<link
	href="<c:url value="/assets/plugins/bower_components/morrisjs/morris.css" />"
	rel="stylesheet">
<!-- animation CSS -->
<link href="<c:url value="/assets/css/animate.css" />" rel="stylesheet">
<!-- Custom CSS -->
<link href="<c:url value="/assets/css/style.css" />" rel="stylesheet">
<!-- color CSS -->
<link href="<c:url value="/assets/css/colors/blue-dark.css" />"
	id="theme" rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/assets/css/custom.css" />">
</head>
<body>
	<div class="preloader">
		<div class="cssload-speeding-wheel"></div>
	</div>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top m-b-0">
			<div class="navbar-header">
				<a class="navbar-toggle hidden-sm hidden-md hidden-lg "
					href="javascript:void(0)" data-toggle="collapse"
					data-target=".navbar-collapse"> <i class="fa fa-bars"></i>
				</a>
				<div class="top-left-part">
					<a class="logo" href="index.html"> <b> <img
					
							src="<c:url value="/assets/plugins/images/pixeladmin-logo.png" />" alt="home" />
					</b> <span class="hidden-xs"> <img
							src="<c:url value="/assets/plugins/images/pixeladmin-text.png" />" alt="home" />
					</span>
					</a>
				</div>
				<ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
					<li>
						<form role="search" class="app-search hidden-xs">
							<input type="text" placeholder="Search..." class="form-control">
							<a href=""> <i class="fa fa-search"></i>
							</a>
						</form>
					</li>
				</ul>
				<ul class="nav navbar-top-links navbar-right pull-right">
					<li>
						<div class="dropdown">
							<a class="profile-pic dropdown-toggle" data-toggle="dropdown"
								href="#"> <img src="<c:url value="/assets/plugins/images/users/varun.jpg" />"
								alt="user-img" width="36" class="img-circle" /> <b
								class="hidden-xs">Cybersoft</b>
							</a>
							<ul class="dropdown-menu">
								<li><a href="profile.html">Thông tin cá nhân</a></li>
								<li><a href="#">Thống kê công việc</a></li>
								<li class="divider"></li>
								<li><a href="#">Đăng xuất</a></li>
							</ul>
						</div>
					</li>
				</ul>
			</div>
			<!-- /.navbar-header -->
			<!-- /.navbar-top-links -->
			<!-- /.navbar-static-side -->
		</nav>
		<!-- Left navbar-header -->
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse slimscrollsidebar">
				<ul class="nav" id="side-menu">
					<li style="padding: 10px 0 0;"><a href="index.html"
						class="waves-effect"><i class="fa fa-clock-o fa-fw"
							aria-hidden="true"></i><span class="hide-menu">Dashboard</span></a></li>
					<li><a href="user-table.html" class="waves-effect"><i
							class="fa fa-user fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Thành viên</span></a></li>
					<li><a href="role-table.html" class="waves-effect"><i
							class="fa fa-modx fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Quyền</span></a></li>
					<li><a href="groupwork.html" class="waves-effect"><i
							class="fa fa-table fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Dự án</span></a></li>
					<li><a href="task.html" class="waves-effect"><i
							class="fa fa-table fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Công việc</span></a></li>
					<li><a href="blank.html" class="waves-effect"><i
							class="fa fa-columns fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Blank Page</span></a></li>
					<li><a href="404.html" class="waves-effect"><i
							class="fa fa-info-circle fa-fw" aria-hidden="true"></i><span
							class="hide-menu">Error 404</span></a></li>
				</ul>
			</div>
		</div>
		<!-- Left navbar-header end -->
		<!-- Page Content -->
		<decorator:body />
		<!-- /.container-fluid -->
		<footer class="footer text-center"> 2018 &copy; myclass.com </footer>
	</div>


	<script
		src="<c:url value="/assets/plugins/bower_components/jquery/dist/jquery.min.js" />"></script>
	<!-- Bootstrap Core JavaScript -->
	<script
		src="<c:url value="/assets/bootstrap/dist/js/bootstrap.min.js" />"></script>
	<!-- Menu Plugin JavaScript -->
	<script
		src="<c:url value="/assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js" />"></script>
	<!--slimscroll JavaScript -->
	<script src="<c:url value="/assets/js/jquery.slimscroll.js" />"></script>
	<!--Wave Effects -->
	<script src="<c:url value="/assets/js/waves.js" />"></script>
	<!--Counter js -->
	<script
		src="<c:url value="/assets/plugins/bower_components/waypoints/lib/jquery.waypoints.js" />"></script>
	<script
		src="<c:url value="/assets/plugins/bower_components/counterup/jquery.counterup.min.js" />"></script>
	<!--Morris JavaScript -->
	<script
		src="<c:url value="/assets/plugins/bower_components/raphael/raphael-min.js" />"></script>
	<script
		src="<c:url value="/assets/plugins/bower_components/morrisjs/morris.js" />"></script>
	<!-- Custom Theme JavaScript -->
	<script src="<c:url value="/assets/js/custom.min.js" />"></script>
	<script src="<c:url value="/assets/js/dashboard1.js" />"></script>
	<script
		src="<c:url value="/assets/plugins/bower_components/toast-master/js/jquery.toast.js" />"></script>
</body>
</html>