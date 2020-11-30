<%@page import="com.vtanh1905.entity.Job"%>
<%@page import="com.vtanh1905.utils.DateLibrary"%>
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
		Job job = (Job) request.getAttribute("job");
		String messageError = (String)request.getAttribute("messageError");
	%>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row bg-title">
				<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
					<h4 class="page-title">Sửa dự án</h4>
				</div>
			</div>
			<!-- /.row -->
			<!-- .row -->
			<div class="row">
				<div class="col-md-2 col-12"></div>
				<div class="col-md-8 col-xs-12">
					<div class="white-box">
						<form class="form-horizontal form-material" method="post"
							action="<%=CONTEXT_PATH + PathConfig.JOB_EDIT%>">
							<% if(messageError != null) { %>
								<div class="alert alert-danger" role="alert">${ messageError }</div>
							<% } %>
							<div class="form-group">
								<label class="col-md-12">Tên dự án</label>
								<div class="col-md-12">
									<input type="text" placeholder="Tên công việc"
										class="form-control form-control-line" name="name"
										value="${ job.name }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-12">Ngày bắt đầu</label>
								<div class="col-md-12">
									<%
										if (job == null) {
									%>
									<input type="text" placeholder="dd/MM/yyyy"
										class="form-control form-control-line" name="start_date">
									<%
										} else {
									%>
									<input type="text" placeholder="dd/MM/yyyy"
										class="form-control form-control-line" name="start_date"
										value="<%=DateLibrary.convertTimestampToSimpleDate(job.getStart_date())%>">
									<%
										}
									%>

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-12">Ngày kết thúc</label>
								<div class="col-md-12">
									<%
										if (job == null) {
									%>
									<input type="text" placeholder="dd/MM/yyyy"
										class="form-control form-control-line" name="end_date">
									<%
										} else {
									%>
									<input type="text" placeholder="dd/MM/yyyy"
										class="form-control form-control-line" name="end_date"
										value="<%=DateLibrary.convertTimestampToSimpleDate(job.getEnd_date())%>">
									<%
										}
									%>
									
								</div>
							</div>
							<input type="hidden" name="id" value="${ job.id }" >
							<div class="form-group">
								<div class="col-sm-12">
									<button type="submit" class="btn btn-success">Sửa</button>
									<a href="<%=CONTEXT_PATH + PathConfig.JOB%>"
										class="btn btn-primary">Quay lại</a>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="col-md-2 col-12"></div>
			</div>
			<!-- /.row -->
		</div>
</body>
</html>