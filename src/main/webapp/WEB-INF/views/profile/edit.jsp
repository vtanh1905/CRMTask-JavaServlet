<%@page import="com.vtanh1905.utils.DateLibrary"%>
<%@page import="com.vtanh1905.dto.TaskDetailDto"%>
<%@page import="com.vtanh1905.config.PathConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/constants.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		TaskDetailDto task = (TaskDetailDto)request.getAttribute("task");
	%>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row bg-title">
				<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
					<h4 class="page-title">Cập nhật trạng thái</h4>
				</div>
			</div>
			<!-- /.row -->
			<!-- .row -->
			<div class="row">
				<div class="col-md-2 col-12"></div>
				<div class="col-md-8 col-xs-12">
					<div class="white-box">
						<form method="POST" class="form-horizontal form-material" action="<%= CONTEXT_PATH + PathConfig.PROFILE_EDIT %>">
							<div class="form-group">
								<label class="col-md-12">Tên dự án</label>
								<div class="col-md-12">
									<input type="text" readonly value="${ task.job_name }"
										class="form-control form-control-line">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-12">Tên công việc</label>
								<div class="col-md-12">
									<input type="text" readonly value="${ task.name }"
										class="form-control form-control-line">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-12">Ngày bắt đầu</label>
								<div class="col-md-12">
									<input type="text" readonly value="<%= DateLibrary.convertTimestampToSimpleDate(task.getStart_date())%>"
										class="form-control form-control-line">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-12">Ngày kết thúc</label>
								<div class="col-md-12">
									<input type="text" readonly value="<%= DateLibrary.convertTimestampToSimpleDate(task.getJob_end_date())%>"
										class="form-control form-control-line">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-12">Trạng thái</label>
								<div class="col-md-12">
									<select class="form-control form-control-line" name="status_id">
										<option value="1" ${ task.status_id == 1 ? "selected" : "" }>Chưa thực hiện</option>
										<option value="2" ${ task.status_id == 2 ? "selected" : "" }>Đang thực hiện</option>
										<option value="3" ${ task.status_id == 3 ? "selected" : "" }>Đã hoàn thành</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<button type="submit" class="btn btn-success">Cập nhật</button>
									<a href="<%= CONTEXT_PATH + PathConfig.PROFILE %>" class="btn btn-primary">Quay lại</a>
								</div>
							</div>
							<input type="hidden" name="id" value="${ task.id }" />
						</form>
					</div>
				</div>
				<div class="col-md-2 col-12"></div>
			</div>
			<!-- /.row -->
		</div>
</body>
</html>