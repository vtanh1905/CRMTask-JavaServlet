<%@page import="com.vtanh1905.utils.DateLibrary"%>
<%@page import="com.vtanh1905.entity.Task"%>
<%@page import="com.vtanh1905.dto.ListTaskOfUserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ListTaskOfUserDto tasksOfUser = (ListTaskOfUserDto) request.getAttribute("tasksOfUser");
	int amountTaskNotDo = tasksOfUser.getTasksNotDo().size();
	int amountTaskDoing = tasksOfUser.getTasksDoing().size();
	int amountTaskDone = tasksOfUser.getTasksDone().size();
	int amountTask = amountTaskNotDo + amountTaskDoing + amountTaskDone;
	int percentTaskNotDo = amountTask != 0 ? ((amountTaskNotDo * 100) / amountTask) : 0;
	int percentTaskDoing = amountTask != 0 ? ((amountTaskDoing * 100) / amountTask) : 0;
	int percentTaskDone = amountTask != 0 ? ((amountTaskDone * 100) / amountTask) : 0;
	%>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row bg-title">
				<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
					<h4 class="page-title">Chi tiết thành viên</h4>
				</div>
			</div>
			<!-- /.row -->
			<!-- .row -->
			<div class="row">
				<div class="col-md-4 col-xs-12">
					<div class="white-box">
						<div class="user-bg">
							<img width="100%" alt="user" src="plugins/images/large/img1.jpg">
							<div class="overlay-box">
								<div class="user-content">
									<a href="javascript:void(0)"><img
										src="<c:url value="/assets/plugins/images/users/genu.jpg" />"
										class="thumb-lg img-circle" alt="img"></a>
									<h4 class="text-white">${ tasksOfUser.user.fullname }</h4>
									<h5 class="text-white">${ tasksOfUser.user.email }</h5>
								</div>
							</div>
						</div>

					</div>
				</div>
				<div class="col-md-8 col-xs-12">
					<!-- BEGIN THỐNG KÊ -->
					<div class="row">
						<!--col -->
						<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
							<div class="white-box">
								<div class="col-in row">
									<div class="col-xs-12">
										<h3 class="counter text-right m-t-15 text-danger"><%=percentTaskNotDo%>%
										</h3>
									</div>
									<div class="col-xs-12">
										<i data-icon="E" class="linea-icon linea-basic"></i>
										<h5 class="text-muted vb text-center">CHƯA BẮT ĐẦU</h5>
									</div>
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="progress">
											<div class="progress-bar progress-bar-danger"
												role="progressbar" aria-valuenow="40" aria-valuemin="0"
												aria-valuemax="100" style="width: <%=percentTaskNotDo%>%"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- /.col -->
						<!--col -->
						<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
							<div class="white-box">
								<div class="col-in row">
									<div class="col-xs-12">
										<h3 class="counter text-right m-t-15 text-megna"><%=percentTaskDoing%>%
										</h3>
									</div>
									<div class="col-xs-12">
										<i class="linea-icon linea-basic" data-icon="&#xe01b;"></i>
										<h5 class="text-muted vb text-center">ĐANG THỰC HIỆN</h5>
									</div>
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="progress">
											<div class="progress-bar progress-bar-megna"
												role="progressbar" aria-valuenow="40" aria-valuemin="0"
												aria-valuemax="100" style="width: <%=percentTaskDoing%>%"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- /.col -->
						<!--col -->
						<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
							<div class="white-box">
								<div class="col-in row">
									<div class="col-xs-12">
										<h3 class="counter text-right m-t-15 text-primary"><%=percentTaskDone%>%
										</h3>
									</div>
									<div class="col-xs-12">
										<i class="linea-icon linea-basic" data-icon="&#xe00b;"></i>
										<h5 class="text-muted vb text-center">HOÀN THÀNH</h5>
									</div>
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="progress">
											<div class="progress-bar progress-bar-primary"
												role="progressbar" aria-valuenow="40" aria-valuemin="0"
												aria-valuemax="100" style="width: <%=percentTaskDone%>%"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- /.col -->
					</div>
					<!-- END THỐNG KÊ -->

				</div>
			</div>
			<br />
			<!-- /.row -->
			<!-- BEGIN DANH SÁCH CÔNG VIỆC -->
			<h4>DANH SÁCH CÔNG VIỆC</h4>
			<div class="row">
				<div class="col-md-4">
					<div class="white-box">
						<h3 class="box-title">Chưa thực hiện</h3>
						<div class="message-center">
							<%
								for (Task task : tasksOfUser.getTasksNotDo()) {
							%>
							<a href="#">
								<div class="mail-contnet">
									<h5><%=task.getName()%></h5>
									<span class="mail-desc"></span> <span class="time">Bắt
										đầu: <%=DateLibrary.convertTimestampToSimpleDate(task.getStart_date())%></span>
									<span class="time">Kết thúc: <%=DateLibrary.convertTimestampToSimpleDate(task.getEnd_date())%></span>
								</div>
							</a>
							<%
								}
							%>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="white-box">
						<h3 class="box-title">Đang thực hiện</h3>
						<div class="message-center">
							<%
								for (Task task : tasksOfUser.getTasksDoing()) {
							%>
							<a href="#">
								<div class="mail-contnet">
									<h5><%=task.getName()%></h5>
									<span class="mail-desc"></span> <span class="time">Bắt
										đầu: <%=DateLibrary.convertTimestampToSimpleDate(task.getStart_date())%></span>
									<span class="time">Kết thúc: <%=DateLibrary.convertTimestampToSimpleDate(task.getEnd_date())%></span>
								</div>
							</a>
							<%
								}
							%>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="white-box">
						<h3 class="box-title">Đã hoàn thành</h3>
						<div class="message-center">
							<%
								for (Task task : tasksOfUser.getTasksDone()) {
							%>
							<a href="#">
								<div class="mail-contnet">
									<h5><%=task.getName()%></h5>
									<span class="mail-desc"></span> <span class="time">Bắt
										đầu: <%=DateLibrary.convertTimestampToSimpleDate(task.getStart_date())%></span>
									<span class="time">Kết thúc: <%=DateLibrary.convertTimestampToSimpleDate(task.getEnd_date())%></span>
								</div>
							</a>
							<%
								}
							%>
						</div>
					</div>
				</div>
			</div>
			<!-- END DANH SÁCH CÔNG VIỆC -->
		</div>
</body>
</html>