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
	<% 
		List<Role> roles = (ArrayList<Role>)request.getAttribute("roles"); 
		String messageError = (String)request.getAttribute("messageError");
	%>

	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row bg-title">
				<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
					<h4 class="page-title">Sửa thành viên</h4>
				</div>
			</div>
			<!-- /.row -->
			<!-- .row -->
			<div class="row">
				<div class="col-md-2 col-12"></div>
				<div class="col-md-8 col-xs-12">
					<div class="white-box">
						<form class="form-horizontal form-material" action="<%= CONTEXT_PATH +  PathConfig.USER_EDIT %>" method="POST">
							<% if(messageError != null) { %>
								<div class="alert alert-danger" role="alert">${ messageError }</div>
							<% } %>
							<div class="form-group">
								<label class="col-md-12">Full Name</label>
								<div class="col-md-12">
									<input type="text" placeholder="Johnathan Doe"
										class="form-control form-control-line" name="fullname" value="${ user.fullname }">
								</div>
							</div>
							<div class="form-group">
								<label for="example-email" class="col-md-12">Email</label>
								<div class="col-md-12">
									<input type="email" placeholder="johnathan@admin.com"
										class="form-control form-control-line" name="email"
										id="example-email" value="${ user.email }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-12">Password</label>
								<div class="col-md-12">
									<input type="password" placeholder="password"
										class="form-control form-control-line" name="password" >
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-12">Avatar URL</label>
								<div class="col-md-12">
									<input type="text" placeholder="https://i.pinimg.com/originals/31/cf/58/31cf5881a0173478ac8f6d1ca3a49786.jpg"
										class="form-control form-control-line" name="avatar" value="${ user.avatar }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-12">Select Role</label>
								<div class="col-sm-12">
									<select class="form-control form-control-line" name="role_id">
										<c:forEach var="role" items="${ roles }">
										<option value="${ role.id }"  ${ user.role_id == role.id ? "selected" : "" }>${ role.description }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<input type="hidden" name="id" value="${ user.id }">
							<input type="hidden" name="oldPassword" value="${ user.password }">
							<div class="form-group">
								<div class="col-sm-12">
									<button type="submit" class="btn btn-success">Edit User</button>
									<a href="<%= CONTEXT_PATH +  PathConfig.USER %>" class="btn btn-primary">Quay lại</a>
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