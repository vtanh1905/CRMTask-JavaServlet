<%@page import="java.util.ArrayList"%>
<%@page import="com.vtanh1905.dto.TaskDetailDto"%>
<%@page import="java.util.List"%>
<%@page import="com.vtanh1905.utils.DateLibrary"%>
<%@page import="com.vtanh1905.config.PathConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/taglib.jsp"%>
<%@ include file="/WEB-INF/views/commons/constants.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<TaskDetailDto> tasks = (ArrayList<TaskDetailDto>) request.getAttribute("tasks");
	%>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row bg-title">
				<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
					<h4 class="page-title">Danh sách công việc</h4>
				</div>
				<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
					<a href="<%=CONTEXT_PATH + PathConfig.TASK_ADD%>"
						class="btn btn-sm btn-success">Thêm mới</a>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /row -->
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
										<th>Người Thực Hiện</th>
										<th>Ngày Bắt Đầu</th>
										<th>Ngày Kết Thúc</th>
										<th>Trạng Thái</th>
										<th>Hành Động</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (TaskDetailDto task : tasks) {
									%>
									<tr>
										<td><%= task.getId() %></td>
										<td><%= task.getName() %></td>
										<td><%= task.getJob_name() %></td>
										<td><%= task.getUser_fullname() %></td>
										<td><%=DateLibrary.convertTimestampToSimpleDate(task.getStart_date())%></td>
										<td><%=DateLibrary.convertTimestampToSimpleDate(task.getEnd_date())%></td>
										<td><%= task.getStatus_name() %></td>
										<td><a href="<%= CONTEXT_PATH + PathConfig.TASK_EDIT %>?id=<%= task.getId() %>" class="btn btn-sm btn-primary">Sửa</a> <a
											href="<%= CONTEXT_PATH + PathConfig.TASK_REMOVE %>?id=<%= task.getId() %>" class="btn btn-sm btn-danger">Xóa</a> 
											<!-- 
											<a href="#" class="btn btn-sm btn-info">Xem</a></td>
											 -->
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- /.row -->
		</div>
</body>
</html>