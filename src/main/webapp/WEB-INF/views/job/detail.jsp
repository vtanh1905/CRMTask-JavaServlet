<%@page import="com.vtanh1905.utils.DateLibrary"%>
<%@page import="com.vtanh1905.entity.Task"%>
<%@page import="com.vtanh1905.dto.ListTaskOfUserDto"%>
<%@page import="java.util.List"%>
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
		List<ListTaskOfUserDto> listTaskOfUsers = (List<ListTaskOfUserDto>) request.getAttribute("listTaskOfUsers");
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
					<h4 class="page-title">Chi tiết công việc</h4>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- BEGIN THỐNG KÊ -->
			<div class="row">
				<!--col -->
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="white-box">
						<div class="col-in row">
							<div class="col-md-6 col-sm-6 col-xs-6">
								<i data-icon="E" class="linea-icon linea-basic"></i>
								<h5 class="text-muted vb">CHƯA BẮT ĐẦU</h5>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6">
								<h3 class="counter text-right m-t-15 text-danger"><%= percentNotDo %>%</h3>
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
							<div class="col-md-6 col-sm-6 col-xs-6">
								<i class="linea-icon linea-basic" data-icon="&#xe01b;"></i>
								<h5 class="text-muted vb">ĐANG THỰC HIỆN</h5>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6">
								<h3 class="counter text-right m-t-15 text-megna"><%= percentDoing %>%</h3>
							</div>
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="progress">
									<div class="progress-bar progress-bar-megna" role="progressbar"
										aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
										style="width: <%= percentDoing %>%"></div>
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
							<div class="col-md-6 col-sm-6 col-xs-6">
								<i class="linea-icon linea-basic" data-icon="&#xe00b;"></i>
								<h5 class="text-muted vb">HOÀN THÀNH</h5>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6">
								<h3 class="counter text-right m-t-15 text-primary"><%= percentDone %>%</h3>
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

			<!-- BEGIN DANH SÁCH CÔNG VIỆC -->
			<%
				for (ListTaskOfUserDto item : listTaskOfUsers) {
			%>
			<div class="row">
				<div class="col-xs-12">
					<a href="#" class="group-title"> <img width="30"
						src="<c:url value="/assets/plugins/images/users/pawandeep.jpg" />"
						class="img-circle" /> <span><%=item.getUser().getFullname()%></span>
					</a>
				</div>
				<div class="col-md-4">
					<div class="white-box">
						<h3 class="box-title">Chưa thực hiện</h3>
						<div class="message-center">
							<%
								for (Task task : item.getTasksNotDo()) {
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
								for (Task task : item.getTasksDoing()) {
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
								for (Task task : item.getTasksDone()) {
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
			<%
				}
			%>
		</div>
</body>
</html>