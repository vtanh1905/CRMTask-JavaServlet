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
	<% String messageError = (String)request.getAttribute("messageError"); %>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row bg-title">
				<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
					<h4 class="page-title">Sửa mới quyền</h4>
				</div>
			</div>
			<!-- /.row -->
			<!-- .row -->
			<div class="row">
				<div class="col-md-2 col-12"></div>
				<div class="col-md-8 col-xs-12">
					<div class="white-box">
						<form class="form-horizontal form-material"
							action="<%=CONTEXT_PATH + PathConfig.ROLE_EDIT%>" method="POST">
							<% if(messageError != null) { %>
								<div class="alert alert-danger" role="alert">${ messageError }</div>
							<% } %>
							
							<div class="form-group">
								<label class="col-md-12">Tên quyền</label>
								<div class="col-md-12">
									<input name="name" type="text" placeholder="Tên quyền"
										class="form-control form-control-line" value="${ role.name }" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-12">Mô tả</label>
								<div class="col-md-12">
									<input name="description" type="text" placeholder="Mô tả"
										class="form-control form-control-line" value="${ role.description }" />
								</div>
							</div>
							<input type="hidden" name="id" value="${ role.id }" />
							<div class="form-group">
								<div class="col-sm-12">
									<button type="submit" class="btn btn-success">Edit Role</button>
									<a href="<%=CONTEXT_PATH + PathConfig.ROLE%>" class="btn btn-primary">Quay lại</a>
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