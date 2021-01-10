<%@page import="com.vtanh1905.config.PathConfig"%>
<%@page import="com.vtanh1905.utils.DateLibrary"%>
<%@page import="java.util.List"%>
<%@page import="com.vtanh1905.dto.TaskDetailDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/constants.jsp"%>
<%@ include file="/WEB-INF/views/commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
	<%
		List<TaskDetailDto> tasks = (List<TaskDetailDto>)request.getAttribute("tasks");
		List<Integer> listAmountStatusTask = (List<Integer>) request.getAttribute("listAmountStatusTask");
		int countTask = listAmountStatusTask.get(0) + listAmountStatusTask.get(1) + listAmountStatusTask.get(2);
		int percentNotDo = countTask == 0 ? 0 : (listAmountStatusTask.get(0) * 100) / countTask;
		int percentDoing = countTask == 0 ? 0 : (listAmountStatusTask.get(1) * 100) / countTask;
		int percentDone = countTask == 0 ? 0 : (listAmountStatusTask.get(2) * 100) / countTask;
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
							<img width="100%" alt="user" src="<c:url value="/assets/plugins/images/users/genu.jpg" />">
							<div class="overlay-box">
								<div class="user-content">
									<a href="javascript:void(0)"><img
										src="<c:url value="/assets/plugins/images/users/genu.jpg" />"
										class="thumb-lg img-circle" alt="img"></a>
									<h4 class="text-white"><%= USERLOGIN.getFullname() %></h4>
									<h5 class="text-white"><%= USERLOGIN.getEmail() %></h5>
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
										<h3 class="counter text-right m-t-15 text-danger"><%= percentNotDo %>%</h3>
									</div>
									<div class="col-xs-12">
										<i data-icon="E" class="linea-icon linea-basic"></i>
										<h5 class="text-muted vb text-center">CHƯA BẮT ĐẦU</h5>
									</div>
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="progress">
											<div class="progress-bar progress-bar-danger"
												role="progressbar" aria-valuenow="40" aria-valuemin="0"
												aria-valuemax="100" style="width: <%= percentNotDo %>%"></div>
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
										<h3 class="counter text-right m-t-15 text-megna"><%= percentDoing %>%</h3>
									</div>
									<div class="col-xs-12">
										<i class="linea-icon linea-basic" data-icon="&#xe01b;"></i>
										<h5 class="text-muted vb text-center">ĐANG THỰC HIỆN</h5>
									</div>
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="progress">
											<div class="progress-bar progress-bar-megna"
												role="progressbar" aria-valuenow="40" aria-valuemin="0"
												aria-valuemax="100" style="width: <%= percentDoing %>%"></div>
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
										<h3 class="counter text-right m-t-15 text-primary"><%= percentDone %>%</h3>
									</div>
									<div class="col-xs-12">
										<i class="linea-icon linea-basic" data-icon="&#xe00b;"></i>
										<h5 class="text-muted vb text-center">HOÀN THÀNH</h5>
									</div>
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="progress">
											<div class="progress-bar progress-bar-primary"
												role="progressbar" aria-valuenow="40" aria-valuemin="0"
												aria-valuemax="100" style="width: <%= percentDone %>%"></div>
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
				<div class="col-sm-12">
					<div class="white-box">
						<div class="table-responsive">
							<table class="table" id="example">
								<thead>
									<tr>
										<th>STT</th>
										<th>Tên Công Việc</th>
										<th>Dự Án</th>
										<th>Ngày Bắt Đầu</th>
										<th>Ngày Kết Thúc</th>
										<th>Trạng Thái</th>
										<th>Hành Động</th>
									</tr>
								</thead>
								<tbody>
									<% for(TaskDetailDto task : tasks) {%>
									<tr>
										<td><%= task.getId() %></td>
										<td><%= task.getName() %></td>
										<td><%= task.getJob_name() %></td>
										<td><%= DateLibrary.convertTimestampToSimpleDate(task.getStart_date())%></td>
										<td><%= DateLibrary.convertTimestampToSimpleDate(task.getJob_end_date())%></td>
										<td><%= task.getStatus_name() %></td>
										<td><a href="<%= CONTEXT_PATH + PathConfig.PROFILE_EDIT %>?id=<%= task.getId() %>"
											class="btn btn-sm btn-primary">Cập nhật</a></td>
									</tr>
									<% } %>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- END DANH SÁCH CÔNG VIỆC -->
		</div>
</body>
</html>