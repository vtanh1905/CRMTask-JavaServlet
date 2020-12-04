<%@page import="com.vtanh1905.utils.DateLibrary"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.vtanh1905.entity.Job"%>
<%@page import="java.util.List"%>
<%@page import="com.vtanh1905.config.PathConfig"%>
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
		List<Job> jobs = (ArrayList<Job>) request.getAttribute("jobs");
	%>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row bg-title">
				<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
					<h4 class="page-title">Danh sách dự án</h4>
				</div>
				<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
					<a href="<%=CONTEXT_PATH + PathConfig.JOB_ADD%>"
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
										<th>Tên Dự Án</th>
										<th>Ngày Bắt Đầu</th>
										<th>Ngày Kết Thúc</th>
										<th>Hành Động</th>
									</tr>
								</thead>
								<tbody>
								<% for(Job job : jobs) { %>
								 	<tr>
											<td><%= job.getId() %></td>
											<td><%= job.getName() %></td>
											<td><%= DateLibrary.convertTimestampToSimpleDate(job.getStart_date()) %></td>
											<td><%= DateLibrary.convertTimestampToSimpleDate(job.getEnd_date()) %></td>
											<td><a href="<%= CONTEXT_PATH + PathConfig.JOB_EDIT %>?id=<%= job.getId() %>" class="btn btn-sm btn-primary">Sửa</a> <a
												href="<%= CONTEXT_PATH + PathConfig.JOB_REMOVE %>?id=<%= job.getId() %>" class="btn btn-sm btn-danger">Xóa</a> <a
												href="<%= CONTEXT_PATH + PathConfig.JOB_DETAIL %>?id=<%= job.getId() %>" class="btn btn-sm btn-info">Xem</a>
											</td>
										</tr>
								 <% } %>
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