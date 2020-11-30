<%@page import="java.util.ArrayList"%>
<%@page import="com.vtanh1905.entity.Role"%>
<%@page import="java.util.List"%>
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
	<% List<Role> roles = (ArrayList<Role>)request.getAttribute("roles"); %>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row bg-title">
				<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
					<h4 class="page-title">Thêm mới thành viên</h4>
				</div>
			</div>
			<!-- /.row -->
			<!-- .row -->
			<div class="row">
				<div class="col-md-2 col-12"></div>
				<div class="col-md-8 col-xs-12">
					<div class="white-box">
						<form class="form-horizontal form-material" action="<%= CONTEXT_PATH +  PathConfig.USER_ADD %>" method="POST">
							<div class="form-group">
								<label class="col-md-12">Full Name</label>
								<div class="col-md-12">
									<input type="text" placeholder="Johnathan Doe"
										class="form-control form-control-line">
								</div>
							</div>
							<div class="form-group">
								<label for="example-email" class="col-md-12">Email</label>
								<div class="col-md-12">
									<input type="email" placeholder="johnathan@admin.com"
										class="form-control form-control-line" name="example-email"
										id="example-email">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-12">Password</label>
								<div class="col-md-12">
									<input type="password" value="" placeholder="password"
										class="form-control form-control-line">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-12">Avatar URL</label>
								<div class="col-md-12">
									<input type="text" placeholder="https://i.pinimg.com/originals/31/cf/58/31cf5881a0173478ac8f6d1ca3a49786.jpg"
										class="form-control form-control-line">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-12">Select Role</label>
								<div class="col-sm-12">
									<select class="form-control form-control-line">
										<c:forEach var="role" items="${ roles }">
										<option value="${ role.id }">${ role.description }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<button type="submit" class="btn btn-success">Add User</button>
									<a href="user-table.html" class="btn btn-primary">Quay lại</a>
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